//Write an efficient algorithm that searches for a value in an m x n matrix.
//
//This matrix has the following properties:
//
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the 
//previous row.
//Have you met this question in a real interview? Yes
//Example
//Consider the following matrix:
//
//[
//    [1, 3, 5, 7],
//    [10, 11, 16, 20],
//    [23, 30, 34, 50]
//]
//Given target = 3, return true.
//
//Challenge
//O(log(n) + log(m)) time


public class SearchMatrix {
	
	// binary search twice
	public boolean searchMatrixI(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return false;
		}
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		int mid;
		while (top + 1 < bottom) {
			mid = top + (bottom - top) / 2;
			if (matrix[mid][left] == target) {
				return true;
			}
			else if (matrix[mid][bottom] < target) {
				top = mid;
			}
			else {
				bottom = mid;
			}			
		}
		if (matrix[top][left] == target || matrix[bottom][left] == target) {
			return true;
		}
		if (matrix[bottom][left] < target) {
			top = bottom;
		}
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (matrix[top][mid] == target) {
				return true;
			}
			else if (matrix[top][mid] < target) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		if (matrix[top][left] == target || matrix[top][right] == target) {
			return true;
		}
		return false;
	}
	
	
	//binary search once
	public boolean searchMatrixII(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return false;
		}
		int row = matrix.length;
		int column = matrix[0].length;
		int start = 0;
		int end = row * column - 1;
		int mid;
		int number;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			number = matrix[mid / column][mid % column];
			if (number == target) {
				return true;
			}
			else if (number < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		if (matrix[start / column][start % column] == target 
				|| matrix[end / column][end % column] == target) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchMatrix result = new SearchMatrix();
//		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int[][] matrix = {{5}};
//		int[][] matrix = {};
		System.out.println(result.searchMatrixI(matrix, 1));
		System.out.println(result.searchMatrixII(matrix, 1));
//		System.out.println(result.searchMatrixII({{5}}, 1));
	}

}
























