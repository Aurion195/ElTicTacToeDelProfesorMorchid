package IA;

/**
 * Classe coup du joeur
 * @author MATHIEU Thomas
 * @author GARCIA Jérémy
 *
 */
public class Coup 
{
	/**
	 * Tableau d'entrée
	 */
	int[] in = new int[9] ;
	
	/**
	 * Tableau de sortie
	 */
	int[] out = new int[9] ;
	
	/**
	 * Constructeur de coup vide
	 */
	public Coup() 
	{
		
	}
	
	/**
	 * Constructeur de coup du joueur
	 * @param a = tableau d'entrée ;
	 * @param b = tableau de sortie ;
	 */
	public Coup(int[] a, int[] b)
	{
		this.in = a ;
		this.out = b ;
	}

	/**
	 * @return un String du tableau de IN
	 */
	public String getInString()
	{
		String result = "";
		for(int i = 0; i < 9; i++)
		{
			result += in[i];
		}
		return result;
	}
	
	/**
	 * @return un String du tableau de OUT
	 */
	public String getOutString()
	{
		String result = "";
		for(int i = 0; i < 9; i++)
		{
			result += out[i];
		}
		return result;
	}
	
	/**
	 * @return le in
	 */
	public int[] getIn() {
		return in;
	}

	/**
	 * @return le out
	 */
	public int[] getOut() {
		return out;
	}

	/**
	 * Permet de changer le tableau de IN
	 * @param in = nouveau tableau ;
	 */
	public void setIn(int[] in) 
	{
		this.in = in;
	}

	/**
	 * Permet de changer le tableau de OUT
	 * @param out = nouveau tableau ;
	 */
	public void setOut(int[] out) 
	{
		this.out = out;
	}
	
	
}
