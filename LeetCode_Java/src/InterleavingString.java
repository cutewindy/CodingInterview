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
	 * @param String s1, String s2, String s3
	 * @return Boolean
	 * Time: 
	 * Space:
	 */
	public boolean interleavingString(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		int m = s1.length() + 1;
		int n = s2.length() + 1;
		boolean[][] interleaving = new boolean[m][n];
		// init
		interleaving[0][0] = true;
		for (int i = 1; i < m; i++) {
			interleaving[i][0] = (s3.charAt(i - 1) == s1.charAt(i - 1) && interleaving[i - 1][0]);
		}
		for (int j = 1; j < n; j++) {
			interleaving[0][j] = (s3.charAt(j - 1) == s2.charAt(j - 1) && interleaving[0][j - 1]);
		}
		// function
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if ((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaving[i - 1][j] == true) ||
						(s3.charAt(i + j - 1) == s2.charAt(j - 1) && interleaving[i][j - 1] == true)) {
					interleaving[i][j] = true;
				}
				else {
					interleaving[i][j] = false;
				}
				System.out.print(interleaving[i][j] + ", ");
			}
			System.out.println();
		}
		return interleaving[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString result = new InterleavingString();
		System.out.println(result.interleavingString("aabcc", "dbbca", "aadbbcbcac"));
//		System.out.println(result.interleavingString("aabcc", "dbbca", "aadbbbaccc"));
//		System.out.println(result.interleavingString("aabc", "abad", "aabadabc"));

	}

}
