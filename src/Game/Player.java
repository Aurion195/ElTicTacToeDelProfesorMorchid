package Game;

import java.util.Vector;

import IA.Coup;

/**
 * Classe player
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Player 
{
	/**
	 * Nom du joueur
	 */
	
	String name ;
	
	/**
	 * liste de coup du joueur
	 */
	Vector<Coup> coups ;

	/**
	 * Constructeur du joueur
	 * @param name = nom du joueur ;
	 */
	public Player(String name)
	{
		this.name = name ;
		this.coups = new Vector<Coup>() ;
	}

	/**
	 * @return the name
	 */
	public String getName() 
	{
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return the coups
	 */
	public Vector<Coup> getCoups() 
	{
		return coups;
	}

	/**
	 * @param coups the coups to set
	 */
	public void setCoups(Vector<Coup> coups) 
	{
		this.coups = coups;
	}
	
	
}
