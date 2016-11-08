package practice.bitwise;

public class SwapNBits {

	public static void main(String[] args) {
		int x = 16;
		int p1 = 0 ;
		int p2 = 3 ;
		int n = 2;
		
		
		int set1 = x>>p1;
		int set2 = x>>p2;
		
		set1 = set1 & ((1<<n) - 1);
		set2 = set2 & ((1<<n) - 1);
		int xor = set1 ^ set2;
		int s = (xor<<p1) | (xor<<p2);
		
		int ans = x ^ s;
		System.out.println(ans);
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(ans));
	}
}
