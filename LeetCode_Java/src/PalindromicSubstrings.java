/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings 
 * even they consist of same characters.
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note:
 * The input string length won't exceed 1000.
 * @author wendi
 *
 */
public class PalindromicSubstrings {

	/**
	 * Brute force
	 * @param String s
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int palindromicSubstrings(String s) {
		if (s == null || s.length() == 0) return 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindrom(s, i, j)) res++;
			}
		}
		return res;	
	}
	
	public boolean isPalindrom(String s, int i, int j) {
		if (i == j) return true;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromicSubstrings result = new PalindromicSubstrings();
		System.out.println(result.palindromicSubstrings("aaa"));
	}

}
