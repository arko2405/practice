package practice.advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class MrXAndHisShots {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		Range shotArray[] = new Range[n];
		Range fieldArray[] = new Range[m];
		int count = 0;

		for (int i = 0; i < n; i++)
			shotArray[i] = new Range(in.nextInt(), in.nextInt());

		for (int i = 0; i < m; i++)
			fieldArray[i] = new Range(in.nextInt(), in.nextInt());

		Arrays.sort(shotArray, new RangeComparator());
		Arrays.sort(fieldArray, new RangeComparator());

		int shotPointer = 0, fieldPointer = 0;

		while (fieldPointer < m && shotPointer < n) {
			if (fieldArray[fieldPointer].high < shotArray[shotPointer].low)
				fieldPointer++;

			else if (fieldArray[fieldPointer].low > shotArray[shotPointer].high)
				shotPointer++;

			else {
				int countPointer = shotPointer;

				while (countPointer < n && fieldArray[fieldPointer].high >= shotArray[countPointer].low) {

					if (Range.isOverlapping(fieldArray[fieldPointer], shotArray[countPointer]))
						count++;

					countPointer++;
				}
				fieldPointer++;
			}
		}
		System.out.println(count);

	}

	static class Range {
		int low;
		int high;

		public Range(int low, int high) {
			this.low = low;
			this.high = high;
		}

		public static boolean isOverlapping(Range a, Range b) {
			if (a.high < b.low || a.low > b.high)
				return false;
			else
				return true;
		}
	}

	static class RangeComparator implements Comparator<Range> {

		@Override
		public int compare(Range a, Range b) {
			if (a.low < b.low)
				return -1;
			else if (a.low > b.low)
				return 1;
			else
				return a.high - b.high;
		}
	}
}
/*

A cricket match is going to be held. The field is represented by a 1D plane.
A cricketer, Mr. X has favorite shots. Each shot has a particular range. The
range of the shot is from i to i. That means his favorite shot can be
anywhere in this range. Each player on the opposite team can field only in a
particular range. Player can field from i to i. You are given the favorite
shots of Mr. X and the range of players.

represents the strength of each player i.e. the number of shots player can
stop. Your task is to find:

.

Game Rules: A player can stop the shot if the range overlaps with the
player's fielding range.

For more clarity about overlapping, study the following figure:

L.png

Input Format

The first line consists of two space separated integers, and . Each of the
next lines contains two space separated integers. The line contains and .
Each of the next lines contains two integers. The line contains integers and
.

Output Format

You need to print the sum of the strengths of all the players: .

Constraints:




Sample Input

4 4 1 2 2 3 4 5 6 7 1 5 2 3 4 7 5 7 Sample Output

9 Explanation

Player 1 can stop the 1st, 2nd and 3rd shot so the strength is . Player 2 can
stop the 1st and 2nd shot so the strength is . Player 3 can stop the 3rd and
4th shot so the strength is . Player 4 can stop the 3rd and 4th shot so the
strength is .

The sum of the strengths of all the players is .

 */