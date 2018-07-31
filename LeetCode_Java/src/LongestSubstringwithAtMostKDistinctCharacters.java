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
	 * Method2: Slide Window + char array
	 * @param String s, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringwithAtMostKDistinctCharacterI(String s, int k) {
		if (s == null || s.length() == 0 || k == 0) return 0;
		char[] S = s.toCharArray();
		int[] charCnt = new int[256];
		int res = 0;
		int cnt = 0;
		for (int start = 0, end = 0; start < S.length; start++) {
			while (end < S.length && (charCnt[S[end]] > 0 || cnt < k)) {
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
	 * Method1: Slide Window + HashMap: Like longestSubstringwithAtMostKDistinctCharacters
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
		System.out.println(result.longestSubstringwithAtMostKDistinctCharacterI("eceba", 2));
	}

}
