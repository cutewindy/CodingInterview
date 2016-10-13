/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,  
 * Given s = "Hello World",
 * return 5.
 * @author wendi
 *
 */
public class LengthofLastWord {
	
	/**
	 * From the end to start. Using trim to remove ' ' behind last word.
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int lengthofLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		char[] S = s.trim().toCharArray();
		for (int i = S.length - 1; i >= 0 && S[i] != ' '; i--) {
			result++;
		}		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthofLastWord result = new LengthofLastWord();
		System.out.println(result.lengthofLastWord("Hello world  "));
		System.out.println(result.lengthofLastWord(" "));
	}

}
