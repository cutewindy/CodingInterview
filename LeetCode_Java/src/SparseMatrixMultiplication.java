import java.util.Arrays;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * Example:
		A = [
		  [ 1, 0, 0],
		  [-1, 0, 3]
		]
		B = [
		  [ 7, 0, 0 ],
		  [ 0, 0, 0 ],
		  [ 0, 0, 1 ]
		]
		     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
		AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
		                  | 0 0 1 |
 * 
 * Tags: HashTable
 * @author wendi
 *
 */
public class SparseMatrixMultiplication {
	
	/**
	 * Using sparse property
	 * @param int[][] A, int[][] B
	 * @return int[][]
	 * Time: O(m*n)
	 * Space: O(1)
	 */
	public int[][] sparseMatrixMultiplication(int[][] A, int[][] B) {
		if (A == null || A.length == 0 || A[0].length == 0 ||
			B == null || B.length == 0 || B[0].length == 0) {
			return new int[0][0];
		}
		int m = A.length;
		int q = A[0].length;
		if (q != B.length) {
			return new int[0][0];
		}
		int n = B[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < q; k++) {
				if (A[i][k] == 0) continue;  // optimization
				for (int j = 0; j < n; j++) {
					if (B[k][j] == 0) continue;   // optimization
					result[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparseMatrixMultiplication result = new SparseMatrixMultiplication();
		int[][] matrix = result.sparseMatrixMultiplication(new int[][] {{1, 0, 0}, {-1, 0, 3}}, 
						new int[][] {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}});
		for (int[] m: matrix) {
			System.out.println(Arrays.toString(m));
		}
	}

}
