import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of 
 * distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 
 * 2, where:
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * Output: 7 
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 *              the point (1,2) is an ideal empty land to build a house, as the total 
 *              travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the 
 * above rules, return -1.
 * @author wendi
 *
 */
public class ShortestDistancefromAllBuildings {
	
	/**
	 * BFS
	 * Basic idea: compute the distance from each building to all the spots, use two matrix to store 
	 * the total distance of all the buildings it connects to and how many buildings it connects to 
	 * accordingly.
	 * Finally, we can traverse the distances[][] matrix to get the point having shortest distance 
	 * to all buildings.
	 * @param int[][] grid
	 * @return int
	 * Time: O((m*n)^2)
	 * Space: O(m*n)
	 */
	public int shortestDistancefromAllBuildings(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] distances = new int[m][n];
		int[][] reachs = new int[m][n];
		int buildsCnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j ++) {
				if (grid[i][j] == 1) {
					buildsCnt++;
					setDistance(grid, i, j, distances, reachs);
				}
			}
		}
		
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0 || reachs[i][j] != buildsCnt) continue;
				res = Math.min(distances[i][j], res);
			}
		}
		
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	
	private void setDistance(int[][] grid, int row, int col, int[][] distances, int[][] reachs) {
		int level = 1;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				for (int k = 0; k < 4; k++) {
					int i = curr[0] + dx[k];
					int j = curr[1] + dy[k];
					if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
						grid[i][j] != 0 || visited[i][j]) continue;
					//The shortest distance from building [row][col] to [i][j] is 'level'.
					distances[i][j] += level;
					reachs[i][j] += 1;
					visited[i][j] = true;
					queue.offer(new int[] {i, j});
				}
			}
			level++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestDistancefromAllBuildings result = new ShortestDistancefromAllBuildings();
		System.out.println(result.shortestDistancefromAllBuildings(
				new int[][] {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}}));
	}

}
