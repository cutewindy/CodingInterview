package IBM;
/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 * @author wendi
 *
 */
public class FirstUniqueCharinaString {
	
	
	/**
	 * int array
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int firstUniqueCharinaString(String s) {
        int[] cnts = new int[26];
        for (char c: s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cnts[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
