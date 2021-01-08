package imp;

public class LongestCommonSubsequenceSolver {

	static Integer dp[][];
	static int cache[][];
	
	
	//	Method1() - recursive solution (Top-down approach)
	//	Time complexity - O(2^(m+n))
	//	Space complexity - O(m+n)
	public static int LCSM1(char[] x, char[] y, int i, int j) {
		if(i <= 0 || j <= 0) // Base Condition. 
			return 0;
		
		if(x[i - 1] == y[j - 1])
			return 1 + LCSM1(x, y, i - 1, j - 1);
		else
			return Math.max(LCSM1(x, y, i, j - 1), LCSM1(x, y, i - 1, j));
	}
	
	//	Method2() - Recursive solution with Memoization. 
	public static int LCSM2(char[] x, char[] y, int i, int j, Integer[][] dp) {
		if(i <= 0 || j <= 0) // Base Condition. 
			return 0;
		
		if(dp[i][j] != null) 
			return dp[i][j];
		
		if(x[i - 1] == y[j - 1])
			return 1 + LCSM2(x, y, i - 1, j - 1, dp);
		else
			return dp[i][j] = Math.max(LCSM2(x, y, i, j - 1, dp), LCSM2(x, y, i - 1, j, dp));
	}
	
	//	Method3() - DP Solution (Bottom-Up Approach)
	//	Time complexity - O(m*n)
	//	Space complexity - O(m*n)
	public static int LCSM3(char[] x, char[] y, int m, int n) {
		int[][] memo = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 || j == 0)
					memo[i][j] = 0;
				else if(x[i - 1] == y[j - 1])
					memo[i][j] = memo[i-1][j-1] + 1;
				else
					memo[i][j] = Math.max(memo[i][j-1], memo[i][j-1]);
			}
		}
		cache = memo;
		return memo[m][n];
	}
	
	//	Method4() - DP Solution (Bottom-Up Approach)
	//	Time complexity - O(m*n)
	//	Space complexity - O(n)
	public static int LCSM4(char[] x, char[] y, int m, int n) {
		int[] memo = new int[n+1];
		
		for (int i = 1; i <= m; i++) {
			int prev = 0;
			for(int j = 1; j <= n; j++) {
				int temp = memo[j];
				
				if(x[i - 1] == y[j - 1]) {
					memo[j] = prev + 1;
				} else {
					memo[j] = Math.max(memo[j], memo[j-1]);
				}
				prev = temp;
			}
		}
		return memo[n];
	}
	
}
