package google_intern;
/**
 * Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can 
 * you put into the backpack?
 * You cannot divide item into small pieces and the total size of items you choose should smaller or 
 * equal to m.
 * Example
 * Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The 
 * maximum value is 9.
 * Challenge
 * O(n x m) memory is acceptable, can you do it in O(m) memory?
 * @author wendi
 *
 */
public class BackpackII {
	
	/**
	 * DP
	 * 单次选择 => 最大价值
	 * 在n个物品中挑选若干物品装入体积为m的背包，使得背包价值最大
	 * dp[i][j]: max value when pick a few from first i items with a backpack size of j
	 * @param int m, int[] A, int[] V
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n) can reduce to O(m)
	 */
	public int backpackII(int m, int[] A, int[] V) {
		if (A == null || A.length == 0) return 0;
		int n = A.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.max(
						   dp[i - 1][j],                                           // not pick ith item
						   j >= A[i - 1] ? dp[i - 1][j - A[i - 1]] + V[i - 1] : 0);// pick ith item
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackpackII result = new BackpackII();
		System.out.println(result.backpackII(10, new int[] {2,3,5,7}, new int[] {1,5,2,4}));
	}

}
