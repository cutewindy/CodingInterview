import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to 
 * create another string.  Return a list of all possible strings we could create.
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * S will be a string with length at most 12.
 * S will consist only of letters or digits.
 * @author wendi
 *
 */
public class LetterCasePermutation {
	
	/**
	 * Backtraking: 
	 * @param String s
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		if (S == null) return result;
		char[] s = S.toCharArray();
		helper(s, 0, result);
		return result;
	}
	
	public void helper(char[] s, int pos, List<String> result) {
		if (pos == s.length) {
			result.add(new String(s));
			return;
		}
		if (Character.isDigit(s[pos])) {
			helper(s, pos + 1, result);
			return;
		}
		s[pos] = Character.toLowerCase(s[pos]);
		helper(s, pos + 1, result);
		s[pos] = Character.toUpperCase(s[pos]);
		helper(s, pos + 1, result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCasePermutation result = new LetterCasePermutation();
		System.out.println(result.letterCasePermutation("a1b2"));
	}

}
