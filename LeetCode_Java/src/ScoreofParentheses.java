import java.util.Stack;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * Example 1:
 * Input: "()"
 * Output: 1
 * Example 2:
 * Input: "(())"
 * Output: 2
 * Example 3:
 * Input: "()()"
 * Output: 2
 * Example 4:
 * Input: "(()(()))"
 * Output: 6
 * Note:
 * 1. S is a balanced parentheses string, containing only ( and ).
 * 2. 2 <= S.length <= 50
 * @author wendi
 *
 */
public class ScoreofParentheses {
	
	
	/**
	 * Approach2: Count layers and add score when meet "()"
	 * @param String S
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int scoreofParenthesesI(String S) {
        if (S == null || S.length() == 0) return 0;
        int layer = 0;
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
        	if (S.charAt(i) == '(') layer++;
        	else layer--;
        	if (S.charAt(i) == '(' && S.charAt(i + 1) == ')') {
        		res += 1 << (layer - 1);
        	}
        }
        return res;
    }
	
	/**
	 * Approach1: Stack
	 * 1. if c = '(', push 0 into stack to mark it as '('
	 * 2. else,
	 *    2.1 if stack.peek() is 0 means the previous char is '(', push 1 into stack
	 *    2.2 else the previous string has "()", add all the previous res to current res, then push
	 *        it into stack multiply by 2. 
	 * @param String S
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int scoreofParentheses(String S) {
        if (S == null || S.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char c: S.toCharArray()) {
            if (c == '(') stack.push(0);
            else {
                if (stack.peek() == 0) {
                    stack.pop();
                    stack.push(1);
                }
                else {
                    int curr = 0;
                    while (stack.peek() != 0) {
                        curr += stack.pop();
                    }
                    stack.pop();
                    stack.push(curr * 2);
                }
            }
        }
        int res = 0;
        for (Integer num: stack) res += num;
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreofParentheses result = new ScoreofParentheses();
		System.out.println(result.scoreofParentheses("(())()((()))"));
		System.out.println(result.scoreofParenthesesI("(())()((()))"));
	}

}
