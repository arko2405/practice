package practice.bitwise;

public class ElementOccuringOnce {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 3, 2, 2, 2, 5, 3, 1, 3 };
		int n = arr.length;
		System.out.println("The element with single occurrence is "
				+ getSingleOccurence(arr, n));
	}

	static int getSingleOccurence(int arr[], int n) {
		int result = 0;
		for (int i = 1 << 31; i != 0; i = i >>> 1) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & arr[j]) != 0)
					sum++;
			}
			if (sum % 3 != 0)
				result = result | i;
		}
		return result;
	}

	static int getSingle(int arr[], int n) {
		int ones = 0, twos = 0;
		int common_bit_mask;
		for (int i = 0; i < n; i++) {
			twos = twos | (ones & arr[i]);
			ones = ones ^ arr[i];
			common_bit_mask = ~(ones & twos);
			ones &= common_bit_mask;
			twos &= common_bit_mask;
			System.out.println(Integer.toBinaryString(ones) + " "
					+ Integer.toBinaryString(twos) + " "
					+ Integer.toBinaryString(common_bit_mask));
		}
		return ones;
	}
}
