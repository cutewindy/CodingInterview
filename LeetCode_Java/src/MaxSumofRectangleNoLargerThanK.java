import java.util.Arrays;
import java.util.TreeSet;

/**
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the 
 * matrix such that its sum is no larger than k.
 * Example:
 * Given matrix = [
 *  [1,  0, 1],
 *  [0, -2, 3]
 * ]
 * k = 2
 * The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number 
 * no larger than k (k = 2).
 * Note:
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 * 
 * Tags: BinarySearch, DP, Queue
 * @author wendi
 *
 */
public class MaxSumofRectangleNoLargerThanK {
	
	
	/**
	 * Method2: DP: use a TreeSet to save the 
	 * @param int[][] matrix, int k
	 * @return int 
	 * Time: O(n^3*log(n))
	 * Space: 
	 */
	public int maxSumofRectangleNoLargerThanKI(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int result = Integer.MIN_VALUE;
		int m = matrix.length;
		int n = matrix[0].length;
		// use an int[][] to save the sum of matrix from point [0, 0] to [i, j]
		int[][] sum = new int[m][n];
		sum[0][0] = matrix[0][0];
		for (int i = 1; i < m; i++) {
			sum[i][0] = sum[i - 1][0] + matrix[i][0];
		}
		for (int j = 1; j < n; j++) {
			sum[0][j] = sum[0][j - 1] + matrix[0][j];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
			}
		}
		// use a TreeSet to save
		for (int row1 = 0; row1 < m; row1++) {
			for (int row2 = row1; row2 < m; row2++) {
				TreeSet<Integer> ts = new TreeSet<>();
				
			}
		}
		
		return result;
	}
	

	/**
	 * Method1: Brute Force:(Like the algorithm "Range sum query 2D Immutable") 
	 * First, Use an int[][] sum to save the sum of matrix from point [0, 0] to point [i, j]
	 * Then, find the max sum of rectangle at the point of [row1, col1] and [row2, col2], 
	 * which satisfied area <= k.
	 * @param int[][] matrix, int k
	 * @return int
	 * Time: O(m*n*m*n)
	 * Space: O(m*n)
	 */
	public int maxSumofRectangleNoLargerThanK(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] sum = new int[m][n];
		int result = Integer.MIN_VALUE;
		// save sum of matrix from [0, 0] to [i, j]
		// init sum
		sum[0][0] = matrix[0][0];
		for (int i = 1; i < m; i++) {
			sum[i][0] = sum[i - 1][0] + matrix[i][0];
		}
		for (int j = 1; j < n; j++) {
			sum[0][j] = sum[0][j - 1] + matrix[0][j];
		}
		// calculate sum
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
			}
		}
		// find the largest sum of rectangle <= k, use [row1, col1] and [row2, col2] as the angle
		// of rectangle
		for (int row1 = 0; row1 < m; row1++) {
			for (int col1 = 0; col1 < n; col1++) {
				for (int row2 = row1; row2 < m; row2++) {
					for (int col2 = col1; col2 < n; col2++) {
						int rectSum = 0;
						if (row1 == 0 && col1 == 0) {
							rectSum = sum[row2][col2];
						}
						else if (row1 == 0) {
							rectSum = sum[row2][col2] - sum[row2][col1 - 1];
						}
						else if (col1 == 0) {
							rectSum = sum[row2][col2] - sum[row1 - 1][col2];
						}
						else {
							rectSum = sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1]
									+ sum[row1 - 1][col1 -1];
						}
						if (rectSum <= k) {
							result = Math.max(rectSum, result);
						}
					}
				}
			}
		}
		return result;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumofRectangleNoLargerThanK result = new MaxSumofRectangleNoLargerThanK();
		System.out.println(result.maxSumofRectangleNoLargerThanK(new int[][] {{1, 0, 1}, {0, -2, 3}}, 2));
		System.out.println(result.maxSumofRectangleNoLargerThanKI(new int[][] {{1, 0, 1}, {0, -2, 3}}, 2));
	}

}
