package practice.interviewquestions;

import java.util.Scanner;

public class Polygon {
	public static void main(String[] args) {
		int rect = 0,sqr=0,oth=0;
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			if (a == c && b == d && (a>0 && b>0 && c>0 && d>0)) {
				if (c != b)
					rect++;
				else
					sqr++;
			}
			else
				oth++;
		}

		System.out.println(sqr + " " + rect + " " + oth);
	}
}
