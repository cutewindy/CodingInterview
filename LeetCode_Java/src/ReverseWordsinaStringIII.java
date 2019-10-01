/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while 
 * still preserving whitespace and initial word order.
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space 
 * in the string.
 * @author wendi
 *
 */
public class ReverseWordsinaStringIII {
	
	/**
	 * 
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseWordsinaStringIII(String s) {
        if (s == null || s.length() == 0) return "";
        char[] S = s.toCharArray();
        for (int l = 0, r = 0; l < s.length();) {
            while (r < s.length() && s.charAt(r) != ' ') r++;
            reverse(S, l, r - 1);
            l = r + 1;
            r++;
        }
        return String.valueOf(S);
    }
    
    private void reverse(char[] S, int i, int j) {
        if (i == j) return;
        while (i < j) {
            swap(S, i++, j--);
        }
    }
    
    private void swap(char[] S, int i, int j) {
        char temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaStringIII result = new ReverseWordsinaStringIII();
		System.out.println(result.reverseWordsinaStringIII("Let's take LeetCode contest"));
	}

}
