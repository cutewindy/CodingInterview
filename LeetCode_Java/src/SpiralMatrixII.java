import java.util.Arrays;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class SpiralMatrixII {
	
	/**
	 * Same like "SpiralMatrix": using a count to record whether our of range
	 * @param int n
	 * @return int[][] 
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int[][] spiralMatrixII(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0) {
			return matrix;
		}
		int count = 1;
		int top = 0;
		int left = 0;
		int bottom = n - 1;
		int right = n - 1;
		int num = n * n;
		while (count <= num) {
			// top
			for (int j = left; j <= right && count <= num; j++) {
				matrix[top][j] = count++;
			}
			top++;
			// right
			for (int i = top; i <= bottom && count <= num; i++) {
				matrix[i][right] = count++;
			}
			right--;
			// bottom
			for (int j = right; j >= left && count <= num; j--) {
				matrix[bottom][j] = count++;
			}
			bottom--;
			// left
			for (int i = bottom; i >= top && count <= num; i--) {
				matrix[i][left] = count++;
			}
			left++;
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrixII result = new SpiralMatrixII();
		int[][] matrix = result.spiralMatrixII(3);
		for (int[] row: matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}

