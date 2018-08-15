/**
 * Given a string that consists of only uppercase English letters, you can replace any letter in the 
 * string with another letter at most k times. Find the length of a longest substring containing all 
 * repeating letters you can get after performing the above operations.
 * Note:
 * Both the string's length and k will not exceed 104.
 * Example 1:
 * Input:
 * s = "ABAB", k = 2
 * Output:
 * 4
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 * Input:
 * s = "AABABBA", k = 1
 * Output:
 * 4
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * @author wendi
 *
 */
public class LongestRepeatingCharacterReplacement {
	
	/**
	 * Sliding window + char array
	 * (length of substring - number of times of the maximum occurring character in the substring) <= k
	 * @param String s, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestRepeatingCharacterReplacement(String s, int k) {
		if (s == null || s.length() == 0) return 0;
		if (k >= s.length()) return s.length();
		char[] S = s.toCharArray();
		int[] charCnt = new int[256];
		int res = 0;
		int majorCnt = 0;
		for (int start = 0, end = 0; start < S.length; start++) {
			while (end < S.length) {
				majorCnt = Math.max(majorCnt, charCnt[S[end]] + 1); // find the window longer than previous
				if (end - start + 1 - majorCnt <= k) {
					charCnt[S[end]]++;
					end++;
				}
				else break;
			}
//			System.out.println("s: " + start + " e: " + end);
			// tricky: not every [start, end] is a valid result, which cannot longer than previous valid result
			res = Math.max(end - start, res); 
			charCnt[S[start]]--;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestRepeatingCharacterReplacement result = new LongestRepeatingCharacterReplacement();
		System.out.println(result.longestRepeatingCharacterReplacement("AABABBA", 1));
	}

}
