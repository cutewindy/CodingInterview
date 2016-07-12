import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the 
 * different possible ways to group numbers and operators. The valid operators are +, - and *.
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 * 
 * Tags: Divide and Conquer
 * @author wendi
 *
 */
public class DifferentWaystoAddParentheses {

	/**
	 * Divide and Conquer: choose c as the last operator, calculate the left substring [0, i-1] and
	 * save the result in the lefrResults, and calculate the right substring [i, input.length-1] and
	 * save the result in the rightResults. Then do two for loop to implement the last operator c using
	 * lefrResults and rightResults, and save the finalResult in result.
	 * @param String input
	 * @return List<Integer>
	 * Time: O()
	 * Space: O()
	 */
	public List<Integer> differentWaystoAddParentheses(String input) {
		List<Integer> result = new ArrayList();
		if (input == null || input.length() == 0) {
			return result;
		}
		return helper(input);
	}
	
	private List<Integer> helper(String input) {
		List<Integer> result = new ArrayList();
		if (input.matches("^[0-9]*$")) {
			result.add(Integer.valueOf(input));
			return result;
		}
		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> leftResults = helper(input.substring(0, i));
				List<Integer> rightResults = helper(input.substring(i + 1));
				for (Integer leftResult: leftResults) {
					for (Integer rightResult: rightResults) {
						if (c == '+') {
							result.add(leftResult + rightResult);
						}
						else if (c == '-') {
							result.add(leftResult - rightResult);
						}
						else {
							result.add(leftResult * rightResult);
						}
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentWaystoAddParentheses result = new DifferentWaystoAddParentheses();
		System.out.println(result.differentWaystoAddParentheses("2*3-4*5"));
	}

}
