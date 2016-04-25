import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author wendi
 *
 */

public class GenerateParentheses {
	
	/**
	 * Recursion
	 * Base case: left==0 && right=00.
	 * Condition: left>0 -> go helper(left-1); left<right && right>0 -> go helper(right-1).
	 * @param n
	 * @return List<String>
	 */
	public List<String> generateParentheses(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			return result;
		}
		helper(result, "", n, n);	
		return result;
	}
	
	private void helper(List<String> result, String curr, int left, int right) {
		if (left == 0 && right == 0) {
			result.add(curr);
			return;
		}
		if (left > 0) {
			helper(result, curr + '(', left - 1, right);
		}
		if (right > 0 && left < right) {
			helper(result, curr + ')', left, right - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses result = new GenerateParentheses();
		System.out.println(result.generateParentheses(3));

	}

}
