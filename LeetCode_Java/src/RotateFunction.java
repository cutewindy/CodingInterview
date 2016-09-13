/**
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a 
 * "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * Note:
 * n is guaranteed to be less than 105.
 * Example:
 * A = [4, 3, 2, 6]
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class RotateFunction {
	
	/**
	 * Method2: Using formula F(k) = F(k - 1) + sum - n * A[n - k] 
	 * to calculate F(0), F(1), ..., F(n-1), then choose the max one.
	 * @param int[] A
	 * @return A
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int rotateFunctionI(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int n = A.length;
		// 1 init, calculate sum and f0
		int sum = 0;
		int f = 0;
		for (int i = 0; i < n; i++) {
			sum += A[i];
			f += i * A[i];
		}
		// 2 calculate f(k) using f(k)=f(k-1)+sum-n*A[n-k]
		int result = f;
		for (int k = 1; k < n; k++) {
			f = f + sum - n * A[n - k];
			result = Math.max(f, result);
		}
		return result;
	}
	
	
	/**
	 * Method1: Brute Force(Time Limited Exceeded) Using formula F(k) += A[(n-k+i)%n] (i: 0 -> n-1)
	 * to calculate F(0), F(1), ..., F(n-1), then choose the max one.
	 * @param int[] A
	 * @return A
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int rotateFunction(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int result = Integer.MIN_VALUE;
		int n = A.length;
		for (int k = 0; k < n; k++) {
			int f = 0;
			for (int i = 0; i < n; i++) {
				f += i * A[(n - k + i) % n];
			}
			result = Math.max(f, result);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateFunction result = new RotateFunction();
		System.out.println(result.rotateFunction(new int[] {4, 3, 2, 6}));
		System.out.println(result.rotateFunctionI(new int[] {4, 3, 2, 6}));
	}

}
