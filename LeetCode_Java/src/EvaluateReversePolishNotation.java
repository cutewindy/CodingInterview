import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * Tags: Stack
 * @author wendi
 *
 */
public class EvaluateReversePolishNotation {

	/**
	 * Stack: add every token as an integer in stack, unless it's an operation.
     * If it's operation, pop two elements from the stack and then save the result back to it. 
     * After all operations are done through, the remaining element in the stack will be the result.
	 * @param String[] tokens
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int evalusteReversePolishNotation(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		for (String token: tokens) {
			if (token.equals("+")) {  // be care cannot use ==
				stack.push(stack.pop() + stack.pop());
			}
			else if (token.equals("-")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
			}
			else if (token.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			}
			else if (token.equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
			}
			else {
				stack.push(Integer.valueOf(token));
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvaluateReversePolishNotation result = new EvaluateReversePolishNotation();
		System.out.println(result.evalusteReversePolishNotation(new String[] {"2", "1", "+", "3", "*"}));
		System.out.println(result.evalusteReversePolishNotation(new String[] {"4", "13", "5", "/", "+"}));
		System.out.println(result.evalusteReversePolishNotation(new String[] {"0", "3", "/"}));
	}

}
