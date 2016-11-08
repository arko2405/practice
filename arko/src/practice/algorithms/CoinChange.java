package practice.algorithms;

public class CoinChange {
	public static void main(String[] args) {
		int denominations[] = {2,5,3,6};
		int n = 10;
		int size = denominations.length;
		System.out.println(coinChangeIterativeLessSpace(denominations, size, n));
	}

	public static int coinChangeRecursive(int denomination[], int size, int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0)
			return 0;
		if (size <= 0)
			return 0;
		return coinChangeRecursive(denomination, size - 1, n)
				+ coinChangeRecursive(denomination, size,
						(n - denomination[size - 1]));
	}

	public static int coinChangeIterative(int denomination[], int size, int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (size <= 0)
			return 0;
		int table[][] = new int[n + 1][size];
		for (int i = 0; i < size; i++) {
			table[0][i] = 1;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < size; j++) {
				int x = (j > 0) ? table[i][j - 1] : 0;
				int y = (i - denomination[j]) >= 0 ? table[i - denomination[j]][j]
						: 0;
				table[i][j] = x + y;
			}
		}
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
		return table[n][size - 1];
	}

	public static int coinChangeIterativeLessSpace(int denomination[],
			int size, int n) {
		if (n < 0)
			return 0;
		int table[] = new int[n + 1];
		table[0] = 1;
		for (int i = 0; i < size; i++) {
			for (int j = denomination[i]; j < n + 1; j++) {
				table[j] = table[j] + table[j - denomination[i]];
			}
		}
		return table[n];
	}
}
