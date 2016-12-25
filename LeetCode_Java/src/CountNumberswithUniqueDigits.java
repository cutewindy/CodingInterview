/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, 
 * excluding [11,22,33,44,55,66,77,88,99])
 * Hint:
 * 1 A direct way is to use the backtracking approach.
 * 2 Backtracking should contains three states which are (the current number, number of steps to 
 *   get that number and a bitmask which represent which number is marked as visited so far in 
 *   the current number). Start with state (0,0,0) and count all valid number till we reach number 
 *   of steps equals to 10n.
 * 3 This problem can also be solved using a dynamic programming approach and some knowledge of
 *   combinatorics.
 * 4 Let f(k) = count of numbers with unique digits with length equals k.
 * 5 f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number
 *   cannot start with 0].
 * 
 * Tags: DP, Backtracking, Math
 * @author wendi
 *
 */
public class CountNumberswithUniqueDigits {

	/**
	 * DP: dp[i] = count of numbers with unique digits with length equals i.
	 * dp[0] = 1 (0)
	 * dp[1] = 10 (0, 1, 2, 3, ...., 9)
	 * dp[2] = 9*9 (Because i from 1, ..., 9, we can pick j to form a 2-digit number ij and 
	 * 				there are 9 numbers that are different from i for j to choose from);;
	 * dp[3] = 9*9*8;
	 * dp[4] = 9*9*8*7;
	 * dp[i] = dp[i-1]*(10-i+1);
	 * dp[11] = dp[12] = ... = 0 (any number with length > 10 couldn't be unique digits number).
	 * result += dp[i]
	 * @param int n
	 * @return int
	 * Time: O(1) There are only 11 different ans. You can create a lookup table for it. 
	 * This problem is O(1) in essence
	 * Space: O(1)
	 */
	public int countNumberswithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 10;
		}
		int result = 0;
		int[] dp = new int[11];
		// init
		dp[0] = 1;
		dp[1] = 9;
		result = 10;
		// dp update
		for (int i = 2; i <= n && i <= 10; i++) {
			dp[i] = dp[i - 1] * (11 - i);
			result += dp[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountNumberswithUniqueDigits result = new CountNumberswithUniqueDigits();
		System.out.println(result.countNumberswithUniqueDigits(11));
	}

}
