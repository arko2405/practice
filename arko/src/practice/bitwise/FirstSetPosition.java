package practice.bitwise;

public class FirstSetPosition {

	public static void main(String[] args) {
		int x=8;
		x = x & (-x);
		int p = (int) (Math.log(x)/Math.log(2));
		System.out.println(p+1);
	}
}
