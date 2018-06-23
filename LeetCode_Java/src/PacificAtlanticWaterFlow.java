import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a 
 * continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic 
 * ocean" touches the right and bottom edges.
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with 
 * height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * Note:
 * 1.The order of returned grid coordinates does not matter.
 * 2.Both m and n are less than 150.
 * Example:
 * Given the following 5x5 matrix:
	  Pacific ~   ~   ~   ~   ~ 
	       ~  1   2   2   3  (5) *
	       ~  3   2   3  (4) (4) *
	       ~  2   4  (5)  3   1  *
	       ~ (6) (7)  1   4   5  *
	       ~ (5)  1   1   2   4  *
	          *   *   *   *   * Atlantic
 * Return:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above 
 * matrix).
 * @author wendi
 *
 */
public class PacificAtlanticWaterFlow {
	
	/**
	 * BFS
	 * 1. Two Queue and add all the Pacific border to one queue; Atlantic border to another queue.
	 * 2. Keep a visited matrix for each queue. In the end, add the cell visited by two queue 
	 * 	  to the result.
	 * BFS: Water flood from ocean to the cell. Since water can only flow from high/equal cell to 
	 * low cell, add the neighbor cell with height larger or equal to current cell to the queue and
	 *  mark as visited.
	 * @param int[][] matrix
	 * @return List<int[]>
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public List<int[]> pacificAtlanticWaterFlow(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
		
		// init
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<int[]> pQueue = new LinkedList<>();
		Queue<int[]> aQueue = new LinkedList<>();
		boolean[][] pVisited = new boolean[m][n];
		boolean[][] aVisited = new boolean[m][n];
		for (int j = 0; j < n; j++) {
			pQueue.offer(new int[] {0, j});
			pVisited[0][j] = true;
			aQueue.offer(new int[] {m - 1, j});
			aVisited[m - 1][j] = true;
		}
		for (int i = 0; i < m; i++) {
			pQueue.offer(new int[] {i, 0});
			pVisited[i][0] = true;
			aQueue.offer(new int[] {i, n - 1});
			aVisited[i][n - 1] = true;
		}

		// update
		bfs(matrix, pQueue, pVisited);
		bfs(matrix, aQueue, aVisited);		
		
		// find valid result
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pVisited[i][j] && aVisited[i][j]) res.add(new int[] {i, j});
			}
		}
		
		return res;
	}
	
	private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int k = 0; k < 4; k++) {
				int i = curr[0] + dx[k];
				int j = curr[1] + dy[k];
				if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length ||
					visited[i][j] || matrix[curr[0]][curr[1]] > matrix[i][j]) continue;
				queue.offer(new int[] {i, j});
				visited[i][j] = true;
			}
		}
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacificAtlanticWaterFlow result = new PacificAtlanticWaterFlow();
		List<int[]> list = result.pacificAtlanticWaterFlow(new int[][] {{1, 2, 2, 3, 5},
																        {3, 2, 3, 4, 4},
																        {2, 4, 5, 3, 1},
																        {6, 7, 1, 4, 5},
																        {5, 1, 1, 2, 4}});
		for (int[] l: list) System.out.print(Arrays.toString(l));
	}

}
