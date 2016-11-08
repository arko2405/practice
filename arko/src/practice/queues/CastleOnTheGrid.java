package practice.queues;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CastleOnTheGrid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Queue<Point> a = new LinkedList<>();
			List<String> grid = new ArrayList<>();
			while (n-- > 0) {
				grid.add(sc.next());
			}
			n = grid.size();
			Point init = new Point(sc.nextInt(), sc.nextInt());
			Point dest = new Point(sc.nextInt(), sc.nextInt());
			Map<Point, Boolean> visited = new HashMap<>();
			a.offer(init);
			int size = a.size();
			int dist = 0;
			boolean found = false;
			while (!found) {
				while (!a.isEmpty() && size-- > 0) {
					Point temp = a.poll();
					if (temp.equals(dest)) {
						found = true;
						break;
					}
					visited.put(temp, true);
					for (int i = temp.y + 1; i < n; i++) {
						Point temp1 = new Point(temp.x, i);
						if (grid.get(temp.x).charAt(i) == 'X' || visited.containsKey(temp1))
							break;
						a.offer(temp1);
					}
					for (int i = temp.y - 1; i >= 0; i--) {
						Point temp1 = new Point(temp.x, i);
						if (grid.get(temp.x).charAt(i) == 'X' || visited.containsKey(temp1))
							break;
						a.offer(temp1);
					}
					for (int i = temp.x + 1; i < n; i++) {
						Point temp1 = new Point(i, temp.y);
						if (grid.get(i).charAt(temp.y) == 'X' || visited.containsKey(temp1))
							break;
						a.offer(temp1);
					}
					for (int i = temp.x - 1; i >= 0; i--) {
						Point temp1 = new Point(i, temp.y);
						if (grid.get(i).charAt(temp.y) == 'X' || visited.containsKey(temp1))
							break;
						a.offer(temp1);
					}

				}
				size = a.size();
				if (!found)
					dist++;
			}
			System.out.println(dist);
		}
	}

}
/*

You are given a grid with both sides equal to . Rows and columns are numbered from  to . There is a castle on the intersection of the th row and the th column.

Your task is to calculate the minimum number of steps it would take to move the castle from its initial position to the goal position ().

It is guaranteed that it is possible to reach the goal position from the initial position.

Note: You can move the castle from cell  to any  in a single step if there is a straight line between and  that does not contain any forbidden cell. Here, "X" denotes a forbidden cell.

Input Format

The first line contains an integer , the size of the grid.

The following  lines contains a string of length  that consists of one of the following characters: "X" or ".". Here, "X" denotes a forbidden cell, and "." denotes an allowed cell.

The last line contains , , denoting the initial position of the castle, and , , denoting the goal position. Here,  and  are space separated.

Constraints

 
 

Output Format

Output a single line: The integer denoting the minimum number of steps required to move the castle to the goal position.

Sample Input

3
.X.
.X.
...
0 0 0 2
Sample Output

3
Explanation

Here is a path that one could follow in order to reach the destination in  steps:

.

*/

