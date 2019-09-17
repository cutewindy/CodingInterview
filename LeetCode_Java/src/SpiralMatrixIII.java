import java.util.Arrays;

/**
 * On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.
 * Here, the north-west corner of the grid is at the first row and column, and the south-east corner 
 * of the grid is at the last row and column.
 * Now, we walk in a clockwise spiral shape to visit every position in this grid. 
 * Whenever we would move outside the boundary of the grid, we continue our walk outside the grid 
 * (but may return to the grid boundary later.) 
 * Eventually, we reach all R * C spaces of the grid.
 * Return a list of coordinates representing the positions of the grid in the order they were 
 * visited.
 * Example 1:
 * Input: R = 1, C = 4, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1],[0,2],[0,3]]
 * Example 2:
 * Input: R = 5, C = 6, r0 = 1, c0 = 4
 * Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],
 * [1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 * Note:
 * 1. 1 <= R <= 100
 * 2. 1 <= C <= 100
 * 3. 0 <= r0 < R
 * 4.0 <= c0 < C
 * @author wendi
 *
 */
public class SpiralMatrixIII {
	
	
	/**
	 * move right 1 step, turn right
	 * move down 1 step, turn right
	 * move left 2 steps, turn right
	 * move top 2 steps, turn right,
	 * move right 3 steps, turn right
	 * move down 3 steps, turn right
	 * move left 4 steps, turn right
	 * move top 4 steps, turn right,
	 * @param int R, int C, int r0, int c0
	 * @return int[][]
	 * Time: O(max(R,C)^2)
	 * Space: O(1)
	 */
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] res = new int[R * C][2];
		res[0] = new int[] {r0, c0};
		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // east, south, west, north
		int d = 0;
		int len = 0;       // move <len> steps in the <d> direction
		int index = 1;
		while (index < R * C) {
			if (d == 0 || d == 2) len++; // when move east or west, the length of path need plus 1
			for (int i = 0; i < len; i++) {
				r0 += dir[d][0];
				c0 += dir[d][1];
				if (r0 < 0 || r0 >= R || c0 < 0 || c0 >= C) continue; // check valid
				res[index++] = new int[] {r0, c0};
			}
			d = (d + 1) % 4; // turn to next direction
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrixIII result = new SpiralMatrixIII();
		System.out.println(Arrays.deepToString(result.spiralMatrixIII(1, 4, 0, 0)));
	}

}
