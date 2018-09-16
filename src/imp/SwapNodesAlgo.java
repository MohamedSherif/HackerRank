package imp;

import java.util.Scanner;

/*
 * Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, 
 * then after swapping left subtree will be R and right subtree L. Eg. In the following tree, we swap children of node 1.
 * 
 * Swap operation: Given a tree and a integer, K, we have to swap the subtrees of all the nodes who are at depth h, where h ∈ [K, 2K, 3K,...].
 * You are given a tree of N nodes where nodes are indexed from [1..N] and it is rooted at 1. You have to perform T swap operations on it, 
 * and after each swap operation print the inorder traversal of the current state of the tree.
 * 
 * Input Format 
 * First line of input contains N, number of nodes in tree. Then N lines follow. Here each of ith line (1 <= i <= N) 
 * contains two integers, a b, where a is the index of left child, and b is the index of right child of ith node. 
 * -1 is used to represent null node. 
 * Next line contain an integer, T. Then again T lines follows. Each of these line contains an integer K.
 * 
 * Output Format 
 * For each K, perform swap operation as mentioned above and print the inorder traversal of the current state of tree
 */
public class SwapNodesAlgo {

	private static void swap(Pair[] array, int K, int maxDepth) {
		for (int h = K; h <= maxDepth; h += K) {
			swap(array, h, 1, 1);
		}
	}

	private static void swap(Pair[] array, int depth, int currIndex, int currDepth) {
		if (currIndex < 1) {
			return;
		}
		Pair p = array[currIndex];
		if (currDepth == depth) {
			p.swapSubtrees();
		} else {
			swap(array, depth, p.left, currDepth + 1);
			swap(array, depth, p.right, currDepth + 1);
		}
	}

	private static void inorderTraverse(Pair[] array, int index) {
		if (index != -1) {
			inorderTraverse(array, array[index].left);
			System.out.print(index + " ");
			inorderTraverse(array, array[index].right);
		}
	}

	public static void main(String[] args) {
		/* Create tree */
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Pair[] array = new Pair[N + 1]; // represents our tree
		for (int i = 1; i <= N; i++) {
			array[i] = new Pair(scan.nextInt(), scan.nextInt());
		}

		/* Perform swaps and print inorder traversals */
		int T = scan.nextInt();
		for (int i = 1; i <= T; i++) {
			int K = scan.nextInt();
			swap(array, K, N);
			inorderTraverse(array, 1);
			System.out.println();
		}
		scan.close();
	}
}

class Pair {
	int left;
	int right;

	public Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public void swapSubtrees() {
		int temp = left;
		left = right;
		right = temp;
	}
}
