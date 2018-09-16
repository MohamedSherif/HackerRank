package imp;

public class BinarySearchTree {

	private static Node root;
	private static Node prev;

	private static class Node {
		int val;
		Node left;
		Node right;

		Node(int data) {
			val = data;
		}
	}

	public static void add(int data) {

		if (root == null) {
			root = new Node(data);
			return;
		}

		Node node = root;
		while (true) {
			if (data <= node.val) {
				if (node.left == null) {
					node.left = new Node(data);
					break;
				}
				node = node.left;
			} else {
				if (node.right == null) {
					node.right = new Node(data);
					break;
				}
				node = node.right;
			}
		}
	}

	private static Node getLCA(Node curr, int node1, int node2) {
		if (curr == null)
			return null;
		if (curr.val == node1 || curr.val == node2)
			return curr;

		Node left = getLCA(curr.left, node1, node2);
		Node right = getLCA(curr.right, node1, node2);

		if (left != null && right != null)
			return curr;

		return left == null ? right : left;
	}

	private static int getDepth(Node curr, int target) {
		if (curr == null)
			return -1;

		if (curr.val == target)
			return 0;

		int left = getDepth(curr.left, target);
		int right = getDepth(curr.right, target);

		if (left == -1 && right == -1)
			return -1;

		return left == -1 ? right + 1 : left + 1;

	}

	public static int bstDistance(int[] values, int n, int node1, int node2) {
		if (values.length > 0) {
			for (int i : values) {
				add(i); // Build the BST.
			}

			Node ancestor = getLCA(root, node1, node2);
			if (ancestor != null) {
				int depth1 = getDepth(root, ancestor.val);

				int depth2 = getDepth(root, node1);
				int depth3 = getDepth(root, node2);

				if (depth2 == -1 || depth3 == -1) {
					return -1;
				} else {
					return depth2 + depth3 - 2 * depth1;
				}
			} else {
				return -1;
			}

		} else {
			return -1;
		}
	}

	/**
	 * For each node, check if MAX value in left subtree is smaller than the
	 * node and MIN value in right subtree greater than the node.
	 * 
	 * (Correct but not efficient)
	 * 
	 * @param root
	 * @return
	 */
	public static boolean _isBST(Node root) {
		// Empty tree is a BST.
		if (root == null)
			return true;

		if (root.left != null && maxValue(root.left) > root.val)
			return false;

		if (root.right != null && minValue(root.right) < root.val)
			return false;

		if (_isBST(root.left) && _isBST(root.right))
			return true;
		else
			return false;
	}

	private static int maxValue(Node node) {
		// TODO To be implemented to return the Max Value of non empty tree.
		return node.val;
	}

	private static int minValue(Node node) {
		// TODO To be implemented to return the Min Value of non empty tree.
		return node.val;
	}
	// ===================================

	/*
	 * Method 2 above runs slowly since it traverses over some parts of the tree
	 * many times. A better solution looks at each node only once. The trick is
	 * to write a utility helper function isBSTUtil(struct node* node, int min,
	 * int max) that traverses down the tree keeping track of the narrowing min
	 * and max allowed values as it goes, looking at each node only once. The
	 * initial values for min and max should be INT_MIN and INT_MAX — they
	 * narrow from there.
	 * 
	 * Time Complexity: O(n) Auxiliary Space : O(1) if Function Call Stack size
	 * is not considered, otherwise O(n)
	 */
	public static boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTUtil(Node node, int min, int max) {
		if (node == null) { // an empty tree is a BST.
			return true;
		}

		// false if this node violates the min/max constraints
		if (node.val < min || node.val > max) {
			return false;
		}

		/*
		 * Otherwise check the subtrees recursively tightening the min/max
		 * constraints Allow only distinct values
		 */
		return (isBSTUtil(node.left, min, node.val - 1) && isBSTUtil(node.right, node.val + 1, max));
	}

	// =========================================

	/*
	 * METHOD 4(Using In-Order Traversal)
	 * 
	 * Thanks to LJW489 for suggesting this method. 1) Do In-Order Traversal of
	 * the given tree and store the result in a temp array. 3) Check if the temp
	 * array is sorted in ascending order, if it is, then the tree is BST.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * We can avoid the use of Auxiliary Array. While doing In-Order traversal,
	 * we can keep track of previously visited node. If the value of the
	 * currently visited node is less than the previous value, then tree is not
	 * BST. Thanks to ygos for this space optimization.
	 */
	public static boolean isBST_() {
		prev = null;
		return isBST_(root);
	}

	private static boolean isBST_(Node node) {
		if (node != null) {
			if (!isBST_(node.left))
				return false;

			if (prev != null && node.val <= prev.val)
				return false;

			prev = node;

			return isBST_(node.right);
		}
		return true;
	}

	public static void main(String[] args) {
		int[] values = { 4 };
		System.out.println(bstDistance(values, values.length, 2, 5));
	}
}
// public static int bstDistance(int[] values, int n, int node1, int node2)
// {
// int dist = -1;
//
// if(values.length >= 2){
// Node root = new Node(values[0]);
//
// for (int i = 1; i < values.length; i++) {
// insert(root, values[i]);
// }
// }
//
// return dist;
// }
//
// public static Node insert(Node root, int data) {
// if (root == null) {
// return new Node(data);
// } else {
// Node cur;
// if (data <= root.data) {
// cur = insert(root.left, data);
// root.left = cur;
// } else {
// cur = insert(root.right, data);
// root.right = cur;
// }
// return root;
// }
// }
//
// }
//
// class Node {
// public Node left;
// public Node right;
// public int data;
//
// public Node(int data) {
// this.data = data;
// left = null;
// right = null;
// }
// }