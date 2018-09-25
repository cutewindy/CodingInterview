/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a 
 * palindrome.
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * @author wendi
 *
 */
public class ValidPalindromeII {
	
	/**
	 * Method2: Greedy
	 * @param String s
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean validPalindromeIII(String s) {
		char[] S = s.toCharArray();
		int n = S.length;
		int left = 0, right = n - 1;
		while (left < right) {
			if (S[left] != S[right]) {
				return isPalindrome(S, left + 1, right) || isPalindrome(S, left, right - 1);
			}
			left++;
			right--;
		}
		return true;
	}
	
	private boolean isPalindrome(char[] S, int left, int right) {
		while (left < right) {
			if (S[left++] != S[right--]) return false;
		}
		return true;
	}
	
	
	/**
	 * Method1: Recursion
	 * @param String s
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public boolean validPalindromeII(String s) {
		char[] S = s.toCharArray();
		return helper(S, 0, S.length - 1, false);
	}
	
	public boolean helper(char[] S, int left, int right, boolean hasDelete) {
		if (left >= right) return true;
		if (S[left] != S[right]) {
			if (hasDelete) return false;
			return helper(S, left + 1, right, true) || helper(S, left, right - 1, true);
		}
		
		return helper(S, left + 1, right - 1, hasDelete);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindromeII result = new ValidPalindromeII();
		System.out.println(result.validPalindromeII("cbbcc"));
		System.out.println(result.validPalindromeIII("cbbcc"));
	}

}
