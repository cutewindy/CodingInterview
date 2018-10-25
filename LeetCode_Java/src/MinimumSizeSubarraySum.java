/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a 
 * contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * Example: 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time 
 * complexity is O(n log n). 
 * @author wendi
 *
 */
public class MinimumSizeSubarraySum {
	
	
	/**
	 * Approach2: Binary search: search if a window of size k exists that satisfy the condition
	 * @param int s, int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int minimumSizeSubarraySumI(int s, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = Integer.MAX_VALUE;
		int start = 1;
		int end = nums.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isValid(nums, s, mid)) {
				res = mid;
				end = mid - 1;
			}
			else start = mid + 1;
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
	
	private boolean isValid(int[] nums, int s, int size) {
		int sum = 0;
		for (int i = 0; i < size - 1; i++) sum += nums[i];
		for (int i = size - 1; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= s) return true;
			sum -= nums[i - size + 1];
		}
		return false;
	}
	
	
	/**
	 * Approach1: sliding window other template
	 * @param int s, int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int minimumSizeSubarraySum(int s, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = Integer.MAX_VALUE;
		int sum = 0;
		for (int start = 0, end = 0; start < nums.length; start++) {
			while (end < nums.length && sum < s) {
				sum += nums[end];
				end++;
			}
			if (sum >= s && res > end - start) res = end - start;
			sum -= nums[start];
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum result = new MinimumSizeSubarraySum();
		System.out.println(result.minimumSizeSubarraySum(7, new int[] {2, 3, 1, 2, 4, 3}));
		System.out.println(result.minimumSizeSubarraySum(3, new int[] {1, 1}));
		System.out.println(result.minimumSizeSubarraySumI(7, new int[] {2, 3, 1, 2, 4, 3}));
		System.out.println(result.minimumSizeSubarraySumI(3, new int[] {1, 1}));
	}

}
