package google_intern;
/**
 * Given n kind of items with size Ai and value Vi( each item has an infinite number available) and 
 * a backpack with size m. What's the maximum value can you put into the backpack?
 * You cannot divide item into small pieces and the total size of items you choose should smaller or 
 * equal to m.
 * Example
 * Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The 
 * maximum value is 15.
 * @author wendi
 *
 */
public class BackpackIII {

	
	/**
	 * DP
	 * 重复选择 => 最大价值
	 * 在n个物品中挑选(可重复)若干物品装入体积为m的背包，使得背包价值最大
	 * dp[i][j]: max value when pick a few from first i items (multiple times allowed) with a backpack size of j
	 * @param int[] A, int[] V, int m
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n) can reduce to O(m)
	 */
	public int backPackIII(int m, int[] A, int[] V) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++) {
        		dp[i][j] = Math.max(
        				   dp[i - 1][j],                                       // not pick ith item
        				   j >= A[i - 1] ? dp[i][j - A[i - 1]] + V[i - 1] : 0);// pick ith item
        	}
        }
        return dp[n][m];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackpackIII result = new BackpackIII();
		System.out.println(result.backPackIII(10, new int[] {2,3,5,7}, new int[] {1,5,2,4}));
	}

}
