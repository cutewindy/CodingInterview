/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned 
 * into two subsets such that the sum of elements in both subsets is equal.
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * @author wendi
 *
 */
public class PartitionEqualSubsetSum {
	
	/**
	 * DP
	 * dp[i][j] means whether the specific sum j can be gotten from the first i numbers.
	 * If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise 
	 * it is false.
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n*sum)
	 * Space: O(sum) rolling array
	 */
    public boolean partitionEqualSubsetSum(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        boolean[][] dp = new boolean[2][sum / 2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j];
                if (j - nums[i - 1] >= 0 && dp[(i - 1) % 2][j - nums[i - 1]]) dp[i % 2][j] = true;
            }
        }
        return dp[nums.length % 2][sum / 2];
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionEqualSubsetSum result = new PartitionEqualSubsetSum();
		System.out.println(result.partitionEqualSubsetSum(new int[] {1, 5, 11, 5}));
	}

}
