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
	
//	/**
//	 * Method2: If given array is sorted, using two pointers
//	 * @param int[] nums, int target
//	 * @return int[]
//	 * Time: O(n)
//	 * Space: O(1)
//	 */
//	public int[] twoSumI(int[] nums, int target) {
//		if (nums == null || nums.length < 2) return new int[] {-1, -1};	
//		Arrays.sort(nums);
//		int left = 0;
//		int right = nums.length - 1;
//		while (left < right) {
//			if (nums[left] + nums[right] == target) return new int[] {left, right};
//			else if (nums[left] + nums[right] < target) left++;
//			else right--;
//		}
//		return new int[] {-1, -1};
//	}
	
	
	/**
	 * Method: one pass hashMap
	 * @param int[] nums, int target
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) return new int[] {-1, -1};
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hash.containsKey(target - nums[i])) {
				return new int[] {hash.get(target - nums[i]), i};
			}
			else {
				hash.put(nums[i], i);
			}
		}
		return null;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum result = new TwoSum();
		System.out.println(Arrays.toString(result.twoSum(new int[] {2, 7, 11, 15}, 9)));
		System.out.println(Arrays.toString(result.twoSum(new int[] {3, 5, 3}, 6)));
//		System.out.println(Arrays.toString(result.twoSumI(new int[] {2, 7, 11, 15}, 9)));
//		System.out.println(Arrays.toString(result.twoSumI(new int[] {3, 3, 5}, 6)));
	}

}
