import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of 
 * non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated 
 * by a single space.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 * 
 * Tags: String
 * @author wendi
 *
 */
public class ReverseWordsinaStringII {
	
	/**
	 * Two steps to reverse
    // 1 reverse the whole sentence
     * 2 reverse each word
	 * @param char[] s
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void reverseWordsinaStringII(char[] s) {
		if (s == null || s.length <= 1) {
			return;
		}
		reverse(s, 0, s.length - 1);
		int start = 0;
		for (int i = 0; i <= s.length; i++) {
			if (i == s.length || s[i] == ' ') {   // don't forget the last word
				reverse(s, start, i - 1);
				start = i + 1;
			}
		}
		return;
	}

	private void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaStringII result = new ReverseWordsinaStringII();
		char[] s = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
		result.reverseWordsinaStringII(s);
		System.out.println(Arrays.toString(s));
	}

}
