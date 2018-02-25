import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a 
 * new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c 
 * representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same 
 * row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped 
 * matrix; Otherwise, output the original matrix.
 * Example 1:
 * Input: 
 * nums = 
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output: 
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row 
 * by row by using the previous list.
 * Example 2:
 * Input: 
 * nums = 
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output: 
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 * @author wendi
 *
 */
public class ReshapetheMatrix {
	
	/**
	 * Method2: result[i/c][i%c]=matrix[i/n][i%n]
	 * @param int[][] nums, int r, int c
	 * @return int[][]
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public int[][] reshapetheMatrixII(int[][] nums, int r, int c) {
		if (nums == null || nums.length == 0 || nums[0].length == 0) {return null;}
		int[][] result = new int[r][c];
		int m = nums.length;
		int n = nums[0].length;		
		if (m * n != r * c) {return nums;}
		for (int i = 0; i < r * c; i++) {
			result[i / c][i % c] = nums[i / n][i % n]; 
		}
		return result;
		
	}
	
	/**
	 * Methed1: using queue to save the numbers and reshape in new matrix
	 * @param int[][] nums, int r, int c
	 * @return int[][]
	 * Time: O(mn)
	 * Space: O(mn)
	 */
	public int[][] reshapetheMatrixI(int[][] nums, int r, int c) {
		if (nums == null || nums.length == 0 || nums[0].length == 0) {return null;}
		int[][] result = new int[r][c];
		int m = nums.length;
		int n = nums[0].length;
		if (m * n != r * c) {return nums;}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				queue.offer(nums[i][j]);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = queue.poll();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReshapetheMatrix result = new ReshapetheMatrix();
		System.out.println(Arrays.deepToString(result.reshapetheMatrixI(new int[][] {{1, 2}, {3, 4}}, 1, 4)));
		System.out.println(Arrays.deepToString(result.reshapetheMatrixI(new int[][] {{1, 2}, {3, 4}}, 2, 4)));
		System.out.println(Arrays.deepToString(result.reshapetheMatrixII(new int[][] {{1, 2}, {3, 4}}, 1, 4)));
		System.out.println(Arrays.deepToString(result.reshapetheMatrixII(new int[][] {{1, 2}, {3, 4}}, 2, 4)));
	}

}
