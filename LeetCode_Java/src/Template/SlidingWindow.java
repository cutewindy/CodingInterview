package Template;
/**
 * 3. Longest Substring Without Repeating Characters
 * 30. Substring with Concatenation of All Words
 * 76. Minimum Window Substring
 * 209. Minimum Size Subarray Sum
 * 340. Longest Substring with At Most K Distinct Characters
 * 424. Longest Repeating Character Replacement
 * 438. Find All Anagrams in a String (like sliding window, window is fixed size)
 * 567. Permutation in String (like sliding window, window is fixed size. same like 438. Find All Anagrams in a String)
 * 713. Subarray Product Less Than K
 * @author wendi
 *
 */

public class SlidingWindow {
	
	public int slidingWindow(String s, int k) {
		if (s == null || s.length() == 0) return 0;
		if (s.length() < k) return s.length();
		char[] S = s.toCharArray();
		int[] cnts = new int[256];
		int cnt = 0;
		int res = 0;
		for (int start = 0, end = 0; start < S.length; start++) {
			while (end < S.length && (cnts[S[end]] > 0 || cnt < k)) {
				if (cnts[S[end]] == 0) cnt++;
				cnts[S[end]]++;
				end++;
			}
			res = Math.max(end - start, res);
			if (--cnts[S[start]] == 0) cnt--;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindow result = new SlidingWindow();
		System.out.println(result.slidingWindow("eceba", 2));
	}

}
