import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
		[
		  [1,1,2],
		  [1,2,1],
		  [2,1,1]
		]
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class PermutationsII {

	/**
	 * Backtracking
	 * @param int[] nums
	 * @return List<Lis<Integer>>
	 * Time: O(n!)
	 * Space: O(n)
	 * Static space: O(n)
	 */
	public List<List<Integer>> permutationsII(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		helper(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
		return result;
	}
	
	private void helper(int[] nums, boolean[] isUsed, List<Integer> combo, List<List<Integer>> result) {
		if (combo.size() == nums.length) {
			result.add(new ArrayList<>(combo));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (isUsed[i] || (i != 0 && nums[i] == nums[i - 1] && !isUsed[i - 1])) {  // skip the used and duplicate num
				continue;
			}
			combo.add(nums[i]);
			isUsed[i] = true;
			helper(nums, isUsed, combo, result);
			combo.remove(combo.size() - 1);
			isUsed[i] = false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationsII result = new PermutationsII();
		System.out.println(result.permutationsII(new int[] {1, 1, 2}));
	}

}
