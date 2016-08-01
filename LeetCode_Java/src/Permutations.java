import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
		[
		  [1,2,3],
		  [1,3,2],
		  [2,1,3],
		  [2,3,1],
		  [3,1,2],
		  [3,2,1]
		]
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class Permutations {

	/**
	 * Backtracking
	 * @param int[] nums
	 * @return List<List<Integer>>
	 * Time: O(n!)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<List<Integer>> permutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		helper(nums, new ArrayList<Integer>(), result);
		return result;
	}
	
	private void helper(int[] nums, List<Integer> combo, List<List<Integer>> result) {
		if (combo.size() == nums.length) {
			result.add(new ArrayList<>(combo));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!combo.contains(nums[i])) {   // if nums[i] has not exist in combo, add it to combo
				combo.add(nums[i]);
				helper(nums, combo, result);
				combo.remove(combo.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations result = new Permutations();
		System.out.println(result.permutations(new int[] {1, 2, 3}));
	}

}
