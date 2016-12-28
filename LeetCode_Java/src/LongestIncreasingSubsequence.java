import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, it is only necessary for 
 * you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * Tags: DP, Binary Search
 * @author wendi
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * Binary Search: 
	 * Tails is an array storing the smallest tail of all increasing subsequences with length i+1 in 
	 * tails[i].
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public int longestIncreasingSubsequenceI(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] tails = new int[n];
		tails[0] = nums[0];
		int start = 0;
		int end = 0;
		int size = 1;
		for (int num: nums) {
			start = 0;
			end = size - 1;
			while (start + 1 < end) {
				int mid = start + (end - start) / 2;
				if (tails[mid] < num) {
					start = mid;
				}
				else {
					end = mid;
				}
			}
			if (num <= tails[start]) {
				tails[start] = num;
			}
			else if (num <= tails[end]) {
				tails[end] = num;
			}
			else {
				tails[end + 1] = num;
				size++;
			}
		}
		return size;
 	}
	
	/**
	 * DP: LIS[i] means the LIS of the elements before nums[i] including nums[i]. 
	 * Need to find the satisfied max(LIS[j]+1), where 0<j<i.
	 * Then return the max(LIS[i]), where 0<i<nums.length.
	 * @param int[] nums
	 * @return int
	 * Time: O(n ^ 2)
	 * Space: O(n)
	 */
	public int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) { 
			return 0;
		}
		int result = 1;
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			result = Math.max(dp[i], result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence result = new LongestIncreasingSubsequence();
		System.out.println(result.longestIncreasingSubsequence((new int[]{10, 9, 2, 5, 3, 7, 101, 18})));
		System.out.println(result.longestIncreasingSubsequenceI((new int[]{10, 9, 2, 5, 3, 7, 101, 18})));
	}

}
