package imp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. 
 * To find the median, you must first sort your set of integers in non-decreasing order, 
 * then: 
 * - If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set {1, 2, 3} , 2 is the median.
 * - If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. 
 * In the sorted set {1,2,3,4}, (2+3)/2 = 2.5 is the median.
 * Given an input stream of  integers, you must perform the following task for each ith integer:
 * 1- Add the ith integer to a running list of integers.
 * 2- Find the median of the updated list (i.e., for the first element through the ith element).
 * 3- Print the list's updated median on a new line. The printed value must be a double-precision number scaled to 1 decimal place (i.e., 12.3 format).
 * 
 * Input Format:
 * The first line contains a single integer, n , denoting the number of integers in the data stream. 
 * Each line i of the n subsequent lines contains an integer, ai , to be added to your list.
 * 
 * Output Format
 * After each new integer is added to the list, print the list's updated median on a new line as a single double-precision 
 * number scaled to 1 decimal place (i.e., 12.3 format).
 */
public class RunningMedian {

	public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		if(lowers.size() == 0 || number < lowers.peek()){
			lowers.add(number);
		}else{
			highers.add(number);
		}
	}

	
	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size()? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size()? highers : lowers;
		
		if(biggerHeap.size() - smallerHeap.size() >= 2){
			// Poll the lowers' MAX element or the higher's MIN element.
			smallerHeap.add(biggerHeap.poll());
		}
	}
	
	private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size()? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size()? highers : lowers;
		
		if(smallerHeap.size() == biggerHeap.size()){
			return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
		}else{
			return biggerHeap.peek();
		}
	}

	
	
	
	public static double[] getMedians(int[] array){
		// MAX Heap to contain the Lower Half of Integers
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			// Changed comparison method to put the Biggest element on the TOP.
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return -1 * a.compareTo(b);
			}
		});
		
		// MIN Heap (Using the default comparator) to contain the Higher half of Integers.
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		
		double[] medians = new double[array.length];
		
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			
			addNumber(number, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		return medians;
		
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arr = new int[t];
        for(int i = 0; i < t; i++){
            int ai = in.nextInt();
            arr[i] = ai;
        }
        
        double[] medians = getMedians(arr);
        for (int i = 0; i < medians.length; i++) {
			System.out.println(medians[i]);
		}
	}
	
}
