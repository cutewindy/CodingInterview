import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral 
 * order.
 * For example,
 * Given the following matrix:
		[
		 [ 1, 2, 3 ],
		 [ 4, 5, 6 ],
		 [ 7, 8, 9 ]
		]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class SpiralMatrix {
	
	/**
	 * Brute force: Do four loops:
	 * 1 Traverse top from left to right, then top++.
	 * 2 Traverse right from top to bottom, then right--;
	 * 3 Traverse bottom from right to left, then bottom--;
	 * 4 Traverse left from bottom to top, then left++;
	 * The only tricky part is like when traverse top from left to right have to check whether the 
	 * row still exists to prevent duplicates.
	 * @param int[][] matrix
	 * @return List<Integer>
	 * Time: O(m*n)
	 * Space: O(1)
	 */
	public List<Integer> spiralMatrix(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int top = 0;
		int left = 0;
		int bottom = matrix.length - 1;
		int right = matrix[0].length - 1;
//		while (top <= bottom && left <= right) {
//			// top
//			for (int j = left; j <= right && top <= bottom; j++) {
//				result.add(matrix[top][j]);
//			}
//			top++;
//			// right
//			for (int i = top; i <= bottom && left <= right; i++) {
//				result.add(matrix[i][right]);
//			}
//			right--;
//			// down
//			for (int j = right; j >= left && top <= bottom; j--) {
//				result.add(matrix[bottom][j]);
//			}
//			bottom--;
//			// left
//			for (int i = bottom; i >= top && left <= right; i--) {
//				result.add(matrix[i][left]);
//			}
//			left++;
//		}
//		return result;
		
		// or 
		while (true) {
			// top
			for (int j = left; j <= right; j++) {
				result.add(matrix[top][j]);
			}
			top++;
			if (top > bottom || left > right) break;
			// right
			for (int i = top; i <= bottom; i++) {
				result.add(matrix[i][right]);
			}
			right--;
			if (top > bottom || left > right) break;
			// down
			for (int j = right; j >= left; j--) {
				result.add(matrix[bottom][j]);
			}
			bottom--;
			if (top > bottom || left > right) break;
			// left
			for (int i = bottom; i >= top; i--) {
				result.add(matrix[i][left]);
			}
			left++;
			if (top > bottom || left > right) break;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix result = new SpiralMatrix();
		System.out.println(result.spiralMatrix(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}

}
