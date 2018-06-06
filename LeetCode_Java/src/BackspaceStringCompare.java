import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. 
 * # means a backspace character.
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * @author wendi
 *
 */
public class BackspaceStringCompare {
	
	/**
	 * Method2: Tow Pointers
	 * @param String S, String T
	 * @return boolean
	 * Time: O(m + n)
	 * Space: O(m + n)
	 */
	public boolean backspaceStringCompareI(String S, String T) {
		if (S == null && T == null) return true;
		if (S == null || T == null) return false;
		return true;
	}
	
	
	/**
	 * Method1: Stack
	 * @param String S, String T
	 * @return boolean
	 * Time: O(m + n)
	 * Space: O(m + n)
	 */
	public boolean backspaceStringCompare(String S, String T) {
		if (S == null && T == null) return true;
		if (S == null || T == null) return false;
		return build(S).equals(build(T));
	}

	private String build(String S) {
		Stack<Character> stack = new Stack<>();
		for (char c: S.toCharArray()) {
			if (c != '#') stack.push(c);
			else if (!stack.isEmpty()) stack.pop();
		}
		return String.valueOf(stack);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackspaceStringCompare result = new BackspaceStringCompare();
		System.out.println(result.backspaceStringCompare("a##c", "#a#c"));
		System.out.println(result.backspaceStringCompareI("a##c", "#a#c"));
	}

}
