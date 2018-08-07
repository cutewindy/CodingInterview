/**
 * Your are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the 
 * subarray is less than k.
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], 
 * [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 * @author wendi
 *
 */
public class SubarrayProductLessThanK {
	
	/**
	 * Two pointers --> Sliding window
	 * 1. The idea is always keep an max-product-window less than K;
	 * 2. Every time shift window by adding a new number on the right(j), if the product is greater 
	 * than k, then try to reduce numbers on the left(i), until the subarray product fit less than 
	 * k again, (subarray could be empty);
	 * 3. Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
	 * example:
	 * for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int subarrayProductLessThanK(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) return 0;
		int pro = 1;
		int res = 0;
		for (int l = 0, r = 0; r < nums.length; r++) {
			pro *= nums[r];
			while (l <= r && pro >= k) {
				pro /= nums[l];
				l++;
			}
			res += r - l + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubarrayProductLessThanK result = new SubarrayProductLessThanK();
		System.out.println(result.subarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
		System.out.println(result.subarrayProductLessThanK(new int[] {1, 1, 1}, 1));
	}

}
