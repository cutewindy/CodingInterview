/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * Example 1:
 * nums = [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 * nums = [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * Tags: DFS, Topological Sort, Memoization
 * @author wendi
 *
 */
public class LongestIncreasingPathinaMatrix {
	
	
	/**
	 * DP+DFS
	 * 1. Do DFS from every cell
	 * 2. Compare every 4 direction and skip cells that are out of boundary or smaller
	 * 3. Get matrix max from every cell's max
	 * 4. Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
	 * 5. The key is to cache the distance because it's highly possible to revisit a cell
	 * @param int[][] matrix
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 * Stack space: O(m*n)
	 */
	private int[] dx;
	private int[] dy;
    public int longestIncreasingPathinaMatrixI(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        dx = new int[] {-1, 0, 1, 0};
        dy = new int[] {0, 1, 0, -1};
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findIncreasingPath(matrix, dp, i, j);
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
    
    private void findIncreasingPath(int[][] matrix, int[][] dp, int row, int col) {
        if (dp[row][col] != 0) return;
        dp[row][col] = 1;
        for (int k = 0; k < 4; k++) {
            int i = row + dx[k];
            int j = col + dy[k];
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || 
            		matrix[i][j] <= matrix[row][col]) continue;
            findIncreasingPath(matrix, dp, i, j);
            dp[row][col] = Math.max(dp[i][j] + 1, dp[row][col]);
         }
    }

    
	/**
	 * Backtracking: see matrix[i][j] as the largest num on path, find the satisfied max_pathNum 
	 * coming from up, down, left, right. Save max_pathNum+1 to pathNum[i][j].
	 * 1. For each cell, try it's left, right, up and down for smaller number.
	 * 2. If it's smaller, means we are on the right track and we should keep going. If larger, 
	 * 	  stop and return.
	 * 3. Treat each cell as a start cell. Calculate and memorize the longest distance for this cell, 
	 * 	  so we don't need to calculate it again in the future.
	 * @param int[][] matrix
	 * @return int
	 * Time: O(n^2) 
	 * Space: O(n^2)
	 * Stack space: O(n^2)
	 */
//	public int longestIncreasingPathinaMatrix(int[][] matrix) {
//		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//			return 0;
//		}
//		int result = 0;
//		int[][] pathNum = new int[matrix.length][matrix[0].length];
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				if (pathNum[i][j] == 0) {
//					helper(matrix, pathNum, i, j, Integer.MAX_VALUE);
//					result = Math.max(pathNum[i][j], result);
//				}
//			}
//		}
//		return result;
//	}
//	
//	private int helper(int[][] matrix, int[][] pathNum, int i, int j, int pre) {
//		// basecase1: index out of range or curr >= pre(pre is not the largest one on path)
//		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= pre) {
//			return 0;
//		}
//		// basecase2: already calculate pathNum[i][j]
//		if (pathNum[i][j] != 0) {
//			return pathNum[i][j];
//		}
//		pathNum[i][j] = Math.max(helper(matrix, pathNum, i - 1, j, matrix[i][j]) + 1, pathNum[i][j]);
//		pathNum[i][j] = Math.max(helper(matrix, pathNum, i + 1, j, matrix[i][j]) + 1, pathNum[i][j]);
//		pathNum[i][j] = Math.max(helper(matrix, pathNum, i, j - 1, matrix[i][j]) + 1, pathNum[i][j]);
//		pathNum[i][j] = Math.max(helper(matrix, pathNum, i, j + 1, matrix[i][j]) + 1, pathNum[i][j]);
//		return pathNum[i][j];
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPathinaMatrix result = new LongestIncreasingPathinaMatrix();
//		System.out.println(result.longestIncreasingPathinaMatrix(new int[][] {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
		System.out.println(result.longestIncreasingPathinaMatrixI(new int[][] {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
	}

}
