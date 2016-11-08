package practice.bitwise;

public class AddOne {

	public static void main(String[] args) {
		int x = 100;
		x = -~x;
		System.out.println(x);
		
		int y = 10;
		x = ((y<<3)-y)>>1;
		System.out.println(x);
		
	}
}
