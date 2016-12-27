/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain 
 * amount of money stashed, the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically contact the police if 
 * two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine 
 * the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Tag: DP
 * @author wendi
 *
 */
public class HouseRobber {

	/**
	 * DP: dp[i] means the max profits that can obtain at house i. 
	 * At house i, if robber, dp[i]=dp[i-2]+nums[i]. If do not robber, dp[i]=dp[i-1].
	 * Choose the max one to determine whether robber or not.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n) can optimize space to O(1) by using prev1 and prev2
	 */
	public int houseRobber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return Math.max(nums[0], 0);
		}
		if (nums.length == 2) { 
			return Math.max(nums[0], nums[1]);
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber result = new HouseRobber();
		System.out.println(result.houseRobber(new int[] {2,1,1,2}));
	}

}
