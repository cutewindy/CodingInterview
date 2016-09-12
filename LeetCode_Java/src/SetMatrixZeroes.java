import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * click to show follow up.
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class SetMatrixZeroes {
	
	/**
	 * Method2: store states of each row in the first of that row, and store states of each column.
	 * Using two boolean value to record whether first row and first column need to be set as zeroes. 
	 * in the first of that column. 
	 * @param int[][] matrix
	 * Time: O(m * n)
	 * Space: O(1)
	 */
	public void setMatrixZeroesI(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row0 = false;
		boolean col0 = false;
		// 1 mark columns and rows to be set to zero. 
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) row0 = true;
					if (j == 0) col0 = true;
					if (i != 0 && j != 0) {
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}
		}
		// 2 make rows zero
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		// 3 make columns zero
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		// 4 zero out first row (if needed)
		if (row0) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		// 5 zero out first column (if needed)
		if (col0) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	
	
	
	/**
	 * Method1: Using two boolean[] arraies to record which row or column need to set as zeroes
	 * @param int[][] matrix
	 * Time: O(m * n)
	 * Space: O(m + n)
	 */
	public void setMatrixZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];
		// 1 find which row or col need to be set as zeroes
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		// 2 set whole row to zeroes
		for (int i = 0; i < m; i++) {
			if (row[i]) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		// 3 set whole column to zeroes
		for (int j = 0; j < n; j++) {
			if (col[j]) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetMatrixZeroes result = new SetMatrixZeroes();
		int[][] matrix = new int[][] {{0, 0, 0, 5}, 
									  {4, 3, 1, 4},
									  {0, 1, 1, 4},
									  {1, 2, 1, 3}, 
									  {0, 0, 1, 1}};
		result.setMatrixZeroes(matrix);
		for (int[] row: matrix) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("------------------");
		matrix = new int[][] {{0, 0, 0, 5}, 
				  			  {4, 3, 1, 4},
				  			  {0, 1, 1, 4},
				  			  {1, 2, 1, 3}, 
				  			  {0, 0, 1, 1}};
		result.setMatrixZeroesI(matrix);
		for (int[] row: matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

}
