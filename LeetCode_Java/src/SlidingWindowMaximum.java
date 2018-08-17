import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left 
 * of the array to the very right. You can only see the k numbers in the window. Each time the 
 * sliding window moves right by one position.
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * Note: 
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * Follow up:
 * Could you solve it in linear time?
 * Hint:
 * How about using a data structure such as deque (double-ended queue)?
 * The queue size need not be the same as the window’s size.
 * Remove redundant elements and the queue should store only elements that need to be considered.
 * 
 * Tags: Heap
 * @author wendi
 *
 */
public class SlidingWindowMaximum {

	/**
	 * Method2: Deque
	 * use deque as window [i-k+1, i] to save the index of nums, and keep the down one is the largest 
	 * number in the window.
	 * If nums[i] is large than the top one, it's fine to remove it, since the window contains nums[i].
	 * @param int[] nums, int k
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] slidingWindowMaximumI(int[] nums, int k) {
		if (nums == null || nums.length == 0) return new int[0];
		if (nums.length <= k) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) max = Math.max(nums[i], max);
			return new int[] {max};
		}
		
		int[] result = new int[nums.length - k + 1];
		// use q to save the index of nums, and keep the down
		Deque<Integer> q = new LinkedList<>();  // can use ArrayDeque<>() as well
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) q.poll();
			
			// remove the numbers in q smaller than nums[i] from top to down(last come in the top of q)
			// keep the down number is the largest number in the window
			while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.pollLast();
			
			// push nums[i] in q
			q.offer(i);
			
			// get res
			if (i - k + 1 >= 0) result[i - k + 1] = nums[q.peek()];
		}
		return result;
	}
	
	/**
	 * Method1: Maxheap(TLE)
	 * @param int[] nums, int k
	 * @return int[]
	 * Time: O(n * (log(k) + k), time for heap.remove is O(k)
	 * Space: O(k)
	 */
	public int[] slidingWindowMaximum(int[] nums, int k) {
		if (nums == null || nums.length == 0) return new int[0];
		int n = nums.length;
		int[] res = new int[n - k + 1];
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		for (int i = 0; i < k - 1; i++) {
			maxHeap.offer(nums[i]);
		}
		for (int i = 0; i < n - k + 1; i++) {
			maxHeap.offer(nums[i + k - 1]);
			res[i] = maxHeap.peek();
			maxHeap.remove(nums[i]);
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowMaximum result = new SlidingWindowMaximum();
//		System.out.println(Arrays.toString(result.slidingWindowMaximum(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
		System.out.println(Arrays.toString(result.slidingWindowMaximum(new int[] {1, 3, 1, 2, 0, 5}, 3)));
		System.out.println(Arrays.toString(result.slidingWindowMaximumI(new int[] {1, 3, 1, 2, 0, 5}, 3)));
	}

}
