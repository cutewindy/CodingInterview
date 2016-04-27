import java.util.HashSet;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * @author wendi
 *
 */
public class ReverseVowelsofaString {
	
	/**
	 * Two pointers: use while loop to find the vowels from start and end of s, then change the values.
	 * @param s
	 * @return
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseVowelsofaString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String vowels = "aeiouAEIOU";
		char[] array = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (start < end && !vowels.contains(String.valueOf(array[start]))) {
				start++;
			}
			while (start < end && !vowels.contains(String.valueOf(array[end]))) {
				end--;
			}
			char c = array[start];
			array[start] = array[end];
			array[end] = c;
			start++;
			end--;
		}
		
		return String.valueOf(array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseVowelsofaString result = new ReverseVowelsofaString();
		System.out.println(result.reverseVowelsofaString("hello"));
	}

}
