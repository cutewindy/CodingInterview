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
	public int longestIncreasingPathinaMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int result = 0;
		int[][] pathNum = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (pathNum[i][j] == 0) {
					helper(matrix, pathNum, i, j, Integer.MAX_VALUE);
					result = Math.max(pathNum[i][j], result);
				}
			}
		}
		return result;
	}
	
	private int helper(int[][] matrix, int[][] pathNum, int i, int j, int pre) {
		// basecase1: index out of range or curr >= pre(pre is not the largest one on path)
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= pre) {
			return 0;
		}
		// basecase2: already calculate pathNum[i][j]
		if (pathNum[i][j] != 0) {
			return pathNum[i][j];
		}
		pathNum[i][j] = Math.max(helper(matrix, pathNum, i - 1, j, matrix[i][j]) + 1, pathNum[i][j]);
		pathNum[i][j] = Math.max(helper(matrix, pathNum, i + 1, j, matrix[i][j]) + 1, pathNum[i][j]);
		pathNum[i][j] = Math.max(helper(matrix, pathNum, i, j - 1, matrix[i][j]) + 1, pathNum[i][j]);
		pathNum[i][j] = Math.max(helper(matrix, pathNum, i, j + 1, matrix[i][j]) + 1, pathNum[i][j]);
		return pathNum[i][j];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPathinaMatrix result = new LongestIncreasingPathinaMatrix();
		System.out.println(result.longestIncreasingPathinaMatrix(new int[][] {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
	}

}
