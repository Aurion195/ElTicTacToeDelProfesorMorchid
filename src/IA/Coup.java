package IA;

public class Coup 
{
	int[] in = new int[9] ;
	int[] out = new int[9] ;
	
	public Coup() 
	{
		
	}
	
	public Coup(int[] a, int[] b)
	{
		this.in = a ;
		this.out = b ;
	}

	public String getInString()
	{
		String result = "";
		for(int i = 0; i < 9; i++)
		{
			result += in[i];
		}
		return result;
	}
	
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
	 * @return the in
	 */
	public int[] getIn() {
		return in;
	}

	/**
	 * @return the out
	 */
	public int[] getOut() {
		return out;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(int[] in) {
		this.in = in;
	}

	/**
	 * @param out the out to set
	 */
	public void setOut(int[] out) {
		this.out = out;
	}
	
	
}
