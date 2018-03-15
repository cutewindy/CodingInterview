/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class FirstMissingPositive {
	
	/**
	 * 1. move every value to the position of its value
	 * 2. find first location where the index doesn't match the value
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) { // take care of case [1, 1]
				swap(nums, i, nums[i] - 1);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;  // the case [1, 2, 3, 4]
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstMissingPositive result = new FirstMissingPositive();
		System.out.println(result.firstMissingPositive(new int[] {3, 8, 2, -1, 1, 2}));
//		System.out.println(result.firstMissingPositive(new int[] {3, 1, 2, 5, 4}));
		System.out.println(result.firstMissingPositive(new int[] {1, 1}));
	}

}
