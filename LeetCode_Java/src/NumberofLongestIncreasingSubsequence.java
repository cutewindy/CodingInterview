/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 
 * subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit 
 * in 32-bit signed int.
 * @author wendi
 *
 */
public class NumberofLongestIncreasingSubsequence {
	
	
	/**
	 * DP
	 * The idea is to use two arrays len[n] and cnt[n] to record the maximum length of Increasing 
	 * Subsequence and the corresponding number of these sequence which ends with nums[i]
	 * len[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
	 * cnt[i]: the number of the Longest Increasing Subsequence which ends with nums[i].
	 * Then, the result is the sum of each cnt[i] while its corresponding len[i] is the maxLen
	 * @param int[] nums
	 * @return int
	 * Time: O(n^2) can convert two pass to one pass
	 * Space: O(2n)
	 */
	public int numberofLongestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int[] len = new int[n];
		int[] cnt = new int[n];
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			len[i] = 1;
			cnt[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] <= nums[j]) continue;
				if (len[i] == len[j] + 1) cnt[i] += cnt[j];
				else if (len[i] < len[j] + 1) {
					cnt[i] = cnt[j];
					len[i] = len[j] + 1;
				}
			}
			maxLen = Math.max(len[i], maxLen);
		}
		
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (len[i] == maxLen) res += cnt[i];
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofLongestIncreasingSubsequence result = new NumberofLongestIncreasingSubsequence();
		System.out.println(result.numberofLongestIncreasingSubsequence(new int[] {1,3,5,4,7}));
		System.out.println(result.numberofLongestIncreasingSubsequence(new int[] {2,2,2,2,2}));
	}

}
