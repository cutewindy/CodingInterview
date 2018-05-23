/**
 * In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in 
 * the array.
 * If it is, return the index of the largest element, otherwise return -1.
 * Example 1:
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 * Note:
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 * @author wendi
 *
 */
public class LargestNumberAtLeastTwiceofOthers {
	
	
	/**
	 * tow pointers
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int largestNumberAtLeastTwiceofOthers(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		int max1 = -1;
		int max2 = -1;
		for (int i = 0; i < nums.length; i++) {
			if (max1 == -1 || nums[i] > nums[max1]) {
				max2 = max1;
				max1 = i;
			}
			else if (max2 == -1 || nums[i] > nums[max2]) {
				max2 = i;
			}
		}
		if (max2 == -1 || nums[max1] >= nums[max2] * 2) return max1;
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumberAtLeastTwiceofOthers result = new LargestNumberAtLeastTwiceofOthers();
		System.out.println(result.largestNumberAtLeastTwiceofOthers(new int[] {3, 6, 1, 0}));
		System.out.println(result.largestNumberAtLeastTwiceofOthers(new int[] {1, 2, 3, 4}));
	}

}
