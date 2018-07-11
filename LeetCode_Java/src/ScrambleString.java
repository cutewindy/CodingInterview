/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty 
 * substrings recursively.
 * Below is one possible representation of s1 = "great":
	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled 
 * string "rgeat".
	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled 
 * string "rgtae".
	    rgtae
	   /    \
	  rg    tae
	 / \    /  \
	r   g  ta  e
	       / \
	      t   a
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class ScrambleString {
	
	/**
	 * DP
	 * @param String s1, String s2
	 * @return boolen
	 * Time: O(n^4)
	 * Space: O(n^3)
	 */
	public boolean scrambleString(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
		int n = s1.length();
		// dp[i][j][l]: tracks isScramble(s1[i...i+l-1], s2[j...j+l-1])
		boolean[][][] dp = new boolean[n][n][n + 1];
		
		// init, when there is only one char, l = 1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
			}
		}
		
		// update
		for (int l = 2; l <= n; l++) {              // substring length
			for (int i = 0; i <= n - l; i++) {      // s1[i...i+l-1]
				for (int j = 0; j <= n - l; j++) {  // s2[j...j+l-1]
					boolean canScramble = false;
					for (int k = 1; k < l; k++) {
						// canScramble = isScramble(s11, s21) && isScramble(s12, s22)
                        //            || isScramble(s11, s22) && isScramble(s12, s21)
						if (dp[i][j][k] && dp[i + k][j + k][l - k] ||
							dp[i][j + l - k][k] && dp[i + k][j][l - k]) {
							canScramble = true;
							break;
						}
					}
					dp[i][j][l] = canScramble;
				}
			}
		}
		
 		return dp[0][0][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString result = new ScrambleString();
		System.out.println(result.scrambleString("rgtae", "great"));
	}

}
