package IBM;
/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 * @author wendi
 *
 */
public class InterleavingString {

	/**
	 * DP
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public boolean interleavingString(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		if (m + n != s3.length()) return false;
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= m; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) dp[i][0] = true;
		}
		for (int j = 1; j <= n; j++) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]) dp[0][j] = true;
		}
		
		for (int i = 1; i <= m; i++) {
			char c1 = s1.charAt(i - 1);
			for (int j = 1; j <= n; j++) {
				char c2 = s2.charAt(j - 1);
				char c3 = s3.charAt(i + j - 1);
				if (c1 == c3 && dp[i - 1][j]) dp[i][j] = true;
				if (c2 == c3 && dp[i][j - 1]) dp[i][j] = true;
			}
		}
		
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString result = new InterleavingString();
		System.out.println(result.interleavingString("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(result.interleavingString("aabcc", "dbbca", "aadbbbaccc"));
	}

}
