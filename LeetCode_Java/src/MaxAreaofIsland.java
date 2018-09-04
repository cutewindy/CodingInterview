import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are 
 * surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum 
 * area is 0.)
 * Example 1:
	[[0,0,1,0,0,0,0,1,0,0,0,0,0],
	 [0,0,0,0,0,0,0,1,1,1,0,0,0],
	 [0,1,1,0,1,0,0,0,0,0,0,0,0],
	 [0,1,0,0,1,1,0,0,1,0,1,0,0],
	 [0,1,0,0,1,1,0,0,1,1,1,0,0],
	 [0,0,0,0,0,0,0,0,0,0,1,0,0],
	 [0,0,0,0,0,0,0,1,1,1,0,0,0],
	 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 * @author wendi
 *
 */
public class MaxAreaofIsland {
	
	/**
	 * 如果左边界和右边界是相连，上边界和下边界相连
	 * @param int[][] grid
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 * Stack space: O(m*n)
	 */
    public int maxAreaofIslandII(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;	
		int result = 0;
		int m = grid.length;
		int n = grid[0].length;
		int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) continue;
				int sum = 0;
				Queue<Integer> queue = new LinkedList<>();
				queue.offer(i * n + j);
				while (!queue.isEmpty()) {
					int pos = queue.poll();
					int row = pos / n;
					int col = pos % n;
					sum++;
					grid[row][col] = 0;
					for (int k = 0; k < 4; k++) {
						int nextRow = (row + dx[k] + m) % m;
						int nextCol = (col + dy[k] + n) % n;
						if (grid[nextRow][nextCol] == 0) continue;
						queue.offer(nextRow * n + nextCol);
						grid[nextRow][nextCol] = 0;
					}
				}
				result = Math.max(sum, result);
			}
		}
		return result;
    }
	
	/**
	 * Method2: DFS
	 * @param int[][] grid
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 * Stack space: O(m*n)
	 */
    public int maxAreaofIslandI(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    int curr = dfs(grid, i, j, visited) + 1;
                    res = Math.max(curr, res);
                }
            }
        }
        return res;
    }
	    
    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int res = 0;
        for (int k = 0; k < 4; k++) {
            int i = row + dx[k];
            int j = col + dy[k];
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) continue;
            visited[i][j] = true;
            res += dfs(grid, i, j, visited) + 1;
        }
        return res;
    }
    
    
    
	/**
	 * Method1: BFS
	 * @param int[][] grid
	 * @return int
	 * Time: O(m*n)
	 * Space: O(1)
	 */
	public int maxAreaofIsland(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int result = 0;
		int m = grid.length;
		int n = grid[0].length;
		int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) continue;
				int sum = 0;
				Queue<Integer> queue = new LinkedList<>();
				queue.offer(i * n + j);
				while (!queue.isEmpty()) {
					int pos = queue.poll();
					int row = pos / n;
					int col = pos % n;
					sum++;
					grid[row][col] = 0;
					for (int k = 0; k < 4; k++) {
						int nextRow = row + dx[k];
						int nextCol = col + dy[k];
						if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || 
								grid[nextRow][nextCol] == 0) continue;
						queue.offer(nextRow * n + nextCol);
						grid[nextRow][nextCol] = 0;
					}
				}
				result = Math.max(sum, result);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxAreaofIsland result = new MaxAreaofIsland();
		System.out.println(result.maxAreaofIsland(new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
		                                                  	   {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                                                	   {0,1,1,0,1,0,0,0,0,0,0,0,0},
		                                                	   {0,1,0,0,1,1,0,0,1,0,1,0,0},
		                                                   	   {0,1,0,0,1,1,0,0,1,1,1,0,0},
		                                                   	   {0,0,0,0,0,0,0,0,0,0,1,0,0},
		                                                	   {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                                                	   {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
		System.out.println(result.maxAreaofIslandI(new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
		                                                  	   {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                                                	   {0,1,1,0,1,0,0,0,0,0,0,0,0},
		                                                	   {0,1,0,0,1,1,0,0,1,0,1,0,0},
		                                                   	   {0,1,0,0,1,1,0,0,1,1,1,0,0},
		                                                   	   {0,0,0,0,0,0,0,0,0,0,1,0,0},
		                                                	   {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                                                	   {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
		System.out.println(result.maxAreaofIslandII(new int[][] {{1, 0, 0, 0},
																{0, 0, 1, 1},
																{1, 1, 0, 0}}));
	}

}
