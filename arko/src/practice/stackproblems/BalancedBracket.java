package practice.stackproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {

	public static void main(String[] args) {
		Map<Character, Character> br = new HashMap<>();
		br.put(')', '(');
		br.put(']', '[');
		br.put('}', '{');
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int p = sc.nextInt();
			while(p-->0){
				
				String s = sc.next();
				Boolean isBalanced = true;
				Stack<Character> st = new Stack<>();
				for (int i = 0; i < s.length(); i++) {
					if(br.containsKey(s.charAt(i))){
						if(st.isEmpty() || br.get(s.charAt(i))!=st.pop()){
							isBalanced = false;
							break;
						}
					}
					else
						st.push(s.charAt(i));
				}
				if(isBalanced && st.isEmpty())
				System.out.println("YES");
				else
					System.out.println("NO");
				
			}
		}
	}

}
