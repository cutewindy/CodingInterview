import java.util.Arrays;

/**
 * Given an input string , reverse the string word by word. 
 * Example:
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Note: 
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
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
	public void reverseWordsinaStringII(char[] str) {
        if (str == null || str.length == 0) return;
        int n = str.length;
        reverse(str, 0, n - 1);
        for (int start = 0, end = 0; start < n;) {
            while (end < n && str[end] != ' ') {
                end++;
            }
            reverse(str, start, end - 1);
            start = end + 1;
            end = start;
        }
	}

	private void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaStringII result = new ReverseWordsinaStringII();
		char[] str = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
		result.reverseWordsinaStringII(str);
		System.out.println(Arrays.toString(str));
	}

}
