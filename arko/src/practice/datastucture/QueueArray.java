package practice.datastucture;

import practice.utility.MyException;

public class QueueArray<E> {
	private Object[] queue;
	private int head;
	private int tail;

	public QueueArray(Integer size) {
		super();
		this.queue = new Object[size];
		this.head = 0;
		this.tail = 0;
	}

	public QueueArray() {
		this(10);
	}

	public boolean isEmpty() {
		if (head == tail) {
			return true;
		}
		return false;
	}
	public int size(){
		return Math.abs(head - tail);
	}

	public void enqueue(E entry) {
		if ((tail + 1) % (queue.length) == head) {
			try {
				throw new MyException("Overflow");
			} catch (MyException e) {
				System.out.println(e.getErrorMessage());
			}
		} else {
			tail = (tail + 1) % queue.length;
			queue[tail] = entry;
		}
	}

	@SuppressWarnings("unchecked")
	public E dequeue() {
		if (this.isEmpty()) {
			try {
				throw new MyException("Underflow");
			} catch (MyException e) {
				System.out.println(e.getErrorMessage());
				return null;
			}
		} else {
			head=(head+1)%queue.length;
			E temp = (E) queue[head];
			return temp;
		}
	}
}
