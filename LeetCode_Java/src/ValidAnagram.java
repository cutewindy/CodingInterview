import java.util.HashMap;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author wendi
 *
 */
public class ValidAnagram {
	/**
	 * use HashMap to record the frequency of each char in s,
	 * check whether hash contains the char of t, and the hash value of that char > 0
	 * @param String s
	 * @param String t
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean validAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (hash.containsKey(s.charAt(i))) {
				hash.put(s.charAt(i), hash.get(s.charAt(i)) + 1);
			}
			else {
				hash.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < t.length(); i++) {
			if (!hash.containsKey(t.charAt(i)) || hash.get(t.charAt(i)) == 0) {
				return false;
			}
			hash.put(t.charAt(i), hash.get(t.charAt(i)) + 1);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidAnagram result = new ValidAnagram();
		System.out.println(result.validAnagram("taa", "ate"));

	}

}
