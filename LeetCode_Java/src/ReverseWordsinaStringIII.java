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
		if (s == null || s.length() == 0) {return s;}
		StringBuilder result = new StringBuilder();
		String[] str = s.split(" ");
		for (String word: str) {
			result.append(reverseWord(word)).append(" ");
		}
		return result.toString().trim();
	}
	
	public String reverseWord(String word) {
		if (word == null || word.length() == 0) {return word;}
		char[] array = word.toCharArray();
		int left = 0;
		int right = word.length() - 1;
		while (left < right) {
			char c = array[left];;
			array[left] = array[right];
			array[right] = c;
			left++;
			right--;
		}
		return new String(array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaStringIII result = new ReverseWordsinaStringIII();
		System.out.println(result.reverseWordsinaStringIII("Let's take LeetCode contest"));
	}

}
