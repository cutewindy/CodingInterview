import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class RotateImage {

	/**
	 * @param int[][] matrix
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public void rotateImage(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int n = matrix.length;
		/*
		 * firstly transpose the matrix and then flip it symmetrically(swap(matrix[i][j], matrix[j][i]))
		 * 1 2 3      1 4 7
		 * 4 5 6  =>  2 5 8
		 * 7 8 9      3 6 9
		*/
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		/*
		 * Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][n - 1 - j])
		 * 1 4 7      7 4 1
		 * 2 5 8  =>  8 5 2
		 * 3 6 9      9 6 3
		*/
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1- j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateImage result = new RotateImage();
		int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		result.rotateImage(matrix);
		for (int[] array: matrix) {
			System.out.println(Arrays.toString(array));
		}
		
		System.out.println("---------------------");
		
		int[][] matrix1 = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		result.rotateImage(matrix1);
		for (int[] array: matrix1) {
			System.out.println(Arrays.toString(array));
		}
	}

}
