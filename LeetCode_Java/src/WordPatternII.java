import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a 
 * non-empty substring in str.
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 * @author wendi
 *
 */
public class WordPatternII {
	
	/**
	 * Backtracking: just have to keep trying to use a character in the pattern to match different 
	 * length of substrings in the input string, keep trying till we go through the input string and 
	 * the pattern.
	 * For example, input string is "redblueredblue", and the pattern is "abab", first let’s use 'a' 
	 * to match "r", 'b' to match "e", then we find that 'a' does not match "d", so we do 
	 * backtracking, use 'b' to match "ed", so on and so forth …
	 * When we do the recursion, if the pattern character exists in the hash map already, we just 
	 * have to see if we can use it to match the same length of the string.
	 * @param String pattern, String str
	 * @return boolean
	 * Time: O(n^k) n is the length of str, k is the length of pattern
	 * Space: O(?)
	 */
	public boolean wordPatternII(String pattern, String str) {
		if (pattern == null && str == null || pattern.length() == 0 && str.length() == 0) return true;
		if (pattern  == null || str == null || pattern.length() == 0 || str.length() == 0) return false;
		char[] P = pattern.toCharArray();
		Map<Character, String> map = new HashMap<>();
		Set<String> seen = new HashSet<>();
		return helper(P, str, 0, 0, map, seen);
	}
	
	public boolean helper(char[] P, String str, int start, int pos, 
			Map<Character, String> map, Set<String> seen) {
		if (pos == P.length && start == str.length()) return true;
		if (pos >= P.length || start >= str.length()) return false;
		// case1: if pattern character exists in map
		if (map.containsKey(P[pos])) {
			String s = map.get(P[pos]);
			if (start + s.length() <= str.length() //check if we can use it to match str[i...i+s.length()]
			 && s.equals(str.substring(start, start + s.length()))) {
				return helper(P, str, start + s.length(), pos + 1, map, seen);
			}
			else return false;
		}
		// case2: pattern character doesn't exist in map
		for (int end = start; end < str.length(); end++) {
			String s = str.substring(start, end + 1);
			if (seen.contains(s)) continue;
			map.put(P[pos], s);
			seen.add(s);
			if (helper(P, str, end + 1, pos + 1, map, seen)) return true; // continue to match the rest
			map.remove(P[pos]);
			seen.remove(s);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPatternII result = new WordPatternII();
		System.out.println(result.wordPatternII("abab", "redblueredblue"));
		System.out.println(result.wordPatternII("aabb", "xyzabcxzyabc"));
	}

}
