import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
 * Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < 
 * i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value 
 * (for 0 <= i < B.length - 1).
 * Example 1:
 * Input: [3,6,9,12]
 * Output: 4
 * Explanation: 
 * The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 * Input: [9,4,7,2,10]
 * Output: 3
 * Explanation: 
 * The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 * Input: [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation: 
 * The longest arithmetic subsequence is [20,15,10,5].
 * Note:
 * 1. 2 <= A.length <= 2000
 * 2. 0 <= A[i] <= 10000
 * @author wendi
 *
 */
public class LongestArithmeticSequence {
	
	
	/**
	 * DP + HashMap
	 * @param int[] A
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n^2)
	 */
    public int longestArithmeticSequence(int[] A) {
        int n = A.length;
        Map<Integer, Integer>[] dp = new Map[n];
        dp[0] = new HashMap<>();
        int res = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[j] - A[i];
                if (dp[j].containsKey(diff)) dp[i].put(diff, dp[j].get(diff) + 1);
                else dp[i].put(diff, 2);
                res = Math.max(dp[i].get(diff), res);
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestArithmeticSequence result = new LongestArithmeticSequence();
		System.out.println(result.longestArithmeticSequence(new int[] {20,1,15,3,10,5,8}));
	}

}
