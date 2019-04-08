/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid 
 * parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and 
 * "(()(()))" are all valid parentheses strings.
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to 
 * split it into S = A+B, with A and B nonempty valid parentheses strings.
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + 
 * P_k, where P_i are primitive valid parentheses strings.
 * Return S after removing the outermost parentheses of every primitive string in the primitive 
 * decomposition of S.
 * Example 1:
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation: 
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation: 
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 * Input: "()()"
 * Output: ""
 * Explanation: 
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * Note:
 * 1. S.length <= 10000
 * 2. S[i] is "(" or ")"
 * 3. S is a valid parentheses string
 * @author wendi
 *
 */
public class RemoveOutermostParentheses {
	
	
	/**
	 * count open variable
	 * @param String S
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String removeOutermostParentheses(String S) {
		StringBuilder sb = new StringBuilder();
		int open = 0;
		for (char c: S.toCharArray()) {
			if (c == '(' && open++ > 0) sb.append(c);
			if (c == ')' && --open > 0) sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveOutermostParentheses result = new RemoveOutermostParentheses();
		System.out.println(result.removeOutermostParentheses("(()())(())(()(()))"));
	}

}
