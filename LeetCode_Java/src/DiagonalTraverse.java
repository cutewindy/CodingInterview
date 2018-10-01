import java.util.Arrays;

/**
 * DescriptionHintsSubmissionsDiscussSolution
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in 
 * diagonal order as shown in the below image.
 * Example:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * Note:
 * 1. The total number of elements of the given matrix will not exceed 10,000.
 * @author wendi
 *
 */
public class DiagonalTraverse {
	
	/**
	 * Brute force and check whether out of bound
	 * If out of bottom border (row >= m) then row = m - 1; col += 2; change walk direction.
	 * else if out of right border (col >= n) then col = n - 1; row += 2; change walk direction.
	 * else if out of top border (row < 0) then row = 0; change walk direction.
	 * else if out of left border (col < 0) then col = 0; change walk direction.
	 * Otherwise, just go along with the current direction.
	 * @param int[][] matrix
	 * @return int[]
	 * Time: O(m*n)
	 * Space: O(1)
	 */
	public int[] diagonalTraverse(int[][] matrix) {
		if (matrix == null) return null;
		if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dx = {-1, 1};
        int[] dy = {1, -1};
        int i = 0;
        int j = 0;
        int dir = 0;
        int[] res = new int[m * n];
        for (int k = 0; k < m * n; k++) {
            res[k] = matrix[i][j];
            i += dx[dir];
            j += dy[dir];
            if (i >= m) {i = m - 1; j += 2; dir ^= 1;}
            else if (j >= n) {i += 2; j = n - 1; dir ^= 1;}
            else if (i < 0) {i = 0; dir ^= 1;}
            else if (j < 0) {j = 0; dir ^= 1;}
            
        }
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiagonalTraverse result = new DiagonalTraverse();
		System.out.println(Arrays.toString(result.diagonalTraverse(new int[][] {{ 1, 2, 3 }, {4, 5, 6 }, {7, 8, 9 }})));
	}

}
