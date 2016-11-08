package practice.linkedList;

public class CommonElementsOfTwoSortedLists {

	public static void main(String[] args) {
		Node f = new Node(7, null);
		Node e = new Node(6, f);
		Node d = new Node(5, e);

		Node b = new Node(3, d);
		Node a = new Node(2, b);
		Node headA = new Node(1, a);

		/*
		 * Node f1 = new Node(70, null); Node e1 = new Node(60, f1); Node d1 =
		 * new Node(50, e1);
		 */
		Node c1 = new Node(9, null);
		Node b1 = new Node(7, c1);
		Node a1 = new Node(4, b1);
		Node headB = new Node(2, a1);

		Node node = commonList(headA, headB);
		print(node);

	}

	private static Node commonList(Node headA, Node headB) {
		Node head = new Node(0, null);
		Node first = head;
		while (headA != null && headB != null) {
			if (headA.item == headB.item) {
				Node node = new Node(headA.item, null);
				first.next = node;
				first = node;
				headA = headA.next;
				headB = headB.next;
			}
			else if(headA.item < headB.item)
				headA = headA.next;
			else
				headB = headB.next;
		}
		return head.next;
	}

	public static void print(Node head2) {
		while (head2 != null) {
			System.out.print(head2.item + " ");
			head2 = head2.next;
		}
	}

}
