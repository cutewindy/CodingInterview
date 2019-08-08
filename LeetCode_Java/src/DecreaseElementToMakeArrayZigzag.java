/**
 * Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
 * An array A is a zigzag array if either:
 * Every even-indexed element is greater than adjacent elements, ie. 
 * A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * OR, every odd-indexed element is greater than adjacent elements, ie. 
 * A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * Return the minimum number of moves to transform the given array nums into a zigzag array.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation: We can decrease 2 to 0 or 3 to 1.
 * Example 2:
 * Input: nums = [9,6,1,6,2]
 * Output: 4
 * Constraints:
 * 1. 1 <= nums.length <= 1000
 * 2. 1 <= nums[i] <= 1000
 * @author wendi
 *
 */
public class DecreaseElementToMakeArrayZigzag {
	
	
	
	/**
	 * Two options, either make A[even] smaller or make A[odd] smaller.
	 * Loop on the whole array A,
	 * find the min(A[i - 1],A[i + 1]),
	 * calculate that the moves need to make smaller than both side.
	 * If it's negative, it means it's already smaller than both side, no moved needed.
	 * Add the moves need to res[i%2].
	 * In the end return the smaller option.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int decreaseElementToMakeArrayZigzag(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] res = new int[2];
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int neighbor = Math.min((i - 1 < 0 ? 1001 : nums[i - 1]), (i + 1 >= n ? 1001 : nums[i + 1]));
			res[i % 2] += nums[i] - neighbor >= 0 ? nums[i] - neighbor + 1 : 0;
		}
		return Math.min(res[0], res[1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecreaseElementToMakeArrayZigzag result = new DecreaseElementToMakeArrayZigzag();
		System.out.println(result.decreaseElementToMakeArrayZigzag(new int[] {1,2,3}));
		System.out.println(result.decreaseElementToMakeArrayZigzag(new int[] {9,6,1,6,2}));
	}

}
