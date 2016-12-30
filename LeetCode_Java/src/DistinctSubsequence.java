/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * Tags: DP, String
 * @author wendi
 *
 */
public class DistinctSubsequence {
	
	/**
	 * DP:dp[i][j]: num of distinct subsequences of T[0..j-1] in S[0..i-1].
	 * 1. init:
	 * The first col must be filled with 1. That's because the empty string is a subsequence of any 
	 * string but only 1 time. So dp[i][0] = 1 for every i.
	 * The first raw of every cols except the first must be 0. This is because an empty string 
	 * cannot contain a non-empty string as a substring
	 * 2. update:
	 * If the current character in S doesn't equal to current character T, then we have the same 
	 * number of distinct subsequences as we had without the new character. That is, if 
	 * S[i-1]=T[j-1],dp[i][j] = dp[i-1][j-1] + dp[i-1][j].
	 * If the current character in S equal to the current character T, then the distinct number of 
	 * subsequences: the number we had before plus the distinct number of subsequences we had with 
	 * less longer T and less longer S. That is, dp[i][j] = dp[i-1][j].
	 * @param String s, String t
	 * @return int
	 * Time:O(m*n)
	 * Space:O(m*n)
	 */
	public int distinctSubsequence(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return 0;
		}
		if (t.length() == 0) {
			return 1;
		}
		int m = s.length();
		int n = t.length();
		int[][] distinct = new int[m + 1][n + 1];
		// init
		for (int i = 0 ; i <= m; i++) {
			distinct[i][0] = 1;
		}
		// update
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					distinct[i][j] = distinct[i - 1][j - 1] + distinct[i - 1][j];
				}
				else {
					distinct[i][j] = distinct[i - 1][j];
				}
			}
		}
		return distinct[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequence result = new DistinctSubsequence();
		System.out.println(result.distinctSubsequence("rabbbit", "rabbit"));
	}

}
