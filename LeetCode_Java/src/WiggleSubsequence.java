import java.util.Arrays;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers 
 * strictly alternate between positive and negative. The first difference (if one exists) may be 
 * either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are 
 * alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle 
 * sequences, the first because its first two differences are positive and the second because its 
 * last difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle 
 * sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) 
 * from the original sequence, leaving the remaining elements in their original order.
 * 
 * Examples:
 * Input: [1,7,4,9,2,5]
 * Output: 6. The entire sequence is a wiggle sequence.
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7. There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * 
 * Follow up:
 * Can you do it in O(n) time?
 * 
 * Tags: DP, Greedy
 * @author wendi
 *
 */
public class WiggleSubsequence {
	
	/**
	 * Method2: Greedy: 
	 * d: the length of the longest subsequence so far that the last number large than previous one.
	 * f: the length of the longest subsequence so far that the last number small than previous one.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int wiggleSubsequenceI(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int d = 1;
		int f = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) d = f + 1;
			else if (nums[i] < nums[i - 1]) f = d + 1;
		}
		return Math.max(d, f);
	}
	
	
	/**
	 * Method1: DP: 
	 * d[i]: the length of the longest subsequence end at nums[i] that the last number large than previous one.
	 * f[i]: the length of the longest subsequence end at nums[i] that the last number small than previous one.
	 * If nums[j] < nums[i], the difference is positive, d[i] = f[j] + 1;
	 * Else if nums[j] > nums[i], the difference is negative, f[i] = d[j] + 1;
	 * Else nums[j] = nums[i], d[i] = f[i] = 1.
	 * @param int[] nums
	 * @return int
	 * Time: O(n^2)
	 * Space: O(2n)
	 */
	public int wiggleSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int result = 1;
		int[] d = new int[n];
		int[] f = new int[n];
		Arrays.fill(d, 1);;
		Arrays.fill(f, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					d[i] = Math.max(f[j] + 1, d[i]);
				}
				else if (nums[j] > nums[i]) {
					f[i] = Math.max(d[j] + 1, f[i]);
				}
			}
			result = Math.max(Math.max(d[i], f[i]), result);
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSubsequence result = new WiggleSubsequence();
		System.out.println(result.wiggleSubsequence(new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
		System.out.println(result.wiggleSubsequenceI(new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
	}

}
