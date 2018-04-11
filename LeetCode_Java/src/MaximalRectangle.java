import java.util.Stack;

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
	 * Based on Largest Rectangle in Histogram
	 * Maintain a col length of Integer array H recorded its height of '1’s, and scan and update row 
	 * by row to find out the largest rectangle of each row.
	 * For each row, if matrix[row][i] == ‘1’. H[i] +=1, or reset the H[i] to zero.
	 * and according the algorithm of [Largest Rectangle in Histogram], to update the maximum area.
	 * @param char[][] matrix
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int result = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            result = Math.max(largestRectangle(heights), result);
        }
        return result;
    }
    
    public int largestRectangle(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i <= heights.length) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || h > heights[stack.peek()]) {
                stack.push(i);
                i++;
            }
            else {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                res = Math.max((right - left - 1) * height, res);
            }
        }
        return res;
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
