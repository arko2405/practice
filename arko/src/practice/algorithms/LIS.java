package practice.algorithms;


public class LIS {
	public static int trace[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1 };
	public static int list[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
	public static int lis[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };

	public static void main(String[] args) {
		lis();
		int x = 0, j=0;
		for (int i = 0; i < lis.length; i++) {
			if (x < lis[i]) {
				x = lis[i];
				j = i;
			}
		}
		print(j);
	}

	public static void print(int j) {
		if (trace[j] == -1)
			System.out.print(list[j] + " ");
		else {
			print(trace[j]);
			System.out.print(list[j] + " ");
		}
	}

	public static void lis() {

		int max = 0;
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < i; j++) {
				if (list[i] > list[j] && lis[i] < (lis[j] + 1)) {
					lis[i] = lis[j] + 1;
					trace[i] = j;
				}
			}
		}
		for (int i = 0; i < lis.length; i++) {
			if (max < lis[i])
				max = lis[i];
		}
		System.out.println(max);
	}
}
