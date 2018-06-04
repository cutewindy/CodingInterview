import java.util.Arrays;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, 
 * column, and both diagonals all have the same sum.
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is 
 * contiguous).
 * Example 1:
 * Input: [[4,3,8,4],
 *         [9,5,1,9],
 *         [2,7,6,2]]
 * Output: 1
 * Explanation: 
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * while this one is not:
 * 384
 * 519
 * 762
 * In total, there is only one magic square inside the given grid.
 * Note:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 * @author wendi
 *
 */


public class MagicSquaresinGrid {
	
	/**
	 * Brute Force
	 * @param int[][] grid
	 * @return int
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public int magicSquaresinGrid (int[][] grid) {
		if (grid == null || grid.length < 3 || grid[0].length < 3) return 0;
		int res = 0;
		for (int i = 0; i < grid.length - 2; i++) {
			for (int j = 0; j < grid[0].length - 2; j++) {
				if (isValid(grid, i, j)) res++;
			}
		}
		return res;
	}

	
	private boolean isValid(int[][] grid, int row, int col) {
		int[] map = new int[9];
		Arrays.fill(map, 1);
		int[] rowSum = new int[3];
		int[] colSum = new int[3];
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (grid[i][j] <= 0 || grid[i][j] > 9 || --map[grid[i][j] - 1] < 0) return false;
				rowSum[j - col] += grid[i][j];
				colSum[i - row] += grid[i][j];
			}
		}
		for (int k = 1; k < 3; k++) {
			if (rowSum[k] != rowSum[0] || colSum[k] != colSum[0]) return false;
		}
		if (grid[row][col] + grid[row + 2][col + 2] != grid[row][col + 2] + grid[row + 2][col]) return false;
		return true;
 	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicSquaresinGrid result = new MagicSquaresinGrid();
		System.out.println(result.magicSquaresinGrid(new int[][] {{4,3,8,4},
		                                                          {9,5,1,9},
		                                                          {2,7,6,2}}));
	}

}
