package practice.algorithms;

public class Partition {

	static int array[] = { 3, 1, 1, 2, 2 ,1 };

	public static void main(String[] args) {
		System.out.println(findPartiionIterative());
	}

	private static boolean isSubsetSum(int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		if (array[n - 1] > sum)
			return isSubsetSum(n - 1, sum);
		return isSubsetSum(n - 1, sum)
				|| isSubsetSum(n - 1, sum - array[n - 1]);
	}

	@SuppressWarnings("unused")
	private static boolean findPartiion() {
		int n = array.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += array[i];
		if (sum % 2 != 0)
			return false;
		return isSubsetSum(n, sum / 2);
	}

	static boolean findPartiionIterative() {
		int n = array.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += array[i];
		}
		if (sum % 2 != 0)
			return false;
		boolean matrix[][] = new boolean[sum / 2 + 1][n+1];
		for (int i = 0; i <= n; i++) {
			matrix[0][i] = true;
		}
		for (int i = 1; i <= sum / 2; i++) {
			matrix[i][0] = false;
		}
		for (int i = 1; i <= sum/2; i++) {
			for (int j = 1; j <= n; j++) {
				if (i < array[j-1])
					matrix[i][j] = matrix[i][j-1];
				else
					matrix[i][j] = matrix[i][j - 1] || matrix[i- array[j-1]][j - 1];
			}
		}
		for (int i = 0; i <= sum/2; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		return matrix[sum / 2][n];
	}
}
