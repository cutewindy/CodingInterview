/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * Tags: DP, String
 * @author wendi
 *
 */
public class InterleavingString {
	
	/**
	 * DP
	 * dp[i][j]: whether s3[0..i+j-1] is interleave by s1[0..i-1] and s2[0..j-1]
	 * @param String s1, String s2, String s3
	 * @return Boolean
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public boolean interleavingString(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		int m = s1.length();
		int n = s2.length();
		boolean[][] interleaving = new boolean[m + 1][n + 1];
		// init
		interleaving[0][0] = true;
		for (int i = 1; i <= m; i++) {
			interleaving[i][0] = (s3.charAt(i - 1) == s1.charAt(i - 1) && interleaving[i - 1][0]);
		}
		for (int j = 1; j <= n; j++) {
			interleaving[0][j] = (s3.charAt(j - 1) == s2.charAt(j - 1) && interleaving[0][j - 1]);
		}
		// update
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if ((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaving[i - 1][j]) 
				|| (s3.charAt(i + j - 1) == s2.charAt(j - 1) && interleaving[i][j - 1])) {
					interleaving[i][j] = true;
				}
			}
		}
		return interleaving[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString result = new InterleavingString();
		System.out.println(result.interleavingString("aabcc", "dbbca", "aadbbcbcac"));
//		System.out.println(result.interleavingString("aabcc", "dbbca", "aadbbbaccc"));
//		System.out.println(result.interleavingString("aabc", "abad", "aabadabc"));

	}

}
