package imp;

import java.util.LinkedList;
import java.util.Queue;

import trees.Node;

public class LevelOrderTraversal {
/*
 * METHOD 1 (Use function to print a given level) Algorithm: 
 * 	There are basically two functions in this method. One is to print all nodes at a
 * 	given level (printGivenLevel), 
 * and other is to print level order traversal of the tree (printLevelorder). printLevelorder makes use of
 * printGivenLevel to print nodes at all levels one by one starting from root.
 * 
 * - Function to print level order traversal of tree 
 * 	printLevelorder(tree) 
 * 		for d = 1 to height(tree) 
 * 			printGivenLevel(tree, d);
 * 
 * - Function to print all nodes at a given level 
 * 	printGivenLevel(tree, level)
 * 		if tree is NULL then return; 
 * 		if level is 1, then 
 * 			print(tree->data); 
 * 		else
 * 			if level greater than 1, then 
 * 				printGivenLevel(tree->left, level-1);
 * 				printGivenLevel(tree->right, level-1);
 */
	
	/* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    static int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else 
            	return(rheight+1); 
        }
    }
	
	
	/* function to print level order traversal of tree*/
    static void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
    
    /* Print nodes at the given level */
    static void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
    
    /* Driver program to test above functions */
    public static void main(String args[])
    {
       Node root = new Node(1);
       root.left= new Node(2);
       root.right= new Node(3);
       root.left.left= new Node(4);
       root.left.right= new Node(5);
        
       System.out.println("Level order traversal of binary tree is ");
       printLevelOrder(root);
       System.out.println("");
       printLevelOrderWithQueue(root);
    }
	
    
	/*
	 * METHOD 2 (Use Queue)
	 * 
	 * Algorithm: For each node, first the node is visited and then it’s child
	 * nodes are put in a FIFO queue.
	 * 
	 * printLevelorder(tree) 
	 * 1) Create an empty queue q 
	 * 2) temp_node = root start from root 
	 * 3) Loop while temp_node is not NULL 
	 * 		a) print temp_node->data. 
	 * 		b) Enqueue temp_node’s children (first left then right children) to q 
	 * 		c) Dequeue a node from q and assign it’s value to temp_node 
	 * 
	 * Implementation: 
	 * Here is a simple implementation of the above algorithm. 
	 * Queue is implemented using an array with maximum size of 500.
	 * We can implement queue as linked list also.
	 */
    
    
    
    static void printLevelOrderWithQueue(Node root){
    	
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	queue.add(root);
    	
    	while(!queue.isEmpty()){
    		//	poll() removes the present head.
    		Node temp_node = queue.poll();
    		
    		System.out.print(temp_node.data + " ");
    		
    		//	Enqueue Left Node
    		if(temp_node.left != null){
    			queue.add(temp_node.left);
    		}
    		// 	Enqueue Right Node
    		if(temp_node.right != null){
    			queue.add(temp_node.right);
    		}
    	}
    	
    	
    }
    
    
    
	
}