import java.util.Arrays;

/**
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move 
 * the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). 
 * However, you can at most move N times. Find out the number of paths to move the ball out of grid 
 * boundary. The answer may be very large, return it after mod 109 + 7.
 * Example 1:
 * Input:m = 2, n = 2, N = 2, i = 0, j = 0
 * Output: 6
 * Explanation:
 * Example 2:
 * Input:m = 1, n = 3, N = 3, i = 0, j = 1
 * Output: 12
 * Explanation:
 * Note:
 * 1. Once you move the ball out of boundary, you cannot move it back.
 * 2. The length and height of the grid is in range [1,50].
 * 3. N is in range [0,50].
 * @author wendi
 *
 */
public class OutofBoundaryPaths {
	
	/**
	 * DP
	 * dp[i][j] stands for how many possible ways to walk into cell i,j
	 * @param int m, int n, int N, int i, int j
	 * @return int
	 * Time: O(m*n*N)
	 * Space: O(m*n)
	 */
	private int modII;
	public int outofBoundaryPathsII(int m, int n, int N, int i, int j) {
		modII = 1000000007;
		int[][] dp = new int[m][n];
		dp[i][j] = 1;
		int res = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int step = 0; step < N; step++) {
			int[][] temp = new int[m][n];
			for (int row = 0; row < m; row++) {
				for (int col = 0; col < n; col++) {
					for (int k = 0; k < 4; k++) {
						int ni = row + dx[k];
						int nj = col + dy[k];
						if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
							res = (dp[row][col] + res) % modII;
						}
						else {
							temp[ni][nj] = (dp[row][col] + temp[ni][nj]) % modII;
						}
					}
				}
			}
			dp = temp;
		}
		return res;
	}
	
	
	/**
	 * DFS + Memoization
	 * @param int m, int n, int N, int i, int j
	 * @return int
	 * Time: O(m*n*N)
	 * Space: O(m*n*N)
	 * Stack space: O(m*n)
	 */
	private int modI;
	public int outofBoundaryPathsI(int m, int n, int N, int i, int j) {
		modI = 1000000007;
		int[][][] dp = new int[m][n][N + 1];
		for (int[][] matrix: dp) {
			for (int[] array: matrix) {
				Arrays.fill(array, -1);
			}
		}
		return checkPoints(m, n, N, i, j, dp);
	}
	
	private int checkPoints(int m, int n, int N, int i, int j, int[][][] dp) {
		if (N < 0) return 0;
		if (i < 0 || i >= m || j < 0 || j >= n) return 1;
		if (dp[i][j][N] != -1) return dp[i][j][N];
		
		dp[i][j][N] = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int k = 0 ;k < 4; k++) {
			dp[i][j][N] = (checkPoints(m, n, N - 1, i + dx[k], j + dy[k], dp) % modI + dp[i][j][N]) % modI;
		}
		
		return dp[i][j][N];
	}
	
	
	/**
	 * DFS Brute Force(TLE)
	 * @param int m, int n, int N, int i, int j
	 * @return int
	 * Time: O(4^(m*n))
	 * Space: O(1)
	 * Stack space: O(m*n)
	 */
	private int mod;
	public int outofBoundaryPaths(int m, int n, int N, int i, int j) {
		mod = 1000000007;
		if (N < 0) return 0;
		if (i < 0 || i >= m || j < 0 || j >= n) return 1;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int res = 0;
		for (int k = 0 ;k < 4; k++) {
			res = (outofBoundaryPaths(m, n, N - 1, i + dx[k], j + dy[k]) % mod + res) % mod;
		}
		
		return res;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutofBoundaryPaths result = new OutofBoundaryPaths();
//		System.out.println(result.outofBoundaryPaths(2, 2, 2, 0, 0));
//		System.out.println(result.outofBoundaryPaths(1, 3, 3, 0, 1));
//		System.out.println(result.outofBoundaryPathsI(2, 2, 2, 0, 0));
//		System.out.println(result.outofBoundaryPathsI(1, 3, 3, 0, 1));
		System.out.println(result.outofBoundaryPathsII(2, 2, 2, 0, 0));
		System.out.println(result.outofBoundaryPathsII(1, 3, 3, 0, 1));
	}

}
