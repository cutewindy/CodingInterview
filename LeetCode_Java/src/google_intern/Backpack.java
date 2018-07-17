package google_intern;
/**
 * Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill 
 * this backpack?
 * You can not divide any item into small pieces.
 * Example
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so 
 * that the max size we can fill this backpack is 10. If the backpack size is 12. we can select 
 * [2, 3, 7] so that we can fulfill the backpack.
 * You function should return the max size we can fill in the given backpack.
 * Challenge
 * O(n x m) time and O(m) memory.
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * @author wendi
 *
 */
public class Backpack {
	
	/**
	 * DP
	 * 单次选择 => 最大体积
	 * 在n个物品中挑选若干物品装入体积为m的背包，使得背包体积最大
	 * dp[i][j]: max size when pick a few from first i items with a backpack size of j
	 * @param int m, int[] A
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n) can reduce to O(m)
	 */
	public int backpack(int m, int[] A) {
		if (A == null || A.length == 0) return 0;
		int n = A.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.max(
						   dp[i - 1][j],                                           // not pick ith item
						   j >= A[i - 1] ? dp[i - 1][j - A[i - 1]] + A[i - 1] : 0);// pick ith item
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Backpack result = new Backpack();
		System.out.println(result.backpack(10, new int[] {3, 4, 5, 8}));
	}

}
