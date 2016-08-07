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
	
	public int palindromePartioningIII(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int l = 2; l <= n; l++) {
			for (int end = l - 1; end < n; end++) {
				int start = end - l + 1;
				if (isPalindrome(s, start, end)) {
					dp[start][end] = 0;
				}
				else {
					dp[start][end] = Integer.MAX_VALUE;
					for (int cut = start; cut < end; cut++) {
						dp[start][end] = Math.min(dp[start][cut] + dp[cut + 1][end] + 1, dp[start][end]);
					}
				}
			}
		}
		
		return dp[0][n - 1]; 
	}
	
	
	/**
	 * Method1: Brute force
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
		// init
		for (int i = 0; i < n; i++) {
			dp[i] = i;
		}
		// update
		for (int end = 1; end < n; end++) {
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
