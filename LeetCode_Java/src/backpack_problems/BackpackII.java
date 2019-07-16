package backpack_problems;
/**
 * Lintcode 125
 * There are n items and a backpack with size m. Given array A representing the size of each item 
 * and array V representing the value of each item.
 * What's the maximum value can you put into the backpack?
 * A[i], V[i], n, m are all integers.
 * You can not split an item.
 * The sum size of the items you want to put into backpack can not exceed m.
 * Each item can only be picked up once
 * Have you met this question in a real interview?  
 * Example
 * Example 1:
 * Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
 * Output: 9
 * Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9 
 * Example 2:
 * Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]
 * Output: 10
 * Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10 
 * Challenge
 * O(nm) memory is acceptable, can you do it in O(m) memory?
 * @author wendi
 *
 */
public class BackpackII {
	
	/**
	 * Approach2:DP
	 * dp[i][j]: 取前i个物品，容量为j的情况下能取到的最大价值
	 * eg: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
	 * 
	 * i/j  0 1 2 3 4 5 6 7 8 9 10 
	 *  0   0 0 0 0 0 0 0 0 0 0 0
	 *  1   0 0 1 1 1 1 1 1 1 1 1
	 *  2   0 0 1 5 5 6 6 6 6 6 6
	 *  3   0 0 1 5 5 6 6 6 7 7 7
	 *  4   0 0 1 5 5 6 6 6 7 7 9
	 *  
	 * dp[i][j] = max(dp[i-1][j-A[i]]+V[i], dp[i-1][j]); (j-A[i]>=0)
	 * dp[i-1][j-A[i]]+V[i]：取第i个物体的价值
	 * dp[i-1][j]：不取第i个物体的价值
	 * 
	 * @param int m, int[] A, int[] V
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n) -> rolling array O(m)
	 */
	public int backpackIII(int m, int[] A, int[] V) {
		int n = A.length;
		
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (j - A[i - 1] >= 0) dp[i][j] = Math.max(dp[i - 1][j - A[i - 1]] + V[i - 1], dp[i - 1][j]);
				else dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][m];
		
		// rolling array
//		int[][] dp = new int[2][m + 1];
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				if (A[i - 1] > j) dp[i % 2][j] = dp[(i - 1) % 2][j];
//				else dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j - A[i - 1]] + V[i - 1], dp[(i - 1) % 2][j]);
//			}
//		}
//      return dp[n % 2][m];
	}
	
	/**
	 * Approach1: Brute force: for each item, has two options, choice or not choice.
	 * prunning：在确定的容量j下，可能包含了不同的情况，但是对于每个相同的容量不同的情况，我们都继续再往下计算。
	 * 其实只需要在知道相同的容量下拿到最好的价值情况下，再继续往下计算就好了。
	 * @param int m, int[] A, int[] V
	 * @return int
	 * Time: O(2^n)
	 * Space: O(1)
	 */
	public int backpackII(int m, int[] A, int[] V) {
		int[] res = new int[1];
		dfs(m, A, V, 0, 0, 0, res);
		return res[0];
	}
	
	private void dfs(int m, int[] A, int[] V, int index, int currM, int currRes, int[] res) {
		if (index > A.length || currM > m) return;
		res[0] = Math.max(currRes, res[0]);
		for (int i = index; i < A.length; i++) {
			dfs(m, A, V, i + 1, currM + A[i], currRes + V[i], res);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackpackII result = new BackpackII();
		System.out.println(result.backpackII(10, new int[] {2, 3, 5, 7}, new int[] {1, 5, 2, 4}));
		System.out.println(result.backpackIII(10, new int[] {2, 3, 5, 7}, new int[] {1, 5, 2, 4}));
	}

}
