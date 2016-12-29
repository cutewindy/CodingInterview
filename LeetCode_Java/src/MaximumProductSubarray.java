/**
 * Find the contiguous subarray within an array (containing at least one number) which has the 
 * largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * Tags: Array, DP
 * @author wendi
 *
 */
public class MaximumProductSubarray {

	/**
	 * DP: Like maximum subarray, use max to record the max product that include nums[i],
	 * and min product that include nums[i]. When nums[i] is negative, swap max and min,
	 * because the max multiply negative number will be the min one, and the min multiply negative
	 * number will be the max one. 
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int maximumProductSubarray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = nums[0];
		int max = nums[0];
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// multiplied by a negative makes big number smaller, small number bigger, 
			// so we redefine the extremums by swapping them
			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}
			// max/min product for the current number is either the current number itself
	        // or the max/min by the previous number times the current one
			max = Math.max(nums[i] * max, nums[i]);
			min = Math.min(nums[i] * min, nums[i]);
			// the newly computed max value is a candidate for our global result
			result = Math.max(max, result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductSubarray result = new MaximumProductSubarray();
		System.out.println(result.maximumProductSubarray(new int[] {2, -5, -2, 4, 3}));
	}

}
