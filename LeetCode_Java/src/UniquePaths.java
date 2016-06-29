/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to 
 * reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * 
 * Tags: Array, DP
 * @author wendi
 *
 */
public class UniquePaths {
	
	/**
	 * DP: the paths of dp[i][j] can only come from dp[i-1][j] and dp[i][j-1].
	 * Thus, dp[i][j] = dp[i-1][j] + dp[i][j-1]. Can save space by using dp[j] = dp[j-1] + dp[j].
	 * @param int m, int n
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int uniquePaths(int m, int n) {
		if (m == 0 &&  n == 0) {
			return 0;
		}
		int[] uniquePaths = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					uniquePaths[j] = 1;
					continue;
				}
				uniquePaths[j] = uniquePaths[j - 1] + uniquePaths[j];
			}
		}
		return uniquePaths[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths result = new UniquePaths();
		System.out.println(result.uniquePaths(3, 7));
	}

}
