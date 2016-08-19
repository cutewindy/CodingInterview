import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * Tags: Array, HashTable
 * @author wendi
 *
 */
public class TwoSum {
	
	/**
	 * Method: hashMap
	 * @param int[] nums, int target
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = {-1, -1};
		if (nums == null || nums.length == 0) return result;
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hash.containsKey(target - nums[i])) {
				result[0] = hash.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			else {
				hash.put(nums[i], i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum result = new TwoSum();
		System.out.println(Arrays.toString(result.twoSum(new int[] {2, 7, 11, 15}, 9)));
		System.out.println(Arrays.toString(result.twoSum(new int[] {3, 5, 3}, 6)));
	}

}
