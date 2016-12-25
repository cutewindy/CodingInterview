import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers 
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * Tags: Array, Backtracking
 * @author wendi
 *
 */
public class CombinationSumIII {

	/**
	 * Backtracking: 
	 * @param int k, int n
	 * @return List<List<Integer>>
	 * Time: O(9k)
	 * Space: O(k)
	 * Stack space: O(k)
	 */
	public List<List<Integer>> combinationSumIII(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (k == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		helper(k, n, 1, new ArrayList<Integer>(), result);
		return result;
	}
	
	private void helper(int k, int n, int pos, List<Integer> combo, List<List<Integer>> result) {
		if (k < 0) {
			return;
		}
		if (n == 0 && k == 0) {
			result.add(new ArrayList<>(combo));
			return;
		}
		for (int i = pos; i <= 9; i++) {
			if (i > n) break;
			combo.add(i);
			helper(k - 1, n - i, i + 1, combo, result);
			combo.remove(combo.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII result = new CombinationSumIII();
		System.out.println(result.combinationSumIII(3, 9));
	}

}
