package practice.stackproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int p = sc.nextInt();
			Stack<String> st = new Stack<>();
			String w = "";
			st.push(w);
			while(p-->0){
				String s = sc.next();
				String temp = st.peek();
				if(s.equalsIgnoreCase("1")){
					st.push(temp+sc.next());
				}
				else if(s.equalsIgnoreCase("2")){
					Integer k = sc.nextInt();
					if(temp.length()<=k)
						st.push("");
					else
						st.push(temp.substring(0,temp.length()-1-k));
				}
				else if(s.equalsIgnoreCase("3")){
					Integer k = sc.nextInt();
					if(temp.length()>=k)
						System.out.println(temp.charAt(k-1));
				}
				else if(s.equalsIgnoreCase("4") && st.size()>1){
					st.pop();
				}
			}
		System.out.println(st.peek());
		}

	}

}
/*

In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . You must perform  operations of the following  types:

append - Append string  to the end of .
delete - Delete the last  characters of .
print - Print the  character of .
undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
Input Format

The first line contains an integer, , denoting the number of operations. 
Each line  of the  subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer,  (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument,  is followed by its space-separated argument. For example, if  and , line  will be 1 abcd.

Constraints



The sum of the lengths of all  in the input .
All input characters are lowercase English letters.
It is guaranteed that the sequence of operations given as input is possible to perform.
Output Format

Each operation of type  must print the  character on a new line.

Sample Input

8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1
Sample Output

c
y
a

*/