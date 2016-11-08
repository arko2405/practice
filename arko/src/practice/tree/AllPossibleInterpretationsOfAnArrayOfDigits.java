package practice.tree;

public class AllPossibleInterpretationsOfAnArrayOfDigits {

	static final String[] alphabet = { "", "a", "b", "c", "d", "e", "f", "g",
			"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "v", "z" };

	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 4 };
		printAllInterpretations(arr, arr.length, 0, "");
		System.out.println();
		int[] arr2 = { 1, 1, 1 };
		printAllInterpretations(arr2, arr2.length, 0, "");
		System.out.println();
		int[] arr3 = { 2, 6 };
		printAllInterpretations(arr3, arr3.length, 0, "");
		System.out.println();
		int[] arr4 = { 1, 2 };
		printAllInterpretations(arr4, arr4.length, 0, "");
		System.out.println();
		int[] arr5 = { 1, 0 };
		printAllInterpretations(arr5, arr5.length, 0, "");
		System.out.println();
		int[] arr6 = {};
		printAllInterpretations(arr6, arr6.length, 0, "");
		System.out.println();
		int[] arr7 = { 1, 2, 2, 1 };
		printAllInterpretations(arr7, arr7.length, 0, "");
	}

	private static void printAllInterpretations(int[] arr, int length,
			int start, String s) {
		if(start == length)
			System.out.print(s + " ");
		if (start == length - 1) {
			s= s + alphabet[arr[start]]; 
			System.out.print(s + " ");
		} else if (start < length - 1) {
			s= s + alphabet[arr[start]]; 
			printAllInterpretations(arr, length, start + 1,s);
			int index = arr[start] * 10 + arr[start + 1];
			if (index <= 26) {
				if(s.length() == 1)
					s=alphabet[index];
				else
					s= s.substring(0, s.length()-1) + alphabet[index]; 
				printAllInterpretations(arr, length, start + 2,s);
			}
		}
	}
}
