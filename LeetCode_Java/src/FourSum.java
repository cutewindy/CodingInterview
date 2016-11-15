import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = 
 * target? Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
		[
		  [-1,  0, 0, 1],
		  [-2, -1, 1, 2],
		  [-2,  0, 0, 2]
		]
 * 
 * Tags: Array, HashTable Two Pointers
 * @author wendi
 *
 */
public class FourSum {

	/**
	 * Three sum to four sum. Same like "3sum"
	 * @param int[] nums, int target
	 * @return List<List<Integer>>
	 * Time: O(n^3)
	 * Space: O(1)
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 4) return result;
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 4; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) continue; // skip duplicate
			for (int j = i + 1; j <= nums.length - 3; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicate
				int start = j + 1;
				int end = nums.length - 1;
				while (start < end) {
					int sum = nums[i] + nums[j] + nums[start] + nums[end];
					if (sum == target) result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
					if (sum <= target){
						while (++start < end && nums[start] == nums[start - 1]); // update start and skip dup
					}
					if (sum >= target) {
						while (start < --end && nums[end] == nums[end + 1]); // update end and skip dup
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum result = new FourSum();
		System.out.println(result.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
	}

}
