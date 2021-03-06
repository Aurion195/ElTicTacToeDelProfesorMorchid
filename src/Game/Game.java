package Game;

import java.util.Vector;

public class Game 
{
	private boolean turnPlayer1 = true ;
	private Vector<String> choicePlayeurStrings = new Vector<String>() ;
	
	public Game()
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			this.choicePlayeurStrings.addElement(String.valueOf(i));
		}
	}
	
	private boolean crossWin(Vector<String> c)
	{
		if((c.elementAt(0).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(8).toString()) ||
		(c.elementAt(2).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(6).toString()))))
		{
			return true ;
		}
		
		return false ;
	}
	
	private boolean horizontalWin(Vector<String> c)
	{
		if((c.elementAt(0).toString().equals(c.elementAt(1).toString()) && c.elementAt(1).toString().equals(c.elementAt(2).toString())) ||
		   (c.elementAt(3).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(5).toString())) ||
		   (c.elementAt(6).toString().equals(c.elementAt(7).toString()) && c.elementAt(7).toString().equals(c.elementAt(8).toString())))
		{
			return true ;
		}
		
		return false ;
	}
	
	private boolean verticaleWin(Vector<String> c)
	{
		if((c.elementAt(0).toString().equals(c.elementAt(3).toString()) && c.elementAt(3).toString().equals(c.elementAt(6).toString())) ||
		   (c.elementAt(1).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(7).toString())) ||
		   (c.elementAt(2).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(6).toString())))
		{
			return true ;
		}
		
		return false ;
	}
	
	public boolean win()
	{
		if(this.crossWin(this.choicePlayeurStrings) || this.horizontalWin(this.choicePlayeurStrings) || this.verticaleWin(this.choicePlayeurStrings))
		{
			return true ;
		}
		
		return false ;
	}
	
	public void erasePion()
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			this.choicePlayeurStrings.set(i, String.valueOf(i)) ;
		}
	}
	
	public boolean turnPlayer(int placePosition)
	{
		this.turnPlayer1 = !this.turnPlayer1 ;
		this.placeStringPlayer(placePosition) ;
		return this.turnPlayer1 ;
	}
	
	public void placeStringPlayer(int placePosition)
	{
		this.choicePlayeurStrings.set(placePosition, (this.turnPlayer1 ? "x" : "o")) ;
	}
}
