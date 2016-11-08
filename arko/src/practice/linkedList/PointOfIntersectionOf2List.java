package practice.linkedList;

public class PointOfIntersectionOf2List {

	public static void main(String[] args) {
		Node f = new Node(70, null);
		Node e = new Node(46, f);
		Node d = new Node(30, e);
		Node c = new Node(15, d);
		Node b = new Node(9, c);
		Node a = new Node(6, b);
		Node headA = new Node(3, a);

		Node b1 = new Node(9, c);
		Node a1 = new Node(6, b1);
		Node headB = new Node(10, a1);
		System.out.println(intersection(headA, headB));
	}

	private static Node intersection(Node headA, Node headB) {
		int countA = 0;
		int countB = 0;
		Node first = headA;
		Node second = headB;
		while (first != null) {
			countA++;
			first = first.next;
		}
		while (second != null) {
			countB++;
			second = second.next;
		}
		int d = Math.abs(countA - countB);
		if (countA > countB) {
			first = headA;
			second = headB;
		}
		else{
			first = headB;
			second = headA;
		}
		while(d>0){
			first = first.next;
			d--;
		}
		while(first !=null && second!=null){
			if(first == second)
				return first;
			first=first.next;
			second=second.next;
		}
		return null;
	}
}
