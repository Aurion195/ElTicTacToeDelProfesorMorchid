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

import IA.Coup;
import IA.MultiLayerPerceptron;
import IA.SigmoidalTransferFunction;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**Pour le nombre de neuronnes choisit nous avons choisit :
 * Facile = 500 
 * Moyen = 1500
 * Difficile = 3000
 */

public class iaViewController extends ToolsBarController
{

	private int nbNeuronne ;
	private double coefApprentissage= 0.1 ;
	private int[] layers ;
	private MultiLayerPerceptron net ;
	private double size ;
	private double tmp ;
	@FXML private JFXButton apprentissage ;
	@FXML private JFXProgressBar progress ;
	@FXML public  Label pourcent ;

	@FXML
	public void lancerApprentissage()
	{
		/*this.apprentissage.setVisible(false);
		this.progress.setVisible(true);*/
		this.apprentissage.setVisible(false);
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
	
	public iaViewController()
	{
		this.configureNeuronne() ;
		this.layers = new int[]{ 9, nbNeuronne, 9};
		this.net = new MultiLayerPerceptron(layers, coefApprentissage, new SigmoidalTransferFunction());
	}

	private double[] convertIntArrayToDoubleArray(int[] a)
	{
		double[] tmp = new double[9] ;

		for(int i = 0 ; i < 9 ; i++)
		{
			tmp[i] = (int) a[i] ;
		}

		return tmp ;
	}

	public void apprentissageIA(String chemin) throws InterruptedException
	{
		ArrayList<Coup> coups;
		double[] in = new double[9];
		double[] out = new double[9];

		for(int i = 0 ; i <= this.nbNeuronne ; i++)
		{
			try {
				double error = 0.0 ;
				coups = getAllCoup(chemin);
				this.size = (double)coups.size() ;
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

		TimeUnit.MILLISECONDS.sleep(50);
	}

	private int[] convertStringtoIntArray(String a)
	{
		int[] tmp = new int[9] ;
		for(int i = 0 ; i < 9 ; i++)
		{
			tmp[i] = a.codePointAt(i) ;
		}

		return tmp ;
	}

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
	 * @return the nbNeuronne
	 */
	public int getNbNeuronne() 
	{
		return nbNeuronne;
	}

	/**
	 * @return the coefApprentissage
	 */
	public double getCoefApprentissage() 
	{
		return coefApprentissage;
	}

	/**
	 * @param nbNeuronne the nbNeuronne to set
	 */
	public void setNbNeuronne(int nbNeuronne) 
	{
		this.nbNeuronne = nbNeuronne;
	}

	/**
	 * @param coefApprentissage the coefApprentissage to set
	 */
	public void setCoefApprentissage(double coefApprentissage) 
	{
		this.coefApprentissage = coefApprentissage;
	}

}
