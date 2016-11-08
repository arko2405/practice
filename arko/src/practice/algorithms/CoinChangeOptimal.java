package practice.algorithms;

public class CoinChangeOptimal {
	static int infinity = 99999;

	public static void main(String[] args) {
		int denominations[] = { 1, 6, 10 };
		int size = denominations.length;
		for (int i = 0; i < 21; i++) {

			System.out.print(coinChangeIterativeLessSpace(denominations, size, i)
					+ "  |  ");
		}
	}

	public static int coinChangeRecursive(int denomination[], int size, int n) {
		if (n == 0)
			return 0;
		if(n<0)
			return -1;
		if (size <= 0)
			return infinity;
		return Math.min(
				coinChangeRecursive(denomination, size - 1, n),
				((n - denomination[size - 1]) >= 0) ? 1 + coinChangeRecursive(
						denomination, size, (n - denomination[size - 1]))
						: infinity);
	}

	public static int coinChangeIterative(int denomination[], int size, int n) {
		if (n == 0)
			return 0;
		if(n<0)
			return -1;
		if (size <= 0)
			return infinity;
		int table[][] = new int[n + 1][size];
		for (int i = 0; i < size; i++) {
			table[0][i] = 0;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < size; j++) {
				int x = (j > 0) ? table[i][j - 1] : infinity;
				int y = (i - denomination[j]) >= 0 ?1+ table[i - denomination[j]][j]
						: infinity;
				table[i][j] = Math.min(x,y);
			}
		}
		/*for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}*/
		return table[n][size - 1];
	}

	public static int coinChangeIterativeLessSpace(int denomination[],
			int size, int n) {
		if (n < 0)
			return -1;
		int table[] = new int[n + 1];
		for (int i =1; i < table.length; i++) {
			table[i]=infinity;
		}
		table[0] = 0;
		for (int i = 0; i < size; i++) {
			for (int j = denomination[i]; j < n + 1; j++) {
				table[j] = Math.min(table[j],1+table[j - denomination[i]]);
			}
		}
		return table[n];
	}

}
