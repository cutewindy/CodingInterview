import java.util.Arrays;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the 
 * resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  For example, 
 * flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, 
 * inverting [0, 1, 1] results in [1, 0, 0].
 * Example 1:
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * @author wendi
 *
 */
public class FlippinganImage {
	
	
	/**
	 * Brute force
	 * @param int[][] A
	 * @return int[][]
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public int[][] flippinganImage(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) return new int[0][0];
		int left = 0;
		int right = A[0].length - 1;
		while (left <= right) {
			for (int i = 0; i < A.length; i++) {
				int temp = A[i][left];
				A[i][left] = A[i][right] ^ 1;
				A[i][right] = temp ^ 1;
			}
			left++;
			right--;
		}
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlippinganImage result = new FlippinganImage();
		System.out.println(Arrays.deepToString(result.flippinganImage(new int[][] {{1,1,0},{1,0,1},{0,0,0}})));
	}

}
