/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits 
 * the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * Example:
 * For the given grid
		0 E 0 0
		E 0 W E
		0 E 0 0
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class BombEnemy {
	
	/**
	 * DP: Count number of 'E' first from the row and col until 'W'. 
	 * When go after 'W', need to count new row or col, otherwise, the rowHits and colHits will not 
	 * change.
 	 * @param int[][] grid
	 * @return int
	 * Time: O(m * n)
	 * Space: O(m + n) can optimize space to O(n) by using int rowHits rather than int[] rowHits.
	 */
	public int bombEnemy(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int result = 0;
		int[] rowHits = new int[m];
		int[] colHits = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0 || grid[i][j - 1] == 'W') {  //in row, after 'W', count new rowHits
					rowHits[i] = 0;
					for (int k = j; k < n && grid[i][k] != 'W'; k++) {
						rowHits[i] += grid[i][k] == 'E' ? 1 : 0;
					}
				}
				if (i == 0 || grid[i - 1][j] == 'W') {  //in col, after 'W', count new colHits
					colHits[j] = 0;
					for (int k = i; k < m && grid[k][j] != 'W'; k++) {
						colHits[j] += grid[k][j] == 'E' ? 1 : 0;
					}
				}
				if (grid[i][j] == '0') {  //count totalHits at each '0'
					result = Math.max(rowHits[i] + colHits[j], result);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BombEnemy result = new BombEnemy();
		System.out.println(result.bombEnemy(new char[][] 
				{{'0', 'E', '0', '0'}, 
				 {'E', '0', 'W', 'E'}, 
				 {'0', 'E', '0', '0'},
				 {'0', 'E', 'E', '0'}}));
	}

}
