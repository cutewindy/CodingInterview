package wePay;
/**
 * Given an array, find the subarray (containing at least k numbers) which has the largest sum.
 * Examples:
 * Input : arr[] = {-4, -2, 1, -3} 
 *             k = 2
 * Output : -1
 * The sub array is {-2, 1}
 * Input : arr[] = {1, 1, 1, 1, 1, 1} 
 *             k = 2
 * Output : 6 
 * The sub array is {1, 1, 1, 1, 1, 1}
 * @author wendi
 *
 */
public class LargestSumSubarraywithAtLeastKNumbers {
	
	/**
	 * DP + Sliding window
	 * This problem is an extension of Largest Sum Subarray Problem.
	 * 1) We first compute maximum sum till every index and store it in an array maxSum[].
	 * 2) After filling the array, we use the sliding window concept of size k. Keep track of sum of 
	 * current k elements. To compute sum of current window, remove first element of previous window 
	 * and add current element. After getting the sum of current window, we add the maxSum of the 
	 * previous window, if it is greater than current max, then update it else not.
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int largestSumSubarraywithAtLeastKNumbers(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		
		// get all maxSum in subarray
		int[] maxSum = new int[n];
		maxSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			maxSum[i] = Math.max(maxSum[i - 1] + nums[i], nums[i]);
		}
		
		// init: sum of first k elements
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		
		// sliding window to get sum at least k elements
		int res = sum;
		for (int i = k; i < n; i++) {
			sum = sum - nums[i - k] + nums[i];
			int currRes = Math.max(sum + maxSum[i - k], sum); // same like big maxSum in subarray
			res = Math.max(currRes, res);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestSumSubarraywithAtLeastKNumbers result = new LargestSumSubarraywithAtLeastKNumbers();
		System.out.println(result.largestSumSubarraywithAtLeastKNumbers(new int[] {-4, -2, 1, -3}, 2));
		System.out.println(result.largestSumSubarraywithAtLeastKNumbers(new int[] {1, 1, 1, 1, 1, 1}, 2));
	}

}
