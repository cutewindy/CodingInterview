import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
 * non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 * 
 * Tags: Stack, Math
 * @author wendi
 *
 */
public class BasicCalculator {
	class Pair{
		int result;
		int sign;
		public Pair(int res, int sign) {
			this.result = res;
			this.sign = sign;
		}
	}
	
	/**
	 * Stack: using sign to record the last operator is '+'/'-'. 
	 * If curr char is '+'/'-', then add num to result and update operator by curr char. 
	 * If curr char is '(', push curr result and sign into stack, init sign. 
	 * If curr char is ')', pop original result from stack and add to curr result.
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int basicCalculator(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int num = 0;
		int result = 0;
		int sign = 1;
		Stack<Pair> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (int) (c - '0');
			}
			else if (c == '+') {
				result += sign * num;
				sign = 1;
				num = 0;
			}
			else if (c == '-') {
				result += sign * num;
				sign = -1;
				num = 0;
			}
			else if (c == '(') {
				stack.push(new Pair(result, sign));
				result = 0;
				sign = 1;
			}
			else if (c == ')') {
				result += sign * num;
				sign = 1;
				num = 0;
				Pair pair = stack.pop();
				result = pair.result + pair.sign * result;
			}
		}
		if (num != 0) {  // don't forget last num if there is no ')' at the end of s
			result += sign * num;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculator result = new BasicCalculator();
		System.out.println(result.basicCalculator("2-1+2"));
		System.out.println(result.basicCalculator("(1-(4+5-2)-3)+(6+8)"));
	}

}
