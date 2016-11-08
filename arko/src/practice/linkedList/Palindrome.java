package practice.linkedList;

public class Palindrome {

	static Node mid;
	public static void main(String[] args) {
		String s = "radar";
		Node head = null;
		for (int i = s.length()-1 ; i >= 0 ; i--) {
			 head = new Node(s.charAt(i), head);
		}
		ReverseList list = new ReverseList();
		list.print(head);
		System.out.println();
		System.out.println(isPalindrome(head));
		
	}

	private static boolean isPalindrome(Node head) {
		ReverseList list = new ReverseList();
		
		int count = 0;
		Node first = head;
		while(first != null){
			count++;
			first = first.next;
		}
		count = count/2;
		int n=0;
		first = head;
		while(n < count){
			first = first.next;
			n++;
		}
		mid = first;
		list.print(mid);
		System.out.println();
		reverse(mid);
		list.print(mid);
		System.out.println();
		n=0;
		first = head;
		while(n < count)
		{
			if(first.item != mid.item)
				return false;
			first = first.next;
			mid = mid.next;
			n++;
		}
		return true;
	}
	
	public static  void reverse(Node head) {
		if(head != null){
			Node first = head;
			Node next = first.next;
			if(next != null){
				mid = next;
				 reverse(next);
				first.next = null;
				next.next = first;
			}
		}
	}
}
