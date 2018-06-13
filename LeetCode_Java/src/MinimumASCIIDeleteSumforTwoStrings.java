/**
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 * Example 1:
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 * Example 2:
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which 
 * are higher.
 * Note:
 * 1. 0 < s1.length, s2.length <= 1000.
 * 2. All elements of each string will have an ASCII value in [97, 122].
 * @author wendi
 *
 */
public class MinimumASCIIDeleteSumforTwoStrings {

	
	/**
	 * DP
	 * @param String s1, String s2
	 * @return int
	 * Time: O(mn)
	 * Space: O(mn)
	 */
	public int minimumASCIIDeleteSumforTwoStrings(String s1, String s2) {
		char[] S1 = s1.toCharArray();
		char[] S2 = s2.toCharArray();
		int m = S1.length;
		int n = S2.length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + S1[i - 1];
		for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] + S2[j - 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (S1[i - 1] == S2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.min(dp[i - 1][j] + S1[i - 1], dp[i][j - 1] + S2[j - 1]);
					dp[i][j] = Math.min(dp[i - 1][j - 1] + S1[i - 1] + S2[j - 1], dp[i][j]);
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumASCIIDeleteSumforTwoStrings result = new MinimumASCIIDeleteSumforTwoStrings();
		System.out.println(result.minimumASCIIDeleteSumforTwoStrings("delete", "leet"));
	}

}
