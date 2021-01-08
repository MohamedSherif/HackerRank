package imp;

public class StairCase {

	static int[] chache;
	
	/*
	 * Method1() - Recursive Solution 
	 * Time Complexity is O(2^n)
	 */
	public static int noOfWaysToClimbM1(int n) {
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
		} 
		
		return noOfWaysToClimbM1(n-1) + noOfWaysToClimbM1(n-2);
	}
	
	
	/**
	 * Method2() Approach 1 - Top Down Approach (Cache Declaration is global)
	 * Time Complexity is O(n)
	 * Space Complexity is O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int noOfWaysToClimbM2A1(int n) {
		
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
		} 
		
		if(chache[n] != 0) {
			return chache[n];
		}
		
		return chache[n] = noOfWaysToClimbM2A1(n-1) + noOfWaysToClimbM2A1(n-2);
	}
	
	/**
	 * Method2() Approach 2 - Top Down Approach (Cache is passed as a method parameter)
	 * Time Complexity is O(n)
	 * Space Complexity is O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int noOfWaysToClimbM2A2(int n, int[] chache) {
		
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
		} 
		
		if(chache[n] != 0) {
			return chache[n];
		}
		
		return chache[n] = noOfWaysToClimbM2A2(n-1, chache) + noOfWaysToClimbM2A2(n-2,chache);
	}
	
	/**
	 * Method3() - Bottom up approach
	 * 
	 * Time Complexity is O(n)
	 * Space Complexity is O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int noOfWaysToClimbM2A2(int n) {
		int[] cache = new int[n+1];

		// Base Case 
		cache[0] = 1;
		cache[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		
		return cache[n];
	}
	
	/**
	 * Method4() - Most efficient solution
	 * 
	 * Time Complexity is O(n)
	 * Space Complexity is O(1)
	 * 
	 * @param n
	 * @return
	 */
	public static int noOfWaysToClimbM4(int n) {
        
        int first = 1;
        int second = 1;
        int third = 2;
        
        int sum = 0;

        if(n < 3) {
            return n;
        }
        
        for(int i = 3; i <= n; i++) {
            sum = first + second + third;
            
            first = second;
            
            second = third;
            
            third = sum;
        }
        
        return sum;
        
	}
	
	// Complete the stepPerms function below.
    static int stepPerms(int n, int[] cache) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } 
        
        if(cache[n] != 0) {
            return cache[n];
        }
        
        return cache[n] = stepPerms(n-1, cache) + stepPerms(n-2,cache) + stepPerms(n-3,cache);
    }
	
	
}
