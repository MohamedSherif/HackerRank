package imp;

public class MergeSortSolver {

	
	public static long mergesort(int[] array) {
		return mergesort(array, new int[array.length], 0, array.length - 1);
	}
	
	public static long mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
		long inversionCount = 0;
		
		if(leftStart >= rightEnd) {
			return 0;
		}
		
		int middleIndex = (leftStart + rightEnd) / 2;
		
		//	Inversion Count will be the sum of inversions in left sub-array, right sub-array and number of inversions in merging. 
		inversionCount = mergesort(array, temp, leftStart, middleIndex);
		inversionCount += mergesort(array, temp, middleIndex + 1, rightEnd);
		//	merge the two parts
//		inversionCount += mergeHalves(array, temp, leftStart, rightEnd);
		
		inversionCount += merge(array, temp, leftStart, middleIndex+1, rightEnd);
		
		return inversionCount;
	}
	
	public static long mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		int inversionCount = 0;
		
		int leftEnd = (leftStart + rightEnd) /2;
		int rightStrat = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStrat;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
				inversionCount = inversionCount + (leftEnd - left +1);
			}
			index++;
		}
		
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		
		System.arraycopy(temp, leftStart, array, leftStart, size);
		
		return inversionCount;
	}
	
	
	public static long merge(int[] array, int[] temp, int left, int mid, int right) {
		
		int i, j, k;
		int inversionCount = 0;
		
		i = left; 	//	i is index of left subarray.
		j = mid;	//	j is index of right subarray.
		k = left;	//	k is index of resultant merged subarray/
		
		while((i <= mid - 1) && (j <= right)) {
			if(array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
				inversionCount = inversionCount + (mid - i);
			}
		}
		
		while(i <= mid - 1) {
			temp[k++] = array[i++];
		}
		
		while(j <= right) {
			temp[k++] = array[j++];
		}
		
		for(i = left; i <= right; i++) {
			array[i] = temp[i];
		}
		
//		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
//		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
//		System.arraycopy(temp, leftStart, array, leftStart, size);
		
		return inversionCount;
	}
	
}
