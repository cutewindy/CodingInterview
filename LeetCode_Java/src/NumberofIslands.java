/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is 
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You 
 * may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * 
 * Tags: DFS, BFS, UnionFind
 * @author wendi
 *
 */
public class NumberofIslands {

	/**
	 * DFS(Recursion). Find '1' in the grid first. Then use helper to find the union island.
	 * If find, set grid[i][j]='0', means this area has already been found, it's union island,
	 * should not count to res.
	 * @param char[][] grid
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public int numberofIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					result++;
					helper(grid, i, j);
				}
			}
		}
		return result;
	}
	
	private void helper(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		helper(grid, i - 1, j); // up
		helper(grid, i + 1, j); // down
		helper(grid, i, j - 1); // left
		helper(grid, i, j + 1); // right
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofIslands result = new NumberofIslands();
		System.out.println(result.numberofIslands(new char[][] 
				{{'1', '1', '1', '1', '0'}, 
				 {'1', '1', '0', '1', '0'},
				 {'1', '1', '0', '0', '0'},
				 {'1', '1', '0', '0', '0'},
				 {'0', '0', '0', '0', '0'}}));
	}

}
