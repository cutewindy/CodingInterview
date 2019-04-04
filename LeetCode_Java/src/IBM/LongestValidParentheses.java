package IBM;

import java.util.Stack;

/**
 * 最长valid括号串。  给一个字符串，找出其中最长的合法子串。 比如 “( )(()”, return 2. "()()))((()))()" return 8.  
 * 一开始想了一个思路，不对，然后又换了一个，前后大概花了15分钟吧，断断续续写了几行代码，就被打断了说思路差不多，move on下一题。
 * @author wendi
 *
 */
public class LongestValidParentheses {
	
	/**
	 * Two pass one from start to end, one from end to start
	 * "(()", "())"
	 * @param str
	 * @return
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int longestValidParenthesesI(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int open = 0;
        int curr = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')' && open > 0) {
                curr += 2;
                open--;
                if (open == 0) res = Math.max(curr, res);
            }
            else {
                curr = 0;
                open = 0;
            }
        }
        
        curr = 0;
        open = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') open++;
            else if (s.charAt(i) == '(' && open > 0) {
                curr += 2;
                open--;
                if (open == 0) res = Math.max(curr, res);
            }
            else {
                curr = 0;
                open = 0;
            }
        }
        return res;
		
	}
	
	/**
	 * Stack 
	 * @param str
	 * @return
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestValidParentheses(String str) {
		if (str == null || str.length() == 0) return 0;
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')' && stack.size() > 1 && str.charAt(stack.peek()) == '(') {
				stack.pop();
				res = Math.max(i - stack.peek(), res);
			} 
			else {
				stack.push(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses result = new LongestValidParentheses();
		System.out.println(result.longestValidParentheses("()(()"));
		System.out.println(result.longestValidParentheses("())"));
		System.out.println(result.longestValidParenthesesI("()(()"));
		System.out.println(result.longestValidParenthesesI("())"));

	}

}
