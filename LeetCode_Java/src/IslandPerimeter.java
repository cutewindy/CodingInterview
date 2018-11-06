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
	 * Approach3: dfs, find the island first, than dfs to find all the same island, count the 
	 * perimeter when facing an edge
	 * @param int[][] grid
	 * @return int
	 * Time: O(m * n)
	 * Space: O(m*n )
	 */
	public int islandPerimeterII(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[] res = new int[1];
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, new boolean[m][n], res);
                    return res[0];
                }
            }
        }
        return res[0];
    }
    
    private void dfs(int[][] grid, int row, int col, boolean[][] visited, int[] res) {
        visited[row][col] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int i = dx[k] + row;
            int j = dy[k] + col;
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) res[0]++;
            else if (!visited[i][j]) dfs(grid, i, j, visited, res);
        }
	}
	
	/**
	 * Approach2: Brute force
	 * 1. Loop over the matrix and count the number of islands;
	 * 2. If the current dot is an island, count if it has any down neighbor or right neighbor;
	 * 3. The result is islands * 4 - neighbors * 2.
	 * @param int[][] grid
	 * @return int
	 * Time: O(m * n)
	 * Space: O(1)
	 */
	public int islandPerimeterI(int[][] grid) {
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
	
	
	/**
	 * Approach1: Brute force
	 * @param int[][] grid
	 * @return int
	 * Time: O(m * n * 4)
	 * Space: O(1)
	 */
	public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    if (isValid(grid, i + dx[k], j + dy[k])) res++;
                }
            }
        }
        return res;
    }
    
    private boolean isValid(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return true;
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IslandPerimeter result = new IslandPerimeter();
		System.out.println(result.islandPerimeter(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
		System.out.println(result.islandPerimeterI(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
		System.out.println(result.islandPerimeterII(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
	}

}
