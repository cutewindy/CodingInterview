/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the 
 * following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * Consider the following matrix:
		[
		  [1,   4,  7, 11, 15],
		  [2,   5,  8, 12, 19],
		  [3,   6,  9, 16, 22],
		  [10, 13, 14, 17, 24],
		  [18, 21, 23, 26, 30]
		]
 * Given target = 5, return true.
 * Given target = 20, return false.
 * 
 * Tags: BinarySearch, Divide and Conquer
 * @author wendi
 *
 */
public class Searcha2DMatrixII {

	/**
	 * from botton left to top right, if matrix[row][col]<target, then the whole col less than target, 
	 * need col++. If matrix[row][col]>target, then the whole row larget than target, need row--.
	 * Can be optimized using BinarySearch
	 * @param int[][] matrix, int target
	 * @return boolean
	 * Time: O(m + n)
	 * Space: O(1)
	 */
	public boolean searcha2DMatrixII(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int row = matrix.length - 1;
		int col = 0;
		while (row >= 0 && col <= matrix[0].length - 1) {
			if (matrix[row][col] == target) {
				return true;
			}
			else if (matrix[row][col] < target) {
				col++;
			}
			else {
				row--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Searcha2DMatrixII result = new Searcha2DMatrixII();
		System.out.println(result.searcha2DMatrixII(new int[][] 
				{{1,  4,  7,  11, 15}, 
				 {2,  5,  8,  12, 19}, 
				 {3,  6,  9,  16, 22}, 
				 {10, 13, 14, 17, 24}, 
				 {18, 21, 23, 26, 30}}, 12));
	}

}
