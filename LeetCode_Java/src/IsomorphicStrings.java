import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 * 
 * Tags: HashTable
 * @author wendi
 *
 */
public class IsomorphicStrings {

	/**
	 * Method2: Array, like method 1, using two arrays instead of hashmap to record the corresponding 
	 * char pairs in s[t] and t[s].   
	 * @param String s, String t
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean isomorphicStringsI(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		if (s == null || s.length() == 0) {
			return true;
		}
		char[] array1 = new char[256];
		char[] array2 = new char[256];
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			// check value, which index coming from s
			if (array1[cs] == 0) {  // using 0 instead of '0' to chech whether cell is empty
				array1[cs] = ct;
			}
			else if (array1[cs] != ct) {
				return false;
			}
			// check value, which index coming from t
			if (array2[ct] == 0) {
				array2[ct] = cs;
			}
			else if (array2[ct] != cs) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method1: HashMap, Using two hashmap to record the (key, value) pair.
	 * One is <s, t>, the other is <t, s>.
	 * @param String s, String t
	 * @return boolean
	 * Time: O(n) n is the length of String s
	 * Space: O(1)
	 */
	public boolean isomorphicStrings(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		if (s == null || s.length() == 0) {
			return true;
		}
		Map<Character, Character> hash1 = new HashMap<>();
		Map<Character, Character> hash2 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			// check hash1, which char from s is the key
			if (!hash1.containsKey(cs)) {
				hash1.put(cs, ct);
			}
			else if (hash1.get(cs) != ct) {
				return false;
			}
			// check hash2, which char from t is the key
			if (!hash2.containsKey(ct)) {
				hash2.put(ct, cs);
			}
			else if (hash2.get(ct) != cs) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsomorphicStrings result = new IsomorphicStrings();
		System.out.println(result.isomorphicStrings("ab", "aa"));
		System.out.println(result.isomorphicStrings("ab", "ca"));
		System.out.println(result.isomorphicStringsI("ab", "aa"));
		System.out.println(result.isomorphicStringsI("ab", "ca"));
	}

}
