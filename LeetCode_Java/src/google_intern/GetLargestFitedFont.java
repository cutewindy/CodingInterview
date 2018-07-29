package google_intern;
/**
 * 给定一个屏幕，大小为W*H， 一个字符串 s，一个字号范围 1 ～ 12， 两个method能分别返回给定character在给定字号下的w和h，
 * 求能将s放进屏幕的最大字号。假设不同字符在相同字号下的高度一样，宽度不一样。
 * @author wendi
 *
 */
public class GetLargestFitedFont {
	

	/**
	 * Binary Search
	 * @param int W, int H, String s, int minFont, int maxFont
	 * @return int
	 * Time: O(log(n) * m)  n=maxFont-minFont, m=s.length()
	 * Space: O(1)
	 */
	public int getLargestFitedFont(int W, int H, String s, int minFont, int maxFont) {
		while (minFont + 1 < maxFont) {
			int mid = minFont + (maxFont - minFont) / 2;
			if (canFit(W, H, s, mid)) minFont = mid;
			else maxFont = mid - 1;
		}
		if (canFit(W, H, s, maxFont)) return maxFont;
		if (canFit(W, H, s, minFont)) return minFont;
		return -1;  // even the smallest number cannot fit
	}
	
	public boolean canFit(int W, int H, String s, int font) {
		int currW = 0;
		int currH = 0;
		char[] S = s.toCharArray();
		for (int i = 0; i < S.length; i++) {
			int w = getW(S[i], font);
			int h = getH(S[i], font);
			if (w > W || currW + w > W && currH + h > H) return false;
			if (currW + w <= W) currW += w;
			else {           // need to restart with a new line
				currW = w;
				currH += h;
			}
		}
		return true;
	}
	
	public int getW(char c, int font) {
		return font;
	}
	
	public int getH(char c, int font) {
		return font;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
