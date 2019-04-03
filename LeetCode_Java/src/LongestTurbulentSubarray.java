/**
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 * For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 * OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 * That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of 
 * elements in the subarray.
 * Return the length of a maximum size turbulent subarray of A
 * Example 1:
 * Input: [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
 * Example 2:
 * Input: [4,8,12,16]
 * Output: 2
 * Example 3:
 * Input: [100]
 * Output: 1
 * Note:
 * 
 * 
 * 
 * 
 * QAZT6AYSDD
 * 1. 1 <= A.length <= 40000
 * 2. 0 <= A[i] <= 10^9
 * @author wendi
 *
 */
public class LongestTurbulentSubarray {
	
	
	/**
	 * Approach1: Brute force, two times check
	 * @param: int[] A
	 * @return: int
	 * Time: O(2n)
	 * Space: O(1)
	 */
	public int longestTurbulentSubarray(int[] A) {
		if (A == null || A.length == 0) return 0;
		int res = 1;
		int currLen = 0;
		
		// case1: i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even
		for (int i = 0; i < A.length - 1; i++) {
			if (i % 2 != 0 && A[i] > A[i + 1] || i % 2 == 0 && A[i] < A[i + 1]) currLen++;
			else {
				res = Math.max(currLen, res);
				currLen = 1;
			}
		}
		res = Math.max(currLen, res);
		currLen = 1;
		
		// case2: i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd
		for (int i = 0; i < A.length - 1; i++) {
//			if (i % 2 == 0 && A[i] > A[i + 1] || i % 2 != 0)
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestTurbulentSubarray result = new LongestTurbulentSubarray();
		System.out.println(result.longestTurbulentSubarray(new int[] {9,4,2,10,7,8,8,1,9}));
	}

}
