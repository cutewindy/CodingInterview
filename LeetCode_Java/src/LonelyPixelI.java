/**
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.
 * The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and 
 * white pixels respectively.
 * A black lonely pixel is character 'B' that located at a specific position where the same row and 
 * same column don't have any other black pixels.
 * Example:
 * Input: 
 * [['W', 'W', 'B'],
 *  ['W', 'B', 'W'],
 *  ['B', 'W', 'W']]
 * Output: 3
 * Explanation: All the three 'B's are black lonely pixels.
 * Note:
 * The range of width and height of the input 2D array is [1,500].
 * @author wendi
 *
 */
public class LonelyPixelI {

	

	/**
	 * Two pass with m+n space
	 * First pass, count how many times B occurs in each row and col, 
	 * Second pass, check whether B is lonely pixel
	 * @param char[][] picture
	 * @return int
	 * Time: O(2mn)
	 * Space: O(m+n)
	 */
	public int lonelyPixelI(char[][] picture) {
		if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
		int m = picture.length;
		int n = picture[0].length;
		int[] rowCount = new int[m];
		int[] colCount = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] == 'B') {
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < m; i++) {
			if (rowCount[i] > 1) continue;
			for (int j = 0; j < n; j++) {
				if (colCount[j] > 1) continue;
				if (picture[i][j] == 'B') res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LonelyPixelI result = new LonelyPixelI();
		char[][] picture = {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};
		System.out.println(result.lonelyPixelI(picture));
	}

}
