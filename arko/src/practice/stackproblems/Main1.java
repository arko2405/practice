package practice.stackproblems;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {
	public static void main(String[] args) {
		Stack<Character> stackArray = new Stack<Character>();
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			String str = input.next();
			if (str == null) {
				System.out.print("Yes");
				if (i != n - 1)
					System.out.println();
			} else {
				int x = 0;
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) == ')') {
						Character c = ')';
						if (stackArray.isEmpty()) {
							c = ')';
						}

						else {
							c = stackArray.pop();
						}
						if (!c.equals('('))
							x = 1;
					} else if (str.charAt(j) == ']') {
						Character c = ')';
						if (stackArray.isEmpty()) {
							c = ')';
						}

						else {
							c = stackArray.pop();
						}
						if (!c.equals('['))
							x = 1;
					} else {
						stackArray.push(str.charAt(j));
					}
				}
				if (x == 0 && stackArray.isEmpty()) {
					System.out.print("Yes");
					if (i != n - 1)
						System.out.println();
				} else {
					System.out.print("No");
					stackArray.clear();
					if (i != n - 1)
						System.out.println();
				}
			}
		}
	}
}
