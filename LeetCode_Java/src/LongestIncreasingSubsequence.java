import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, it is only necessary for 
 * you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * 
 * Tags: DP, Binary Search
 * @author wendi
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * DP: LIS[i] means the LIS of the elements before nums[i] and the element nums[i](which menas the LIS includes nums[i]). 
	 * Need to find the satisfied max(LIS[j]+1), where 0<j<i.
	 * Then return the max(LIS[i]), where 0<i<nums.length.
	 * and then return 
	 * @param int[] nums
	 * @return int
	 * Time: O(n ^ 2)
	 * Space: O(n)
	 */
	public int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int[] LIS = new int[nums.length];
		Arrays.fill(LIS, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i]) {
					LIS[i] = LIS[j] + 1 > LIS[i] ? LIS[j] + 1 : LIS[i];
				}
			}
			result = Math.max(LIS[i], result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence result = new LongestIncreasingSubsequence();
		System.out.println(result.longestIncreasingSubsequence((new int[]{10, 9, 2, 5, 3, 7, 101, 18})));
	}

}
