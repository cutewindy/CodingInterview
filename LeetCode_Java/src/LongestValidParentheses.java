import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid 
 * (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has 
 * length = 4.
 * 
 * Tags: DP, String
 * @author wendi
 *
 */
public class LongestValidParentheses {

	/**
	 * Method2: DP: Using dp[] to save the longest length of valid parentheses which is end at i.
	 * If s[i]='(', have an open parentheses.
	 * If s[i]=')', can close a parentheses, dp[i]=dp[i-1]+2; and need to add dp[i-dp[i]].
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestValidParenthesesI(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		int open = 0;
		char[] S = s.toCharArray();
		int[] dp = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);    // time limited expected 
			if (S[i] == '(') open++;
			if (S[i] == ')' && open > 0) {
				dp[i] = dp[i - 1] + 2;
				if (i - dp[i] > 0) {
					dp[i] += dp[i - dp[i]];
				}
				open--;
			}
//			result = Math.max(dp[i], result);  // time limited expected
			if (dp[i] > result) result = dp[i];
		}
		return result;
	}
	
	/**
	 * Method1: Stack:
	 * @param String s
	 * @return int
	 * Time:O(n)
	 * Space: O(n)
	 */
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		int curr = 0;
		char[] S = s.toCharArray();
		boolean content = true;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (S[i] == '(') {
				stack.push(i);
				content = true;
			}
			else if (S[i] == ')' && !stack.isEmpty()) {
				if (content) curr += i - stack.pop() + 1;
				else curr = i - stack.pop() + 1;
			}
			else {
				content = false;
				curr = 0;
			}
			if (curr > result) result = curr;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses result = new LongestValidParentheses();
		System.out.println(result.longestValidParentheses(")()((()())"));
		System.out.println(result.longestValidParentheses("())"));
		System.out.println(result.longestValidParentheses("()(()"));
		System.out.println(result.longestValidParentheses("()()"));
		System.out.println(result.longestValidParenthesesI(")()((()())"));
		System.out.println(result.longestValidParenthesesI("())"));
		System.out.println(result.longestValidParenthesesI("()(()"));
	}

}
