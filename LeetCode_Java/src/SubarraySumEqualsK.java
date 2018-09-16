import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous 
 * subarrays whose sum equals to k.
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * 1. The length of the array is in range [1, 20,000].
 * 2. The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * @author wendi
 *
 */
public class SubarraySumEqualsK {
	
	/**
	 * PrefixSum + hashmap
	 * sum to keep track of sum of all the elements so far. If we can find a prefix sum in the map 
	 * for sum-k, it means we can form sum == k using the elements after the element corresponding 
	 * to that prefix sum till the current element (included). Count all such sums at each element.
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int subarraySumEqualsK(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		Map<Integer, Integer> prefixSum = new HashMap<>(); // (key, value): (prefixSum, freq)
		prefixSum.put(0, 1);
		int sum = 0;
		int res = 0;
		for (int num: nums) {
			sum += num;
			if (prefixSum.containsKey(sum - k)) res += prefixSum.get(sum - k);
			prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubarraySumEqualsK result = new SubarraySumEqualsK();
		System.out.println(result.subarraySumEqualsK(new int[] {1,5,3,2,1,4,6}, 10));
		System.out.println(result.subarraySumEqualsK(new int[] {1}, 0));
	}

}
