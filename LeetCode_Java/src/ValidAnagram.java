import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 * Tags: HashTable, Sort
 * @author wendi
 *
 */
public class ValidAnagram {
	
	/**
	 * Method2: Using array instead of hash to save the frequency of each char
	 * @param String s, String t
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean validAnagramI(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		if (s == null || t == null) {
			return true;
		}
		int[] array = new int[26];
		for (char c: s.toCharArray()) {
			array[c - 'a']++;
		}
		for (char c: t.toCharArray()) {
			if (--array[c - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method1: use HashMap to record the frequency of each char in s,
	 * check whether hash contains the char of t, and the hash value of that char > 0
	 * @param String s, String t
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean validAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		if (s == null || t == null) {
			return true;
		}
		Map<Character, Integer> hash = new HashMap<>();
		for (char c: s.toCharArray()) {
			if (hash.containsKey(c)) {
				hash.put(c, hash.get(c) + 1);
			}
			else {
				hash.put(c, 1);
			}
		}
		for (char c: t.toCharArray()) {
			if (!hash.containsKey(c) || hash.get(c) - 1 < 0) {
				return false;
			}
			hash.put(c, hash.get(c) - 1);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidAnagram result = new ValidAnagram();
		System.out.println(result.validAnagram("taa", "ate"));
		System.out.println(result.validAnagramI("taa", "ate"));
	}

}
