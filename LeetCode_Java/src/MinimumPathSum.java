/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom 
 * right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * Tags: Array, DP
 * @author wendi
 *
 */
public class MinimumPathSum {
	
	/**
	 * DP: use grid[i][j] to record the minimum path sum of point [i][j], which can save space.
	 * grid[i][j] can only come from grid[i-1][j] or grid[i][j-1], choose the minimum one, then plus itself.
	 * That is, grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
	 * @param int[][] grid
	 * @return int
	 * Time: O(m * n)
	 * Space : O(1)
	 */
	public int minimumPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		// init
		for (int i = 1; i < m; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			grid[0][j] = grid[0][j - 1] + grid[0][j];
		}
		// update dp
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
			}
		}
		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumPathSum result = new MinimumPathSum();
		System.out.println(result.minimumPathSum(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}

}
