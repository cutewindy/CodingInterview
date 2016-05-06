import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.

 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 * nums should be [1, 3, 12, 0, 0].

 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * @author wendi
 *
 */
public class MoveZeros {
	
	/**
	 * two points: i0 represent zero, i1 represent non-zero.
	 * first step is to find them, then if i0 < i1, swap them.
	 * @param int[] nums
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void moveZeros(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int i1 = 1;
		int i0 = 0;
		while (i1 < nums.length) {
			while (i0 < nums.length && nums[i0] != 0) {
				i0++;
			}
			while (i1 < nums.length && nums[i1] == 0) {
				i1++;
			}
			if (i0 < nums.length && i1 < nums.length && i0 < i1) {
				int temp = nums[i0];
				nums[i0] = nums[i1];
				nums[i1] = temp;
				i0++;
			}
			i1++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZeros result = new MoveZeros();
		int[] nums = {0, 1, 0, 3, 12};
		result.moveZeros(nums);
		System.out.println(Arrays.toString(nums));
	}

}
