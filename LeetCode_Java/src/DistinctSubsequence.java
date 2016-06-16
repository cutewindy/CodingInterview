/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * Tags: DP, String
 * @author wendi
 *
 */
public class DistinctSubsequence {
	
	/**
	 * DP:state: num of distinct subsequences of T in S
	 * Function: if S[i-1]=T[j-1],f[i][j]=f[i-1][j-1]+f[i-1][j].Else f[i][j]=f[i-1][j].
	 * @param String s, String t
	 * @return int
	 * Time:O(m*n)
	 * Space:O(m*n)
	 */
	public int distinctSubsequence(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return 0;
		}
		if (t.length() == 0) {
			return 1;
		}
		int m = s.length() + 1;
		int n = t.length() + 1;
		int[][] distinct = new int[m][n];
		for (int i = 0 ; i < m; i++) {
			distinct[i][0] = 1;
		}
		for (int j = 1; j < n; j++) {
			distinct[0][j] = 0;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					distinct[i][j] = distinct[i - 1][j - 1] + distinct[i - 1][j];
				}
				else {
					distinct[i][j] = distinct[i - 1][j];
				}
			}
		}
		return distinct[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequence result = new DistinctSubsequence();
		System.out.println(result.distinctSubsequence("rabbbit", "rabbit"));
	}

}
