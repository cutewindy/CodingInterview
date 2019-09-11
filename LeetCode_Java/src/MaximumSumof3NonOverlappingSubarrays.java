import java.util.Arrays;

/**
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 * Return the result as a list of indices representing the starting position of each interval 
 * (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 * Example:
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 * Note:
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 * @author wendi
 *
 */
public class MaximumSumof3NonOverlappingSubarrays {
	
	/**
	 * prefix sum + sliding window
	 * @param int[] nums, int k
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] maximumSumof3NonOverlappingSubarrays(int[] nums, int k) {
		if (nums == null || nums.length < 3 * k) return new int[0];
		int n = nums.length;
		int m = n - k + 1;
		int[] sum = new int[m];  // an array of sums of windows with length of k
		int currSum = 0;
		for (int i = 0; i < k - 1; i++) currSum += nums[i];
		for (int i = 0; i < m; i++) {
			currSum += nums[i + k - 1];
			sum[i] = currSum;
			currSum -= nums[i];
		}
		
		// leftIdx[i]: start index that can get max k subarray sum in nums[0,..,i]
		int[] leftIdx = new int[m];
		for (int i = 0, maxIndex = 0; i < m; i++) {
			if (sum[i] > sum[maxIndex]) {
				maxIndex = i;
			}
			leftIdx[i] = maxIndex;
		}
		
		// rightIdx[i]: start index that can get max k subarray sum in nums[i,..,n-1]
		int[] rightIdx = new int[m];
		for (int i = m - 1, maxIndex = m - 1; i >= 0; i--) {
			if (sum[i] >= sum[maxIndex]) {
				maxIndex = i;
			}
			rightIdx[i] = maxIndex;
		}
		
		// maxSum = sum[left] + sum[i] + sum[right]
		int[] res = new int[] {-1, -1, -1};
		int maxSum = Integer.MIN_VALUE;
		for (int i = k; i < m - k; i++) {
			int left = leftIdx[i - k];
			int right = rightIdx[i + k];
			currSum = sum[left] + sum[i] + sum[right];
			if (currSum > maxSum) {
				res[0] = left;
				res[1] = i;
				res[2] = right;
				maxSum = currSum;
			}
		}
			
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSumof3NonOverlappingSubarrays result = new MaximumSumof3NonOverlappingSubarrays();
		System.out.println(Arrays.toString(result.maximumSumof3NonOverlappingSubarrays(new int[] {1,2,1,2,6,7,5,1}, 2)));
	}	

}
