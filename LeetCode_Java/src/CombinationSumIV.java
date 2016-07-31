/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible 
 * combinations that add up to a positive integer target.
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class CombinationSumIV {

	/**
	 * DP:
	 * @param int[] nums, int target
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int combinationSumIVI(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return 0;
	}
	
	/**
	 * Method1: Backtracking: Time limited
	 * @param int[] nums, int target
	 * @return int
	 * Time: O()
	 * Space: O()
	 * Stack space: O()
	 */
	private int result = 0;
	public int combinationSumIV(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		helper(nums, target);
		return result;
	}
	
	private void helper(int[] nums, int target) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result++;
		}
		for (int i = 0; i < nums.length; i++) {
			helper(nums, target - nums[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIV result = new CombinationSumIV();
		System.out.println(result.combinationSumIV(new int[] {1, 2, 3}, 4));
//		System.out.println(result.combinationSumIV(new int[] {1, 2, 3}, 32));
		System.out.println(result.combinationSumIVI(new int[] {1, 2, 3}, 4));
	}

}
