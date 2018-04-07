import java.util.Arrays;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a 
 * smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of 
 * all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as 
 * many as you can.
 * Example 1:
 * Input:
	[[1,1,1],
	 [1,0,1],
	 [1,1,1]]
 * Output:
	[[0, 0, 0],
	 [0, 0, 0],
	 [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * 1. The value in the given matrix is in the range of [0, 255].
 * 2. The length and width of the given matrix are in the range of [1, 150].
 * @author wendi
 *
 */
public class ImageSmoother {
	
	
	/**
	 * Iterate through grid
	 * For each cell in the grid, look at the immediate neighbors - up to 9 of them, including the 
	 * original cell.
	 * Then, we will add the sum of the neighbors into res[i][j] while recording count, the number 
	 * of such neighbors. The final answer is the sum divided by the count.
	 * @param int[][] M
	 * @return int[][]
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public int[][] imageSmoother(int[][] M) {
		if (M == null || M.length == 0 || M[0].length == 0) return new int[0][0];
		int m = M.length;
		int n = M[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int r = i - 1; r < i + 2; r++) {
					for (int c = j - 1; c < j + 2; c++) {
						if (r < 0 || r >= m || c < 0 || c >= n) continue;  // out of range
						count++;
						result[i][j] += M[r][c];
					}
				}
				result[i][j] /= count;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageSmoother result = new ImageSmoother();
		System.out.println(Arrays.deepToString(result.imageSmoother
				(new int[][] {{1,1,1},{1,0,1},{1,1,1}})));
		System.out.println(Arrays.deepToString(result.imageSmoother
				(new int[][] {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}})));		
		
	}

}
