import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of 
 * the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements 
 * (including none) from A, without changing the order of the remaining elements.  For example, 
 * [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 * Example 1:
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 * Note:
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 * @author wendi
 *
 */
public class LengthofLongestFibonacciSubsequence {
	
	/**
	 * Method3: DP
	 * dp[i][j]: the length of longest fibo sequence which ends with A[i] and A[j].
	 * @param int[] A
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n^2)
	 */
	public int lengthofLongestFibonacciSubsequenceII(int[] A) {
		if (A == null || A.length == 0) return 0;
		int n = A.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) map.put(A[i], i);
		int[][] dp = new int[n][n];
		int res = 0;
		for (int j = 1; j < n; j++) {   // left = i, right = j
			for (int i = 0; i < j; i++) {
				int k = map.getOrDefault(A[j] - A[i], -1);// A[k] + A[i] = A[j]
				if (k < 0 || A[k] >= A[i]) continue;      // cannot find A[k] or A[k] is bigger than A[i]
				dp[i][j] = dp[k][i] + 1;            
				res = Math.max(dp[i][j] + 2, res);        // add first 2 nums
			}
		}
		return res;
	}
	
	
	/**
	 * Method2: DFS + Memoization
	 * @param int[] A
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n^2)
	 */
	public int lengthofLongestFibonacciSubsequenceI(int[] A) {
		if (A == null || A.length == 0) return 0;
		int res = 0;
		Set<Integer> set = new HashSet<>();	
		for (int a: A) set.add(a);
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int curr = dfs(set, map, A[i], A[j]);
				if (curr > 0 && curr + 2 > res) res = curr + 2;
			}
		}
		return res;
	}
	
	private int dfs(Set<Integer> set, Map<String, Integer> map, int left, int right) {
		if (!set.contains(left + right)) return 0;
		String curr = left + "+" + right;
		if (map.containsKey(curr)) return map.get(curr);
		int res = dfs(set, map, right, left + right) + 1;
		map.put(curr, res);
		return res;
	}
	
	
	/**
	 * Method1: BruteForce
	 * 1. Save array A to a hash set s.
	 * 2. Start from base (A[i], A[j]) as the first two element in the sequence,
	 * 3. we try to find the Fibonacci like subsequence as long as possible,
	 *    Initial (left, right) = (A[i], A[j])
	 *    While the set s contains left + right, we update (left, right) = (right, left + right).
	 *    In the end we update the longest length we find.
	 * @param int[] A
	 * @return int
	 * Time: O(n^3)
	 * Space: O(n)
	 */
	public int lengthofLongestFibonacciSubsequence(int[] A) {
		if (A == null || A.length == 0) return 0;
		Set<Integer> set = new HashSet<>();
		for (int a: A) set.add(a);
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int left = A[i], right = A[j];
				int cnt = 0;
				while (set.contains(left + right)) {
					int next = left + right;
					left = right;
					right = next;
					cnt++;
				}
				if (cnt > 0 && cnt + 2 > res) res = cnt + 2; // if is a valid sequence, add first 2 nums
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthofLongestFibonacciSubsequence result = new LengthofLongestFibonacciSubsequence();
		System.out.println(result.lengthofLongestFibonacciSubsequence(new int[] {1,2,3,4,5,6,7,8}));
		System.out.println(result.lengthofLongestFibonacciSubsequenceI(new int[] {1,2,3,4,5,6,7,8}));
		System.out.println(result.lengthofLongestFibonacciSubsequenceII(new int[] {1,2,3,4,5,6,7,8}));
	}

}
