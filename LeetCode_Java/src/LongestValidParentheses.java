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
	 * Method3: iterate from left to right and right to left
	 * In this approach, we make use of two counters left and right. First, we start traversing the 
	 * string from the left towards the right and for every ‘(’ encountered, we increment the left 
	 * counter and for every ‘)’ encountered, we increment the right counter. Whenever left becomes 
	 * equal to right, we calculate the length of the current valid string and keep track of maximum 
	 * length substring found so far. If right becomes greater than left we reset left and right to 0.
	 * Next, we start traversing the string from right to left and similar procedure is applied.
	 * @param String s
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int longestValidParenthesesII(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) res = Math.max(right * 2, res);
            else if (left < right) {
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {    // case: "(()"
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) res = Math.max(right * 2, res);
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        
        return res;		
	}
	
	/**
	 * Method2: DP: Using dp[] to save the longest length of valid parentheses which is end at i.
	 * If s[i]='(', have an open parentheses.
	 * If s[i]=')' and open > 0, can close a parentheses, dp[i]=dp[i-1]+2; and need to add dp[i-dp[i]].
	 * If s[i]=')' and open = 0, skip it.
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
		int n = s.length();
		char[] S = s.toCharArray();
		int[] dp = new int[s.length()];
		for (int i = 0; i < n; i++) {
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
	 * Method1: Stack: Using stack to save all invalid index of '(' or ')', then the left bound is 
	 * stack.peek().
	 * If s[i]==')' && s[stack.peek()]=='(', currLength = i - stack.peek().
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
		char[] S = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (S[i] == ')' && stack.size() > 1 && S[stack.peek()] == '(') {
				stack.pop();
				if (i - stack.peek() > result) result = i - stack.peek();
//				result = Math.max(i - stack.peek(), result);  // time limit exception
			}
			else {
				stack.push(i);
			}
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
//		System.out.println(result.longestValidParenthesesI(")()((()())"));
//		System.out.println(result.longestValidParenthesesI("())"));
//		System.out.println(result.longestValidParenthesesI("()(()"));
	}

}
