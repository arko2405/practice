package practice.bitwise;

public class BinaryRepresentation {

	public static void main(String[] args) {
		
		for (int n = 0; n < 10; n++) {

			for (int i = 1<<31; i!=0 ; i = i>>>1) {
				System.out.print(((n & i) != 0) ? "1" : "0");
			}
			System.out.println();
		}
	}

}
