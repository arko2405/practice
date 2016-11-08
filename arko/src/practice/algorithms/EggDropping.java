package practice.algorithms;

public class EggDropping {
	public static void main(String[] args) {
		int n = 2, k = 36;
	    System.out.println ("Min "+eggDropIterative(n, k));

	}
	static int eggDrop(int n, int k)
	{
	   
	    if (k == 1 || k == 0)
	        return k;
	 
	    if (n == 1)
	        return k;
	 
	    int min = 99999, x, res;
	 
	    for (x = 1; x <= k; x++)
	    {
	        res = Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x));
	        if (res < min)
	            min = res;
	    }
	 
	    return min + 1;
	}
	static int eggDropIterative(int n , int k){
		int noOfDrops[][]=new int[n+1][k+1];
		int m=99999;
		for (int i = 0; i < n+1; i++) {
			noOfDrops[i][0]=0;
			noOfDrops[i][1]=1;
		}
		for (int i = 1; i < k+1; i++) {
			noOfDrops[1][i]=i;
		}
		for (int i =2; i < n+1; i++) {
			for (int j = 2; j < k+1; j++) {
				noOfDrops[i][j]=99999;
				for (int x = 1; x <=j; x++) {
					m = 1 + Math.max(noOfDrops[i-1][x-1], noOfDrops[i][j-x]);
					 if (m < noOfDrops[i][j])
						 noOfDrops[i][j] = m;
				}
			}
		}
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < k+1; j++) {
				System.out.print(noOfDrops[i][j]+" ");
			}
			System.out.println();
		}
		return noOfDrops[n][k];
	}
}
