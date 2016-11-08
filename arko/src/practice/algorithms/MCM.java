package practice.algorithms;

public class MCM {

	public static int p[] = { 30, 35, 15, 5, 10, 20, 25 };
	public static int m[][] = new int[7][7];
	public static int s[][] = new int[7][7];
	public static int infinity = 99999999;

	public static void main(String[] args) {
		int ans = matrixChainMultiplicationRecursive();
		System.out.println(ans);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(s[i][j] + "\t");
			}
			System.out.println();
		}
		printSeq(1, 6);
	}

	public static void printSeq(int i, int j) {
		if (i == j)
			System.out.print("A" + i + " ");
		else {
			System.out.print(" ( ");
			printSeq(i, s[i][j]);
			printSeq(s[i][j] + 1, j);
			System.out.print(" ) ");
		}
	}

	public static int matrixChainMultiplicationRecursive() {
		int n = p.length - 1;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				m[i][j] = infinity;
			}
		}
		return lookUpChain(1, n);
	}

	private static int lookUpChain(int i, int j) {
		if (i == j)
			m[i][j] = 0;
		else if (m[i][j] < infinity)
			return m[i][j];
		else {
			int q = infinity;
			for (int k = i; k < j; k++) {
				q = lookUpChain(i, k) + lookUpChain(k + 1, j)
						+ (p[i - 1] * p[k] * p[j]);
				if (q < m[i][j]) {
					m[i][j] = q;
					s[i][j] = k;
				}
			}
		}
		return m[i][j];
	}

	public static int matrixMultiplicationIterative() {
		int n = p.length - 1;
		for(int l = 2;l<=n;l++){
			for (int i = 1; i <= n-l+1; i++) {
				int j = i+l-1;
				m[i][j]=infinity;
				for (int k = i; k < j; k++) {
					int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(q < m[i][j]){
						m[i][j] = q;
						s[i][j]= k;
					}
				}
			}
		}
		return m[1][6];
	}
}
