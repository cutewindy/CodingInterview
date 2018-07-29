/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence 
 * (subarray).
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 
 * are separated by 4. 
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
 * Note: Length of the array will not exceed 10,000.
 * @author wendi
 *
 */
public class LongestContinuousIncreasingSubsequence {
	
	/**
	 * Method2: DP
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int longestContinuousIncreasingSubsequenceI(int[] nums) {
		if (nums == null || nums.length == 0) return 0;	
		int res = 1;
		int curr = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) curr++;
			else curr = 1;
			res = Math.max(curr, res);
		}
		return res;
	}
	
	
	/**
	 * Method1: Sliding window
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int longestContinuousIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int start = 0;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i - 1] >= nums[i]) start = i;
			result = Math.max(i - start + 1, result);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestContinuousIncreasingSubsequence result = new LongestContinuousIncreasingSubsequence();
		System.out.println(result.longestContinuousIncreasingSubsequence(new int[] {1,3,5,4,7}));
		System.out.println(result.longestContinuousIncreasingSubsequenceI(new int[] {1,3,5,4,7}));
	}

}
