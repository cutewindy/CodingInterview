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
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
		    while (l < r && !set.contains(S[l])) l++;
		    while (l < r && !set.contains(S[r])) r--;
		    if (l < r) swap(S, l++, r--);  
		}
//		return String.valueOf(S);
		return new String(S);
	}
	
	public void swap(char[] S, int l, int r) {
		char temp = S[l];
		S[l] = S[r];
		S[r] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseVowelsofaString result = new ReverseVowelsofaString();
		System.out.println(result.reverseVowelsofaString("leetcode"));
	}

}
