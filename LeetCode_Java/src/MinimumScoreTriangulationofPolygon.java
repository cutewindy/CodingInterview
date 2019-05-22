import java.util.Arrays;


/**
 * Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in 
 * clockwise order.
 * Suppose you triangulate the polygon into N-2 triangles.  For each triangle, the value of that 
 * triangle is the product of the labels of the vertices, and the total score of the triangulation 
 * is the sum of these values over all N-2 triangles in the triangulation.
 * Return the smallest possible total score that you can achieve with some triangulation of the 
 * polygon.
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Explanation: The polygon is already triangulated, and the score of the only triangle is 6.
 * Example 2:
 * Input: [3,7,4,5]
 * Output: 144
 * Explanation: There are two triangulations, with possible scores: 3*7*5 + 4*5*7 = 245, or 
 * 3*4*5 + 3*4*7 = 144.  The minimum score is 144.
 * Example 3:
 * Input: [1,3,1,4,1,5]
 * Output: 13
 * Explanation: The minimum score triangulation has score 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13.
 * Note:
 * 1. 3 <= A.length <= 50
 * 2. 1 <= A[i] <= 100
 * @author wendi
 *
 */
public class MinimumScoreTriangulationofPolygon {
	
	
//	/**
//	 * Approach2:Recursion
//	 * @param int[] A
//	 * @return int
//	 * Time: O(n^3)
//	 * Space: O(n^2)
//	 * Stack space: O()
//	 */
//    public int minimumScoreTriangulationofPolygonI(int[] A) {
//        if (A == null || A.length == 0) return 0;
//        int n = A.length;
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//        	Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//        dfs(A, 0, n - 1, dp);
//        System.out.println(Arrays.deepToString(dp));
//        return dp[n - 1][n - 1];
//    }
//    
//    private void dfs(int[] A, int start, int end, int[][] dp) {
//    	System.out.println("start: " + start + ", end: " + end);
//    	if (start == end || start == end + 1) {
//    		dp[start][end] = 0;
//    		return;
//    	}
//    	if (dp[start][end] != Integer.MAX_VALUE) return;
//		for (int k = start + 1; k < end; k++) {
//			dfs(A, start, k, dp);
//			dfs(A, k, end, dp);
//			System.out.println("start: " + start + ", end: " + end);
//			System.out.println("k: " + k + ",dp: " + Arrays.deepToString(dp));
//			dp[start][end] = Math.min(dp[start][k] + A[start] * A[k] * A[end] + dp[k][end], dp[start][end]);
//		}
//    	
//    }
	
	
	/**
	 * Approach1: DP
	 * dp[i][j]: minimum score to shape i,...,j, with j-i+1 points.
	 * 
	 *        (i)
	 *         0     1
	 *         
	 *  (j) 5            2 (k, where i<k<j)
	 *     
	 *         4     3         
	 *         
	 * dp[i][j] = dp[i][k] + A[i]*A[k]*A[j] + dp[k][j], i<k<j
	 * @param int[] A
	 * @return int
	 * Time: O(n^3)
	 * Space: O(n^2)
	 */
    public int minimumScoreTriangulationofPolygon(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int p = 3; p <= n; p++) {
            for (int i = 0; i <= n - p ; i++) {
                int j = i + p - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][k] + A[i] * A[k] * A[j] + dp[k][j], dp[i][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumScoreTriangulationofPolygon result = new MinimumScoreTriangulationofPolygon();
		System.out.println(result.minimumScoreTriangulationofPolygon(new int[] {1, 3, 1, 4, 1, 5}));
//		System.out.println(result.minimumScoreTriangulationofPolygonI(new int[] {1, 3, 1, 4, 1, 5}));
	}

}
