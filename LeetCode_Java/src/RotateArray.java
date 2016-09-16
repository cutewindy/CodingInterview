import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * [show hint]
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class RotateArray {
	
	/**
	 * Three steps to reverse:
	 * 1 reverse whole nums from 0 to nums.length-1.
	 * 2 reverse first part of nums from 0 to k-1.
	 * 3 reverse second part of nums from k to nums.length-1.
	 * @param nums
	 * @param k
	 */
	public void rotateArray(int[] nums, int k) {
		if (nums == null || nums.length <= 1 || k <= 0) {
			return;
		}
		k %= nums.length;  // don't forget
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		return;
	}
	
	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArray result = new RotateArray();
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		result.rotateArray(nums, 10);
		System.out.println(Arrays.toString(nums));
	}

}
