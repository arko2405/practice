package practice.datastucture;

import practice.utility.MyException;

public class StackArray<E> {
	private Object stack[];
	private int top;

	public StackArray(Integer size) {
		super();
		this.stack = new Object[size];
		this.top = -1;
	}

	public StackArray() {
		this(10);
	}

	public Boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	public void push(E item) {
		if (top == stack.length - 1) {
			try {
				throw new MyException("Overflow");
			} catch (MyException e) {
				System.out.println(e.getErrorMessage());
			}
		} else {
			top += 1;
			stack[top] = item;
		}
	}

	@SuppressWarnings("unchecked")
	public E pop() {

		if (isEmpty()) {
			try {
				throw new MyException("Underflow");
			} catch (MyException e) {
				System.out.println(e.getErrorMessage());
				return null;
			}
		}

		else {
			top -= 1;
			return (E) stack[top + 1];
		}
	}
}
