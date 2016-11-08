package practice.linkedList;

public class AddTwoNumbers {

	public static void main(String[] args) {
		/*
		 * Node f = new Node(7, null); Node e = new Node(6, f); Node d = new
		 * Node(5, e); Node c = new Node(4, d);
		 */
		Node b = new Node(2, null);
		Node a = new Node(2,b);
		Node headA = new Node(2, a);

		/*
		 * Node f1 = new Node(70, null); Node e1 = new Node(60, f1); Node d1 =
		 * new Node(50, e1); Node c1 = new Node(40, null);
		 */
		Node b1 = new Node(2, null);
		Node a1 = new Node(3, b1);
		Node headB = new Node(1, a1);

		Node ans = add(headA, headB);
		if(ans.item == 0)
			ans = ans.next;
		print(ans);
		
	}

	private static Node add(Node headA, Node headB) {
		
		if (headA == null)
			return headB;
		else if (headB == null)
			return headA;
		
		int sizeA = sizeOF(headA);
		int sizeB = sizeOF(headB);
		if(sizeA > sizeB){
			for (int i = 0; i < sizeA-sizeB; i++) {
				Node temp = new Node(0, headB);
				headB=temp;
			}
		}
		if(sizeB > sizeA){
			for (int i = 0; i < sizeB-sizeA; i++) {
				Node temp = new Node(0, headA);
				headA=temp;
			}
		}
		return addSame(headA,headB);
		
	}

	private static Node addSame(Node headA, Node headB) {
		if(headA == null && headB==null)
			return new Node(0, null);
		Node temp = addSame(headA.next, headB.next);
		int temp1 = headA.item + headB.item + temp.item;
		temp.item = temp1%10;
		Node curr = new Node(temp1/10, temp);
		return curr;
	}

	private static int sizeOF(Node head) {
		int count=0;
		while(head != null){
			count++;
			head = head.next;
			}
		return count;
	}
	private static void print(Node head) {
		if (head != null) {
			System.out.print(head.item + " ");
			print(head.next);
		}
	}
}
