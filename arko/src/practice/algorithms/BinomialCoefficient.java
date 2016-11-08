package practice.algorithms;

public class BinomialCoefficient {

	public static void main(String[] args) {
		    int n = 4, k = 2;
		    System.out.println("Value "+binomialCoeff(n, k));
	}

	 static int binomialCoeff(int n, int k) {
		 int binomial[][] = new int[n+1][k+1];
		for (int i = 0; i < n+1; i++) {
		   binomial[i][0]=1;
		}
		for (int i = 0; i < k+1; i++) {
			binomial[i][i]=1;
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < k+1; j++) {
				binomial[i][j]=binomial[i-1][j-1]+binomial[i-1][j];
			}
		}
		return binomial[n][k];
	}

}
