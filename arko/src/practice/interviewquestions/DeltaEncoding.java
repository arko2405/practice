package practice.interviewquestions;

import java.util.Comparator;
import java.util.Scanner;

public class DeltaEncoding {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int first = in.nextInt();
		System.out.print(first);
		while(in.hasNext()) {
			int temp = in.nextInt();
			int difference = temp-first;
			if (difference>127 ||difference <-127) {
				System.out.print(" -128 " + difference);
			} else {
				System.out.print(" " + difference);
			}
			first = temp;
			
		}
	}

	
}
