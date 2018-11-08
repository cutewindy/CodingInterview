package FB_onsite;

import java.util.Arrays;

/**
 * 给出一个positive integer array和一个target number，求subset的数量，使得subset中的最小值和最大值之和小于等于target。
 * @author wendi
 *
 */
public class SubsetMinMaxSumLessThanK {
	
	/**
	 * Two pointers, 
	 * res += 2^(end - start) means at each window nums[start, ..., end], 
	 * nums[start] + nums[end] <= target, then each subset must contains nums[start], there are
	 * 2^(end - start) subsets. Can think in this way that, nums[i] after start in or not in subset.
	 * eg: [2, 4, 7] target = 9;
	 * subsets: [2], [2, 4], [2, 7], [2, 4, 7]
	 * @param int[] nums, int target
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int subsetMinMaxSumLessThanK(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int res = 0;
		while (start <= end) {
			if (nums[start] + nums[end] <= target) {
				res += Math.pow(2, end - start);
				start++;
			}
			else {
				end--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetMinMaxSumLessThanK result = new SubsetMinMaxSumLessThanK();
		System.out.println(result.subsetMinMaxSumLessThanK(new int[] {2,7,4,8}, 9));
	}

}
