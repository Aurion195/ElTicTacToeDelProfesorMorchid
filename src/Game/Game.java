package Game;

import java.io.*;
import java.util.Vector;

import org.w3c.dom.Element;

import com.jfoenix.validation.DoubleValidator;

import IA.Coup;
import View.MultiViewController;

/**
 * Classe Game, elle va s'occuper de la gestion BACK-END du jeu
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 */
public class Game 
{
	/**
	 * Boolean permettant de savoir le tour du joueur
	 */
	public boolean turnPlayer1 = true ;
	
	/**
	 * Nom du joueur 1
	 */
	private String player00 ;
	
	/**
	 * Nom du joueur 2
	 */
	private String player01 ;
	
	/**
	 * Plateau du jeu, la on on va placer les pions des joueurs
	 */
	private Vector<String> choicePlayeurStrings = new Vector<String>() ;
	
	/**
	 * Tableau de double contenant le plateau du joueur
	 */
	private Double[] myVector = new Double[9] ;
	
	private double[] plateauIA = new double[9] ;
	/**
	 * Constructeur de la classe game, on initialise le plateau du jeu et le tableau
	 */
	public Game()
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			this.choicePlayeurStrings.addElement(String.valueOf(i));
			this.myVector[i] = 0.0 ;
			this.plateauIA[i] = 0.0 ;
		}
	}
	
	/**
	 * Permet de savoir si le joueur à gagné en utilisant les diagonales
	 * @param c = plateau de jeu ;
	 * @return le int qui permet d'identifier la barre rouge
	 */
	private int crossWin(Vector<String> c)
	{
		if((c.elementAt(0).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(8).toString())))
		{
			return 7 ;
		}
		else if(c.elementAt(2).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(6).toString()))
		{
			return 8 ;
		}
		
		return -1 ;
	}
	
	/**
	 * Permet de savoir si le joueur à gagné en utilisant les lignes horizontales
	 * @param c = plateau de jeu ;
	 * @return le int qui permet d'identifier la barre rouge
	 */
	private int horizontalWin(Vector<String> c)
	{
		if((c.elementAt(0).toString().equals(c.elementAt(1).toString()) && c.elementAt(1).toString().equals(c.elementAt(2).toString())))
		{
			return 1 ;
		}
		else if(c.elementAt(3).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(5).toString()))
		{
			return 2 ;
		}
		else if(c.elementAt(6).toString().equals(c.elementAt(7).toString()) && c.elementAt(7).toString().equals(c.elementAt(8).toString()))
		{
			return 3 ;
		}
		
		return -1 ;
	}
	
	/**
	 * Permet de savoir si le joueur à gagné en utilisant les lignes verticales
	 * @param c = plateau de jeu ;
	 * @return le int qui permet d'identifier la barre rouge
	 */
	private int verticaleWin(Vector<String> c)
	{
		if((c.elementAt(0).toString().equals(c.elementAt(3).toString()) && c.elementAt(3).toString().equals(c.elementAt(6).toString())))
		{
			return 4 ;
		}
		else if(c.elementAt(1).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(7).toString()))
		{
			return 5 ;
		}
		else if(c.elementAt(2).toString().equals(c.elementAt(5).toString()) && c.elementAt(5).toString().equals(c.elementAt(8).toString()))
		{
			return 6 ;
		}
		
		return -1 ;
	}
	
	/**
	 * Fonction appeler à chaque fin de tour de jeu, elle va vérifier si un joueur n'a pas gagné
	 * @return un int != de 0, si un joueur à gagné
	 */
	public int win()
	{
		int a = this.horizontalWin(this.choicePlayeurStrings) ;
		int b = this.crossWin(this.choicePlayeurStrings) ;
		int c = this.verticaleWin(this.choicePlayeurStrings) ;
		
		if(a != -1)
		{
			return a ;  
		}
		else if(b != -1)
		{
			return b ;
		}
		else if(c != -1) 
		{
			return c ;
		}
		else 
		{
			return -1 ;
		}
		
	}
	
	/**
	 * Permet la fonction rejouer, efface tous les pions du plateau de jeu
	 */
	public void erasePion()
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			this.choicePlayeurStrings.set(i, String.valueOf(i)) ;
		}
	}
	
	/**
	 * Change le tour du joueur
	 * @param placePosition = position on le joueur à placer le pion ;
	 * @return le tour du joueur
	 */
	public boolean turnPlayer(int placePosition)
	{
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.placeStringPlayer(placePosition) ;
		this.getCoupJouer();
		return this.turnPlayer1 ;
	}
	
	/**
	 * Permet de placer le pion dans le plateau du jeu 
	 * @param placePosition = position du pion sur le plateau
	 */
	public void placeStringPlayer(int placePosition)
	{
		this.choicePlayeurStrings.set(placePosition, (this.turnPlayer1 ? "o" : "x")) ;
	}
	
	/**
	 * Permet de donner tous les coups jouer par tous les joueurs
	 * 1 = player 1
	 * 2 = player 2
	 * 0 = pas de pion
	 */
	public void getCoupJouer()
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			if(this.choicePlayeurStrings.elementAt(i).equals("x"))
			{
				this.myVector[i] =  1.0 ;
			}
			else if(this.choicePlayeurStrings.elementAt(i).equals("o"))
			{
				this.myVector[i] = 2.0 ;
			}
			else
			{
				this.myVector[i] = 0.0 ;
			}
		}
	}
	
	public void IAVsPlayer(String pion, int position)
	{
		System.out.println("on pose le pion");
		double a = (pion.equals("x") ? 1.0 : 2.0) ;
		this.plateauIA[position] = a ;
	}
	
	/**
	 * @return le plateau du jeu
	 */
	public int[] getPlateau()
	{
		int[] tab = new int[9];
		
		for(int i = 0; i < 9; i++)
		{
			tab[i] = (int) Math.round(this.myVector[i]);
		}
		return tab ;
	}
	
	/**
	 * Fonction permettant de sauvegarder les coups dans le fichier train.txt pour l'IA
	 * @param listCoup = list de coup à sauvegarder ;
	 */
	public void saveCoup(Vector<Coup> listCoup) 
	{
		System.out.println("Bien dans saveCoup");
		BufferedWriter writer;
		try
		{
			writer = new BufferedWriter(new FileWriter("src/IA/train.txt", true));

			for(Coup coup : listCoup)
			{
				System.out.println(coup.getInString() + "/" + coup.getOutString());
				writer.append(coup.getInString());
				writer.append("/");
				writer.append(coup.getOutString()) ;
				writer.newLine();
			}
			
			 writer.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			
		}
	}

	public double[] getChoicePlayeurStrings() {
		return this.plateauIA ;
	}
	
	
}
