
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class PalindromePartitioningII {
	
	
	/**
	 * Method2: DP: 
	 * isPalindrome[i][j]: whether s[i..j] is palindrome
	 * dp[end]: min cut of s[0..end]
	 * If s[start] = s[end] and s[start+1..end-1] is palindrome, then, s[start..end] is palindrome, 
	 * and dp[end] = min(dp[start - 1] + 1, dp[end]).  
	 * @param String s
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n^2 + n)
	 */
	public int palindromePartioningIII(String s) {
		if (s == null || s.length() == 0) return 0;
		int n = s.length();
		boolean[][] isPalindrome = new boolean[n][n]; 
		int[] dp = new int[n];
		for (int end = 0; end < n; end++) {
			dp[end] = end; // init: max cut of string(0, end)
			for (int start = 0; start <= end; start++) {
				if (s.charAt(start) == s.charAt(end)
				&& (start + 1 >= end - 1 || isPalindrome[start + 1][end - 1])) {
					isPalindrome[start][end] = true;
					dp[end] = Math.min(start == 0 ? 0 : dp[start - 1] + 1, dp[end]);
				}
			}
		}
		return dp[n - 1];
	}
	
	
	/**
	 * Method1: DP: Brute force(TLE)
	 * dp[end]: min cut of s[0..end]
	 * @param String s
	 * @return int
	 * Time: O(n^3)
	 * Space: O(n)
	 */
	public int palindromePartioningII(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n];
		for (int end = 1; end < n; end++) {
			dp[end] = end; // init
			for (int start = 0; start <= end; start++) {
				if (isPalindrome(s, start, end)) {
					dp[end] = Math.min(start != 0 ? dp[start - 1] + 1 : 0, dp[end]);
				}
			}
		}
		return dp[n - 1];
	}
	
	public boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioningII result = new PalindromePartitioningII();
//		System.out.println(result.palindromePartioningII("aab"));
		System.out.println(result.palindromePartioningIII("abcbm"));
	}

}
