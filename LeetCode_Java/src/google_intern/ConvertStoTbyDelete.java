package google_intern;
/**
 * Write a function:
class Solution
{
      public int solution(String S, String T) {}
}

that, given a string S and a string T, return 1 if it's possible to convert string S into string T 
by deleting some(possible zero).
characters from string S, and otherwise returns 0.

For example, given S="abcd" and T="abd" the function should return 1. We can delete 'c' from string 
S to convert string S into
string T. However, given S="ab" and T="ba" the function should return 0.

Assume that:
the length of ('S' , 'T') is within the range [1..1,000]
strings S and T consist only of lower-case letters (a-z).
 * @author wendi
 *
 */
public class ConvertStoTbyDelete {
	
	/**
	 * DP
	 * @param String S, String T
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public int convertStoTbyDelete(String S, String T) {
		if (S == null && T == null || S.length() == 0 && T.length() == 0) return 1;
		if (S == null || S.length() == 0) return 0;
		int m = S.length();
		int n = T.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		dp[1][0] = true;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j - 1] && S.charAt(i - 1) == T.charAt(j - 1) ||
						dp[i - 1][j];
			}
		}
		return dp[m][n] ? 1 : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertStoTbyDelete result = new ConvertStoTbyDelete();
		System.out.println(result.convertStoTbyDelete("abcd", "abd"));
		System.out.println(result.convertStoTbyDelete("ab", "ba"));
	}

}
