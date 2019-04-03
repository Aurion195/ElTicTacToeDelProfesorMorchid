package View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.jfoenix.controls.*;

import Game.Launcher;
import IA.Coup;
import IA.MultiLayerPerceptron;
import IA.SigmoidalTransferFunction;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * Classe permettant de gérer l'IA
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class iaViewController extends ToolsBarController implements Initializable
{
	
	/**Pour le nombre de neuronnes choisit nous avons choisit :
	 * Facile = 500 
	 * Moyen = 1500
	 * Difficile = 3000
	 */
	
	/**
	 * Nombre de neuronne (difficulté du jeu)
	 */
	private int nbNeuronne ;
	
	/**
	 * Coef d'apprentissage de l'IA
	 */
	private double coefApprentissage= 0.1 ;
	
	/**
	 * Tableau de int
	 */
	private int[] layers ;
	
	/**
	 * Réseau de neureonne
	 */
	private MultiLayerPerceptron net ;
	
	/**
	 * Compteur du fichier
	 */
	private double tmp ;
	
	/**
	 * ProgressBar
	 */
	@FXML private JFXProgressBar progress ;
	
	/**
	 * Affiche les % pour l'IA
	 */
	@FXML private Label pourcent ;
	
	/**
	 * Button pour lancer le jeu
	 */
	@FXML private JFXButton begin ;

	/**
	 * Dés qu'on va aller sur cette View, cette fonction va s'apeller et le chargement va s'effectuer tout seul
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		try {
			Service<Void> ser = new Service<Void>() {
				@Override protected Task createTask() {
					return new Task<Void>() {
						@Override protected Void call() throws InterruptedException 
						{
							try {
								apprentissageIA("/home/nas02a/etudiants/inf/uapv1703778/eclipse-workspace/ElTicTacToeDelProfesorMorchid/src/IA/train.txt");
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							return null;
						}
					};
				}
			};
			ser.setExecutor(null);
			ser.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Ce button va s'afficher uniquement lorsque l'IA va finir d'apprendre
	 * Permet de lancer le jeu en 1v1
	 */
	@FXML
	public void lauchGame()
	{
		Launcher main = Launcher.getInstance();
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("SoloView.fxml"));
			main.setRootLayout(loader.load());

			Scene scene = new Scene(main.getRootLayout());
			main.getPrimaryStage().setScene(scene);
			main.getPrimaryStage().show();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Permet de regler le nombre de neuronnes et ainsi la difficulté de l'IA, la function
	 * va rechercher dans le fichier config.xml qui sauvegarde les options
	 */
	private void configureNeuronne()
	{
		try {
			int easy, moyen, hard ;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("config.xml");
			
			easy = Integer.parseInt(doc.getElementsByTagName("Facile").item(0).getTextContent()) ;
			moyen = Integer.parseInt(doc.getElementsByTagName("Medium").item(0).getTextContent()) ;
			hard = Integer.parseInt(doc.getElementsByTagName("Hard").item(0).getTextContent()) ;
			
			this.nbNeuronne = (easy == 1 ? 500 : moyen == 1 ? 1500 : 3000) ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructeur de l'IA
	 */
	public iaViewController()
	{
		this.configureNeuronne() ;
		this.layers = new int[]{ 9, nbNeuronne, 9};
		this.net = new MultiLayerPerceptron(layers, coefApprentissage, new SigmoidalTransferFunction());
	}

	/**
	 * Permet de convertir un tableau de Int en tableau de Double
	 * @param a = tableau de int ;
	 * @return le tableau de double
	 */
	private double[] convertIntArrayToDoubleArray(int[] a)
	{
		double[] tmp = new double[9] ;

		for(int i = 0 ; i < 9 ; i++)
		{
			tmp[i] = (int) a[i] ;
		}

		return tmp ;
	}

	/**
	 * Permet l'apprentissage de l'IA
	 * @param chemin = chemin vers le dossier train.txt ;
	 */
	public void apprentissageIA(String chemin)
	{
		ArrayList<Coup> coups;
		double[] in = new double[9];
		double[] out = new double[9];

		for(int i = 0 ; i <= this.nbNeuronne ; i++)
		{
			try {
				double error = 0.0 ;
				coups = getAllCoup(chemin);
				this.tmp = (double)i ;
				for(Coup coup : coups)
				{
					in = convertIntArrayToDoubleArray(coup.getIn());
					out = convertIntArrayToDoubleArray(coup.getOut());
					error = this.net.backPropagate(in, out);
				}

				Platform.runLater(new Runnable()
				{
					@Override
					public void run()
					{
						if(nbNeuronne == 500) pourcent.setText(Math.round((float)(nbNeuronne/50)*(tmp/50))+" %") ;
						if(nbNeuronne == 1500) pourcent.setText(Math.round((float)(nbNeuronne/150)*(tmp/150))+" %") ;
						if(nbNeuronne == 3000) pourcent.setText(Math.round((float)(nbNeuronne/300)*(tmp/300))+" %") ;
					}
				});

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		try {
			TimeUnit.MILLISECONDS.sleep(50);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		this.begin.setVisible(true);
	}

	/**
	 * Permet de convertir le string qu'on récupere dans le fichier en tableau de int
	 * @param a = string du fichier ;
	 * @return un tableau de int
	 */
	private int[] convertStringtoIntArray(String a)
	{
		int[] tmp = new int[9] ;
		for(int i = 0 ; i < 9 ; i++)
		{
			tmp[i] = a.codePointAt(i) ;
		}

		return tmp ;
	}

	/**
	 * Permet d'avoir tous les coups du fichier "train.txt"
	 * @param chemin = chemin du fichier 'train.txt" ;
	 * @return une arrayList avec tous les coups
	 */
	public ArrayList<Coup> getAllCoup(String chemin)
	{
		ArrayList<Coup> coup = new ArrayList<Coup>();
		String recupLigne = "";
		String inString = "";
		String outString = "";

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(chemin)) ;
			String line;
			while ((line = br.readLine()) != null)
			{
				recupLigne = line;
				inString = recupLigne.substring(0, recupLigne.lastIndexOf("/"));
				outString = recupLigne.substring(recupLigne.lastIndexOf("/")+1, recupLigne.length());
				coup.add(new Coup(this.convertStringtoIntArray(inString), this.convertStringtoIntArray(outString)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return coup;
	}

	/**
	 * @return le nbNeuronne
	 */
	public int getNbNeuronne() 
	{
		return nbNeuronne;
	}

	/**
	 * @return le coefApprentissage
	 */
	public double getCoefApprentissage() 
	{
		return coefApprentissage;
	}

	/**
	 * Permet de changer le nombre de neuronne
	 * @param nbNeuronne = nouveau nombre de neuronne ;
	 */
	public void setNbNeuronne(int nbNeuronne) 
	{
		this.nbNeuronne = nbNeuronne;
	}

	/**
	 * Permet de changer le coef d'apprentissage
	 * @param coefApprentissage = nouveay coef d'apprentissage ;
	 */
	public void setCoefApprentissage(double coefApprentissage) 
	{
		this.coefApprentissage = coefApprentissage;
	}


}
