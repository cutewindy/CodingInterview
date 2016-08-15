import java.util.HashMap;
import java.util.Map;



/**
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Similar Algorithm: 
 * Minimum Size Subarray Sum, Subarray Sum II, Longest Substring Without Repeating Character, 
 * Longest Substring with At Most Two Distinct Character, Minimum Window Substring, Substring with Concatenation of All Words
 * 
 * Tags: HashTable, Two pointers, String
 * @author wendi
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * Two pointers: slide window: 
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringWithoutRepeatingCharacters(String s) {	
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		int start = 0;
		Map<Character, Integer> hash = new HashMap<>();
		char[] S = s.toCharArray();
		for (int i =0; i < s.length(); i++) {
			if (hash.containsKey(S[i]) && start <= hash.get(S[i])) {
				start = hash.get(S[i]) + 1;	
			}
			hash.put(S[i], i);
			result = Math.max(i - start + 1, result);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters result = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(result.longestSubstringWithoutRepeatingCharacters("pwwkew"));
	}

}
