package imp;

public class LongestCommonSubstring {

	static Integer dp[][][];
	static int cache[][];
	/**
	 * Method1() - recursive solution (Top-Down approach)
	 * Time Complexity - O(3^(m+n))
	 * Space Complexity - O(m+n)
	 * @param x
	 * @param y
	 * @param m
	 * @param n
	 * @param lcsCount
	 * @return
	 */
	public static int LCSubStrM1(char[] x, char[] y, int m, int n, int lcsCount) {
		if(m <= 0 || n <= 0){
			return lcsCount;
		}
		
		int lcsCount1 = lcsCount;
		
		if(x[m-1] == y[n-1]) {
			lcsCount1 = LCSubStrM1(x, y, m-1, n-1, lcsCount + 1);
		}
		
		int lcsCount2 = LCSubStrM1(x, y, m, n-1, 0);
		int lcsCount3 = LCSubStrM1(x, y, m-1, n-1, 0);
		
		return Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
	}
	
	/**
	 * Method2A1() - Recursive solution with memoization  ( Top-down approach caching on method level) 
	 * @param x
	 * @param y
	 * @param m
	 * @param n
	 * @param lcsCount
	 * @param dp
	 * @return
	 */
	public static int LCSubStrM2A1(char[] x, char[] y, int m, int n, int lcsCount, Integer[][][] dp) {
		if(m <= 0 || n <= 0){
			return lcsCount;
		}
		
		if(dp[m][n][lcsCount] != null) {
			return dp[m][n][lcsCount];
		}
		int lcsCount1 = lcsCount;
		
		if(x[m-1] == y[n-1]) {
			lcsCount1 = LCSubStrM2A1(x, y, m-1, n-1, lcsCount + 1, dp);
		}
		
		int lcsCount2 = LCSubStrM2A1(x, y, m, n-1, 0, dp);
		int lcsCount3 = LCSubStrM2A1(x, y, m-1, n-1, 0, dp);
		
		return dp[m][n][lcsCount] = Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
	}
	
	
	/**
	 * Method2A2() - Recursive solution with memoization  ( Top-down approach caching on Global level) 
	 * @param x
	 * @param y
	 * @param m
	 * @param n
	 * @param lcsCount
	 * @param dp
	 * @return
	 */
	public static int LCSubStrM2A2(char[] x, char[] y, int m, int n, int lcsCount) {
		if(m <= 0 || n <= 0){
			return lcsCount;
		}
		
		if(dp[m][n][lcsCount] != null) {
			return dp[m][n][lcsCount];
		}
		int lcsCount1 = lcsCount;
		
		if(x[m-1] == y[n-1]) {
			lcsCount1 = LCSubStrM2A2(x, y, m-1, n-1, lcsCount + 1);
		}
		
		int lcsCount2 = LCSubStrM2A2(x, y, m, n-1, 0);
		int lcsCount3 = LCSubStrM2A2(x, y, m-1, n-1, 0);
		
		return dp[m][n][lcsCount] = Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
	}
	
	
	/**
	 * Method3() - DP Solution (Bottom up approach)
	 * Time Complexity - O(m*n)
	 * Space Complexity - O(m*n) 
	 * @param x
	 * @param y
	 * @param m
	 * @param n
	 * @param lcsCount
	 * @param dp
	 * @return
	 */
	public static int LCSubStrM3(char[] x, char[] y, int m, int n) {
		
		int [][] memo = new int [m+1][n+1];
		int result = 0;
		
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; i++) {
				if(i == 0 && j == 0) {
					memo[i][j] = 0;
				} else if(x[i - 1] == y[j - 1]) {
					memo[i][j] = memo[i - 1][j - 2] + 1;
					result = Math.max(result, memo[i][j]);
				} else {
					memo[i][j] = 0;
				}
			}
		}
		cache = memo;
		return result;
	}
}
