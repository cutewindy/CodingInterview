import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
		[
		  [1, 7],
		  [1, 2, 5],
		  [2, 6],
		  [1, 1, 6]
		]
 * 
 * Tags: Array, Backtracking
 * @author wendi
 *
 */
public class CombinationSumII {

	/**
	 * DFS: 
	 * @param int[] candidates, int target
	 * @return List<List<Integer>>
	 * Time: O(2^n)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<List<Integer>> combinationSumII(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return result;
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
			if (i != pos && candidates[i] == candidates[i - 1]) continue; // skip duplicates
			combo.add(candidates[i]);
			helper(candidates, i + 1, target - candidates[i], combo, result);  // cannot reuse the same elements
			combo.remove(combo.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII result = new CombinationSumII();
		System.out.println(result.combinationSumII(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
	}

}
