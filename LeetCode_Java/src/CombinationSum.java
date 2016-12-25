import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C 
 * where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 * 
 * Tags: Array, Backtracking
 * @author wendi
 *
 */
public class CombinationSum {

	/**
	 * Backtracking
	 * @param int[] candidates, int target
	 * @return List<List<Integer>>
	 * Time: O(unknow)
	 * Space: O(1)
	 * Stack space: O(unknow)
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		helper(candidates, 0, target, new ArrayList<Integer>(), result);
		return result;
	}
	
	private void helper(int[] candidates, int pos, int target, List<Integer> combo, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(combo));
			return;
		}
		for (int i = pos; i < candidates.length; i++) {
			if (candidates[i] > target) break;
			combo.add(candidates[i]);
			helper(candidates, i, target - candidates[i], combo, result); // not i + 1 because we can reuse same elements
			combo.remove(combo.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum result = new CombinationSum();
		System.out.println(result.combinationSum(new int[] {2, 3, 6, 7}, 7));
	}

}
