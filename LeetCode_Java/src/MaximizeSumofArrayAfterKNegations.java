import java.util.Arrays;

/**
 * Given an array A of integers, we must modify the array in the following way: we choose an i and 
 * replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same 
 * index i multiple times.)
 * Return the largest possible sum of the array after modifying it in this way.
 * Example 1:
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * Example 2:
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * Example 3:
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 * Note:
 * 1. 1 <= A.length <= 10000
 * 2. 1 <= K <= 10000
 * 3. -100 <= A[i] <= 100
 * @author wendi
 *
 */
public class MaximizeSumofArrayAfterKNegations {
	
	/**
	 * Arrays sort + Math
	 * @param int[] A, int k
	 * @return int
	 * Time: O(nlog(n)) can improve this to O(N) by quick selecting the Kth in the negative numbers.
	 * Space: O(1)
	 */
	public int maximizeSumofArrayAfterKNegations(int[] A, int K) {
		Arrays.sort(A);
		for (int i = 0; i < A.length && K > 0 && A[i] < 0; i++, K--) {
			A[i] = -A[i];
		}
		int res = 0;
		int min = Integer.MAX_VALUE;
		for (int a: A) {
			res += a;
			min = Math.min(a, min);
		}
		if (K % 2 != 0) res -= 2 * min;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximizeSumofArrayAfterKNegations result = new MaximizeSumofArrayAfterKNegations();
		System.out.println(result.maximizeSumofArrayAfterKNegations(new int[] {2,-3,-1,5,-4}, 2));
	}

}
