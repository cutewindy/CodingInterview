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
	 * Method3: Two pointer
	 * @param String S, String T
	 * @return boolean
	 * Time: O(m + n)
	 * Space: O(1)
	 */
	public boolean backspaceStringCompareII(String S, String T) {
		int i = S.length() - 1;
		int j = T.length() - 1;
		int skipS = 0;
		int skipT = 0;
		while (i >= 0 || j >= 0) {
			while (i >= 0 && (S.charAt(i) == '#' || skipS > 0)) {
				if (S.charAt(i) == '#') skipS++;
				else skipS--;
				i--;
			}
			while (j >= 0 && (T.charAt(j) == '#' || skipT > 0)) {
				if (T.charAt(j) == '#') skipT++;
				else skipT--;
				j--;
			}
			if (i < 0 || j < 0) return i == j;
			if (S.charAt(i--) != T.charAt(j--)) return false;
		}
		return i == j;
	}
	
	/**
	 * Method2: Get original two string using Stringbuilder then compare 
	 * @param String S, String T
	 * @return boolean
	 * Time: O(m + n)
	 * Space: O(1)
	 */
	public boolean backspaceStringCompareI(String S, String T) {
		if (S == null && T == null) return true;
		if (S == null || T == null) return false;
		return getStr(S).equals(getStr(T));
	}
	
	private String getStr(String str) {
		int i = str.length() - 1;
		int skip = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0) {
			while (i >= 0 && (str.charAt(i) == '#' || skip > 0)) {
				skip = str.charAt(i) == '#' ? skip + 1 : skip - 1;
				i--;
			}
			if (i >= 0) sb.append(str.charAt(i--));
		}
		return sb.reverse().toString();
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
		System.out.println(result.backspaceStringCompare("nzp#o#g", "b#nzp#o#g"));
		System.out.println(result.backspaceStringCompare("bxj##tw", "bxj###tw"));
		System.out.println(result.backspaceStringCompareI("nzp#o#g", "b#nzp#o#g"));
		System.out.println(result.backspaceStringCompareI("bxj##tw", "bxj###tw"));
		System.out.println(result.backspaceStringCompareII("nzp#o#g", "b#nzp#o#g"));
		System.out.println(result.backspaceStringCompareII("bxj##tw", "bxj###tw"));
	}

}
