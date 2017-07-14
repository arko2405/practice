package practice.algorithms.searchingrelated;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

//quest : https://www.hackerrank.com/challenges/count-luck
public class CountLuck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int t = sc.nextInt();
			while (t-- > 0) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				Queue<Point> a = new LinkedList<>();
				List<String> grid = new ArrayList<>();
				Point init = null;
				Point dest = null;
				for (int i = 0; i < n; i++) {
					String s = sc.next();
					grid.add(s);
					if(s.contains("M"))
						init = new Point(i, s.indexOf("M"));
					if(s.contains("*"))
						dest = new Point(i, s.indexOf("*"));
				}
				int k = sc.nextInt();
				Map<Point, Boolean> visited = new HashMap<>();
				visited.put(init, true);
				findDest(init,dest,visited,k,0,n,m,grid);
			}
		}
	}

	private static void findDest(Point init, Point dest, Map<Point, Boolean> visited, int k, int noOfTimesWand, int n, int m, List<String> grid) {
		int x = init.x;
		int y = init.y;
		if(x>=0 && x<n && y<m && y>=0 && grid.get(x).charAt(y)!='X'){
			if(init.equals(dest)){
				visited.put(dest, true);
				if(k==noOfTimesWand)
					System.out.println("Impressed");
				else
					System.out.println("Oops!");
				return ; 
			}
			int noOfWaysForward = 0;
			if(y+1<m && grid.get(x).charAt(y+1)!='X' && !visited.containsKey(new Point(x, y+1)))
				noOfWaysForward++;
			if(y-1>=0 && grid.get(x).charAt(y-1)!='X' && !visited.containsKey(new Point(x, y-1)))
				noOfWaysForward++;
			if(x+1<n && grid.get(x+1).charAt(y)!='X' && !visited.containsKey(new Point(x+1, y)))
				noOfWaysForward++;
			if(x-1>=0 && grid.get(x-1).charAt(y)!='X' && !visited.containsKey(new Point(x-1, y)))
				noOfWaysForward++;
			if(noOfWaysForward>1)
				noOfTimesWand++;
			visited.put(init, true);
			if(!visited.containsKey(dest) && !visited.containsKey(new Point(x, y+1)))
				findDest(new Point(x, y+1), dest, visited, k, noOfTimesWand, n, m, grid);
			if(!visited.containsKey(dest) && !visited.containsKey(new Point(x, y-1)))
				findDest(new Point(x, y-1), dest, visited, k, noOfTimesWand, n, m, grid);
			if(!visited.containsKey(dest) && !visited.containsKey(new Point(x+1, y)))
				findDest(new Point(x+1, y), dest, visited, k, noOfTimesWand, n, m, grid);
			if(!visited.containsKey(dest) && !visited.containsKey(new Point(x-1, y)))
				findDest(new Point(x-1, y), dest, visited, k, noOfTimesWand, n, m, grid);
		}
	}

}
/*

Ron and Hermione are deep in the Forbidden Forest collecting potion ingredients, and they've managed to lose their way. The path out of the forest is blocked, so they must make their way to a portkey that will transport them back to Hogwarts.

Consider the forest as an  grid. Each cell is either empty (represented by .) or blocked by a tree (represented by ). Ron and Hermione can move (together inside a single cell) LEFT, RIGHT, UP, and DOWN through empty cells, but they cannot travel through a tree cell. Their starting cell is marked with the character , and the cell with the portkey is marked with a . The upper-left corner is indexed as .

.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
In example above, Ron and Hermione are located at index  and the portkey is at . Each cell is indexed according to Matrix Conventions

Hermione decides it's time to find the portkey and leave. Each time they are able to move in more than one direction, she waves her wand and it points to the correct direction. Ron is betting that she will have to wave her wand exactly  times. Can you determine if Ron's guesses are correct?

Note: It is guaranteed that there is only one path from the starting location to the portkey.

Input Format

The first line contains an integer, , the number of test cases.

Each test case is described as follows: 
The first line contains  space-separated integers,  and , respectively, denoting the forest matrix. 
The  subsequent lines each contain a string of length  describing a row of the forest matrix. 
The last line contains an integer, , denoting Ron's guess as to how many times Hermione will wave her wand.

Constraints




There will be exactly one  and one  in the forest.
Exactly one path exists between  and .
Output Format

On a new line for each test case, print  if Ron impresses Hermione by guessing correctly; otherwise, print .

Sample Input

3
2 3
*.M
.X.
1
4 11
.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
3
4 11
.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
4
Sample Output

Impressed
Impressed
Oops!

*/