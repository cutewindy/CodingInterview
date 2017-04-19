/**
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 
 * Tags: DP, Backtracking, Greedy, String
 * @author wendi
 *
 */
public class WildcardMatching {
		
	/**
	 * Method1: DP
	 * dp[i][j]: whether s[0..i-1] is matching p[0..j-1]
	 * 1 If p[j-1] == s[i-1]: dp[i][j] = dp[i-1][j-1];
	 * 2 Else if p[j-1] == '.': dp[i][j] = dp[i-1][j-1];
	 * 3 Else if p[j-1] == '*', here are two sub conditions:
	 *    3.1 dp[i][j] = dp[i][j-1]  // in this case, * matches 0 character;
	 *    3.2 dp[i][j] = dp[i-1][j]  // in this case, * matches single or more characters;
	 * 4 Else p[j-1] != s[i-1]: dp[i][j] = false.
	 * @param String s, String p
	 * @return boolean
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public boolean wildcardMatching(String s, String p) {
		if (s == null && p == null || s.length() == 0 && p.length() == 0) return true;
		if (s == null || p == null) return false;
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		// init
		dp[0][0] = true;
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) != '*') break;
			dp[0][j] = true;
		}
		// update
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				}
				else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching result = new WildcardMatching();
		System.out.println(result.wildcardMatching("aaabbbaaaabbccc", "*aa*aa*?bb*cc?"));
//		System.out.println(result.wildcardMatchingI("aa", "a*"));
//		System.out.println(result.wildcardMatchingI("ab", "*?"));
//		System.out.println(result.wildcardMatchingI("aaabbbaaaabbccc", "*aa*aa*?bb*cc?"));
	}

}
