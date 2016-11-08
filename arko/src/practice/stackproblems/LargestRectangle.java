package practice.stackproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int p = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			int arr[] = new int[p];
			int max = 0;
			for (int i = 0; i < p; i++) {
				Integer n = sc.nextInt();
				arr[i]=n;
				if(st.isEmpty() || n>=arr[st.peek()])
					st.push(i);
				else{
					while(!st.isEmpty() && arr[st.peek()]>n){
						int x = st.pop();
						int area;
						if(st.isEmpty())
							area = arr[x]*i;
						else
						  area = arr[x]*(i-st.peek()-1);
						max=(max>=area)?max:area;
					}
				}
				st.push(i);
			}
			while(!st.isEmpty()){
				int x = st.pop();
				int area;
				if(st.isEmpty())
					area = arr[x]*p;
				else
				  area = arr[x]*(p-st.peek()-1);
				max=(max>=area)?max:area;
			}
			System.out.println(max);
		}
	}

}
/*
There are  buildings in a certain two-dimensional landscape. Each building has a height given by . If you join  adjacent buildings, they will form a solid rectangle of area .

Given  buildings, find the greatest such solid area formed by consecutive buildings.

Input Format 
The first line contains , the number of buildings altogether. 
The second line contains  space-separated integers, each representing the height of a building.

Constraints 
 


Output Format 
One integer representing the maximum area of rectangle formed.

Sample Input

5
1 2 3 4 5
Sample Output

9
Explanation 
rect formed by 345 : 3*3=9

*/