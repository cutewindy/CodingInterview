
/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k 
 * characters counting from the start of the string. If there are less than k characters left, 
 * reverse all of them. If there are less than 2k but greater than or equal to k characters, then 
 * reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * 1. The string consists of lower English letters only.
 * 2. Length of the given string and k will in the range [1, 10000]
 * @author wendi
 *
 */
public class ReverseStringII {
	
	
	/**
	 * We will reverse each block of 2k characters directly.
	 * Each block starts at a multiple of 2k: for example, 0, 2k, 4k, 6k, .... One thing to be 
	 * careful about is we may not reverse each block if there aren't enough characters.
	 * To reverse a block of characters from i to j, we can swap characters in positions i++ and j--
	 * @param String s, int k
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseStringII(String s, int k) {
		if (s == null || s.length() == 0) return null;
		char[] S = s.toCharArray();
		for (int i = 0; i < S.length; i += 2 * k) {
			reverse(S, i, i + k - 1);
		}
		return new String(S);
	}
	 
	public void reverse(char[] S, int start, int end) {
		if (end >= S.length) end = S.length - 1;
		while (start < end) {
			char temp = S[start];
			S[start++] = S[end];
			S[end--] = temp;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStringII result = new ReverseStringII();
		System.out.println(result.reverseStringII("abcdefg", 2));
	}

}
