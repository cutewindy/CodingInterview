import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the 
 * maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has 
 * the same degree as nums.
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * 1. nums.length will be between 1 and 50,000.
 * 2. nums[i] will be an integer between 0 and 49,999.
 * @author wendi
 *
 */
public class DegreeofanArray {
	
	
	/**
	 * HashMap
	 * 1. Get index of all unique integers in array , then the size of list is the degree of that integer.
	 * 2. Maintain max as the  maximum frequency of integer.
	 * 2. Return the minimum occurrence range of each integer which appears max times
	 * @param int[] nums
	 * @return int
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int degreeofanArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int result = Integer.MAX_VALUE;
		Map<Integer, List<Integer>> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<Integer>());
			map.get(nums[i]).add(i);
			max = Math.max(map.get(nums[i]).size(), max);
		}
		for (Map.Entry<Integer, List<Integer>> e: map.entrySet()) {
			if (e.getValue().size() == max) {
				List<Integer> list = e.getValue();
				result = Math.min(list.get(list.size() - 1) - list.get(0) + 1, result);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DegreeofanArray result = new DegreeofanArray();
		System.out.println(result.degreeofanArray(new int[] {1,2,2,3,1,4,2}));
	}

}
