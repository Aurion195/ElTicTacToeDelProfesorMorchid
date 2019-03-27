package Game;

import java.util.Vector;

import IA.Coup;

public class Player 
{
	String name ;
	String pion ;
	Vector<Coup> coups ;

	public Player(String name, String pion)
	{
		this.name = name ;
		this.pion = pion ;
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
	
	public String getPion()
	{
		return this.pion ;
	}
	
	public void setPion(String pion)
	{
		this.pion = pion ;
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
