import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct 
 * characters.
 * For example, given s = "eceba",
 * T is "ece" which its length is  3.
 * 
 * Tags: hashTable, Two pointers, String
 * @author wendi
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	/**
	 * Method2: sliding window + char array
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringWithAtMostTwoDistinctCharactersI(String s) { 
		if (s == null || s.length() == 0) return 0;
		int[] charCnt = new int[256];
		char[] S = s.toCharArray();
		int cnt = 0;
		int res = 0;
		for (int start = 0, end = 0; start < S.length; start++) {
			while (end < S.length && (charCnt[S[end]] > 0 || cnt < 2)) {
				if (charCnt[S[end]] == 0) cnt++;
				charCnt[S[end]]++;
				end++;
			}
			res = Math.max(end - start, res);
			charCnt[S[start]]--;
			if (charCnt[S[start]] == 0) cnt--;
		}
		return res;
	}
	
	
	
	/**
	 * Method1: Slide window + hash table
	 * The main idea is to maintain a sliding window with 2 unique characters. The key is to store 
	 * the last occurrence of each character as the value in the hashmap. This way, whenever the 
	 * size of the hashmap exceeds 2, we can traverse through the s from start to remove the it in 
	 * hashmap, if it's frequency is 0, then we remove it from hashmap that can get the longest
	 * substring from start to i. And remove this character from our map. Since the range of 
	 * characters is constrained, we should be able to find the left most index in constant time.
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringWithAtMostTwoDistinctCharacters(String s) { 
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		int start = 0;
		Map<Character, Integer> hash = new HashMap<>();	
		char[] S = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (hash.containsKey(S[i])) {
				hash.put(S[i], hash.get(S[i]) + 1);
			}
			else {
				hash.put(S[i], 1);
			}
			while (hash.size() > 2) {
				hash.put(S[start], hash.get(S[start]) - 1);
				if (hash.get(S[start]) == 0) {
					hash.remove(S[start]);
				}
				start++;
			}
			result = Math.max(i - start + 1, result);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithAtMostTwoDistinctCharacters result = new LongestSubstringWithAtMostTwoDistinctCharacters();
		System.out.println(result.longestSubstringWithAtMostTwoDistinctCharacters("eceba"));
		System.out.println(result.longestSubstringWithAtMostTwoDistinctCharactersI("eceba"));
	}

}
