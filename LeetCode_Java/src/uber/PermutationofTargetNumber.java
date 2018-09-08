package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given: an array of unsorted numbers, and a target number;
 * return: all the permutations of combinations of array elements sum up to the target number.
 * For example, [2,5,7], 7
 * return: [2,5], [5,2], [7]
 * @author wendi
 *
 */
public class PermutationofTargetNumber {
	
	/**
	 * Backtracking
	 * @param int[] nums, int target
	 * @return List<List<Integer>>
	 * Time: O(2^n)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<List<Integer>> permutationofTargetNumber(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		dfs(nums, target, new HashSet<Integer>(), new ArrayList<Integer>(), res);
		return res;
	}
	
	private void dfs(int[] nums, int target, Set<Integer> seen, List<Integer> path, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int num: nums) {
			if (target - num < 0) break;
			if (seen.contains(num)) continue;
			path.add(num);
			seen.add(num);
			dfs(nums, target - num, seen, path, res);
			path.remove(path.size() - 1);
			seen.remove(num);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationofTargetNumber result = new PermutationofTargetNumber();
		System.out.println(result.permutationofTargetNumber(new int[] {2, 5, 7}, 7));
	}

}
