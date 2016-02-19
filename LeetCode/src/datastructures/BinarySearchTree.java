package datastructures;

public class BinarySearchTree {

	private int value;
	private BinarySearchTree parent;
	private BinarySearchTree left;
	private BinarySearchTree right;

	public BinarySearchTree(int x) {
		value = x;
	}

	public BinarySearchTree search(BinarySearchTree tree, int val) { // recursively search based on value we are looking for, runs in O(log(n)) time, may degenerate to O(N) time. Worst case run time is the height of the tree.
		if (tree == null) { // not found in tree 
			return null;
		}
		if (tree.value == val) { // found
			return tree;
		}
		if (val > tree.value) { // go right
			return search(tree.right, val);
		} else { // go left
			return search(tree.left, val);
		}
	}

	public BinarySearchTree findMin(BinarySearchTree tree) {
		if (tree == null) { // invalid tree
			return null;
		}
		BinarySearchTree current = tree; // root at least exists but may be minimum
		while (current.left != null) { // stop when current can not go further left
			current = current.left;
		}
		return current;
	}

	public BinarySearchTree findMax(BinarySearchTree tree) {
		if (tree == null) {
			return null;
		}
		BinarySearchTree current = tree;
		while (current.right != null) { // stop when current can not go further right
			current = current.right;
		}
		return current;
	}

	public void traverseTree(BinarySearchTree tree) { // runs in O(N) time
		if (tree != null) {
			traverseTree(tree.left);
			System.out.println(tree.value);
			traverseTree(tree.right);
		}
	}

	public void insertTree(BinarySearchTree tree, int val, BinarySearchTree parent) {
		if (tree == null) { // found spot to insert at
			tree = new BinarySearchTree(val);
			tree.parent = parent;
			if (tree.value > parent.value) { // value is greater
				parent.right = tree;
			} else { // value is less
				parent.left = tree;
			}
		}

		if (val > tree.value) { // go right
			insertTree(tree.right, val, tree);
		} else if (val < tree.value) { // go left
			insertTree(tree.left, val, tree);
		}
	}

	public BinarySearchTree deleteTree(BinarySearchTree tree, int val) {
		if (tree == null) { // not found
			System.out.println("Not Found");
			return tree;
		}
		if (tree.value > val) {
			tree.left = deleteTree(tree.left, val);
		} else if (tree.value < val) {
			tree.right = deleteTree(tree.right, val);
		} else if (tree.value == val) { // found value to delete
			if (tree.right == null) {
				return tree.left;
			}
			if (tree.left == null) {
				return tree.right;
			}
			if (tree.left != null && tree.right != null) { // two children
				BinarySearchTree temp = tree;
				tree = findMin(temp.right);
				tree.right = deleteTree(temp.right, tree.value);
				tree.left = temp.left;
			}
			return tree;
		}
		return tree; // store previous tree in right or left position from method call in conditional statements
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(2);
		tree.insertTree(tree, 1, null);
		tree.insertTree(tree, 7, null);
		tree.insertTree(tree, 4, null);
		tree.insertTree(tree, 8, null);
		tree.insertTree(tree, 3, null);
		tree.insertTree(tree, 6, null);
		tree.insertTree(tree, 5, null);
		tree.deleteTree(tree, 1);
		tree.deleteTree(tree, 7);
		tree.traverseTree(tree);
	}
}
