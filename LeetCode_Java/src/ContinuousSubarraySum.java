import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the 
 * array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, 
 * sums up to n*k where n is also an integer.
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * Note:
 * 1. The length of the array won't exceed 10,000.
 * 2. You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 * @author wendi
 *
 */
public class ContinuousSubarraySum {
	
	/**
	 * PrefixSum + HashMap
	 * Iterate through the input array exactly once, keeping track of the running sum mod k of the 
	 * elements in the process. If we find that a running sum value at index j has been previously 
	 * seen before in some earlier index i in the array, then we know that the sub-array (i,j] 
	 * contains a desired sum.
	 * @param int[] nums, int k
	 * @return boolean
	 * Time: O(n)
	 * Space: O(k)
	 */
	public boolean continuousSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) return false;
		Map<Integer, Integer> prefixSum = new HashMap<>(); // (key, value): (prefixSum, index)
		prefixSum.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) sum %= k;
			if (prefixSum.containsKey(sum)) {
				if (i - prefixSum.get(sum) >= 2) return true;
			}
			else prefixSum.put(sum, i);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContinuousSubarraySum result = new ContinuousSubarraySum();
		System.out.println(result.continuousSubarraySum(new int[] {23, 2, 4, 6, 7}, 6));
		System.out.println(result.continuousSubarraySum(new int[] {23, 2, 6, 4, 7}, 6));
	}

}
