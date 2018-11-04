import java.util.Arrays;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * Tags: Array, DP, Divide and Conquer
 * @author wendi
 *
 */
public class MaximumSubarray {
	
	
	/**
	 * Approach2: Divide and Conquer
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int maximumSubarrayI(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		return dfs(nums, 0, nums.length - 1);
	}
	
	private int dfs(int[] nums, int start, int end) {
		if (start > end) return Integer.MIN_VALUE;
		if (start == end) return nums[start];
		int mid = start + (end - start) / 2;
		int left = dfs(nums, start, mid - 1);
		int right = dfs(nums, mid + 1, end);
		int currLeft = 0;
		for (int i = mid - 1, sum = 0; i >= start; i--) {
			sum += nums[i];
			currLeft = Math.max(sum, currLeft);
		}
		int currRight = 0;
		for (int i = mid + 1, sum = 0; i <= end; i++) {
			sum += nums[i];
			currRight = Math.max(sum, currRight);
		}
		int currMax = Math.max(Math.max(left, right), currLeft + nums[mid] + currRight);
		return currMax;        
	}
	
	/**
	 * Approach1: DP: maxSum[i] means the largest sum of subarray includes the element nums[i],
	 * result = max(maxSum[i]), where 0<=i<nums.length.
	 * Can use global value maxSum and result to save space.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int maximumSubarray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = nums[0];
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxSum = Math.max(maxSum + nums[i], nums[i]);
			result = Math.max(maxSum, result);
		}		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarray result = new MaximumSubarray();
		System.out.println(result.maximumSubarray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		System.out.println(result.maximumSubarrayI(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}

}
