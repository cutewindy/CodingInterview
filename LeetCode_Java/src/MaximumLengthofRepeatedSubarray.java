/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both 
 * arrays.
 * Example 1:
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation: 
 * The repeated subarray with maximum length is [3, 2, 1].
 * Note:
 * 1. 1 <= len(A), len(B) <= 1000
 * 2. 0 <= A[i], B[i] < 100
 * @author wendi
 *
 */
public class MaximumLengthofRepeatedSubarray {
	
	/**
	 * DP
	 * dp[i][j]: maximum length of repeated subarray ending with A[i-1] and B[j-1]
	 * res = max(dp[i][j], res)
	 * @param int[] A, int[] B
	 * @return int
	 * Time: O(a * b)
	 * Space: O(a * b)
	 */
	public int maximumLengthofRepeatedSubarrayI(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int[][] dp = new int[m + 1][n + 1];
		int res = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (A[i - 1] == B[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
				res = Math.max(dp[i][j], res);
			}
		}
		return res;
	}
	
	
	/**
	 * Brute force (TLE)
	 * @param int[] A, int[] B
	 * @return int
	 * Time: O(a * b^2)
	 * Space: O(1)
	 */
	public int maximumLengthofRepeatedSubarray(int[] A, int[] B) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int iA = i;
				int jB = j;
				while (iA < A.length && jB < B.length && A[iA] == B[jB]) {
					iA++;
					jB++;
				}
				res = Math.max(iA - i, res);
			}
		}
		return res;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumLengthofRepeatedSubarray result = new MaximumLengthofRepeatedSubarray();
		System.out.println(result.maximumLengthofRepeatedSubarray(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7}));
		System.out.println(result.maximumLengthofRepeatedSubarrayI(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7}));
	}

}
