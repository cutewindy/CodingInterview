import java.util.Arrays;

/**
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the 
 * sum of the face up numbers equals target.
 * Example 1:
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation: 
 * You throw one die with 6 faces.  There is only one way to get a sum of 3.
 * Example 2:
 * Input: d = 2, f = 6, target = 7
 * Output: 6
 * Explanation: 
 * You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
 * 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * Example 3:
 * Input: d = 2, f = 5, target = 10
 * Output: 1
 * Explanation: 
 * You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
 * Example 4:
 * Input: d = 1, f = 2, target = 3
 * Output: 0
 * Explanation: 
 * You throw one die with 2 faces.  There is no way to get a sum of 3.
 * Example 5:
 * Input: d = 30, f = 30, target = 500
 * Output: 222616187
 * Explanation: 
 * The answer must be returned modulo 10^9 + 7.
 * Constraints:
 * 1. 1 <= d, f <= 30
 * 2. 1 <= target <= 1000
 * @author wendi
 *
 */
public class NumberofDiceRollsWithTargetSum {
	
	
	/**
	 * Approach2: DP
	 * dp[i][j]: the number of possible ways sum up to j with i dice rolls
	 * dp[i][j] = sum(dp[i-1][j-k]), 1<=k<=f && k<=j 
	 * @param int d, int f, int target
	 * @return int
	 * Time: O(d * target * f)
	 * Space: O(d * target)  rolling array to save space
	 */
	public int numberofDiceRollsWithTargetSumI(int d, int f, int target) {
		int[][] dp = new int[2][target + 1];
		dp[0][0] = 1;
		int mod = 1000000007;
		for (int i = 1; i <= d; i++) {
			Arrays.fill(dp[i % 2], 0);
			for (int j = 1; j <= target; j++) {
				if (j > i * f) break;  // speed up
				for (int k = 1; k <= f && k <= j; k++) {
					dp[i % 2][j] = (dp[(i - 1) % 2][j - k] + dp[i % 2][j]) % mod;
				}
			}
		}
		return dp[d % 2][target];
	}
	
	
	
	/**
	 * Approach1: DFS + Memorization
	 * dp[i][j]: the number of possible ways sum up to j with i dice rolls
	 * @param int d, int f, int target
	 * @return int
	 * Time: O(d * target * f)
	 * Space: O(d * target)
	 */
	int mod = 1000000007;
	public int numberofDiceRollsWithTargetSum(int d, int f, int target) {
		Integer[][] dp = new Integer[d + 1][target + 1];
		return dfs(d, f, target, dp);
	}
	
	private int dfs(int d, int f, int target, Integer[][] dp) {
		if (d == 0) {
			return target == 0 ? 1 : 0;
		}
		if (dp[d][target] != null) return dp[d][target];
		int res = 0;
		for (int i = 1; i <= f && i <= target; i++) {
			res = (dfs(d - 1, f, target - i, dp) + res) % mod;
		}
		dp[d][target] = res;
		return res;
	} 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofDiceRollsWithTargetSum result = new NumberofDiceRollsWithTargetSum();
		System.out.println(result.numberofDiceRollsWithTargetSum(2, 6, 7));
		System.out.println(result.numberofDiceRollsWithTargetSumI(2, 6, 7));
	}

}
