package IBM;
/**
 * 给一个数组求sum的最大的子序列
 * @author wendi
 *
 */
public class MaximumSubarray {
	
	/**
	 * dp
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[(i - 1) % 2] + nums[i] < nums[i]) dp[i % 2] = nums[i];
            else dp[i % 2] = dp[(i - 1) % 2] + nums[i];
            res = Math.max(dp[i % 2], res);
        }
        return res;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
