import java.util.Stack;

/**
 * Given a string representing arbitrarily nested ternary expressions, calculate the result of the 
 * expression. You can always assume that the given expression is valid and only consists of digits 
 * 0-9, ?, :, T and F (T and F represent True and False respectively).
 * Note:
 * 1. The length of the given string is ≤ 10000.
 * 2. Each number will contain only one digit.
 * 3. The conditional expressions group right-to-left (as usual in most languages).
 * 4. The condition will always be either T or F. That is, the condition will never be a digit.
 * 5. The result of the expression will always evaluate to either a digit 0-9, T or F.
 * Example 1:
 * Input: "T?2:3"
 * Output: "2"
 * Explanation: If true, then result is 2; otherwise result is 3.
 * Example 2:
 * Input: "F?1:T?4:5"
 * Output: "4"
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is 
 * read/evaluated as:
             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"
 * Example 3:
 * Input: "T?T?F:5:3"
 * Output: "F"
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is 
 * read/evaluated as:
             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"
 * @author wendi
 *
 */
public class TernaryExpressionParser {
	
	
	/**
	 * Stack: Iterate the expression from tail, whenever encounter a character before '?', calculate 
	 * the right value and push back to stack.
	 * P.S. this code is guaranteed only if "the given expression is valid" base on the requirement.
	 * @param String expression
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String ternaryExpressionParser(String expression) {
		if (expression == null || expression.length() == 0) return "";
		Stack<Character> stack = new Stack<>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);
			if (!stack.isEmpty() && stack.peek() == '?') {
				stack.pop(); //pop '?'
				char first = stack.pop();
				stack.pop(); //pop ':'
				char second = stack.pop();
				if (c == 'T') stack.push(first);
				else stack.push(second);
			}
			else stack.push(c);
		}
		return stack.pop().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TernaryExpressionParser result = new TernaryExpressionParser();
		System.out.println(result.ternaryExpressionParser("T?T?F:5:3"));
	}

}
