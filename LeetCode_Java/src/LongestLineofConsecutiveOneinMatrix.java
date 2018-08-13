/**
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be 
 * horizontal, vertical, diagonal or anti-diagonal.
 * Example:
 * Input:
 * [[0,1,1,0],
 *  [0,1,1,0],
 *  [0,0,0,1]]
 * Output: 3
 * Hint: The number of elements in the given matrix will not exceed 10,000.
 * @author wendi
 *
 */
public class LongestLineofConsecutiveOneinMatrix {
	
	/**
	 * Approach2: DP + Rolling array
	 * Same like approach1, but use only O(n*k) space
	 * dp[i][j][k]: longest line at matrix[i-1][j-1], in area [0,..,i][0,..,j], at k direction
	 * @param int[][] M
	 * @return int
	 * Time: O(m*n*k) k=4
	 * Space: O(n*k)
	 */
	public int longestLineofConsecutiveOneinMatrixI(int[][] M) {
		if (M == null || M.length == 0 || M[0].length == 0) return 0;
		int m = M.length;
		int n = M[0].length;
		int[][][] dp = new int[2][n + 2][4];  // take care for n+2
		int res = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (M[i - 1][j - 1] == 0) {
					for (int k = 0; k < 4; k++) dp[i % 2][j][k] = 0;
					continue;
				}
				dp[i % 2][j][0] = dp[i % 2][j - 1][0] + 1;      // horizontal
				dp[i % 2][j][1] = dp[(i - 1) % 2][j][1] + 1;      // vertical
				dp[i % 2][j][2] = dp[(i - 1) % 2][j - 1][2] + 1;  // diagonal
				dp[i % 2][j][3] = dp[(i - 1) % 2][j + 1][3] + 1;  // anti-diagonal
				for (int k = 0; k < 4; k++) {
					res = Math.max(dp[i % 2][j][k], res);
				}
			}
		}
		return res;
	}	
	
	
	/**
	 * Approach1: DP
	 * dp[i][j][k]: longest line at matrix[i-1][j-1], in area [0,..,i][0,..,j], at k direction
	 * @param int[][] M
	 * @return int
	 * Time: O(m*n*k) k=4
	 * Space: O(m*n*k)
	 */
	public int longestLineofConsecutiveOneinMatrix(int[][] M) {
		if (M == null || M.length == 0 || M[0].length == 0) return 0;
		int m = M.length;
		int n = M[0].length;
		int[][][] dp = new int[m + 1][n + 2][4];  // take care for n+2
		int res = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (M[i - 1][j - 1] == 0) continue;
				dp[i][j][0] = dp[i][j - 1][0] + 1;      // horizontal
				dp[i][j][1] = dp[i - 1][j][1] + 1;      // vertical
				dp[i][j][2] = dp[i - 1][j - 1][2] + 1;  // diagonal
				dp[i][j][3] = dp[i - 1][j + 1][3] + 1;  // anti-diagonal
				for (int k = 0; k < 4; k++) {
					res = Math.max(dp[i][j][k], res);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestLineofConsecutiveOneinMatrix result = new LongestLineofConsecutiveOneinMatrix();
		System.out.println(result.longestLineofConsecutiveOneinMatrix(new int[][] {{0,1,1,0},{0,1,1,0},{0,0,0,1}}));
		System.out.println(result.longestLineofConsecutiveOneinMatrix(new int[][] {{0,1,1,0},{0,1,1,0},{0,0,0,1}}));
	}

}
