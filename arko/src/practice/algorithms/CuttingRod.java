package practice.algorithms;

public class CuttingRod {
	public static int prices[] = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
	public  int optimal[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static int trace[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int q = 0;

	public void cutRod() {
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j <= i; j++) {
				// q = Math.max(q, prices[j] + optimal[i - j]);
				if (q < (prices[j] + optimal[i - j])) {
					q = prices[j] + optimal[i - j];
					trace[i] = j;
				}
			}
			optimal[i] = q;
		}
	}

	public static void main(String[] args) {
		CuttingRod cuttingRod = new CuttingRod();
		cuttingRod.cutRod();
		for (int i = 1; i < 11; i++) {
			System.out.print(cuttingRod.optimal[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < 11; i++) {
			System.out.print(trace[i] + " ");
		}
	}

}
