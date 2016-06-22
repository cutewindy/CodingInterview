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
	 * @param String word1, String word2
	 * @return int
	 * Time: O(m * n)
	 * Space: O(m * n)
	 */
	public int editDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return 0;
		}
		int m = word2.length() + 1;
		int n = word1.length() + 1;
		int[][] dis = new int[m][n];
		//init
		for (int i = 0; i < m; i++) {
			dis[i][0] = i;
		}
		for (int j = 0; j < n; j++) {
			dis[0][j] = j;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
					dis[i][j] = Math.min(dis[i - 1][j - 1], Math.min(dis[i - 1][j] + 1, dis[i][j - 1] + 1));
				}
				else {
					dis[i][j] = Math.min(dis[i - 1][j - 1] + 1, Math.min(dis[i - 1][j] + 1, dis[i][j - 1] + 1));
				}
			}
		}
		return dis[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance result = new EditDistance();
		System.out.println(result.editDistance("abba", "ab"));
	}

}
