import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseVowelsofaString(String s) {
        if (s == null || s.length() == 0) return s;
        char[] S = s.toCharArray();
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
//		set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
		    while (start < end && !set.contains(S[start])) start++;
		    while (start < end && !set.contains(S[end])) end--;
		    if (start >= end) break;  // take care
		    char temp = S[start];
		    S[start] = S[end];
		    S[end] = temp;
		    start++;
		    end--;
		}
		return String.valueOf(S);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseVowelsofaString result = new ReverseVowelsofaString();
		System.out.println(result.reverseVowelsofaString("leetcode"));
	}

}
