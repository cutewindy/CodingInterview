/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence 
 * of W.
 * If there is no such window in S that covers all characters in T, return the empty string "". If 
 * there are multiple such minimum-length windows, return the one with the left-most starting index.
 * Example 1:
 * Input: 
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation: 
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of S will be in the range [1, 20000].
 * The length of T will be in the range [1, 100].
 * @author wendi
 *
 */
public class MinimumWindowSubsequence {

	/**
	 * DP(49 ms)
	 * dp[i][j]: store the starting index of the substring where S has length i, T has length j.
	 * if T[i - 1] == S[j - 1], we could borrow the start index from dp[i - 1][j - 1] to make the 
	 * current substring valid;
	 * else, we only need to borrow the start index from dp[i - 1][j] which could either exist or not.
	 * Finally, go through the last col to find the substring with minLen and appears first.
	 * @param String S, String T
	 * @return String
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public String minimumWindowSubsequenceI(String S, String T) {
		if (S == null || T == null || S.length() == 0 || T.length() == 0) return "";
		int m = S.length();
		int n = T.length();
		int[][] dp = new int[m + 1][n + 1];
		// init
		for (int i = 0; i <= m; i++) dp[i][0] = i;
		for (int j = 1; j <= n; j++) dp[0][j] = -1;
		
		// update
		int minLen = Integer.MAX_VALUE;
		int start = -1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
				else dp[i][j] = dp[i - 1][j];
			}
			if (dp[i][n] != -1 && i - dp[i][n] < minLen) {
				minLen = i - dp[i][n];
				start = dp[i][n];
			}
		}
		return start == -1 ? "" : S.substring(start, start + minLen); 
	}
	
	
	/**
	 * Brute force(583 ms)
	 * @param String S, String T
	 * @return String
	 * Time: O(m*n)
	 * Space: O(1)
	 */
	public String minimumWindowSubsequence(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        String res = S + " ";
        for (int start = 0; start < s.length; start++) {
            if (s[start] == t[0]) {
                int end = findT(s, t, start);
                if (end != -1 && end - start < res.length()) res = S.substring(start, end);
            }
        }
        return res.length() > S.length() ? "" : res;
    }
    
    private int findT(char[] s, char[] t, int start) {
        int i = 0;
        for (int end = start; end < s.length; end++) {
            if (s[end] == t[i]) i++;
            if (i == t.length) return end + 1;
        }
        return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubsequence result = new MinimumWindowSubsequence();
		System.out.println(result.minimumWindowSubsequence("abcdebdde", "bde"));
		System.out.println(result.minimumWindowSubsequenceI("abcdebdde", "bde"));
	}

}
