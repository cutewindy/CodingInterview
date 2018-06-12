/**
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.
 * A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
 * Example 1:
 * Input: grid = 
 * [[1, 0, 0, 1, 0],
 *  [0, 0, 1, 0, 1],
 *  [0, 0, 0, 1, 0],
 *  [1, 0, 1, 0, 1]]
 * Output: 1
 * Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 * Example 2:
 * Input: grid = 
 * [[1, 1, 1],
 *  [1, 1, 1],
 *  [1, 1, 1]]
 * Output: 9
 * Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 * Example 3:
 * Input: grid = 
 * [[1, 1, 1, 1]]
 * Output: 0
 * Explanation: Rectangles must have four distinct corners.
 * Note:
 * The number of rows and columns of grid will each be in the range [1, 200].
 * Each grid[i][j] will be either 0 or 1.
 * The number of 1s in the grid will be at most 6000.
 * @author wendi
 *
 */
public class NumberofCornerRectangles {
	
	/**
	 * Method2: (combination)
	 * Fix two columns (or two rows) first, then check row by row to find "1" on both columns. 
	 * Say you find n pairs, then just pick any 2 of those to form an axis-aligned rectangle using
	 * combination
	 * @param int[][] grid
	 * @return int
	 * Time: O(m^2*n)
	 * Space: O(1)
	 */
	public int numberofCornerRectanglesI(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;	
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int l = 0; l < n - 1; l++) {
			for (int r = l + 1; r < n; r++) {
				int count = 0;
				for (int i = 0; i < m; i++) {
					if (grid[i][l] == 1 && grid[i][r] == 1) count++;
				}
				if (count > 1) res += count * (count - 1) / 2;
			}
		}
		return res;
	}
	

	/**
	 * Method1: (like "largest rectangle in histogram")
	 * We ask the question: for each additional row, how many more rectangles are added?
	 * For each pair of 1s in the new row (say at new_row[i] and new_row[j]), we could create more 
	 * rectangles where that pair forms the base. The number of new rectangles is the number of 
	 * times some previous row had row[i] = row[j] = 1.
	 * @param int[][] grid
	 * @return int
	 * Time: O(m*n^2)
	 * Space: O(n^2)
	 */
	public int numberofCornerRectangles(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int n = grid[0].length;
		int[][] count = new int[n][n];
		int res = 0;
		for (int[] row: grid) {
			for (int l = 0; l < n - 1; l++) {
				if (row[l] == 0) continue;
				for (int r = l + 1; r < n; r++) {
					if (row[r] == 0) continue;
					res += count[l][r];
					count[l][r]++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofCornerRectangles result = new NumberofCornerRectangles();
		int[][] grid = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
		System.out.println(result.numberofCornerRectangles(grid));
		System.out.println(result.numberofCornerRectanglesI(grid));
	}

}
