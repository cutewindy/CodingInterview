import java.util.Arrays;

/**
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a 
 * square to another 4-directionally adjacent square if and only if the elevation of both squares 
 * individually are at most t. You can swim infinite distance in zero time. Of course, you must stay 
 * within the boundaries of the grid during your swim.
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom 
 * right square (N-1, N-1)?
 * Example 1:
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation 
 * than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * Example 2:
 * Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 * 	 0  1  2  3  4
 * 	24 23 22 21  5
 * 	12 13 14 15 16
 * 	11 17 18 19 20
 * 	10  9  8  7  6
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 * Note:
 * 1. 2 <= N <= 50.
 * 2. grid[i][j] is a permutation of [0, ..., N*N - 1].
 * @author wendi
 *
 */
public class SwiminRisingWater {
	
	
	/**
	 * DFS+DP
	 * @param int[][] grid
	 * @return int
	 * Time: O(n^4)
	 * Space: O(n^2)
	 */
	public int swiminRisingWater(int[][] grid) {
		int n = grid.length;
		int[][] max = new int[n][n];
		for (int[] line: max) Arrays.fill(line, Integer.MAX_VALUE);
		helper(grid, 0, 0, grid[0][0], max);
		return max[n - 1][n - 1];
	}
	
	private void helper(int[][] grid, int i, int j, int prev, int[][] max) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid.length ||
				Math.max(prev, grid[i][j]) >= max[i][j]) return;
		max[i][j] = Math.max(prev, grid[i][j]);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int k = 0; k < 4; k++) {
			helper(grid, i + dx[k], j + dy[k], max[i][j], max);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwiminRisingWater result = new SwiminRisingWater();
		System.out.println(result.swiminRisingWater(
				new int[][] {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}}));
	}

}
