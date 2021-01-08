package imp;

import java.util.Scanner;

public class StringS1ToS2Transformer {

	
	public static void transformS2ToS2(String s1, String s2) {
		int lcsLen = findLCSLen(s1, s2);
		
		System.out.println("Minimum number of deletions required: " + (s1.length() - lcsLen));
		System.out.println("Minimum number of insertions required: " + (s2.length() - lcsLen));
	}
	
	private static int findLCSLen(String s1, String s2) {
		char [] X = s1.toCharArray();
		char [] Y = s2.toCharArray();
		
		int m = s1.length();
		int n = s2.length();
		
		return LongestCommonSubsequenceSolver.LCSM4(X, Y, m, n);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		transformS2ToS2(s1, s2);
		sc.close();
	}
}
