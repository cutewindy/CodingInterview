/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
		[
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
 * Given target = 3, return true.
 * 
 * Tags: Array, BinarySearch
 * @author wendi
 *
 */
public class Searcha2DMatrix {

	/**
	 * BinarySearch(Template): use once binary search, view matrix as an sorted array with length m*n.
	 * Then i*n+j = mid => i = mid/n and j = mid%n.
	 * @param int[][] matrix
	 * @param int target
	 * @return boolean
	 * Time: O(log(m*n))
	 * Space: O(1)
	 */
	public boolean searcha2DMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;
		int end = m * n - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int row = mid / n;
			int col = mid % n;
			if (matrix[row][col] == target) {
				return true;
			}
			else if (matrix[row][col] < target) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Searcha2DMatrix result = new Searcha2DMatrix();
		System.out.println(result.searcha2DMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 35));
	}

}
