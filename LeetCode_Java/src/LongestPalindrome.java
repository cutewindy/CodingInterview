import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest 
 * palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * Example:
 * Input: "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * Tags: Hash Table
 * @author wendi
 *
 */
public class LongestPalindrome {
	
	/**
	 * Method2: set
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestPalindromeI(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		Set<Character> set = new HashSet<>();
		for (char c: s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
				result += 2;
			}
			else {
				set.add(c);
			}
		}
		return set.isEmpty() ? result : result + 1;
	}
	
	
	/**
	 * Method1: hash table
	 * @param String s
	 * @return int
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		Map<Character, Integer> hash = new HashMap<>();
		for (char c: s.toCharArray()) {
			if (hash.containsKey(c)) {
				hash.put(c, hash.get(c) + 1);
			}
			else {
				hash.put(c, 1);
			}
		}
		for (Character c: hash.keySet()) {
			if (hash.get(c) > 1) {
				result += hash.get(c) / 2 * 2;
			}
		}
		return result < s.length() ? result + 1 : result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome result = new LongestPalindrome();
		System.out.println(result.longestPalindrome("abccccddd"));
		System.out.println(result.longestPalindromeI("abccccddd"));
	}

}
