/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a 
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * Tags: Array, Two pointers, Binary Search
 * 
 * Similar algorithm:
 * Minimum Size Subarray Sum, Subarray Sum II, Longest Substring Without Repeating Character, 
 * Longest Substring with At Most Two Distinct Character, Minimum Window Substring, 
 * Substring with Concatenation of All Words
 * @author wendi
 *
 */
public class MinimumSizeSubarraySum {
	
	/**
	 * sliding window other template
	 * @param int s, int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int minimumSizeSubarraySumI(int s, int[] nums) {
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
	
	/**
	 * Two pointers(head, i): slide window: while(sum>=s) minimum size = min(i - head + 1), 
	 * move the head of slide window by head+1, else move the tail of slide window by i + 1.
	 * @param int s, int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int minimumSizeSubarraySum(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		int start = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				result = Math.min(i - start + 1, result);
				sum -= nums[start];
				start++;
			}
		}
		return result <= nums.length ? result : 0;   // be care
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
