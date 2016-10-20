/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't 
 * exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class FirstUniqueCharacterinaString {
	
	/**
	 * Using char array
	 * @param Strings
	 * @return int
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int firstUniqueCharacterinaString(String s) { 
		if (s == null || s.length() == 0) {
			return -1;
		}
		char[] array = new char[26];
		char[] S = s.toCharArray();
 		for (char c: S) {
			array[c - 'a']++;
		}
		for (int i = 0; i < S.length; i++) {
			if (array[S[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstUniqueCharacterinaString result = new FirstUniqueCharacterinaString();
		System.out.println(result.firstUniqueCharacterinaString("loveleetcode"));
	}

}
