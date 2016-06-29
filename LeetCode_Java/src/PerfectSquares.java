import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 
 * because 13 = 4 + 9.
 * 
 * Tags: DP, BFS, Math
 * @author wendi
 *
 */
public class PerfectSquares {

	/**
	 * DP: dp[n1] = min(dp[n1-n2*n2] + 1, dp[n1])
	 * @param int n
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int perfectSquares(int n) {
		if (n == 0) {
			return 0;
		}
		int result = n;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int n1 = 1; n1 <= n; n1++) {
			for (int n2 = 1; n2 * n2 <= n1; n2++) {
				dp[n1] = Math.min(dp[n1 - n2 * n2] + 1, dp[n1]);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquares result = new PerfectSquares();
		System.out.println(result.perfectSquares(9));
	}

}
