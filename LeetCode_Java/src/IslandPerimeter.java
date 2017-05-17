/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 
 * represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is 
 * completely surrounded by water, and there is exactly one island (i.e., one or more connected land 
 * cells). The island doesn't have "lakes" (water inside that isn't connected to the water around 
 * the island). One cell is a square with side length 1. The grid is rectangular, width and height 
 * don't exceed 100. Determine the perimeter of the island.
 * Example:
		[[0,1,0,0],
		 [1,1,1,0],
		 [0,1,0,0],
		 [1,1,0,0]]
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 * Tags: Hash Table
 * @author wendi
 *
 */
public class IslandPerimeter {

	
	/**
	 * Brute force
	 * 1. Loop over the matrix and count the number of islands;
	 * 2. If the current dot is an island, count if it has any down neighbor or right neighbor;
	 * 3. The result is islands * 4 - neighbors * 2.
	 * @param int[][] grid
	 * @return int
	 * Time: O(m * n)
	 * Space: O(1)
	 */
	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int islands = 0;
		int neighbors = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					islands += 1;
					if (i + 1 < m && grid[i + 1][j] == 1) neighbors += 1; // count down neighbors
					if (j + 1 < n && grid[i][j + 1] == 1) neighbors += 1; // count right neighbors
				}
			}
		}
		return islands * 4 - neighbors * 2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IslandPerimeter result = new IslandPerimeter();
		System.out.println(result.islandPerimeter(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
	}

}
