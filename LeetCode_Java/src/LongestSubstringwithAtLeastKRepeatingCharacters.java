/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) 
 * such that every character in T appears no less than k times.
 * Example 1:
 * Input: s = "aaabb", k = 3
 * Output: 3. The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * Input: s = "ababbc", k = 2
 * Output: 5. The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {

	
	/**
	 * Method2: Divide and Conquer + char array: 
	 * @param String s, int k
	 * @return int
	 * Time: O(n^2)
	 * Space: O(26n)
	 * Stack space: O(n)
	 */
	public int longestSubstringwithAtLeastKRepeatingCharactersI(String s, int k) {
		if (s == null || s.length() == 0 || s.length() < k) {
			return 0;
		}
		if (k <= 1) {
			return s.length();
		}
		return helper(s, k);
	}
	
	private int helper(String s, int k) {
		if (s.length() < k) {
			return 0;
		}
		char[] counts = new char[26];
		for (char c: s.toCharArray()) {
			counts[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (counts[s.charAt(i) - 'a'] != 0 && counts[s.charAt(i) - 'a'] < k) {
				return Math.max(helper(s.substring(0,  i), k), helper(s.substring(i + 1), k)); 
			}
		}
		return s.length();
	}
	
	
	/**
	 * Method1: Brute Force + char array(Time Limit Exceeded)
	 * @param String s, int k
	 * @return int
	 * Time: O(26 * n^2)
	 * Space: O(26)
	 */
	public int longestSubstringwithAtLeastKRepeatingCharacters(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (k <= 1) {
			return s.length();
		}
		int result = 0;
		char[] S = s.toCharArray();
		for (int i = 0; i < S.length - 1; i++) {
			int[] counts = new int[26];
			counts[S[i] - 'a']++;
			for (int j = i + 1; j < S.length; j++) {
				counts[S[j] - 'a']++;
				boolean find = true;
				for (int count: counts) {
					if (count != 0 && count < k) {
						find = false;
					}
				}
				if (find && j - i + 1 > result) {
					result = j - i + 1;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringwithAtLeastKRepeatingCharacters result = new LongestSubstringwithAtLeastKRepeatingCharacters();
		System.out.println(result.longestSubstringwithAtLeastKRepeatingCharacters("abcababbdabae", 2));
		System.out.println(result.longestSubstringwithAtLeastKRepeatingCharactersI("abcababbdabae", 2));
	}

}
