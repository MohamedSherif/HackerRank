package imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

public class CountingValleysSolver {
	/*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
    	int valleysCount = 0;
    	int[] s = new int[path.length()];
    	
    	for (int i = 0; i < path.length(); i++) {
			if(path.charAt(i) == 'U') {
				s[i] = 1;
			}
			
			if(path.charAt(i) == 'D') {
				s[i] = -1;
			}
		}
    	
    	boolean isInValley = false;
    	
    	int pathSum = 0;
    	
    	for(int i = 0; i < path.length(); i++) {
    		pathSum += s[i];
    		
    		if(pathSum < 0 && !isInValley) {
    			// We are not already in a valley (Start of a valley)
    			isInValley = true;
    		}
    		
    		if(pathSum == 0 && isInValley) {
    			// We just come out from a valley (End of a valley, increase count)
    			
    			valleysCount ++;
    			isInValley = false; // Reset is in valley.
    		}
    	}
    	
    	return valleysCount;
    }
    
    
 // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long count = 0;
        long size = s.length();
        long repeated = n / size;
        long remaining = n - (size * repeated);
        
        if(!s.contains("a")){
            return 0;
        }
        
        if(s.equals("a")){
            return n;
        }
        
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        count = count * repeated;
        
        String partialString = "";
        // if(n%s.length() != 0){
        //     partialString = s.substring(0, (int) n%s.length());
        // }
        // for(int i = 0; i < partialString.length(); i++) {
        //     if (partialString.charAt(i) == 'a') {
        //         count++;
        //     }
        // }
        
        if(remaining > 0){
            for(int i = 0; i < remaining; i++){
                if (s.charAt(i) == 'a') {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
    // Complete the minimumSwaps function below.
//    static int minimumSwaps(int[] arr) {
//        int n = arr.length; 
//  
//        // Create two arrays and use as pairs where first 
//        // array is element and second array 
//        // is position of first element 
//        ArrayList <Pair <Integer, Integer> > arrpos = new ArrayList <Pair <Integer, Integer> > (); 
//        
//        for (int i = 0; i < n; i++) {
//            arrpos.add(new Pair <Integer, Integer> (arr[i], i));
//        }
//  
//        // Sort the array by array element values to 
//        // get right position of every element as the 
//        // elements of second array. 
//        arrpos.sort(new Comparator<Pair<Integer, Integer>>() 
//        { 
//            @Override
//            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) 
//            { 
//                if (o1.getKey() > o2.getKey()) 
//                    return -1; 
//  
//                // We can change this to make it then look at the 
//                // words alphabetical order 
//                else if (o1.getKey().equals(o2.getKey())) 
//                    return 0; 
//  
//                else
//                    return 1; 
//            } 
//        }); 
//  
//        // To keep track of visited elements. Initialize 
//        // all elements as not visited or false. 
//        Boolean[] vis = new Boolean[n]; 
//        Arrays.fill(vis, false); 
//  
//        // Initialize result 
//        int ans = 0; 
//  
//        // Traverse array elements 
//        for (int i = 0; i < n; i++) 
//        { 
//            // already swapped and corrected or 
//            // already present at correct pos 
//            if (vis[i] || arrpos.get(i).getValue() == i) 
//                continue; 
//  
//            // find out the number of  node in 
//            // this cycle and add in ans 
//            int cycle_size = 0; 
//            int j = i; 
//            while (!vis[j]) 
//            { 
//                vis[j] = true; 
//  
//                // move to next node 
//                j = arrpos.get(j).getValue(); 
//                cycle_size++; 
//            } 
//  
//            // Update answer by adding current cycle. 
//            if(cycle_size > 0) 
//            { 
//                ans += (cycle_size - 1); 
//            } 
//        } 
//  
//        // Return result 
//        return ans; 
//
//    }
    
 // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] array) {
       int n = array.length - 1;
        int minSwaps = 0;
        for (int i = 0; i < n; i++) {
            if (i < array[i] - 1) {
                swap(array, i, Math.min(n, array[i] - 1));
                minSwaps++;
                i--;
            }
        }
        return minSwaps; 
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    
    static String twoStrings(String s1, String s2) {
//    	String res = "NO";
//        
//        String firstWord = "";
//        String secondWord = "";
//        
//        if(s1.length() <= s2.length()) {
//            firstWord = s1;
//            secondWord = s2;
//        } else {
//            firstWord = s2;
//            secondWord = s1;
//        }
//        
//        for(int i = 0; i < firstWord.length(); i++) {
//            if(secondWord.indexOf(firstWord.charAt(i)) > -1) {
//                return "YES";
//            }
//        }
//        
//        return res;
    	System.out.println(Pattern.compile("[" + s2 + "]"));
    	if (Pattern.compile("[" + s2 + "]").matcher(s1).find())
            return "YES";
        return "NO";
    }
    
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int totalCount = 0;
    	
    	HashMap<String, Integer> map = new HashMap<>();
    	
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String currentSubString = s.substring(i, j);

                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);

                int value = map.getOrDefault(currentSubString, 0);
                if (value > 0) {
                    totalCount += value;
                }
                map.put(currentSubString, ++value);
            }
        }
        return totalCount;
    }
    
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	Map<Long, Long> leftMap = new HashMap<>();
    	Map<Long, Long> rightMap = new HashMap<>();
    	
    	for (Long item : arr) {
			rightMap.put(item, rightMap.getOrDefault(item, 0L) + 1);
		}
    	
    	long count = 0;
    	
    	for (int i = 0; i < arr.size(); i++) {
			long midItem = arr.get(i);
			long cLeft = 0, cRight = 0; 
			
			rightMap.put(midItem, rightMap.getOrDefault(midItem, 0L) - 1);
			
			if(leftMap.containsKey(midItem / r) && midItem%r == 0) {
				cLeft = leftMap.get(midItem / r);
			}
			
			if(rightMap.containsKey(midItem * r)) {
				cRight = rightMap.get(midItem * r);
			}
			
			count += cLeft * cRight;
			
			leftMap.put(midItem, leftMap.getOrDefault(midItem, 0L) + 1);
		}
    	
    	return count;
    }
    
    
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	List<Integer> output = new ArrayList<Integer>();
    	
    	Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    	
    	for (List<Integer> query : queries) {
			int operation = query.get(0);
			int data = query.get(1);
			
			if(operation == 1) {
				freqMap.put(data, freqMap.getOrDefault(data, 0) + 1);
			} else if(operation == 2) {
				if(freqMap.containsKey(data) && freqMap.get(data) > 0) {
					freqMap.put(data, freqMap.getOrDefault(data, 0) - 1);
				}
			} else if(operation == 3) {
//				boolean found = false;
//				
//				for(Map.Entry<Integer, Integer> set : freqMap.entrySet()) {
//					if(set.getValue() == data) {
//						found = true;
//						break;
//					}
//				}
//				if(found) {
//					output.add(1);
//				} else {
//					output.add(0);
//				}
				if(data > queries.size()) {
					output.add(0);
				} else {
					if (freqMap.containsValue(data)) {
						output.add(1);
					} else {
						output.add(0);
					}
				}
			}
		}
    	
    	return output;
    }
    
 // Complete the isValid function below.
    static String isValid(String s) {
        final String GOOD = "YES";
        final String BAD = "NO";

        if(s.isEmpty()) return BAD;
        if(s.length() <= 3) return GOOD;

        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++){
            letters[s.charAt(i) - 'a']++;
        }
        Arrays.sort(letters);
        int i=0;
        while(letters[i]==0){
            i++;
        }
        //System.out.println(Arrays.toString(letters));
        int min = letters[i];   //the smallest frequency of some letter
        int max = letters[25]; // the largest frequency of some letter
        String ret = BAD;
        if(min == max) ret = GOOD;
        else{
            // remove one letter at higher frequency or the lower frequency 
            if(((max - min == 1) && (max > letters[24])) || (min == 1) && (letters[i+1] == max))
                ret = GOOD;
        }
        return ret;
    }
    
 // Complete the substrCount function below.
    static long substrCount(int n, String s) {
    	long counter = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
			counter++;
			
			for (int j = i+1; j < s.length(); j++) {
				if(s.charAt(j) == s.charAt(i)) {
					counter++;
				} else {
					if(2*j-i < s.length() && s.substring(i, j).equals(s.substring(j+1, 2*j-i +1 ))) {
						counter++;
						break;
					} else {
						break;
					}
				}
			}
		}
    	
    	return counter;
    }
    
    
 // Complete the steadyGene function below.
    static int steadyGene(String gene) {
    	int minLengthString = gene.length();
    	Map<Character, Integer> ocurrences = new HashMap<Character, Integer>();
    	
    	ocurrences.put('A', 0);
    	ocurrences.put('C', 0);
    	ocurrences.put('G', 0);
    	ocurrences.put('T', 0);
    	
    	int expectedOcurrences = gene.length() / 4;
    	
    	for(char g : gene.toCharArray()) {
    		ocurrences.put(g, ocurrences.get(g) + 1);
    	}
    	
    	for(char g : ocurrences.keySet()) {
    		ocurrences.put(g, Math.max(0, ocurrences.get(g) - expectedOcurrences));
    	}
    	
    	if(ocurrences.get('A') == 0 && ocurrences.get('C') == 0 && ocurrences.get('G') == 0 && ocurrences.get('T') == 0)
    		return 0;
    	
    	
    	Map<Character, Integer> found = new HashMap<Character, Integer>();
    	
    	found.put('A', 0);
    	found.put('C', 0);
    	found.put('G', 0);
    	found.put('T', 0);
    	
    	int head = 0;
    	int tail = 0;
    	
    	while(head != gene.length()) {
    		found.put(gene.charAt(head), found.get(gene.charAt(head)) + 1);
    		
    		if(found.get('A') >= ocurrences.get('A') && found.get('C') >= ocurrences.get('C') && found.get('G') >= ocurrences.get('G') && found.get('G') >= ocurrences.get('G')) {
    			// This is a valid candidate
    			
    			minLengthString = Math.min(minLengthString, head - tail + 1);
    			
    			// Try to shorten it
    			while(found.get(gene.charAt(tail)) > ocurrences.get(gene.charAt(tail))) {
    				found.put(gene.charAt(tail), found.get(gene.charAt(tail)) - 1);
    				tail += 1;
    				minLengthString = Math.min(minLengthString, head - tail + 1);
    			}
    		}
    		head += 1;
    	}
    	return minLengthString;
    }
    
    //	Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
    	char palindrome[] = s.toCharArray();
    	
    	String result = "";
    	
    	// Iinitialize l and r by leftmost and rightmost ends  
    	int l = 0;
    	int r = s.length() - 1;
        
    	// first try to make String palindrome
    	while(l < r) {
    		// Replace left and right character by maximum of both
    		if(s.charAt(l) != s.charAt(r)) {
    			palindrome[l] = palindrome[r] = (char) Math.max(s.charAt(l), s.charAt(r));
    			k--;
    		}
    		l++;
    		r--;
    	}
        // If k is negative then we can't make String palindrome using k changes. 
    	if(k < 0) {
    		return "-1";
    	}
    	
    	l = 0;
    	r = s.length() - 1;
    	
    	while(l <= r) {
    		// 	At mid character, if K>0 then change it to 9  
            if (l == r) { 
                if (k > 0) { 
                    palindrome[l] = '9'; 
                } 
            } 
            
            //	If character at lth (same as rth) is less than 9
            if (palindrome[l] < '9') {
            	 /* If none of them is changed in the previous loop then subtract 2 from K and convert both to 9 */
            	if (k >= 2 && palindrome[l] == s.charAt(l) && palindrome[r] == s.charAt(r)) {
            		k -= 2; 
                    palindrome[l] = palindrome[r] = '9'; 
                }/* If one of them is changed in the previous loop then subtract 1 from K (1 more is subtracted already) and make them 9 */ 
            	else if (k >= 1 && (palindrome[l] != s.charAt(l) || palindrome[r] != s.charAt(r))) { 
                    k--; 
                    palindrome[l] = palindrome[r] = '9'; 
                } 
            }
            l++; 
            r--;
    	}
    	for(int i = 0;i<palindrome.length;i++) 
            result += palindrome[i];
    	
    	return result;
    }
    
    //	Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
    	int numToys = 0;
    	
    	Arrays.sort(prices);
    	
    	for (int i = 0; i < prices.length; i++) {
			if(prices[i] <= k) {
				numToys++;
				k -= prices[i];
			}
		}
    	return numToys;
    }
    
    public static int getMedian(int[] arr) {
    	Arrays.sort(arr);
    	int l = arr.length;
    	if(l % 2 != 0) { // Odd Number of numbers
    		return arr[l / 2];
    	} else {
    		return (arr[(l - 1) / 2] + arr[l / 2]) / 2;
    		
    	}
    }
    
    public static int activityNotifications(int[] expenditure, int d) {
    	int counter = 0;
    	int[] trailingDays = new int[d];
    	
    	for(int i = d; i < expenditure.length; i++) {
    		for(int j = 0; j < d; j++) {
    			trailingDays[j] = expenditure[i-d+j];
    		}
    		
    		int median = getMedian(trailingDays);
    		
    		if(expenditure[i] >= 2*median) {
    			counter++;
    		}
    	}
    	return counter;
    }
    
    
    
    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
    	int n = arr.length;
    	
    	if(n <= 1) {
    		return 0;
    	}

    	int mid = n / 2;
    	
    	int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
    	int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
    	
    	long inversions = countInversions(leftArr) + countInversions(rightArr);
    	
    	return inversions;
    }
    
    
    public static int arraySum(List<Integer> numbers) {
    	// Write your code here
    	int sum = 0;
    	
    	for(Integer i : numbers) {
    		sum += i;
    	}
    	
    	return sum; 
        
    }
    

    public static void reverseArray(int[] arr) {
    	for(int i = 0; i < arr.length / 2; i++)
    	{
    	    int temp = arr[i];
    	    arr[i] = arr[arr.length - i - 1];
    	    arr[arr.length - i - 1] = temp;
    	}
    }
    
    public static int lilysHomework(int[] arr) {
    	int[] reversedInput = new int[arr.length];
    	
    	System.arraycopy(arr, 0, reversedInput, 0, arr.length);
    	
    	reverseArray(reversedInput);

    	int ascSolution = solveBeutifulArray(arr);
    	
    	int descSolution = solveBeutifulArray(reversedInput);
    	
    	return Math.min(ascSolution, descSolution);
    }
    
    public static int solveBeutifulArray(int[] arr) {


    	int numberOfSwaps = 0;
    	
    	Map<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
    	
    	for(int i = 0; i < arr.length; i++) {
    		inputMap.put(arr[i], i);
    	}
    	
    	int[] sortedInput = new int[arr.length];
    	
    	System.arraycopy(arr, 0, sortedInput, 0, arr.length);
    	
    	Arrays.sort(sortedInput);
    	
    	int newIndex = 0;
    	int temp = 0;
    	
    	int currentValue = 0;
    	int sortedCurrentValue = 0;
    	
    	for(int i = 0; i < arr.length; i++) {
    		currentValue = arr[i];
			sortedCurrentValue = sortedInput[i];
			
    		if(currentValue != sortedCurrentValue) {
    			
    			numberOfSwaps++;
    			
    			newIndex = inputMap.get(sortedCurrentValue);
    			
    			temp = arr[i];
    			arr[i] = arr[newIndex];
    			arr[newIndex] = temp;
    			
    			inputMap.put(currentValue, inputMap.get(sortedCurrentValue));
    			
    		}
    	}
    	
    	
    	return numberOfSwaps;
    
    }
    
    
    static int hackerlandRadioTransmitters(int[] x, int k) {
    	Arrays.sort(x);
    	
    	int numberOfTransmitters = 0;
    	int i = 0;
    	
    	while(i < x.length) {
    		numberOfTransmitters ++;
    		/* Key is to use greedy algorithm to always place the transmitter at the house furthest to the right possible 
    		 * to cover the range.
    		 */
    		int loc = x[i] + k;	//let this i be i_orig
            
    		//	Go to right as far as we cover i_orig as well.
    		while(i < x.length && x[i] <= loc) i++;
    		
    		i--;	//this is where we place the transmitter
    		
    		//	Now, go to the right of x[i] by k because transmitter at x[i] covers houses to its right as well. 
    		loc = x[i] + k;
    		while(i < x.length && x[i] <= loc) i++;
    	}
    	
    	return numberOfTransmitters;
    }
    
    // Failed in two test cases due to Time Out
    static int minimumAbsoluteDifference(int[] arr) { 
    	int minAbsDiff = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < arr.length-1; i++) {
    		for(int j = i+1; j < arr.length; j++) {
    			minAbsDiff = Math.min(minAbsDiff, Math.abs(arr[i] - arr[j]));
    		}
    	}
    	
    	return minAbsDiff;
    }
    
    // 	1)Sort 
    //	2)consider difference between the first pair as the minimum.
    //	3)compare all "consecutive pair difference" with the one in step2 to get the least minimum.
    static int minimumAbsoluteDifference2(int[] arr) {
    	int minAbsDiff = Integer.MAX_VALUE;
    	
    	Arrays.sort(arr);
    	
    	for(int i = 0; i < arr.length - 1; i++) {
    		minAbsDiff = Math.min(minAbsDiff, Math.abs(arr[i] - arr[i+1]));
    	}
    	
    	return minAbsDiff;
    }
    
    
    static String[] bigSorting(String[] unsorted) {
    	
    	Arrays.sort(unsorted, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return (s1.length() == s2.length())? s1.compareTo(s2) : Integer.compare(s1.length(), s2.length());
			}
    		
		});
    	
    	return unsorted;
    }
    
    
    static long marcsCakewalk(int[] calorie) {
    	long milesCount = 0;
    	
    	Arrays.sort(calorie);
    	
    	reverseArray(calorie);
    	
    	for(int i = 0; i < calorie.length; i++) {
    		milesCount += Math.pow(2, i) * calorie[i];
    	}
    	
    	return milesCount;
    }
    
    static int minimumLoss(long[] price) {
    	long minLoss = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < price.length-2; i++) {
    		for(int j = i+1; j < price.length; j++) {
    			long loss = price[i] - price[j];
    			
    			if(loss >= 0) {
    				minLoss =  Math.min(minLoss, loss);
    			}
    		}
    	}
    	
    	return (int) minLoss;
    }
    
    static int minimumLoss2(long[] prices) {
    	long minLoss = Integer.MAX_VALUE;
    	
    	HashMap<Long,Integer> indices = new HashMap<>();

        //Populate prices array with the input
        for(int i = 0; i < prices.length; i++){
            indices.put(prices[i],i);
        }
    	
        Arrays.sort(prices);//Performs a double pivot quicksort and sorts ascending
        
      //Iterate from end to start
        for(int i = prices.length-1; i >0; i--){
            //Make sure it is a smaller loss
            if(prices[i]-prices[i-1] < minLoss){
                //Verify if the pair is a valid transaction
                if(indices.get(prices[i]) < indices.get(prices[i-1]))
                	minLoss = prices[i]-prices[i-1];
            }
        }
        
    	return (int) minLoss;
    }
    
    static int luckBalance(int k, int[][] contests) {
    	int luckBalance = 0;
    	
    	List<Integer> importantContests = new ArrayList<>(); 
    	
    	List<Integer> nonImportantContests = new ArrayList<>();
    	
    	for(int i = 0; i < contests.length; i++) {
    		if(contests[i][1] > 0) {
    			importantContests.add(contests[i][0]);
    		} else {
    			nonImportantContests.add(contests[i][0]);
    		}
    	}
    	
    	// Sort it in descending order
    	Collections.sort(importantContests);
    	Collections.reverse(importantContests); 
    	
    	for(int i = 0; i < nonImportantContests.size(); i++) {
    		luckBalance += nonImportantContests.get(i);
    	}

    	for(int i = 0; i < importantContests.size(); i++) {
//    		if(k > 0) {
//    			luckBalance += importantContests.get(i);
//    			k--;
//    		} else {
//    			luckBalance -= importantContests.get(i);
//    		}
    		// Or Simply
    		if(i < k) {
    			luckBalance += importantContests.get(i);
    		} else {
    			luckBalance -= importantContests.get(i);
    		}
    		
    	}
    	
    	return luckBalance;
    }

    //	Greedy Florist
    static int getMinimumCost(int k, int[] c) {
    	int minimumCost = 0;
    	int prevPurchase = 0;
    	
    	Arrays.sort(c);
    	reverseArray(c);
    	int i = 0;
    	while(i < c.length) {
    		for(int j = i; j < i+k; j++) {
    			if(j < c.length) {
    				minimumCost += (prevPurchase + 1) * c[j];
    			}
    		}
    		i += k;
    		prevPurchase++;
    	}
    	
    	return minimumCost;	
    }
    
    
    static int maxMin(int k, int[] arr) {
    	int minUnfairness = Integer.MAX_VALUE;
    	
    	Arrays.sort(arr);
    	
    	for(int i = 0; i <= arr.length - k; i++) {
    		minUnfairness = Math.min(minUnfairness, arr[i+k-1] - arr[i]);
    	}
    	
    	return minUnfairness;
    }
    
    
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	Map<Integer, Integer> costMap = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < cost.length; i++) {
			costMap.put(cost[i], i);
		}
    	
    	for (int i = 0; i < cost.length; i++) {
			if(costMap.containsKey(money - cost[i]) && costMap.get(money - cost[i]) != i) {
				System.out.println((i+1) + " " + (costMap.get(money - cost[i]) + 1));
				return;
			}
		}

    }
    
    
    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
    	int pairsCount = 0;
    	
    	Arrays.sort(arr);
    	reverseArray(arr);
    	
    	for(int i = 0; i < arr.length-1; i++) {
    		for(int j = i+1; j < arr.length; j++) {
    			if(arr[i] - arr[j] == k) pairsCount++;
    		}
    	}
    	
    	return pairsCount;
    }
    
    
    // Complete the pairs function below.
    static int pairs2(int k, int[] arr) {
    	int pairsCount = 0;
    	
    	Set<Integer> arrSet = new HashSet<>();
    	
    	for (int i = 0; i < arr.length; i++) {
			arrSet.add(arr[i]);
		}
    	
    	for (int i : arrSet) {
			if(arrSet.contains(i + k)) pairsCount++;
		}
    	
    	return pairsCount; 
    }
    
    
    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
    	int count = 0;
    	
//    	Arrays.sort(a);
//    	Arrays.sort(b);
//    	Arrays.sort(c);

    	a = Arrays.stream(a).sorted().distinct().toArray();
    	b = Arrays.stream(b).sorted().distinct().toArray();
    	c = Arrays.stream(c).sorted().distinct().toArray();
    	
    	int aIndex = 0;
    	int bIndex = 0;
    	int cIndex = 0;
    	
    	while(bIndex < b.length) {
    		while(aIndex < a.length && a[aIndex] <= b[bIndex])
    			aIndex ++;
    		
    		while(cIndex < c.length && b[bIndex] >= c[cIndex])
    			cIndex ++;
    		
    		count += aIndex * cIndex;
    		
    		bIndex++;
    	}
    	
    	
    	return count;
    }
    
    static void permutation(String str) {
    	permutation(str, "");
    }
    
    static void permutation(String str, String prefix) {
    	if(str.length() == 0) {
    		System.out.println(prefix);
    	} else {
    		for (int i = 0; i < str.length(); i++) {
				String rem = str.subSequence(0, i) + str.substring(i+1);
				permutation(rem, prefix + str.charAt(i));
			}
    	}
    }
    
    
	static int powersOf2(int n) {
		if (n < 1) {
			return 0;
		} else if (n == 1) {
			System.out.println(1);
			return 1;
		} else {
			int prev = powersOf2(n / 2);
			int curr = prev * 2;
			System.out.println(curr);
			return curr;
		}
	}
	
	
	static long minTime(long[] machines, long goal) {
		long numberOfDaysRequired = 0;

		Map<Long, Long> machineDaysMap = new HashMap<>();
		
		for(int i = 0; i < machines.length; i++) {
			machineDaysMap.put(machines[i], machineDaysMap.getOrDefault(machines[i], 0l) + 1);
		}
		
		Set<Long> keys = machineDaysMap.keySet();
		
		
		while(goal > 0) {
			numberOfDaysRequired ++;
			
			for(Long key : keys) {
				if(numberOfDaysRequired % key == 0) {
					goal -= machineDaysMap.get(key);
				}
			}
		}
		
		return numberOfDaysRequired;
    }
	
	
	static long minTime2(long[] machines, long goal) {
		long numberOfDaysRequired = 0;
		
		Arrays.sort(machines);
		
		long upperBound = (goal / machines.length) * machines[machines.length - 1];
		
		long lowerBound = (goal / machines.length) * machines[0];
		
		// Binary Search
		
		long mid = 0;
		
		while (upperBound - lowerBound > 1) {
			mid = lowerBound + (upperBound - lowerBound) / 2; // After mid days how many items produced?
			long itemProduced = 0;
			
			for (int i = 0; i < machines.length; i++) {
				itemProduced += (mid / machines[i]);
			}
			
			if(itemProduced < goal) {
				lowerBound = mid;
			} else {
				upperBound = mid;
			}
		}
		return upperBound;
    }
	
	
	// Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
    	long largestArea = 0;
    	
    	// Define two stacks one for height and one for indexes
    	Stack<Integer> heights = new Stack<Integer>();
    	Stack<Integer> indexes = new Stack<Integer>();
    	
    	for (int i = 0; i < h.length; i++) {
    		// Case 1. current height is larger thus can be candidate of rectangle start.
			if(heights.isEmpty() || h[i] > heights.peek()) {
				heights.push(h[i]);
				indexes.push(i);
			} else if(h[i] < heights.peek()) {
				// If current height is shorter, thus we need to pop those longer heights
				// and compute the candidate rectangle's area size.
				
				int lastIndex = 0; 
				// This index to keep track of the last index which 
				// will be replacing the current index for the current height inserting. 
				while (!heights.isEmpty() && h[i] < heights.peek()) {
					// We need to compute the area
					lastIndex = indexes.pop();
					int tempAreaSize = heights.pop() * (i - lastIndex);
					
					if(largestArea < tempAreaSize) {
						largestArea = tempAreaSize; //Update the largest area if necessary.
					}
				}
				
				// After popping those unqualified start positions including current index,  Add the current
				heights.push(h[i]);
				indexes.push(lastIndex); // Note this is not i, but last index.
			}
		}
    	
    	// After the process there may still be values in the stack, pop out each and test size.
    	
    	while(!heights.isEmpty()) {
    		// We need to compute the size.
    		int tempAreaSize = heights.pop() * (h.length - indexes.pop()); // Width = currentIndex (Last One) - stored index
			
			if(largestArea < tempAreaSize) {
				largestArea = tempAreaSize; //Update the largest area if necessary.
			}
    	}
    	
    	return largestArea;
    }
	
    
    static long[] riddle1(long[] arr) {
        // complete this function
        long[] result = new long[arr.length];
        for (int i = 1; i <= arr.length; i++) {
            result[i - 1] = getMax(i, arr);
        }
        return result;
    }

    static long getMax(int windowSize, long[] data) {
        long MAX = Long.MIN_VALUE;
        for (int i = 0; i < (data.length - windowSize + 1); i++) {
            long min = getMin(data, i, windowSize);
            if (min > MAX) {
                MAX = min;
            }
        }
        return MAX;
    }

    static long getMin(long[] data, int startIndex, int windowSize) {
        long MIN = Long.MAX_VALUE;
        for (int i = startIndex; i < (startIndex + windowSize); i++) {
            if (data[i] < MIN) {
                MIN = data[i];
            }
        }
        return MIN;
    }
    
    private static class GridPair{
		private String data;
		private int x;
		private int y;
		
		private boolean marked;
		private boolean visited;
		
		private GridPair(String data){
			this.data = data;
		}
	}
    
    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    	int minMoves = 0;
    	
    	Queue<GridPair> gridQueue = new LinkedList<GridPair>();
    	
    	int[][] visitedMatrix = new int[grid.length][grid[0].length()];
    	
    	GridPair[][] predecessorsMatrix = new GridPair[grid.length][grid[0].length()] ;
    	
    	Stack<GridPair> pathStack = new Stack<GridPair>();
    	
    	GridPair root = new GridPair("" + grid[startX].charAt(startY));
    	
    	root.marked = true;
    	
    	visitedMatrix[startX][startY] = 1; // Marked as queued.
    	
    	gridQueue.add(root); // Add to the queue.
    	
    	while(!gridQueue.isEmpty()) {
    		GridPair node = gridQueue.poll(); // Dequeue The head of the queue.
    		visitedMatrix[node.x][node.y] = 2; // Marked as Visited.
    		
    		if(node.x == goalX && node.y == goalY) {
    			// We reached the destination node.
    			// We need to generate the path using the path stack.
    			
    			pathStack.push(node);
    			
    			GridPair preNode = predecessorsMatrix[node.x][node.y];
    			
    			while(preNode != null && !(preNode.x == startX && preNode.y == startY)) {
    				pathStack.push(preNode);
    				preNode = predecessorsMatrix[preNode.x][preNode.y];
    			}
    			
    			minMoves = pathStack.size();
    		}
    		
    		// Iterate on all adjacent node of the current node;
    		
    		// Firstly, We need to iterate on all the same row adjacent node.
    		String row = grid[node.x];
    		
    		for (int i = node.y; i >= 0; i--) {
    			if(visitedMatrix[node.x][i] == 0 ) {
    				if(row.charAt(i) == 'X') break;
    				
    				visitedMatrix[node.x][i] = 1; // Mark as queued
    				predecessorsMatrix[node.x][i] = node;
    				
    				GridPair n = new GridPair(row.charAt(i) + "");
    				n.x = node.x;
    				n.y = i;
    				
    				gridQueue.add(n);
    			}
			}
    		
    		for (int i = node.y; i < row.length(); i++) {
    			if(visitedMatrix[node.x][i] == 0 ) {
    				if(row.charAt(i) == 'X') break;
    				
    				visitedMatrix[node.x][i] = 1; // Mark as queued
    				predecessorsMatrix[node.x][i] = node;
    				
    				GridPair n = new GridPair(row.charAt(i) + "");
    				n.x = node.x;
    				n.y = i;
    				
    				gridQueue.add(n);
    			}
			}
    		
    		// Secondly, We need to iterate on all the same column adjacent node.
    		for (int i = node.x; i >= 0; i--) {
				row = grid[i];
				
				if(visitedMatrix[i][node.y] == 0 ) {
					if(row.charAt(node.y) == 'X') break;
					
					visitedMatrix[i][node.y] = 1; // Mark as queued
					predecessorsMatrix[i][node.y] = node;
					
					GridPair n = new GridPair(row.charAt(node.y) + "");
					n.x = i;
    				n.y = node.y;
    				
					gridQueue.add(n);
				}
			}
    		
    		for (int i = node.x; i < grid.length; i++) {
				row = grid[i];
				
				if(visitedMatrix[i][node.y] == 0 ) {
					if(row.charAt(node.y) == 'X') break;
					
					visitedMatrix[i][node.y] = 1; // Mark as queued
					predecessorsMatrix[i][node.y] = node;
					
					GridPair n = new GridPair(row.charAt(node.y) + "");
					n.x = i;
    				n.y = node.y;
    				
					gridQueue.add(n);
				}
			}
    		
    	}
    	
    	return minMoves;
    }
    
 // Complete the staircase function below.
    static void staircase(int n) {
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= (n-i); j++){
//                System.out.print(" ");
//            }
//            for(int j = 1; j <= i; j++){
//                System.out.print("#");
//            }
//            System.out.println();
//        }
    	String str = "#";
    	
    	for(int i = 0; i < n; i++) {
    		
    		System.out.printf("%" + n + "s\n", str);
    		str += "#";
    	}

    }
    
    
    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
    	String result = "NO";
    	
    	for(int i = 0; i < arr.size(); i++) {
    		int leftSum = 0;
    		int rightSum = 0;
    		for(int j = 0; j < i; j++) {
    			leftSum += arr.get(j);
    		}
    		
    		for(int j = i+1; j < arr.size(); j++) {
    			rightSum += arr.get(j);
    		}
    		
    		if(leftSum == rightSum) {
    			result = "YES";
    			break;
    		}
    	}
    	
    	return result; 
    }
    
 // Complete the balancedSums function below.
    static String balancedSums2(List<Integer> arr) {
    	int sum = 0;
    	
    	int x = 0;
    	
    	for (Integer element : arr) {
			sum += element;
		}
    	
    	for (Integer y : arr) {
			if(2*x == sum - y) {
				return "YES";
			}
			x+= y;
		}
    	
    	return "NO";
    }
    
    
    public static void main(String[] args) {
//		System.out.println(twoStrings("hello", "world"));
		
//		System.out.println(twoStrings("hi", "world"));
//    	System.out.println(isValid("abcc"));
    	
//    	LongestCommonSubsequenceSolver commonSubsequenceSolver = new LongestCommonSubsequenceSolver();
//    	String s1 = "JAVAAID";
//    	String s2 = "JAVAID";
//    	String s1 = "SALLY";
//    	String s2 = "HARRY";
//    	System.out.println(commonSubsequenceSolver.LCSM4(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    	
    	
//    	int[] arr = {3,4,2,5,1};
//    	
//    	lilysHomework(arr);
    	
    	
//    	int[] cal = {7, 4, 9, 6};
//    	System.out.println(marcsCakewalk(cal));

//    	int [][] contests = {{5,1},{2, 1},{1, 1},{8, 1},{10, 0},{5, 0}};
    	
//    	System.out.println(luckBalance(3, contests));
    	
//    	int[] c = {1, 3, 5, 7, 9};
//    	
//    	System.out.println(getMinimumCost(3, c));
    	
//    	int[] c = {1, 4, 7, 2};
//    	
//    	System.out.println(maxMin(3, c));
    	
//    	int [] a = {1, 4, 5};
//    	int [] b = {3, 2, 3};
//    	int [] c = {1, 2, 3};
//    	
//    	triplets(a, b, c);
    	
//    	permutation("Mohamed");
    	
//    	powersOf2(15);
    	
    	
//    	long [] machines = {2, 3, 2};
//    	
//    	System.out.println(minTime2(machines, 10));
    	
//    	int[] h = {2, 4, 2, 1};
//    	
//    	System.out.println(largestRectangle(h));
//    	
//    	int[] h2 = {2, 4, 2, 1, 10, 6, 10};
//    	
//    	System.out.println(largestRectangle(h2));
    	
//    	long[] arr = {6, 3, 5, 1, 12};
//    	
//    	long[] res = riddle1(arr);
//    	
//    	for (int i = 0; i < res.length; i++) {
//			System.out.print(res[i] + " ");
//		}
    	
//    	String[] grid = {".X.", ".X.", "..."};
    	
//    	String[] grid = {"...", ".X.", ".X."};
    	
//    	System.out.println(minimumMoves(grid, 2, 0, 2, 2));
    	
//    	staircase(6);
    	
    	List<Integer> arr = new ArrayList<Integer>();
    	arr.add(1);
    	arr.add(2);
    	arr.add(3);
    	arr.add(3);
    	
    	System.out.println(balancedSums2(arr));
	}
}
