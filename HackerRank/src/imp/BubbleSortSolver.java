package imp;

public class BubbleSortSolver {
	
	public static void pubbleSort(int[] array) {
		boolean isSorted = false;
		int lastUnsortedIndex = array.length - 1;
		
		while(!isSorted) {
			isSorted = true;
			
			for (int i = 0; i < array.length - 1; i++) {
				if(array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					isSorted = false;
				}
			}
			lastUnsortedIndex --;
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
