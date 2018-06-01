/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending 
 * multiple copies of the substring together. You may assume the given string consists of lowercase 
 * English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * @author wendi
 *
 */
public class RepeatedSubstringPattern {

	
	/**
	 * Brute force
	 * @param String s
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public boolean repeatedSubstringPattern(String s) {
		if (s == null || s.length() == 0) return true;
		for (int i = 1; i <= s.length() / 2; i++) {
			if (canRepeat(s, s.substring(0, i))) return true;
		}
		return false;
	}
	
	public boolean canRepeat(String s, String substr) {
		if (s.length() % substr.length() != 0) return false;
		int k = substr.length();
		for (int i = k; i + k <= s.length(); i += k) {
			if (!s.substring(i, i + k).equals(substr)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedSubstringPattern result = new RepeatedSubstringPattern();
		System.out.println(result.repeatedSubstringPattern("abab"));
	}

}
