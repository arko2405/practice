package practice.datastucture;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {

	public Node<E> root;
	private LinkedList<E> list = new LinkedList<E>();

	public BinarySearchTree() {
		this.root = null;
	}

	public Boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	public int height() {
		return this.height(root);
	}

	private int height(Node<E> root) {

		if (root != null) {
			return 1 + Math.max(height(root.left), height(root.right));
		}
		return 0;

	}

	public void insert(E item) {
		if (root == null) {
			root = new Node<E>(item, null, null);
		} else {
			Node<E> newNode = root;
			Node<E> leafNode = root;
			while (newNode != null) {
				leafNode = newNode;
				int c = item.compareTo(newNode.item);
				if (c < 0) {
					newNode = newNode.left;
				} else {
					newNode = newNode.right;
				}
			}
			int c = item.compareTo(leafNode.item);
			if (c < 0) {
				leafNode.left = new Node<E>(item, null, null);
			} else {
				leafNode.right = new Node<E>(item, null, null);
			}
		}

	}

	public List<E> inorder() {
		list.clear();
		return this.inorder(root);
	}

	private List<E> inorder(Node<E> root) {

		if (root != null) {
			inorder(root.left);
			list.add(root.item);
			inorder(root.right);
		}
		return list;

	}

	public List<E> levelorder() {
		list.clear();
		return this.levelorder(root);
	}

	private List<E> levelorder(Node<E> root) {

		int height = height(root);
		for (int i = 1; i <= height; i++) {
			getLevelNode(root, i);
		}
		return list;
	}

	private void getLevelNode(Node<E> root, int level) {
		if(root != null){
			if(level == 1)
				list.add(root.item);
			else{
				getLevelNode(root.left, level-1);
				getLevelNode(root.right, level-1);
			}
		}
	}

	public List<E> preorder() {
		list.clear();
		return this.preorder(root);
	}

	private List<E> preorder(Node<E> root) {
		if (root != null) {
			list.add(root.item);
			preorder(root.left);
			preorder(root.right);
		}
		return list;

	}

	public List<E> postorder() {
		list.clear();
		return this.postorder(root);
	}

	private List<E> postorder(Node<E> root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			list.add(root.item);
		}
		return list;

	}

	public Node<E> parentOf(E item) {
		Node<E> parent = null;
		Node<E> searched = root;
		if (root == null || item.equals(root.item))
			return null;
		else {
			while (searched != null) {
				int c = item.compareTo(searched.item);
				if (c == 0)
					return parent;
				else if (c < 0) {
					parent = searched;
					searched = searched.left;
				} else {
					parent = searched;
					searched = searched.right;
				}

			}
			return null;
		}
	}

	public Node<E> search(E item) {
		if (root.item.equals(item)) {
			return root;
		}

		else {
			Node<E> parent = parentOf(item);
			if (parent == null) {
				return null;
			} else {
				int c = item.compareTo(parent.item);
				return ((c < 0) ? parent.left : parent.right);
			}

		}
	}

	public E minimum() {
		return minimum(this.root);
	}

	public E maximum() {
		return maximum(this.root);
	}

	private E minimum(Node<E> root) {
		Node<E> min = null;
		Node<E> temp = root;
		if (!this.isEmpty()) {
			while (temp != null) {
				min = temp;
				temp = temp.left;
			}
			return min.item;
		} else {
			return null;
		}
	}

	private E maximum(Node<E> root) {
		Node<E> max = null;
		Node<E> temp = root;
		if (!this.isEmpty()) {
			while (temp != null) {
				max = temp;
				temp = temp.right;
			}
			return max.item;
		} else {
			return null;
		}
	}

	public E successor(E item) {
		Node<E> node = search(item);

		if (node == null) {
			return null;
		} else {
			if (node.right != null) {
				return minimum(node.right);
			} else {
				Node<E> parent = parentOf(item);

				while ((parent != null) && (node == parent.right)) {
					node = parent;
					parent = parentOf(parent.item);
				}
				if (parent == null)
					return null;
				return parent.item;
			}
		}

	}

	public E predessor(E item) {
		Node<E> node = search(item);

		if (node == null) {
			return null;
		} else {
			if (node.left != null) {
				return maximum(node.left);
			} else {
				Node<E> parent = parentOf(item);

				while ((parent != null) && (node == parent.left)) {
					node = parent;
					parent = parentOf(parent.item);
				}
				if (parent == null)
					return null;
				return parent.item;
			}
		}

	}

	private void transplant(Node<E> old, Node<E> replacement) {
		Node<E> oldParent = parentOf(old.item);
		if (oldParent == null) {
			root = replacement;
		} else if (oldParent.left == old) {
			oldParent.left = replacement;
		} else if (oldParent.right == old) {
			oldParent.right = replacement;
		}
	}

	public void delete(E item) {
		Node<E> deleteNode = search(item);
		if (deleteNode.left == null) {
			transplant(deleteNode, deleteNode.right);
		} else if (deleteNode.right == null) {
			transplant(deleteNode, deleteNode.left);
		} else {

			Node<E> replaceNode = search(successor(item));

			if (deleteNode.right != replaceNode) {
				transplant(replaceNode, replaceNode.right);
				replaceNode.right = deleteNode.right;
			}
			transplant(deleteNode, replaceNode);
			replaceNode.left = deleteNode.left;
		}
	}

	@Override
	public String toString() {
		return "BinarySearchTree [root=" + root + ", list=" + list + "]";
	}

	public static class Node<E extends Comparable<E>> {
		public E item;
		public Node<E> left;
		public Node<E> right;

		public Node(E item, Node<E> left, Node<E> right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [item=" + item + ", left=" + left + ", right=" + right
					+ "]";
		}

	}
}
