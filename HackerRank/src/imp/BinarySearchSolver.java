package imp;

public class BinarySearchSolver {

	public static boolean binarySearchIterative(int[] array, int x) {
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right) {
			int midIndex = (left + right) / 2;
			
			if(array[midIndex] == x) {
				return true;
			} else if(x < array[midIndex]) {
				right = midIndex - 1;
			} else {
				left = midIndex + 1;
			}
		}
		return false;
	}
	
	public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
		if(left > right) {
			return false;
		}
		
		int midIndex = (left + right) / 2;
		
		if(array[midIndex] == x) {
			return true;
		} else if(x < array[midIndex]) {
			return binarySearchRecursive(array, x, left, midIndex - 1);
		} else {
			return binarySearchRecursive(array, x, midIndex + 1, right);
		}
	}
	
	public static boolean binarySearchRecursive(int[] array, int x) {
		return binarySearchRecursive(array, x, 0, array.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(binarySearchIterative(arr, 9));
		System.out.println(binarySearchRecursive(arr, 9));
	}
}
