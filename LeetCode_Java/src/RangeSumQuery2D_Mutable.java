/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper 
 * left corner (row1, col1) and lower right corner (row2, col2).
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = 
 * (4, 3), which contains sum = 8.
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * Note:
 * 1. The matrix is only modifiable by the update function.
 * 2. You may assume the number of calls to update and sumRegion function is distributed evenly.
 * 3. You may assume that row1 ≤ row2 and col1 ≤ col2.
 * @author wendi
 *
 */
public class RangeSumQuery2D_Mutable {
	
    private int[][] matrix;
    private int[][] colSum;
    /**
     * colSum[i][j] = matrix[0][j] + matrix[1][j] + matrix[2][j] +...+ matrix[i - 1][j]
     */
    public RangeSumQuery2D_Mutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        this.matrix = matrix;
        this.colSum = new int[matrix.length + 1][matrix[0].length];
        for (int i = 1; i < colSum.length; i++) {
            for (int j = 0; j < colSum[0].length; j++) {
                colSum[i][j] = colSum[i - 1][j] + matrix[i - 1][j];
            }
        }
    }
    
    /**
     * T: O(m)
     */
    public void update(int row, int col, int val) {
        for (int i = row + 1; i < colSum.length; i++) {
            colSum[i][col] = colSum[i][col] - matrix[row][col] + val; 
        }
        matrix[row][col] = val;
    }   
    
    /**
     * T: O(n)
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int j = col1; j <= col2; j++) {
            res += colSum[row2 + 1][j] - colSum[row1][j]; 
        }
        return res;
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeSumQuery2D_Mutable result = new RangeSumQuery2D_Mutable(new int[][] {{3, 0, 1, 4, 2},
		                                                                          {5, 6, 3, 2, 1},
		                                                                          {1, 2, 0, 1, 5},
		                                                                          {4, 1, 0, 1, 7},
		                                                                          {1, 0, 3, 0, 5}});
		System.out.println(result.sumRegion(2, 1, 4, 3));
		result.update(3, 2, 2);
		System.out.println(result.sumRegion(2, 1, 4, 3));
	}

}
