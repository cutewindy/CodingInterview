import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * Tags: Array, Backtracking, Bit Manipulation
 * @author wendi
 *
 */
public class Subsets {

	/**
	 * Method3: Bit Manipulation: give all the possible subsets, we just need to exhaust all the 
	 * possible combinations of the numbers. And each number has only two possibilities: either in 
	 * or not in a subset. And this can be represented using a bit.
	 * @param int[] nums
	 * @return List<List<Integer>>
	 * Time: O(2^n)
	 * Space: O(n)
	 */
	public  List<List<Integer>> subsetsII(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		double n = Math.pow(2, nums.length);
		for (int i = 0; i < n; i++) {
			List<Integer> combo = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if (((i >> j) & 1) == 1) {  // means has nums[j]
					combo.add(nums[j]);
				}
			}
			result.add(combo);
		}
		return result;
	}
	
	
	/**
	 * Method2: BFS: Iteration:This problem can also be solved iteratively. 
	 * Take [1, 2, 3] in the problem statement as an example. The process of generating all the 
	 * subsets is like:
	 * 1. Initially: [[]]
	 * 2. Adding the first number to all the existed subsets: [[], [1]];
	 * 3. Adding the second number to all the existed subsets: [[], [1], [2], [1, 2]];
	 * 4. Adding the third number to all the existed subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
	 * @param int[] nums
	 * @return List<List<Integer>>
	 * Time: O(2^n)
	 * Space: O(n)
	 */
	public  List<List<Integer>> subsetsI(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> combo = new ArrayList<>();
		result.add(combo);
		for (int i = 0; i < nums.length; i++) {
			int size = result.size();
			for (int j = 0; j < size; j++) {
				combo = new ArrayList<>(result.get(j));
				combo.add(nums[i]);
				result.add(combo);
			}
		}
		return result;
	}
	
	
	/**
	 * Method1: DFS/ Backtracking
	 * @param int[] nums
	 * @return List<List<Integer>>
	 * Time: O(2^n)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> combo = new ArrayList<>();
		helper(nums, 0, combo, result);
		return result;
	}
	
	private void helper(int[] nums, int pos, List<Integer> combo, List<List<Integer>> result) {
		result.add(new ArrayList<>(combo));
		if (pos == nums.length) {
			return;
		}
		for (int i = pos; i < nums.length; i++) {
			combo.add(nums[i]);
			helper(nums, i + 1, combo, result);
			combo.remove(combo.size() - 1);
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets result = new Subsets();
		System.out.println(result.subsets(new int[] {1, 2, 3}));
		System.out.println(result.subsetsI(new int[] {1, 2, 3}));
		System.out.println(result.subsetsII(new int[] {1, 2, 3}));
	}

}
