import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 * 
 * Tags: Array, Backtracking
 * @author wendi
 *
 */
public class SubsetsII {

	/**
	 * Method2:BFS Iteration: Like subsetI. If nums[i] is duplicate, combo start at the size getting
	 * from last level. Otherwise, combo start at 0.
	 * @param nums
	 * @return List<List<Integer>>
	 * Time: O(2^n)
	 * Space: O(n)
	 */
	public List<List<Integer>> subsetsIII(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		List<Integer> empty = new ArrayList<>();
		result.add(empty);
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			int size = result.size();
			if (i == 0 || nums[i] != nums[i - 1]) { // nums[i] is not duplicate, combine from beginning
				start = 0;
			}
			for (int j = start; j < size; j++) {
				List<Integer> combo = new ArrayList<>(result.get(j));
				combo.add(nums[i]);
				result.add(combo);
			}
			start = size;
		}
		return result;
	}
	
	/**
	 * Method1: DFS(recursion)
	 * @param int[] nums
	 * @return List<List<Integer>>
	 * Time: O(2^n)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<List<Integer>> subsetsII(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		List<Integer> combo = new ArrayList<>();
		helper(nums, 0, combo, result);
		return result;
	}
	
	private void helper(int[] nums, int pos, List<Integer> combo, List<List<Integer>> result) { 
		result.add(new ArrayList<>(combo));
		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i] == nums[i - 1]) {  // duplicate
				continue;
			}
			combo.add(nums[i]);
			helper(nums, i + 1, combo, result);
			combo.remove(combo.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetsII result = new SubsetsII();
//		System.out.println(result.subsetsII(new int[] {1, 2, 2}));
//		System.out.println(result.subsetsII(new int[] {4, 4, 4, 1, 4}));
		System.out.println(result.subsetsIII(new int[] {4, 4, 4, 1, 4}));
	}

}
