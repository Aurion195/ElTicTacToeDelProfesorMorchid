package Game;

import java.util.Vector;

public class Game 
{
	public boolean win(Vector<String> c)
	{
		if((c.elementAt(0).toString().equals(c.elementAt(1).toString()) && c.elementAt(1).toString().equals(c.elementAt(2).toString())) || 
		   (c.elementAt(0).toString().equals(c.elementAt(3).toString()) && c.elementAt(3).toString().equals(c.elementAt(6).toString())) ||
		   (c.elementAt(2).toString().equals(c.elementAt(5).toString()) && c.elementAt(5).toString().equals(c.elementAt(8).toString())) ||
		   (c.elementAt(3).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(5).toString())) ||
		   (c.elementAt(6).toString().equals(c.elementAt(7).toString()) && c.elementAt(7).toString().equals(c.elementAt(8).toString())) ||
		   (c.elementAt(0).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(8).toString())) ||
		   (c.elementAt(2).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(6).toString())) ||
		   (c.elementAt(1).toString().equals(c.elementAt(4).toString()) && c.elementAt(4).toString().equals(c.elementAt(7).toString())))
		{
			
			return true ;
		}
		
		return false ;
	}
}
