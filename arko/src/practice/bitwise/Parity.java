package practice.bitwise;

public class Parity {
	public static void main(String[] args) {
		int n = 3;
	    System.out.println("Parity =" +
	             (getParity(n)? "odd": "even"));
	     
	   	}
	static boolean getParity( int n)
	{
	    boolean parity = false;
	    while (n != 0)
	    {
	        parity = !parity;
	        n      = n & (n - 1);
	    }        
	    return parity;
	}
	 
	/* Driver program to test getParity() */
	
}
