/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing 
 * all ones and return its area.
 * 
 * Tags: Array, HashTable, Stack, DP
 * @author wendi
 *
 */
public class MaximalRectangle {
	
	/**
	 * 
	 * @param char[][] matrix
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalRectangle result = new MaximalRectangle();
		System.out.println(result.maximalRectangle(
				new char[][] {{'0', '0', '1', '0', '0', '0'}, 
							  {'0', '1', '1', '1', '0', '0'}, 
							  {'0', '1', '1', '1', '1', '0'}, 
							  {'0', '0', '1', '1', '0', '0'}}));
	}

}
