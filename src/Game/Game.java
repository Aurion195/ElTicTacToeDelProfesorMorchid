package Game;

import java.util.Vector;

import org.w3c.dom.Element;

import View.MultiViewController;

public class Game 
{
	public boolean turnPlayer1 = true ;
	private String player00 ;
	private String player01 ;
	private Vector<String> choicePlayeurStrings = new Vector<String>() ;
	
	public Game()
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			this.choicePlayeurStrings.addElement(String.valueOf(i));
		}
	}
	
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
