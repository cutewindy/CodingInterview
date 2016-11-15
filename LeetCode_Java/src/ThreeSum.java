import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
		[
		  [-1, 0, 1],
		  [-1, -1, 2]
		]
 * 
 * Tags: Array, Two pointers
 * @author wendi
 *
 */
public class ThreeSum {

	/**
	 * Two pointers:sort an input array and then run through all indices of a possible first element 
	 * of a triplet. For each possible first element we make a standard bi-directional 2Sum sweep of 
	 * the remaining part of the array. Also we want to skip equal elements to avoid duplicates in 
	 * the answer without making a set or smth like that.
	 * @param int[] nums
	 * @return List<List<Integer>>
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3) return result;
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) continue; // take care: skip duplicate
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == 0) result.add(Arrays.asList(nums[i], nums[start], nums[end]));
				if (sum <= 0) while (++start < end && nums[start] == nums[start - 1]); // skip dup and update start
				if (sum >= 0) while (start < --end && nums[end] == nums[end + 1]); // skip dup and update e
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum result = new ThreeSum();
		System.out.println(result.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
	}

}
