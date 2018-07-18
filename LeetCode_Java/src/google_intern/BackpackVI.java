package google_intern;
/**
 * Given an integer array nums with all positive numbers and no duplicates, find the number of 
 * possible combinations that add up to a positive integer target.
 * A number in the array can be used multiple times in the combination.
 * Different orders are counted as different combinations.
 * Example
 * Given nums = [1, 2, 4], target = 4
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * [4]
 * return 6
 * @author wendi
 *
 */
public class BackpackVI {
	
	
	/**
	 * Same like LeetCode: "Combination Sum IV"
	 * DP
	 * 重复选择 (+不同排列) => 装满可能性总数
	 * dp[i]: numbers of combinations from given backpack that sums to i. dp[i] += dp[i - nums[j]] for j in backpack 
	 * @param int m, int[] A
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m)
	 */
	public int backpackVI(int m, int[] A) {
		if (A == null || A.length == 0) return 0;
		int[] dp = new int[m + 1];
		dp[0] = 1;
		for (int i = 1; i <= m; i++) {
			for (int num: A) {
				dp[i] += i >= num ? dp[i - num] : 0;// pick ith item
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackpackVI result = new BackpackVI();
		System.out.println(result.backpackVI(4, new int[] {1, 2, 4}));
	}

}
