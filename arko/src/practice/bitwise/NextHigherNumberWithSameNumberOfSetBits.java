package practice.bitwise;

import java.util.Scanner;

public class NextHigherNumberWithSameNumberOfSetBits {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x;
		
		while ((x = input.nextInt())!=0) {
			System.out.println(nextHigherNumberWithSameNumberOfSetBits(x));
		}
	}

	public static int nextHigherNumberWithSameNumberOfSetBits(int x) {
		int firstSetBit= x & (-x);
		int nextZeroBit = x + firstSetBit;
		int ones = x ^ nextZeroBit;
		ones = (ones >> 2)/firstSetBit;
		return nextZeroBit | ones;
	}
}
