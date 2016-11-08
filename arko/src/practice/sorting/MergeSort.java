package practice.sorting;

public class MergeSort {
	static int arr[] = { 4, 3, 6, 8, 7, 1, 9, 5 };

	public static void main(String[] args) {
		mergesort(0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void mergesort(int lower, int upper) {
		if (lower < upper) {
			int partition = (lower + upper) / 2;
			mergesort(lower, partition);
			mergesort(partition + 1, upper);
			merge(lower, upper, partition);
		}
	}

	private static void merge(int lower, int upper, int partition) {
		int n1 = partition - lower + 1;
		int n2 = upper - partition;
		int left[] = new int[n1 + 1];
		int right[] = new int[n2 + 1];
		left[n1] = 99999;
		right[n2] = 99999;
		for (int i = 0; i < n1; i++) {
			left[i] = arr[lower + i];
		}
		for (int j = 0; j < n2; j++) {
			right[j] = arr[partition + j + 1];
		}
		int i = 0;
		int j = 0;
		for (int k = lower; k <= upper; k++) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
		}
	}

}
