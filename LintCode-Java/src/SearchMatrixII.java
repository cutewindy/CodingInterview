//Write an efficient algorithm that searches for a value in an m x n matrix, 
//return the occurrence of it.
//
//This matrix has the following properties:
//
//    * Integers in each row are sorted from left to right.
//
//    * Integers in each column are sorted from up to bottom.
//
//    * No duplicate integers in each row or column.
//
//Have you met this question in a real interview? Yes
//Example
//Consider the following matrix:
//
//[
//
//    [1, 3, 5, 7],
//
//    [2, 4, 7, 8],
//
//    [3, 5, 9, 10]
//
//]
//
//Given target = 3, return 2.
//
//Challenge
//O(m+n) time and O(1) extra space


public class SearchMatrixII {
	
	public int searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int i = matrix.length - 1;
		int j = 0;
		int count = 0;
		while (i >= 0 && j < matrix.length) {
			if (matrix[i][j] == target) {
				count += 1;
				i --;
				j ++;
				
			}
			else if (matrix[i][j] < target) {
				j ++;
			}
			else {
				i --;
			}
		}
		return count;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchMatrixII result = new SearchMatrixII();
		int[][] matrix = {{1, 3, 5, 7}, {2, 4, 7, 8}, {3, 5, 9, 10}};
		System.out.println(result.searchMatrix(matrix, 3));

	}

}
