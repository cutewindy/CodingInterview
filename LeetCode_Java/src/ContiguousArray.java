import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 
 * 1.
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 * @author wendi
 *
 */
public class ContiguousArray {
	
	
	/**
	 * Prefix sum + map
	 * same like leetcode: 1124. Longest Well-Performing Interval
	 * same like Leetcode: 
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int contiguousArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			count = nums[i] == 0 ? count - 1 : count + 1;
			if (count == 0) res = i + 1;
			else {
				if (map.containsKey(count)) {
					res = Math.max(i - map.get(count), res);
				}
				else map.put(count, i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContiguousArray result = new ContiguousArray();
		System.out.println(result.contiguousArray(new int[] {0, 0, 1, 0, 0, 0, 1, 1}));
	}

}
