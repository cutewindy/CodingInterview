/**
 * Given a positive integer n, break it into the sum of at least two positive integers and 
 * maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * Hints: 
 * 1 There is a simple O(n) solution to this problem.
 * 2 You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 * 
 * Tags: DP, Math
 * @author wendi
 *
 */
public class IntegerBreak {

	/**
	 * Method2: Math: 
	 * @param int n
	 * @return n
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int integerBreakI(int n) {
		if (n <= 3) {
			return n - 1;
		}
		int result = 1;
		while (n > 4) {
			result *= 3;
			n -= 3;
		}
		result *= n;
		return result;
	}
	
	
	/**
	 * Method1: DP
	 * dp[i]: max product of integer i.
	 * dp[i] = max(j, dp[j]) * max(i - j, dp[i - j])
	 * @param int n
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int integerBreak(int n) {
		if (n < 3) return 1;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]), dp[i]);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerBreak result = new IntegerBreak();
		System.out.println(result.integerBreak(9));
		System.out.println(result.integerBreakI(9));
	}

}
