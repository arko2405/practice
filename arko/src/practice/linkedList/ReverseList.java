package practice.linkedList;

public class ReverseList {
static Node head;
	public static void main(String[] args) {
		Node c = new Node(4, null);
		Node b = new Node(3, c);
		Node a = new Node(2,b);
		head = new Node(1, a);
		print(head);
		System.out.println();
		reverse(head);
		print(head);
	}

	public static void print(Node head2) {
		while(head2 != null){
			System.out.print(head2.item + " " );
			head2 = head2.next;
		}
	}

	public static  void reverse(Node heada) {
		if(heada != null){
			Node first = heada;
			Node next = first.next;
			if(next != null){
				head = next;
				 reverse(next);
				first.next = null;
				next.next = first;
			}
		}
	}
}
