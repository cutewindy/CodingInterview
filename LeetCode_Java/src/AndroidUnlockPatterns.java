/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the 
 * total number of unlock patterns of the Android lock screen, which consist of minimum of m keys 
 * and maximum n keys.
 * Rules for a valid pattern:
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, the 
 * other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 * The order of keys used matters.
 * Explanation:
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6 
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 * Example:
 * Given m = 1, n = 1, return 9.
 * 
 * Tags: DP; Backtracking
 * @author wendi
 *
 */
public class AndroidUnlockPatterns {
	
	/**
	 * Backtracking
	 * @param int m, int n
	 * @return int
	 * Time: O(9log(n))
	 * Space: O(9)
	 * Static space: O(log(n))
	 */
	public int androidUnlockPatterns(int m, int n) {
		if (m < 0 || n > 9 || n < m) return 0;
		int[] result = new int[1];
		boolean[][] visited = new boolean[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				visited[i][j] = true;
				helper(visited, i, j, 1, m, n, result);
				visited[i][j] = false;
			}
		}
		return result[0];
	}
	
	public void helper(boolean[][] visited, int row, int col, int num, int m, int n, int[] result) {	
		if (num >= m && num <= n) {
			result[0] += 1;
		}
		if (num == n) return;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (visited[i][j]) {
					continue;
				}
				int rowDiff = Math.abs(i - row);
				int colDiff = Math.abs(j - col);
				if (rowDiff == 0 && colDiff == 2 && !visited[row][1]
				 || rowDiff == 2 && colDiff == 0 && !visited[1][col]
				 || rowDiff == 2 && colDiff == 2 && !visited[1][1]) {
					continue;
				}
				visited[i][j] = true; 
				helper(visited, i, j, num + 1, m, n, result);
				visited[i][j] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AndroidUnlockPatterns result = new AndroidUnlockPatterns();
		System.out.println(result.androidUnlockPatterns(1, 3));
	}

}
