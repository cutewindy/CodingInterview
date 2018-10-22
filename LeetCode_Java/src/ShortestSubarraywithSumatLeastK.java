import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * If there is no non-empty subarray with sum at least K, return -1.
 * Example 1:
 * Input: A = [1], K = 1
 * Output: 1
 * Example 2:
 * Input: A = [1,2], K = 4
 * Output: -1
 * Example 3:
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 * Note:
 * 1. 1 <= A.length <= 50000
 * 2. -10 ^ 5 <= A[i] <= 10 ^ 5
 * 3. 1 <= K <= 10 ^ 9
 * @author wendi
 *
 */
public class ShortestSubarraywithSumatLeastK {
	
	/**
	 * Approach2: Deque
	 * opt(y)是使得当 P[x] <= P[y] - K 时 x 能取到的最大值。
	 * 1. 如果有 x1<x2 并且 P[x2]<=P[x1]，那么opt(y)一定不是 x1，因为如果有P[x1] <= P[y] - K，那么 
	 * P[x2] <= P[x1] <= P[y] - K，但是 y - x2 is smaller。这表明对于opt(y)的候选x应该是在使P(x)递增的区间去找。
	 * 要注意这里的P[x1]指的是从0到X1的数组元素之和，不是单单指一个x1位置上元素的值。
	 * 2. 如果opt(y1)=x, 那么不需要再次考虑x。因为如果我们找到某些y2>y1并且opt(y2)=x，那么这表明这个解答 y2-x 是比
	 * 之前的解答 y1-x 是更坏的答案。
	 * @param int[] A, int K
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int shortestSubarraywithSumatLeastKI(int[] A, int K) {
		if (A == null || A.length == 0) return -1;
		int n = A.length;
		int[] prefixSum = new int[n + 1];  // include sum = 0
		for (int i = 1; i <= n; i++) {
			prefixSum[i] = A[i - 1] + prefixSum[i - 1];
		}
		
		int res = Integer.MAX_VALUE;
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i <= n; i++) {
			while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peek()] >= K) {
				res = Math.min(i - deque.poll(), res);
			}
			while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.offer(i);
		}
		
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	
	
	/**
	 * Approach1: TreeMap
	 * Using TreeMap to store prefix sum
	 * using flooorKey(sum-K) to get the prefix sum(num) which satisfy sum - num >= K if num exists
	 * (which means it is not null),
	 * @param int[] A, int K
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public int shortestSubarraywithSumatLeastK(int[] A, int K) {
		if (A == null || A.length == 0) return -1;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(0, -1);
		int sum = 0;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			Integer num = treeMap.floorKey(sum - K);
			while (num != null) {
				res = Math.min(i - treeMap.get(num), res);
				treeMap.remove(num);
				num = treeMap.floorKey(sum - K);
			}
			treeMap.put(sum, i);
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestSubarraywithSumatLeastK result = new ShortestSubarraywithSumatLeastK();
		System.out.println(result.shortestSubarraywithSumatLeastK(new int[] {-28,81,-20,28,-29}, 89));
		System.out.println(result.shortestSubarraywithSumatLeastKI(new int[] {-28,81,-20,28,-29}, 89));
	}	

}
