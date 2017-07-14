package practice.disjointSet;

import java.util.Scanner;

public class MergingCommunities {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Parent parents[] = new Parent[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = new Parent(i, 1);
			}
			int noOfQueries = sc.nextInt();
			while (noOfQueries-- > 0) {
				String q = sc.next();
				if (q.equalsIgnoreCase("Q")) {
					System.out.println(parents[sc.nextInt()].getParent().noOfMembers);
				} else {
					int x = sc.nextInt();
					int y= sc.nextInt();
					int g = Math.min(x, y);
					int b = Math.max(x, y);
					
					if (parents[g].getParent() != parents[b].getParent()) {
						Parent low = parents[g].getParent().value<parents[b].getParent().value?parents[g].getParent():parents[b].getParent();
						Parent high = parents[g].getParent().value<parents[b].getParent().value?parents[b].getParent():parents[g].getParent();
						low.noOfMembers = low.noOfMembers+high.noOfMembers;
						high.parent = low;
					}
				}
			}

		}
	}
	static class Parent{
		public int value;
		public int noOfMembers;
		Parent parent;
		public Parent(int value, int noOfMembers) {
			super();
			this.value = value;
			this.noOfMembers = noOfMembers;
			parent =this;
		}
		public Parent getParent() {
			if(this.parent == this)
				return this;
			else return this.parent.getParent();
		}
	}
}

/*
People connect with each other in a social network. A connection between
Person and Person is represented as . When two persons belonging to different
communities connect, the net effect is the merger of both communities which
and belongs to.

At the beginning, there are people representing communities. Suppose person
and connected and later and connected, then ,, and will belong to the same
community.

There are two type of queries:

communities containing person and merged (if they belong to different
communities).

print the size of the community to which person belongs.

Input Format

The first line of input will contain integers and , i.e. the number of people
and the number of queries. The next lines will contain the queries.

Constraints :



Output Format

The output of the queries.

Sample Input

3 6
Q 1
M 1 2
Q 2
M 2 3
Q 3
Q 2
Sample Output

1
2
3
3
 Explanation

Initial size of each of the community is .

 */