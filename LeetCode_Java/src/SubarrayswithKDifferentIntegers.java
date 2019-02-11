import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of 
 * A good if the number of different integers in that subarray is exactly K.
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * Return the number of good subarrays of A.
 * Example 1:
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], 
 * [1,2,1], [2,1,2], [1,2,1,2].
 * Example 2:
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 * Note:
 * 1. 1 <= A.length <= 20000
 * 2. 1 <= A[i] <= A.length
 * 3. 1 <= K <= A.length
 * @author wendi
 *
 */
public class SubarrayswithKDifferentIntegers {
	
	/**
	 * Slidng window
	 * Write a helper using sliding window,
	 * to get the number of subarrays with at most K distinct elements.
	 * Then f(exactly K) = f(atMost K) - f(atMost K-1).
	 * @param int[]A, int K
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int subarrayswithKDifferentIntegers(int[] A, int K) {
		if (A == null || A.length == 0 || K == 0) return 0;
		return atMost(A, K) - atMost(A, K - 1);
	}
	
	private int atMost(int[] A, int K) {
		if (K == 0) return 0;
		int res = 0;
		Map<Integer, Integer> cnts = new HashMap<>();
		for (int start = 0, end = 0; start < A.length; start++) {
			while (end < A.length && (cnts.size() < K || cnts.containsKey(A[end]))) {
				cnts.put(A[end], cnts.getOrDefault(A[end], 0) + 1);
				end++;
			}
			res += end - start;
			cnts.put(A[start], cnts.get(A[start]) - 1);
			if (cnts.get(A[start]) == 0) cnts.remove(A[start]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubarrayswithKDifferentIntegers result = new SubarrayswithKDifferentIntegers();
		System.out.println(result.subarrayswithKDifferentIntegers(new int[] {1,2,1,2,3}, 2));
	}

}
