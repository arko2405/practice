package practice.datastucture;

public class DoublyLinkedList<E> {
	private Node<E> dummy=new Node<E>(null, null, null);

	public DoublyLinkedList() {
		dummy.next=dummy;
		dummy.previous=dummy;
	}

	public Boolean isEmpty() {
		if (dummy.next == dummy)
			return true;
		return false;
	}

	public void addToFirst(E item) {
		
		Node<E> first = new Node<E>(item, dummy.next, dummy);
		/*if(isEmpty()){
			dummy.next = first;
			dummy.previous = first;
		}*/
		first.next.previous = first;
		dummy.next = first;
	}

	public void addToLast(E item) {
		Node<E> last = new Node<E>(item, dummy, dummy.previous);
		last.previous.next = last;
		dummy.previous = last;
	}

	public E deleteFromFirst() {
		Node<E> temp = dummy.next;
		dummy.next = temp.next;
		temp.next.previous = dummy;
		temp.next = null;
		temp.previous = null;
		return temp.item;
	}

	public E deleteFromLast() {
		Node<E> temp = dummy.previous;
		dummy.previous = temp.previous;
		temp.previous.next = dummy;
		temp.next = null;
		temp.previous = null;
		return temp.item;
	}

	public E getFirst() {
		return dummy.next.item;
	}

	public E getLast() {
		return dummy.previous.item;
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> previous;

		public Node(E item, Node<E> next, Node<E> previous) {

			this.item = item;
			this.next = next;
			this.previous = previous;
		}

		

	}
	public void printReverse(){
		printReverse(this.dummy);
		
	}
	private  void printReverse(Node<E> root){
		if(root.next != this.dummy){
			printReverse(root.next);
		}
		System.out.println(root.item);
		
	}

	@Override
	public String toString() {
		return "DoublyLinkedList [dummy=" + dummy + "]";
	}
	
}
