/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the 
 * maximum length of s is 1000.
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 * @author wendi
 *
 */
public class LongestPalindromicSubsequence {
	
	/**
	 * DP
	 * dp[i][j]: the longest palindromic subsequence’s length of substring(i, j)
	 * State transition:
	 * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
	 * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
	 * Initialization: dp[i][i] = 1
	 * @param String s
	 * @return int
	 * Time: O(n*2)
	 * Space: O(n*2)
	 */
	public int longestPalindromicSubsequence(String s) {
		if (s == null || s.length() == 0) return 0;
		int n = s.length();
		char[] S = s.toCharArray();
		int[][] dp = new int[n][n];
		// init
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		// update dp
		for (int len = 2; len <= S.length; len++) {
			for (int i = 0; i <= S.length - len; i++) {
				int j = i + len - 1;
				if (S[i] == S[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
				else dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubsequence result = new LongestPalindromicSubsequence();
		System.out.println(result.longestPalindromicSubsequence("bbbcb"));
	}

}
