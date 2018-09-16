package imp;

import java.util.Scanner;

import trees.Node;

public class BinaryTree {

	/**
	 * The height of a binary tree is the number of edges between the tree's
	 * root and its furthest leaf. This means that a tree containing a single
	 * node has a height of 0.
	 * 
	 * @param root
	 * @return
	 */
	static int height(Node root) {
		// Write your code here.
		if (root == null) {
			return -1;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	public static void preOrderTraversal(Node root){
		if (root == null) 
			return;
		System.out.print(root.data + " ");
		if(root.left != null) inOrderTraversal(root.left);
		if(root.right != null) inOrderTraversal(root.right);
	}
	
	public static void inOrderTraversal(Node root){
		if (root == null) 
			return;
		
		if(root.left != null) inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		if(root.right != null) inOrderTraversal(root.right);
	}
	
	public static void postOrderTraversal(Node root){
		if (root == null) 
			return;
		
		if(root.left != null) inOrderTraversal(root.left);
		if(root.right != null) inOrderTraversal(root.right);
		
		System.out.print(root.data + " ");
	}
	
	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		int height = height(root);
		System.out.println(height);
		
		System.out.println("");
		
		preOrderTraversal(root);
		
		System.out.println("");
		
		inOrderTraversal(root);
		
		System.out.println("");
		
		postOrderTraversal(root);
	}
}
