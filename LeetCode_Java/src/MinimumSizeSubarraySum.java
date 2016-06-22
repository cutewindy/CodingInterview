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
		int head = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				result = Math.min(i - head + 1, result);
				sum -= nums[head];
				head++;
			}
		}
		return result <= nums.length ? result : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum result = new MinimumSizeSubarraySum();
		int[] array = {2,3,1,2,4,3};
		System.out.println(result.minimumSizeSubarraySum(7, array));
	}

}
