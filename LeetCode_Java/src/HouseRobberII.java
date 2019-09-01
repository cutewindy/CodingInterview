/**
 * After robbing those houses on that street, the thief has found himself a new place for his 
 * thievery so that he will not get too much attention. This time, all houses at this place are 
 * arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the 
 * security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine 
 * the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class HouseRobberII {

	/**
	 * DP: Like HouseRobber, but if the first house has been chosen, the last house cannot be chosen.
	 * Otherwise, the last house has been chosen the first house cannot be chosen.
	 * Calculate twice, first time from [0, nums.length-2], second from [1, nums.length-1]. Then, 
	 * choose the large one.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int houseRobberII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
	}
	
	private int helper(int[] nums, int start, int end) {
		// using dp + rolling array
//        if (start > end) return 0;
//        if (start == end) return nums[start];
//        int[] dp = new int[3];
//        dp[0] = nums[start];
//        dp[1] = Math.max(nums[start], nums[start + 1]);
//        for (int i = 2; i <= end - start; i++) {
//            dp[i % 3] = Math.max(dp[(i - 2) % 3] + nums[i + start], dp[(i - 1) % 3]);
//        }
//        return dp[(end - start) % 3];
		
		int a = 0;  // use a to save the max profit of even index
		int b = 0;  // use b to save the max profit of odd index 
		for (int i = start; i <= end; i++) {
			if (i % 2 == 0) {
				a = Math.max(a + nums[i], b);
			}
			else {
				b = Math.max(b + nums[i], a);
			}
		}
		return Math.max(a, b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobberII result = new HouseRobberII();
		System.out.println(result.houseRobberII(new int[] {1, 3, 3, 1, 3}));
	}

}
