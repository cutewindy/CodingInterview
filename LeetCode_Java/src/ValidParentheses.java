import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input 
 * string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Subscribe to see which companies asked this question
 * @author wendi
 *
 */
public class ValidParentheses {
	
	/**
	 * Stack.
	 * if s[i]=='(' or '[' or '{', push it in the stack.
	 * if s[i]==')' or ']' or '}', pop from stack, if they don't match, return false.
	 * remember check s.isEmpty() at begin and end.
	 * @param String s
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean validParentheses(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}
			else {
				if (stack.isEmpty()) return false;
				char match = stack.pop();
				if (c == ')' && match != '(' || c == ']' && match != '[' || c == '}' && match != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses result = new ValidParentheses();
		System.out.println(result.validParentheses("()"));
		System.out.println(result.validParentheses("()[]{}"));
		System.out.println(result.validParentheses("(]"));
		System.out.println(result.validParentheses("([)]"));
		System.out.println(result.validParentheses("]"));
		System.out.println(result.validParentheses("("));
	}

}
