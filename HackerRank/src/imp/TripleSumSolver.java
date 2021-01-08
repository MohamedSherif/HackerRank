package imp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TripleSumSolver {

	static long triplets(int[] a, int[] b, int[] c) {
		long distinctTripletsCount = 0;
		
		int[] distinctA = removeDuplicates(a);
		int[] distinctB = removeDuplicates(b);
		int[] distinctC = removeDuplicates(c);
		
		Arrays.sort(distinctA);
		Arrays.sort(distinctB);
		Arrays.sort(distinctC);
		
		for (int q : distinctB) {
			long c1 = getValidIndex(distinctA, q) + 1;
			long c3 = getValidIndex(distinctC, q) + 1;
			
			distinctTripletsCount += c1 * c3;
		}
		
		return distinctTripletsCount;
	}
	
	static int getValidIndex(int[] distinctArr, int key) {
		int count = -1;
		
		int left = 0;
		int right = distinctArr.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if(key >= distinctArr[mid]) {
				count = mid;
				
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		} 
		
		return count;
	}
	
	static int[] removeDuplicates(int[] arr) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		
		int[] result = new int[set.size()];
		int i = 0;
		for (int element : set) {
			result[i++] = element;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int [] a = {1, 4, 5};
    	int [] b = {3, 2, 3};
    	int [] c = {1, 2, 3};
    	
    	System.out.println(triplets(a, b, c));
	}
}
