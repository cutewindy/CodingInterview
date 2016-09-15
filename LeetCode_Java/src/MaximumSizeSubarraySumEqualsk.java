import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
 * If there isn't one, return 0 instead.
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * Follow Up:
 * Can you do it in O(n) time?
 * 
 * Tags: HashTable
 * @author wendi
 *
 */
public class MaximumSizeSubarraySumEqualsk {
	
	/**
	 * HashTable: using  hash<sum, index> to record sum[index].
	 * sum[i] means the sum from 0 to i inclusively
	 * the sum from i + 1 to j is sum[j] - sum[i] except that from 0 to j is sum[j].
	 * j-i is equal to the length of subarray (i, j] of original array. we want to find the max(j - i)
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(n)
	 * Space: On)
	 */
	public int maximumSizeSubarraySumEqualsk(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		Map<Integer, Integer> hash = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {     
			sum += nums[i];
			if (sum == k) {                         // subarray [0, i]
				result = Math.max(i + 1, result);   
			}
			else if (hash.containsKey(sum - k)) {   // subarray (hash.get(sum-k), i]
				result = Math.max(i - hash.get(sum - k), result);
			}
			if (!hash.containsKey(sum)) {   // keep only 1st duplicate as we want longest size
				hash.put(sum, i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSizeSubarraySumEqualsk result = new MaximumSizeSubarraySumEqualsk();
		System.out.println(result.maximumSizeSubarraySumEqualsk(new int[] {-2, -1, 2, 1}, 1));
	}

}
