package imp;

import java.util.Scanner;
import java.util.Stack;

/*
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 * By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:
 * It contains no unmatched brackets.
 * The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 * Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.
 * 
 * Input Format
 * The first line contains a single integer, , denoting the number of strings. 
 * Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.
 * Output Format
 * For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, 
 * print YES; otherwise, print NO.
 * 
 * Explanation
 * The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 * The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced.
 * The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 * Explanation
 * - The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 * - The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced.
 * - The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.


 */

public class BalancedBrackets {

//	private class myStack<T> implements Stack<T>{
//		
//	}
	
	/**
	 * New Method Test Edit
	 * @param in
	 * @return
	 */
	public static boolean isBalanced(String in){
		Stack<Character> charStack = new Stack<Character>();
	
		for (int i = 0; i < in.length(); i++) {
			if(in.charAt(i) == '{' || in.charAt(i) == '(' || in.charAt(i) == '[' || in.charAt(i) == '<'){
				charStack.push(in.charAt(i));
			}
			
			if(in.charAt(i) == '}' || in.charAt(i) == ')' || in.charAt(i) == ']' || in.charAt(i) == '>'){
				if(charStack.isEmpty())
					return false;
				
				if(!isMatchingPair(charStack.pop(), in.charAt(i)))
					return false;
				
			}
		}
		
		if(charStack.isEmpty())
			return true;
		else
			return false;
	}
	
	private static boolean isMatchingPair(char c1, char c2) {
		if (c1 == '(' && c2 == ')')
			return true;
		else if (c1 == '{' && c2 == '}')
			return true;
		else if (c1 == '[' && c2 == ']')
			return true;
		else if (c1 == '<' && c2 == '>')
			return true;
		else
			return false;
	}
	
	
	public static int hasBalancedBrackets(String str)
	{
		// WRITE YOUR CODE HERE
		
		Stack<Character> charStack = new Stack<Character>();
	
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '<'){
				charStack.push(str.charAt(i));
			}
			
			if(str.charAt(i) == '}' || str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '>'){
				if(charStack.isEmpty())
					return 0;
				
				if(!isMatchingPair(charStack.pop(), str.charAt(i)))
					return 0;
				
			}
		}
		
		if(charStack.isEmpty())
			return 1;
		else
			return 0;
		
	}
	
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            if(isBalanced(s))
            	System.out.println("YES");
            else
            	System.out.println("NO");
            
            
            System.out.println(hasBalancedBrackets(s));
        }
    }
}
