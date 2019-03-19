package Game;

public class Player 
{
	String name ;
	String pion ;

	public Player(String name, String pion) 
	{
		this.name = name;
		this.pion = pion ;
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
}
