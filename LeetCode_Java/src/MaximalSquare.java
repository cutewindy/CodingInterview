/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's 
 * and return its area.
 * For example, given the following matrix:
			1 0 1 0 0
			1 0 1 1 1
			1 1 1 1 1
			1 0 0 1 0
Return 4.

 * Tags: DP
 * @author wendi
 *
 */
public class MaximalSquare {
	
	/**
	 * DP: 
	 * dp[i][j]:the width of maximal square which right bottom point is at [i-1][j-1] of matrix.
	 * if matrix[i-1][j-1] = 0, dp[i][j] = 0, 
	 * otherwise, dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1.
	 * @param char[][] matrix
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n) can be optimized to O(n)
	 */
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int result = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] maxWidth = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				maxWidth[i][j] = matrix[i - 1][j - 1] == '1' ? 
				Math.min(Math.min(maxWidth[i - 1][j], maxWidth[i - 1][j - 1]), maxWidth[i][j - 1]) + 1: 0;
				result = Math.max(maxWidth[i][j], result);
			}
		}
		return result * result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalSquare result = new MaximalSquare();
		System.out.println(result.maximalSquare(new char[][] 
				{{'1', '0', '1', '0', '0'}, 
				 {'1', '0', '1', '1', '1'}, 
				 {'1', '1', '1', '1', '1'}, 
				 {'1', '0', '0', '1', '0'}}));
	}
}
