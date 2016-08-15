import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct 
 * characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 * 
 * Tags: HashTable, String
 * @author wendi
 *
 */
public class LongestSubstringwithAtMostKDistinctCharacters {

	/**
	 * Slide Window + HashMap: Like longestSubstringwithAtMostKDistinctCharacters
	 * @param String s, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringwithAtMostKDistinctCharacter(String s, int k) {
		if (s == null || s.length() == 0 || k == 0) {
			return 0;
		}
		int result = 0;
		int start = 0;
		char[] S = s.toCharArray();
		Map<Character, Integer> hash = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (hash.containsKey(S[i])) {
				hash.put(S[i], hash.get(S[i]) + 1);
			}
			else {
				hash.put(S[i], 1);
			}
			while (hash.size() > k) {
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
		LongestSubstringwithAtMostKDistinctCharacters result = new LongestSubstringwithAtMostKDistinctCharacters();
		System.out.println(result.longestSubstringwithAtMostKDistinctCharacter("eceba", 2));
	}

}
