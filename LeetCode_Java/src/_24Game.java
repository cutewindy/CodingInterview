import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could 
 * operated through *, /, +, -, (, ) to get the value of 24.
 * Example 1:
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * Example 2:
 * Input: [1, 2, 1, 2]
 * Output: False
 * Note:
 * The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use - as a unary operator. 
 * For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot 
 * write this as 12 + 12.
 * @author wendi
 *
 */
public class _24Game {
	
	/**
	 * Backtracking
	 * @param int[] nums
	 * @return boolean
	 * Time: O(6^C(4, 2))
	 * Space: O(1)
	 * Stack space: O(1)
	 */
	public boolean game(int[] nums) {
		List<Double> list = new ArrayList<>();
		for (int n: nums) list.add((double) n);
		return dfs(list);
	}
	
	
	private boolean dfs(List<Double> list) {
		if (list.size() == 1) {
			return Math.abs(list.get(0) - 24.0) < 1e-8;
		}
		for (int i = 0; i < list.size() - 1; i++) {
			double a = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				double b = list.get(j);
				List<Double> pairRes = new ArrayList<>();
				pairRes.addAll(Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a));
				
				list.remove(j);  // NOTE: remove larger index first
				list.remove(i);
				for (double r: pairRes) {
					list.add(r);
					if (dfs(list)) return true;
					list.remove(list.size() - 1);
				}
				list.add(i, a);  // NOTE: add smaller index first
				list.add(j, b);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_24Game result = new _24Game();
		System.out.println(result.game(new int[] {4, 1, 8, 7}));
		System.out.println(result.game(new int[] {1, 2, 1, 2}));
	}

}
