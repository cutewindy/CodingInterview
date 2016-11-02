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
	 * Method2: Binary search approach.
	 * Since the matrix is not strictly sorted, so once we find the mid point value, the target can 
	 * be either in the right and lower part of the submatrix or in the left and upper part of the 
	 * submatrix depends on the comparison result. So we need to search in both part. 
     * Case1: found, return true;
     * Case2: mid point(row, col) value is less than target, which means the target must be in the right 
     * submatrix which (left, right, top, bottom) -> (col+1, right, top, bottom) or in the lower 
     * submatrix which (left, right, top, bottom) -> (left, col, row + 1, bottom).
     * Case3: mid point(row, col) value is greater than target, which means that the target must be in the 
     * left submatrix which (left, right, top, bottom) -> (left, col - 1, top, bottom) or in the upper 
     * submatrix which (left, right, top, bottom) -> (col, right, top, row - 1).
	 * @param int[][] matrix, int target
	 * @return boolean
	 * Time: O(log(m * n))
	 * Space: O(1)
	 */
	public boolean searcha2DMatrixIII(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		return helper(matrix, target, 0, matrix[0].length - 1, 0, matrix.length - 1);
	}
	
	private boolean helper(int[][] matrix, int target, int left, int right, int top, int bottom) {
		if (left < 0 || right >= matrix[0].length || left > right ||
			top < 0 || bottom >= matrix.length || top > bottom) {
			return false;
		}
		int row = top + (bottom - top) / 2;
		int col = left + (right - left) / 2;
		if (matrix[row][col] == target) {
			return true;
		}
		else if (matrix[row][col] < target) {
			return helper(matrix, target, col + 1, right, top, bottom) || 
				   helper(matrix, target, left, col, row + 1, bottom);
		}
		else {
			return helper(matrix, target, left, col - 1, top, bottom) ||
				   helper(matrix, target, col, right, top, row - 1);
		}
	}

	
	/**
	 * Method1: Not binary search approach. Optimized binary search.
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
		System.out.println(result.searcha2DMatrixIII(new int[][] 
				{{1,  4,  7,  11, 15}, 
				 {2,  5,  8,  12, 19}, 
				 {3,  6,  9,  16, 22}, 
				 {10, 13, 14, 17, 24}, 
				 {18, 21, 23, 26, 30}}, 12));
	}

}
