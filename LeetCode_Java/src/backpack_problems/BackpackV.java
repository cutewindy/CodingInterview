package backpack_problems;
/**
 * Lintcode: 563 Backkpack V
 * Given n items with size nums[i] which an integer array and all positive numbers. An integer 
 * target denotes the size of a backpack. Find the number of possible fill the backpack.
 * Each item may only be used once
 * Example
 * Given candidate items [1,2,3,3,7] and target 7,
 * A solution set is: 
 * [7]
 * [1, 3, 3]
 * return 2
 * @author wendi
 *
 */
public class BackpackV {
	
    /**
     * DP
     * dp[i][j]: 用前i个物品，有多少种方案可以装满j的空间
     * dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j]
     * dp[i-1][j-nums[i]]: 使用当前i物品装满j的空间的方案个数
     * dp[i-1][j]: 不使用当前i物品装满j的空间方案个数
     * @param： int[] nums, int target
     * @return: 
     * Time: O(n*target)
     * Space: O(target) rolling array
     */
    public int backPackV(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[2][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i - 1] >= 0) dp[i % 2][j] = dp[(i - 1) % 2][j - nums[i - 1]] + dp[(i - 1) % 2][j];
                else dp[i % 2][j] = dp[(i - 1) % 2][j];
            }
        }
        return dp[n % 2][target];
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackpackV result = new BackpackV();
		System.out.println(result.backPackV(new int[] {1,2,3,3,7}, 7));
	}

}
