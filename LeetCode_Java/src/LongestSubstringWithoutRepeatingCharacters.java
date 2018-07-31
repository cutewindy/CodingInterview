import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



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
	 * Method3(60ms): Two pointers: slide window + char array
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringWithoutRepeatingCharactersII(String s) {	
		if (s == null || s.length() == 0) return 0;
		int res = 0;
		char[] S = s.toCharArray();
		int[] charCnt = new int[256];
		for (int start = 0, end = 0; start < S.length; start++) {
			while (end < S.length && charCnt[S[end]] == 0) {
				charCnt[S[end]]++;
				end++;
			}
			res = Math.max(end - start, res);
			charCnt[S[start]]--;
		}
		return res;
	}
	
	
	/**
	 * Method2(60ms): Two pointers: slide window + hash table 
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringWithoutRepeatingCharactersI(String s) {	
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		int start = 0;
		Map<Character, Integer> hash = new HashMap<>();
		char[] S = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (hash.containsKey(S[i]) && start <= hash.get(S[i])) {
				start = hash.get(S[i]) + 1;	
			}
			hash.put(S[i], i);
			result = Math.max(i - start + 1, result);
		}
		return result;
	}
	
	
	/**
	 * Method1(74ms): Two pointers: slide window + set
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] S = s.toCharArray();
        int n = S.length;
        int start = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            while (set.contains(S[i])) {
                set.remove(S[start]);
                start++;
            }
            set.add(S[i]);
            result = Math.max(i - start + 1, result);
        }
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters result = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(result.longestSubstringWithoutRepeatingCharacters("pwwkew"));
		System.out.println(result.longestSubstringWithoutRepeatingCharactersI("pwwkew"));
		System.out.println(result.longestSubstringWithoutRepeatingCharactersII("pwwkew"));
	}

}
