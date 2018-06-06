import java.util.Arrays;
import java.util.Stack;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this 
 * subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted 
 * in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 * @author wendi
 *
 */
public class ShortestUnsortedContinuousSubarray {
	
	/**
	 * Method2: stack
	 * @param int[] nums
	 * @return int
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public int shortestUnsortedContinuousSubarrayI(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int start = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				start = Math.min(stack.pop(), start);
			}
			stack.push(i);
		}
		int end = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				end = Math.max(stack.pop(), end);
			}
			stack.push(i);
		}
		if (end <= start) return 0;
		return end - start + 1;
	}

	
	/**
	 * Method1: Sort array
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public int shortestUnsortedContinuousSubarray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] input = nums.clone();
		Arrays.sort(nums);
		int start = nums.length - 1;
		int end = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != input[i]) {
				start = Math.min(i, start);
				end = Math.max(i, end);
			}
		}
		if (end <= start) return 0;
		return end - start + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestUnsortedContinuousSubarray result = new ShortestUnsortedContinuousSubarray();
		System.out.println(result.shortestUnsortedContinuousSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
		System.out.println(result.shortestUnsortedContinuousSubarrayI(new int[] {2, 6, 4, 8, 10, 9, 15}));
	}

}
