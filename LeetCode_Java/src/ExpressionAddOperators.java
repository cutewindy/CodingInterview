import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add 
 * binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 * 
 * Tags: Divide and Conquer
 * @author wendi
 *
 */
public class ExpressionAddOperators {
	
	/**
	 * Using long multi to save the last operand
	 * This problem has a lot of edge cases to be considered:
	 * 1 overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, 
	 *   we get over it.
	 * 2 0 sequence: because we can't have numbers with multiple digits started with zero, 
	 *   we have to deal with it too.
 	 * 3 a little trick is that we should save the value that is to be multiplied in the next 
 	 * 	 recursion.
	 * @param String num, int target
	 * @return List<String>
	 * Time: O(n*4^(n - 1)) one for loop in dfs, and have non, +, - and *, four operations between n characters.
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public List<String> expressionAddOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		if (num == null || num.length() == 0) {
			return result;
		}
		helper(num, target, "", 0, 0, 0, result);
		return result;
	}
	
	public void helper(String num, int target, String combo, int pos, long curr, long multi, 
			List<String> result) {
		if (pos == num.length()) {
			if (curr == target) {
				result.add(combo);
			}
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (num.charAt(pos) == '0' && i != pos) break;  // 2 be care about "0123" case
			String currStr = num.substring(pos, i + 1);
			Long currNum = Long.parseLong(currStr);         // 1 using long to avoid overflow
			if (pos == 0) {									// init case
				helper(num, target, currStr, i + 1, currNum, currNum, result);
			}
			else {
				helper(num, target, combo + "+" + currStr, i + 1, curr + currNum, currNum, result);
				helper(num, target, combo + "-" + currStr, i + 1, curr - currNum, -currNum, result);
				helper(num, target, combo + "*" + currStr, i + 1, curr - multi + multi * currNum, multi * currNum, result);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionAddOperators result = new ExpressionAddOperators();
		System.out.println(result.expressionAddOperators("12345", 20));
	}

}
