/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * Example 1:
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * Explanation:
 * 1234
 * 5123
 * 9512
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", 
 * and in each diagonal all elements are the same, so the answer is True.
 * Example 2: 
 * Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * Note:
 * 1. matrix will be a 2D array of integers.
 * 2. matrix will have a number of rows and columns in range [1, 20].
 * 3. matrix[i][j] will be integers in range [0, 99].
 * 
 * Follow up:
 * 1. What if the matrix is stored on disk, and the memory is limited such that you can only load at 
 * most one row of the matrix into the memory at once?
 * 	Compare half of 1 row with half of the next/previous row.
 * 
 * 2. What if the matrix is so large that you can only load up a partial row into the memory at once?
 *  Hash 2 rows (so only 1 element needs to be loaded at a time) and compare the results, excluding 
 *  the appropriate beginning or ending element.
 * 
 * @author wendi
 *
 */
public class ToeplitzMatrix {
	
	/**
	 * 
	 * @param int[][] matrix
	 * @return boolean
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public boolean toeplitzMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return true;
		}
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[0].length - 1; j++) {
				if (matrix[i][j] != matrix[i + 1][j + 1]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToeplitzMatrix result = new ToeplitzMatrix();
		System.out.println(result.toeplitzMatrix(new int[][] {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
	}

}
