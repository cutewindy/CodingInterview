/**
 * On a 2-dimensional grid, there are 4 types of squares:
 * . 1 represents the starting square.  There is exactly one starting square.
 * . 2 represents the ending square.  There is exactly one ending square.
 * . 0 represents empty squares we can walk over.
 * . -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * Example 1:
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths: 
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths: 
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation: 
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 * Note:
 * 1. 1 <= grid.length * grid[0].length <= 20
 * @author wendi
 *
 */
public class UniquePathsIII {
	
	/**
	 * DFS
	 * First find out where the start and the number of empty cells.
	 * We we try to explore a cell, it will change 0 to -2 and do a dfs in 4 direction.
	 * If we hit the target and pass all empty cells, increment the result.
	 * @param int[][] grid
	 * @return int
	 * Time: O(4^(m*n))
	 * Space: O(1)
	 */
	public int uniquePathIII(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int sr = -1;
		int sc = -1;
		int emptyCnts = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) emptyCnts++;
				if (grid[i][j] == 1) {
					sr = i;
					sc = j;
				}
			}
		}
		
		int[] res = new int[1];
		dfs(grid, sr, sc, emptyCnts + 1, res);   // totalEmptyCnts = num of 0 cells + one 1 cell
		return res[0];
	}
	
	private void dfs(int[][] grid, int row, int col, int emptyCnts, int[] res) {
		if (grid[row][col] == 2) {
			if (emptyCnts == 0) res[0] += 1;
			return;
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int k = 0; k < 4; k++) {
			int i = row + dx[k];
			int j = col + dy[k];
			if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == -2) continue;
			int original = grid[row][col];
			grid[row][col] = -2;  // means grid[row][col] has been visited
			dfs(grid, i, j, emptyCnts - 1, res);
			grid[row][col] = original;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePathsIII result = new UniquePathsIII();
		System.out.println(result.uniquePathIII(new int[][] {{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
	}

}
