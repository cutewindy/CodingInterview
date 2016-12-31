import java.util.Arrays;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 * Tags: DP, Backtracking, String
 * @author wendi
 *
 */
public class RegularExpressionMatching {
	
	
	/**
	 * DP: 
	 * dp[i][j]: whether s[0..i-1] is matching p[0..j-1]. 
	 * 1 If p[j-1] == s[i-1]: dp[i][j] = dp[i-1][j-1];
	 * 2 Else if p[j-1] == '.': dp[i][j] = dp[i-1][j-1];
	 * 3 Else if p[j-1] == '*', here are two sub conditions:
	 *    3.1 dp[i][j] = dp[i][j-2]  //in this case, X* only counts as empty;
	 *    3.2 if p[j-2] == s[i-1] or p[j-2] == '.': 
	 *        dp[i][j] = dp[i-1][j]   // in this case, X* counts as single or multiple X;
	 * 4 Else p[j-1] != s[i-1]: dp[i][j] = false.
	 * @param String s, String p
	 * @return boolean
	 * Time: O(m * n)
	 * Space: O(m * n)
	 */
	public boolean regularExpressionMatching(String s, String p) {
		if (s == null && p == null || s.length() == 0 && p.length() == 0) return true;
		if (s == null || p == null) return false;
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		// init
		dp[0][0] = true;
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 2]; // case: * match 0 element
			}
		}
		// update
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				}
				else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2] // case: p[j-1]=* match 0 element of s[i-1]
							|| ((p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && dp[i - 1][j]); // case: p[j-1]=* match 1 or more element of s[i-1]
				}
			}
		}
//		for (boolean[] a: dp) {
//			System.out.println(Arrays.toString(a));
//		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching result = new RegularExpressionMatching();
		System.out.println(result.regularExpressionMatching("aaa", "ab*a*c*a"));
	}

}
