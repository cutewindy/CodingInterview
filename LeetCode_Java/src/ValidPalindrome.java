/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * @author wendi
 *
 */
public class ValidPalindrome {
	
	/**
	 * Two pointers: check char one by one, if not equal, return false
	 * @param s
	 * @return
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean validPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
				start++;
			}
			while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			}
			char a = Character.toLowerCase(s.charAt(start));
			char b = Character.toLowerCase(s.charAt(end));
			if (a != b) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome result = new ValidPalindrome();
		System.out.println(result.validPalindrome("A man, a plan, a canal: Panama"));
	}

}
