/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings 
 * even they consist of same characters.
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note:
 * The input string length won't exceed 1000.
 * @author wendi
 *
 */
public class PalindromicSubstrings {
	

	/**
	 * Method3: 
	 * @param String s
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int palindromicSubstringsII(String s) {	
		if (s == null || s.length() == 0) return 0;
		int res = 0;	
		for (int mid = 0; mid < s.length(); mid++) {
			res += countPalindrome(s, mid, mid);
			res += countPalindrome(s, mid, mid + 1);
		}
		return res;
	}
	
	private int countPalindrome(String s, int left, int right) {
		int res = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			res++;
			left--;
			right++;
		}
		return res;
	}

	
	/**
	 * Method2: DP
	 * @param String s
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n^2)
	 */
	public int palindromicSubstringsI(String s) {	
		if (s == null || s.length() == 0) return 0;
		int result = 0;
		char[] S = s.toCharArray();
		boolean[][] dp = new boolean[s.length()][s.length()];
		// init dp
		for (int i = 0; i < S.length; i++) {
			dp[i][i] = true;
			result++;
		}
		for (int j = 1; j < S.length; j++) {
			if (S[j] == S[j - 1]) {
				dp[j-1][j] = true;
				result++;
			}
		}
        // dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
		for (int len = 3; len <= S.length; len++) {
			for (int i = 0; i < S.length - len + 1; i++) {
				int j = i + len - 1;
				if (dp[i + 1][j - 1] && S[i] == S[j]) {
					dp[i][j] = true;
					result++;
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Method1: Brute force
	 * @param String s
	 * @return int
	 * Time: O(n^3)
	 * Space: O(1)
	 */
	public int palindromicSubstrings(String s) {
		if (s == null || s.length() == 0) return 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindrom(s, i, j)) res++;
			}
		}
		return res;	
	}
	
	public boolean isPalindrom(String s, int i, int j) {
		if (i == j) return true;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromicSubstrings result = new PalindromicSubstrings();
		System.out.println(result.palindromicSubstrings("aaa"));
		System.out.println(result.palindromicSubstringsI("aaaaa"));
		System.out.println(result.palindromicSubstringsII("aaaaa"));
	}

}
