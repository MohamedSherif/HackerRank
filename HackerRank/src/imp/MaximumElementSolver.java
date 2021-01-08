package imp;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElementSolver {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			
			Stack<Integer> mainStack = new Stack<Integer>();
			Stack<Integer> maxStack = new Stack<Integer>();
			
			maxStack.push(Integer.MIN_VALUE);
			
			for(int i = 0; i < N; i++) {
				int op = sc.nextInt();
				
				switch (op) {
				case 1: // Push to stack
					int element = sc.nextInt();
					mainStack.push(element);
					int maxElementSoFar = maxStack.peek();
					
					if(element > maxElementSoFar) {
						maxStack.push(element);
					} else {
						maxStack.push(maxElementSoFar);
					}
					
					break;	// 
				case 2: // Delete the top element of the stack
					mainStack.pop();
					maxStack.pop();
					break;
				case 3: // Print the Maximum element of the stack
					System.out.println(maxStack.peek());
					break;
					
				}
			}
			sc.close();
		}
}
