/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * @author wendi
 *
 */

public class LongestPalindromicSubstring {
	
	/**
	 * Method2: 
	 * 1. char i has two case (i,i) and (i,i+1) as center that has palindrome. 
	 * 2. work in the function (i, j). i move to left, j move to right.
	 *    find and return the longest palindrome, which use (i,i) or (i,i+1) as center.
	 * 3. chose the longest one as maxLength, and refresh result
	 * @param String s
	 * @return String
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public String longestPalindromicSubstringI(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String result = new String();
		int start = 0;
		int end = 0;
		int maxLeng = 1;
//		result = Character.toString(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			int len1 = findLongestPalindromicSubstring(s, i, i);
			int len2 = findLongestPalindromicSubstring(s, i, i + 1);
			maxLeng = Math.max(len1, len2);
			if (maxLeng > end - start + 1) {
				start = i - (maxLeng - 1) / 2;
				end = i + maxLeng / 2;			
			}			
		}
		result = s.substring(start, end + 1);
		return result;
	}
	
	public int findLongestPalindromicSubstring(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}		
		return j - i + 1 - 2;
	}
	
	
	
	/**
	 * Method1: Brute force(Time Limit Exceeded)
	 * @param String s
	 * @return String
	 * Time: O(n^3)
	 * Space: O(1)
	 */	
	public String longestPalindromicSubstring(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String result = new String();
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindrome(i, j, s)) {
					if (length < j - i + 1) {
						length = j - i + 1;
						result = s.substring(i, j + 1);
					}
				}
			}
		}
		return result;
	}
	
	public boolean isPalindrome(int start, int end, String s) {
		if (start == end) {
			return true;
		}
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring result = new LongestPalindromicSubstring();
		System.out.println(result.longestPalindromicSubstring("characcar"));
		System.out.println(result.longestPalindromicSubstringI("characcar"));
	}

}
