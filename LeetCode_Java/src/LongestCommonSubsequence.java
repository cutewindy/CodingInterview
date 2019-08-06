/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some characters
 * (can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" 
 * is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a 
 * subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * Constraints:
 * 1. 1 <= text1.length <= 1000
 * 2. 1 <= text2.length <= 1000
 * 3. The input strings consist of lowercase English characters only.
 * @author wendi
 *
 */
public class LongestCommonSubsequence {

	
	/**
	 * DP
	 * dp[i][j]: longest common subsequence for t1[0,..,i] and t2[0,...,j]
	 * dp[i][j] = dp[i-1][j-1]+1, when t1[i]=t2[j],
	 * else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
	 * res = dp[m-1][n-1]
	 * @param String text1, String text2
	 * @return int
	 * Time: O(m*n) m=text1.length(), n=text2.length()
	 * Space: O(n) rolling array
	 */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                }
                else {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        return dp[m % 2][n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubsequence result = new LongestCommonSubsequence();
		System.out.println(result.longestCommonSubsequence("abcde", "ace"));
	}

}
