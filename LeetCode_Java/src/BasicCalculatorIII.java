import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
 * non-negative integers and empty spaces .
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and 
 * closing parentheses ) and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the 
 * range of [-2147483648, 2147483647].
 * Some examples:
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * Note: Do not use the eval built-in library function.
 * @author wendi
 *
 */
public class BasicCalculatorIII {
	
	/**
	 * Stack
	 * 这道题是基本计算器系列的第三道，前两道分别为Basic Calculator和Basic Calculator II，区别是，第一道只有加减法
	 * 跟括号，第二道只有加减乘除法，而这第三道既有加减乘除法又有括号运算。其实做过前两道题的话，那么这道题也就没什么问题，
	 * 因为把前两道题的解法综合一下就是这道题的解法啦。由于此题既有括号，又有乘除法，我们知道括号是优先级最高的，但是好就好在
	 * 我们可以将括号里的内容当作一个整体调用递归函数来处理。这里就有一个小trick，由于表示可能会有括号嵌套括号，所以我们如果
	 * 搜索右括号的话，就有可能使得括号没有正确的匹配上，所以我们用一个变量cnt，遇到左括号自增1，遇到右括号自减1，当cnt为0
	 * 的时候，说明括号正好完全匹配，这个trick在验证括号是否valid的时候经常使用到。然后我们就是根据左右括号的位置提取出中
	 * 间的子字符串调用递归函数，返回值赋给num。
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int basicCalculatiorIII(String s) {
		if (s == null || s.length() == 0) return 0;
		char[] S = s.toCharArray();
		int num = 0;
		char op = '+';
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i <= S.length; i++) {
			
			// get num
			if (i != S.length && Character.isDigit(S[i])) {
				while (i < S.length && Character.isDigit(S[i])) {
					num = num * 10 + S[i++] - '0';
				}
			}
			else if (i != S.length && S[i] == '(') {
				int cnt = 0;
				int start = i + 1;
				for (; i < S.length; i++) {
					if (S[i] == '(') cnt++;
					if (S[i] == ')') cnt--;
					if (cnt == 0) {
						num = basicCalculatiorIII(s.substring(start, i));
						break;
					}
				}
			} 
			
			char c = i == S.length ? '}' : S[i];
			if (c == ' ') continue;
			
			// do the last operation
			if (op == '+') stack.push(num);
			if (op == '-') stack.push(-1 * num);
			if (op == '*') stack.push(stack.pop() * num);
			if (op == '/') stack.push(stack.pop() / num);
			op = c;
			num = 0;
		}
		
		int res = 0;
		while (!stack.isEmpty()) res += stack.pop();
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculatorIII result = new BasicCalculatorIII();
		System.out.println(result.basicCalculatiorIII("(2+6* 3+5- (3*14/7+2)*5)+3"));
	}

}
