/**
 * A sequence of number is called arithmetic if it consists of at least three elements and if the 
 * difference between any two consecutive elements is the same.
 * For example, these are arithmetic sequence:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * 1, 1, 2, 5, 7
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of 
 * integers (P, Q) such that 0 <= P < Q < N.
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * The function should return the number of arithmetic slices in the array A.
 * Example:
 * A = [1, 2, 3, 4]
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * 
 * Tags: DP, Math
 * @author wendi
 *
 */
public class ArithmeticSlices {
	
	
	/**
	 * DP: dp[i]: the number of arithmetic slices including A[i]
	 * @param int[] A
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int arithmeticSlices(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}
		int result = 0;
		int previous = 0;
		int n = A.length;
		for (int i = 2; i < n; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				previous += 1;
				result += previous;
			}
			else {
				previous = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArithmeticSlices result = new ArithmeticSlices();
		System.out.println(result.arithmeticSlices(new int[] {1, 2, 3, 4, 5, 6, 7}));
	}

}