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
	
	
	/** 
	 * Update on 9/25/2019
	 * @param s
	 * @return
	 */
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stackNum = new Stack<>();
        Stack<Integer> stackSign = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (Character.isDigit(s.charAt(i))) {
                num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
            if (i >= s.length()) break;
            if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            else if (s.charAt(i) == '(') {
                stackNum.push(res);
                stackSign.push(sign);
                res = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                res = stackNum.pop() + stackSign.pop() * res;
            }
        }
        return res;
    }	
	
	
	
	
	
	class Pair{
		int result;
		int sign;
		public Pair(int res, int sign) {
			this.result = res;
			this.sign = sign;
		}
	}
	
	/**
	 * Method2: Stack: do curr operation when get num 
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int basicCalculatorI(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}		
		int result = 0;
		int num = 0;
		int sign = 1;
		Stack<Pair> stack = new Stack<>();
		char[] S = s.toCharArray();
		for (int i = 0; i < S.length; i++) {
			num = 0;
			while (i < S.length && Character.isDigit(S[i])) {
				num = num * 10 + S[i] - '0';
				i++;
			}
			result += sign * num;
			
			if (i == S.length) {   // if num is last number in string
				break;
			}
			if (S[i] == '+') {
				sign = 1;
			}
			else if (S[i] == '-') {
				sign = -1;
			}
			else if (S[i] == '(') {
				stack.push(new Pair(result, sign));
				result = 0;
				sign = 1;
			}
			else if (S[i] == ')') {
				Pair pair = stack.pop();
				result = pair.result + pair.sign * result;
			}
		}
		return result;
	}
		
	
	/**
	 * Method1: Do last operation when get operator
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
		for (char c: s.toCharArray()) {
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
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
				Pair pair = stack.pop();
				result = pair.result + pair.sign * result;
				sign = 1;
				num = 0;
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
		System.out.println(result.basicCalculatorI("2-1+2"));
		System.out.println(result.basicCalculatorI("(1-(4+5-2)-3)+(6+8)"));
	}

}
