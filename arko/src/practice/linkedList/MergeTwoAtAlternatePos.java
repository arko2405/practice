package practice.linkedList;

public class MergeTwoAtAlternatePos {

	public static void main(String[] args) {
		Node f = new Node(7, null);
		Node e = new Node(6, f);
		Node d = new Node(5, e);
		Node c = new Node(4, d);
		Node b = new Node(3, c);
		Node a = new Node(2, b);
		Node headA = new Node(1, a);

	/*	Node f1 = new Node(70, null);
		Node e1 = new Node(60, f1);
		Node d1 = new Node(50, e1);*/
		Node c1 = new Node(40, null);
		Node b1 = new Node(30, c1);
		Node a1 = new Node(20, b1);
		Node headB = new Node(10, a1);

		print(headA);
		System.out.println();
		print(headB);
		System.out.println();
		System.out.println();
		merge(headA, headB);
	}

	private static void merge(Node headA, Node headB) {
		Node p = headA;
		Node q = headB;
		while (p != null && q != null) {
			Node pNext = p.next;
			Node qNext = q.next;
			
			q.next=pNext;
			p.next=q;
			
			p=pNext;
			q=qNext;
		}
		headB=q;
		print(headA);
		System.out.println();
		print(headB);
	}

	private static void print(Node head) {
		if (head != null) {
			System.out.print(head.item + " ");
			print(head.next);
		}
	}
}
