import java.util.Arrays;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide 
 * this array into k non-empty subsets whose sums are all equal.
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Note:
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 * @author wendi
 *
 */
public class PartitiontoKEqualSumSubsets {
	
	/**
	 * A natural approach is to simulate the k groups (disjoint subsets of nums). For each number in 
	 * nums, we'll check whether putting it in the i-th group solves the problem. We can check those 
	 * possibilities by recursively searching.
	 * @param int[] nums, int k
	 * @return boolean
	 * Time: O(k^{N-k} k!) where N is the length of nums, and k is as given. As we skip additional 
	 * zeroes in groups, naively we will make O(k!) calls to search, then an additional O(k^{N-k})
	 * calls after every element of groups is nonzero.
	 * Space: O(N) the space used by recursive calls to search in our call stack
	 */
	public boolean partitiontoKEqualSumSubsets(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) return true;
		int sum = 0;
		for (int n: nums) sum += n;
		int target = sum / k;
		Arrays.sort(nums);
		if (sum % k != 0 || nums[nums.length - 1] > target) return false;   // improve1
		int index = nums.length - 1;
		while (index >= 0 && nums[index] == target) {                       // improve2
			index--;
			k--;
		}
		return helper(new int[k], index, target, nums);
	}
	
	public boolean helper(int[] group, int index, int target, int[] nums) {
		if (index < 0) return true;
		for (int i = 0; i < group.length; i++) {
			if (group[i] + nums[index] <= target) {
				group[i] += nums[index];
				if (helper(group, index - 1, target, nums)) return true;
				group[i] -= nums[index];
				if (group[i] == 0) return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitiontoKEqualSumSubsets result = new PartitiontoKEqualSumSubsets();
		System.out.println(result.partitiontoKEqualSumSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4));
	}

}
