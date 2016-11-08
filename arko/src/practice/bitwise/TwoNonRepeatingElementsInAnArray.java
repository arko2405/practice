package practice.bitwise;

public class TwoNonRepeatingElementsInAnArray {

	public static void main(String[] args) {
		int arr[] = {3,5,2,6,3,5,9,2,8,6};
		int xor = arr[1];
		for (int i = 1; i < arr.length; i++) {
			xor = xor ^ arr[i]; 
		}
		xor = xor & (-xor);
		int x=0,y=0;
		for (int i = 0; i < arr.length; i++) {
			if((arr[i] & xor) !=0)
				x ^=arr[i];
			else
				y ^=arr[i];
		}
		System.out.println(x + "  " + y);
		
		System.out.println(x-((x-y) & ((x-y)>>31)));
	}
}
