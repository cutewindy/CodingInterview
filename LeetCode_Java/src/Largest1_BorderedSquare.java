/**
 * Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that 
 * has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
 * Example 1:
 * Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 9
 * Example 2:
 * Input: grid = [[1,1,0,0]]
 * Output: 1
 * Constraints:
 * 1. 1 <= grid.length <= 100
 * 2. 1 <= grid[0].length <= 100
 * 3. grid[i][j] is 0 or 1
 * @author wendi
 *
 */
public class Largest1_BorderedSquare {
	
	
	
	/**
	 * DP: use two dp 2d array to respectively store the maximum left-side outreach point and 
	 * top-side outreach point.
	 * By using these two dp, we can directly be inferred whether currently possible length is valid 
	 * or not.
	 * So in the third for loop, we just need to test the current possible length step by step, from 
	 * the maximum point to the closest. (Early stop when found the valid length helps to reduce time).
	 * 
	 * dpr[i][j]: accumulated continuously 1 from left to right
	 * dpc[i][j]: accumulated continuously 1 from top to down
	 * dpr[i][j] = dpr[i][j-1]+1, dpc[i][j] = dpc[i-1][j]+1
	 * res = max(len * len), where len should be valid.
	 * @param int[][] grid
	 * @return int
	 * Time: O(m*n*min(m,n))
	 * Space: O(m*n)
	 */
    public int largest1_BorderedSquare(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dpr = new int[m + 1][n + 1]; // left - right
        int[][] dpc = new int[m + 1][n + 1]; // top - down
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0) continue;
                dpr[i][j] = dpr[i][j - 1] + 1;
                dpc[i][j] = dpc[i - 1][j] + 1;
                int d = Math.min(dpr[i][j], dpc[i][j]);
                for (int len = d; len > 0; len--) {
                    if (dpr[i - len + 1][j] >= len && dpc[i][j - len + 1] >= len) {
                        res = Math.max(len * len, res);
                        break;
                    }
                }
            }
        }
        return res;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Largest1_BorderedSquare result = new Largest1_BorderedSquare();
		System.out.println(result.largest1_BorderedSquare(new int[][] {{1,1,1},{1,0,1},{1,1,1}}));
	}

}
