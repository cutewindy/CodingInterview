import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * Example 1: 
 * Input:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Output:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Example 2: 
 * Input:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * Output:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * Note:
 * 1. The number of elements of the given matrix will not exceed 10,000.
 * 2. There are at least one 0 in the given matrix.
 * 3. The cells are adjacent in only four directions: up, down, left and right.
 * @author wendi
 *
 */
public class ZeroOneMatrix {

	/**
	 * Method2: DP
	 * The distance of a cell from 0 can be calculated if we know the nearest distance for all the 
	 * neighbors, in which case the distance is minimum distance of any neighbor + 1.
	 * For each 1, the minimum path to 0 can be in any direction. So, we need to check all the 4 
	 * direction. In one iteration from top to bottom, we can check left and top directions, and we 
	 * need another iteration from bottom to top to check for right and bottom direction.
	 * again.
	 * @param int[][]  matrix
	 * @return int[][]
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public int[][] zeroOneMatrixI(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		// iteration from top to bottom, check top and left directions
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) continue;
				matrix[i][j] = m + n; // don't forget
				if (i > 0) matrix[i][j] = Math.min(matrix[i - 1][j] + 1, matrix[i][j]);// top
				if (j > 0) matrix[i][j] = Math.min(matrix[i][j - 1] + 1, matrix[i][j]);// left
			}
		}
		
		// iteration from bottom to top, check bottom and right directions
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == 0) continue;
				if (i < m - 1) matrix[i][j] = Math.min(matrix[i + 1][j] + 1, matrix[i][j]);// bottom
				if (j < n - 1) matrix[i][j] = Math.min(matrix[i][j + 1] + 1, matrix[i][j]);// right
			}
		}
		
		return matrix;
	}
	
	/**
	 * Method1: BFS
	 * 1. At beginning, set cell value to Integer.MAX_VALUE if it is not 0.
	 * 2. If newly calculated distance >= current distance, then we don't need to explore that cell 
	 * again.
	 * @param int[][]  matrix
	 * @return int[][]
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public int[][] zeroOneMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		// init, put all 0s in the queue, or set others as MAX_VALUE
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) queue.offer(new int[] {i, j});
				else matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// update
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int k = 0; k < 4; k++) {
				int i = curr[0] + dx[k];
				int j = curr[1] + dy[k];
				if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= matrix[curr[0]][curr[1]] + 1) {
					continue;
				}
				matrix[i][j] = matrix[curr[0]][curr[1]] + 1;
				queue.offer(new int[] {i, j});
			}
		}
		
		return matrix;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZeroOneMatrix result = new ZeroOneMatrix();
		System.out.println(Arrays.deepToString((result.zeroOneMatrix(new int[][] {{0, 0, 0},
																			 	  {0, 1, 0},
																			 	  {1, 1, 1}}))));
		System.out.println(Arrays.deepToString((result.zeroOneMatrixI(new int[][] {{0, 0, 0},
			 	  																   {0, 1, 0},
			 	  																   {1, 1, 1}}))));
		}

}
