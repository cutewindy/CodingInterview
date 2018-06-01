/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has 
 * the maximum average value. And you need to output the maximum average value.
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 * @author wendi
 *
 */
public class MaximumAverageSubarrayI {
	
	
	/**
	 * Sliding Window
	 * @param int[] nums, int k
	 * @return double
	 * Time: O(n)
	 * Space: O(1)
	 */
	public double maximumAverageSubarrayI(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0.0;
		double maxSum = 0;
		for (int i = 0; i < k && i < nums.length; i++) maxSum += nums[i];
		if (nums.length < k) return maxSum / nums.length;
		double sum = maxSum;
		for (int i = k; i < nums.length; i++) {
			sum = sum - nums[i - k] + nums[i];
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum / k;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumAverageSubarrayI result = new MaximumAverageSubarrayI();
		System.out.println(result.maximumAverageSubarrayI(new int[] {1,12,-5,-6,50,3}, 4));
	}

}
