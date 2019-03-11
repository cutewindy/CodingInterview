/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * Return the length of the longest (contiguous) subarray that contains only 1s. 
 * Example 1:
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation: 
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * Example 2:
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation: 
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * Note:
 * 1. 1 <= A.length <= 20000
 * 2. 0 <= K <= A.length
 * 3. A[i] is 0 or 1 
 * @author wendi
 *
 */
public class MaxConsecutiveOnesIII {
	
	
	/**
	 * sliding window
	 * Translation:
	 * Find the longest subarray with at most K zeros.
	 * @param int[] A, int K
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int maxConsecutiveOnesIII(int[] A, int K) {
		if (A == null || A.length == 0) return 0;
		int res = 0;
		for (int start = 0, end = 0; start < A.length; start++) {
			while (end < A.length && (A[end] == 1 || K > 0)) {
				if (A[end] == 0) K--;
				end++;
			}
			res = Math.max(end - start, res);
			if (A[start] == 0) K++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxConsecutiveOnesIII result = new MaxConsecutiveOnesIII();
		System.out.println(result.maxConsecutiveOnesIII(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
	}

}
