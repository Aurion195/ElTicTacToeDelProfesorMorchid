package IA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.corba.se.impl.presentation.rmi.IDLTypeException;
import com.sun.media.jfxmediaimpl.platform.Platform;

import Game.Launcher;

public class IA 
{
	private int nbNeuronne = 10 ;
	private double coefApprentissage= 0.1 ;
	private int[] layers ;
	private MultiLayerPerceptron net ;

	public IA()
	{
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
	
	public void apprentissageIA(String chemin)
	{
		double error = 0.0 ;
		getProgressBarIncrement();
		addProgresse = this.quotientProgress;
		addProgressePourcent = this.quotientProgressPourcent;
		ArrayList<Coup> coups;
		double[] in = new double[9];
		double[] out = new double[9];


		for(int i = 0 ; i < 1000 ; i++)
		{
			try {
				coups = getAllCoup(chemin);

				for(Coup coup : coups)
				{
					in = convertIntArrayToDoubleArray(coup.getIn());
					out = convertIntArrayToDoubleArray(coup.getOut());
					error = this.net.backPropagate(in, out);
					System.out.println(error);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			Platform.runLater(new Runnable(){

				@Override
				public void run()
				{
					Launcher.getInstance().getLabelPourcent().setText((int)addProgressePourcent + "%");
					Launcher.getInstance().getLabelError().setText("Erreur itération "+it+" est "+ (error/(double)it));
					Launcher.getInstance().getProgressBar().setProgress(addProgresse);
				}
			});

			addProgresse = addProgresse + this.quotientProgress;
			addProgressePourcent = addProgressePourcent + this.quotientProgressPourcent;
			//TimeUnit.MILLISECONDS.sleep(50);
		}
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
	
	public ArrayList<Coup> getAllCoup(String chemin) throws FileNotFoundException, IOException
	{
		ArrayList<Coup> coup = new ArrayList<Coup>();
		String recupLigne = "";
		String inString = "";
		String outString = "";

		// Ouverture du fichier et travail de lecture
		try (BufferedReader br = new BufferedReader(new FileReader(chemin)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				recupLigne = line;
				inString = recupLigne.substring(0, recupLigne.lastIndexOf("/"));
				outString = recupLigne.substring(recupLigne.lastIndexOf("/")+1, recupLigne.length());
				coup.add(new Coup(this.convertStringtoIntArray(inString), this.convertStringtoIntArray(outString)));
			}
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
