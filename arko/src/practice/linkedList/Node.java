package practice.linkedList;

public class Node {
     int item;
     Node next;
	public Node(int item, Node next) {
		super();
		this.item = item;
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [item=" + item + ", next=" + next + "]";
	}
     
}
