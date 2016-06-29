/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
		[
		  [0,0,0],
		  [0,1,0],
		  [0,0,0]
		]
 * The total number of unique paths is 2.
 * 
 * Tags: Array, DP
 * @author wendi
 *
 */
public class UniquePathsII {
	
	/**
	 * DP: if obstacleGrid[i][j]==1, means no path can to here, then reset obstacleGrid[i][j] = 0,
	 * otherwise, obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]. Like uniquePaths.
	 * @param int[][] obstacleGrid
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int uniquePathsII(int[][] obstacleGrid) {
		if (obstacleGrid == null) {
			return 0;
		}
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 1;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		// init
		obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 1; i < m; i++) {
			obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
		}
		for (int j = 1; j < n; j++) {
			obstacleGrid[0][j] = obstacleGrid[0][j] == 1 ? 0 : obstacleGrid[0][j - 1];
		}
		// dp update
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
			}
		}
		return obstacleGrid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePathsII result = new UniquePathsII();
		System.out.println(result.uniquePathsII(new int[][] {{0,0,0}, {0,1,0}, {0,0,0}}));
	}

}
