package IBM;
/**
 *后面问了 移到 2个 string match pattern 的题， 用dp 来解，
 * @author wendi
 *
 */
public class StringMatchPattern {
	
	
	/**
	 * dp
	 * @param String s, String p
	 * @return boolean
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */	
    public boolean regularExpressionMatching(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) dp[0][j] = true;
        }
        
        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') dp[i][j] = dp[i - 1][j - 1];
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 2] || 
                    		((sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }
        
        return dp[m][n];
    }
	
	
	/**
	 * dp
	 * @param String s, String p
	 * @return boolean
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
    public boolean wildcardMatching(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 1]) dp[0][j] = true;
        }    
    
        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (pc == '*') dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
            }
            
        }
        return dp[m][n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
