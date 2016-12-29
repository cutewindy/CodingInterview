/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to
 *  word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word: 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * Tags:DP, String
 * @author wendi
 *
 */
public class EditDistance {
	
	/**
	 * DP: consider insert, delete and replace situations, get the minimum one.
	 * dp[i][j]: the minimum number of operations to convert word1[0..i - 1] to word2[0..j - 1].
	 * Case 1: word1[i] == word2[j], dp[i][j] = dp[i-1][j-1]
	 * Case 2: word1[i] != word2[j], then we must either insert, delete or replace, choose cheaper one:
	 * dp[i][j] = min {dp[i][j-1](insert), dp[i-1][j](delete), dp[i-1][j-1](replace)} + 1
	 * @param String word1, String word2
	 * @return int
	 * Time: O(m * n)
	 * Space: O(m * n) can be optimized to O(n)
	 */
	public int editDistance(String word1, String word2) {
		if (word1 == null && word2 == null) return 0;
		if (word1 == null || word1.length() == 0) return word2.length();
		if (word2 == null || word2.length() == 0) return word1.length();
		int m = word2.length();
		int n = word1.length();
		int[][] dis = new int[m + 1][n + 1];
		//init
		for (int i = 1; i <= m; i++) {
			dis[i][0] = i;
		}
		for (int j = 1; j <= n; j++) {
			dis[0][j] = j;
		}
		// update
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
					dis[i][j] = dis[i - 1][j - 1];
				}
				else {
					dis[i][j] = Math.min(dis[i - 1][j - 1] + 1, Math.min(dis[i - 1][j] + 1, dis[i][j - 1] + 1));
				}
			}
		}
		return dis[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance result = new EditDistance();
		System.out.println(result.editDistance("mart", "karma"));
	}

}
