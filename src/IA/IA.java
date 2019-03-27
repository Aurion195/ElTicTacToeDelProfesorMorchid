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
	
	public void apprentissageIA(String chemin) throws FileNotFoundException, IDLTypeException, InterruptedException
	{
		getProgressBarIncrement();
		addProgresse = this.quotientProgress;
		addProgressePourcent = this.quotientProgressPourcent;
		ArrayList<Coup> coups;
		double[] in = new double[9];
		double[] out = new double[9];


		for(int i = 0 ; i < 1000 ; i++)
		{
			coups = getAllCoup();

			for(Coup coupJouer : coups)
			{
				in = convertIntArrayToDoubleArray(coupJouer.getIn());
				out = convertIntArrayToDoubleArray(coupJouer.getOut());
				error = mlp.backPropagate(in, out);
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

	public ArrayList<Coup> getAllCoup() throws FileNotFoundException, IOException
	{
		ArrayList<Coup> coup = new ArrayList<Coup>();
		String recupLigne = "";
		String inString = "";
		String outString = "";

		// Ouverture du fichier et travail de lecture
		try (BufferedReader br = new BufferedReader(new FileReader("src/file/train.txt")))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				recupLigne = line;
				inString = recupLigne.substring(0, recupLigne.lastIndexOf(";"));
				outString = recupLigne.substring(recupLigne.lastIndexOf(";")+1, recupLigne.length());
				coup.add(new CoupJouer(convertStringtoIntArray(inString), convertStringtoIntArray(outString)));
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
