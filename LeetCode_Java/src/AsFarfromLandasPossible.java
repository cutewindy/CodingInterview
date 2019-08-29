import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents 
 * land, find a water cell such that its distance to the nearest land cell is maximized and return 
 * the distance.
 * The distance used in this problem is the Manhattan distance: the distance between two cells 
 * (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * If no land or water exists in the grid, return -1.
 * Example 1:
 * Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: 
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 * Example 2:
 * Input: [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: 
 * The cell (2, 2) is as far as possible from all the land with distance 4.
 * Note:
 * 1. 1 <= grid.length == grid[0].length <= 100
 * 2. grid[i][j] is 0 or 1
 * @author wendi
 *
 */
public class AsFarfromLandasPossible {
	
	
	/**
	 * BFS
	 * @param int[][] grid
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public int asFarfromLandasPossible(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
		int m = grid.length;
		int n = grid[0].length;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) queue.offer(i * n + j);
			}
		}
		int level = -1;
		int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		boolean[][] visited = new boolean[m][n];
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int curr = queue.poll();
				for (int k = 0; k < 4; k++) {
					int i = curr / n + d[k][0];
					int j = curr % n + d[k][1];
					if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 0 || visited[i][j]) continue;
					visited[i][j] = true;
					queue.offer(i * n + j);
				}
			}
			level++;
		}
		return level == 0 ? -1 : level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AsFarfromLandasPossible result = new AsFarfromLandasPossible();
		System.out.println(result.asFarfromLandasPossible(new int[][] {{1,0,1},{0,0,0},{1,0,1}}));
	}

}
