/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 * B.length >= 3
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > 
 * B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 * Given an array A of integers, return the length of the longest mountain. 
 * Return 0 if there is no mountain.
 * Example 1:
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 * Note:
 * 1. 0 <= A.length <= 10000
 * 2. 0 <= A[i] <= 10000
 * Follow up:
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 * @author wendi
 *
 */
public class LongestMountaininArray {
	
	/**
	 * Method2: DP, one pass, res is at the end of mountain path
	 * when find a new mountain, reset up and down
	 * @param int[] A
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int longestMountaininArrayI(int[] A) {
		if (A == null || A.length == 0) return 0;
		int up = 0, down = 0;
		int res = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1] || A[i] > A[i - 1] && down > 0) up = down = 0; // reset
			if (A[i] > A[i - 1]) up++;
			else if (A[i] < A[i - 1]) down++;
			if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
		}
		return res;
	}
	
	/**
	 * Method1: DP, 正序和倒序遍历数组, res is at the peek point
	 * 1. take one forward pass to count up hill length (to every point).
	 * 2. take another backward pass to count down hill length (from every point).
	 * 3. a pass to find max(up[i] + down[i] + 1) where up[i] and down[i] should be positives.
	 * @param int[] A
	 * @return int
	 * Time: O(3n)
	 * Space: O(2n)
	 */
	public int longestMountaininArray(int[] A) {
		if (A == null || A.length == 0) return 0;
		int n = A.length;
		
		int[] up = new int[n];
		for (int i = 1; i < n; i++) {
			if (A[i] > A[i - 1]) up[i] = up[i - 1] + 1;
		}
		
		int[] down = new int[n];
		for (int i = n - 2; i >= 0; i--) {
			if (A[i] > A[i + 1]) down[i] = down[i + 1] + 1;
		}
		
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (up[i] > 0 && down[i] > 0 && up[i] + down[i] + 1 > res) res = up[i] + down[i] + 1;
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestMountaininArray result = new LongestMountaininArray();
		System.out.println(result.longestMountaininArray(new int[] {2,1,4,7,3,2,5}));
		System.out.println(result.longestMountaininArray(new int[] {2,2,2}));
		System.out.println(result.longestMountaininArrayI(new int[] {2,1,4,7,3,2,5}));
		System.out.println(result.longestMountaininArrayI(new int[] {2,2,2}));
	}

}
