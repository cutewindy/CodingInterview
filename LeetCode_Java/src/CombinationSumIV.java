import java.util.Arrays;

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
	 * Method2: DP: Look target as index from [0, target]. dp[i] means the num of possible 
	 * combination when target is i. Then iterate nums, find which num can add up to i.
	 * 1. If num > i, means cannot add up to i.
	 * 2. If num = i, means can add up to i by 0+num, dp[i]+=dp[0]+1
	 * 3. If num < i, means can add up to i by (i-num)+num, dp[i]+=dp[i-num]
	 * @param int[] nums, int target
	 * @return int
	 * Time: O(target * n)
	 * Space: O(target)
	 */
	public int combinationSumV(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int[] dp = new int[target + 1];
		for (int i = 1; i <= target; i++) {
			for (int num: nums) {
				if (num > i) break;
				else if (num == i) dp[i] += 1;  // target can be 0
				else dp[i] += dp[i - num];
			}
		}
		return dp[target];
	}
	
	/**
	 * Method1: Backtracking: Time limited
	 * @param int[] nums, int target
	 * @return int
	 * Time: O(unknow)
	 * Space: O(1)
	 * Stack space: O(unknow)
	 */
	public int combinationSumIV(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		return helper(nums, target);
	}
	
	private int helper(int[] nums, int target) {
		if (target == 0) {
			return 1;
		}
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > target) break;
			result += helper(nums, target - nums[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIV result = new CombinationSumIV();
		System.out.println(result.combinationSumIV(new int[] {1, 2, 3}, 4));
//		System.out.println(result.combinationSumIV(new int[] {1, 2, 3}, 32));
		System.out.println(result.combinationSumV(new int[] {1, 2, 3}, 4));
	}

}
