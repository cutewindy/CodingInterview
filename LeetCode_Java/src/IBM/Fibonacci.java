package IBM;

public class Fibonacci {
	
	/**
	 * Recursion
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int fibonacciI(int n) {
		Integer[] dp = new Integer[n];
		return dfs(n - 1, dp);
	}
	
	public Integer dfs(int n, Integer[] dp) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (dp[n] != null) return dp[n];
		return dfs(n - 1, dp) + dfs(n - 2, dp);
	}
	
	
	/**
	 * For loop
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int fibonacci(int n) {
		int[] dp = new int[3];
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
		}
		return dp[(n - 1) % 3];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci result = new Fibonacci();
		System.out.println(result.fibonacci(10));
		System.out.println(result.fibonacciI(10));
	}

}
