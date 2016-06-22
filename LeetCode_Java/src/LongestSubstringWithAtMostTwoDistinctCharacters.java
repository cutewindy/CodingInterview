import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, given s = "eceba",
 * T is "ece" which its length is  3.
 * 
 * Tags: hashTable, Two pointers, String
 * @author wendi
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	/**
	 * Two pointers: Slide window
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestSubstringWithAtMostTwoDistinctCharacters(String s) { 
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = Integer.MIN_VALUE;
		int head = 0;
		Map<Character, Integer> hash = new HashMap();		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hash.containsKey(c)) {
				hash.put(c, hash.get(c) + 1);
			}
			else {
				hash.put(c, 1);
			}
			while (hash.size() > 2) {
				hash.put(s.charAt(head), hash.get(s.charAt(head)) - 1);
				if (hash.get(s.charAt(head)) == 0) {
					hash.remove(s.charAt(head));
				}
				head++;
			}
			result = Math.max(i - head + 1, result);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithAtMostTwoDistinctCharacters result = new LongestSubstringWithAtMostTwoDistinctCharacters();
		System.out.println(result.longestSubstringWithAtMostTwoDistinctCharacters("eceba"));

	}

}
