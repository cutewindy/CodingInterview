import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 * nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * Tags: Array, Two pointers
 * @author wendi
 *
 */
public class MoveZeros {
	
	/**
	 * two points: use i as door, before i(not include i), the value is non-zero
	 * if nums[j] is zore, switch it with nums[i], then i++.
	 * @param int[] nums
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void moveZeros(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZeros result = new MoveZeros();
		int[] nums = {0, 1, 0, 3, 12};
		result.moveZeros(nums);
		System.out.println(Arrays.toString(nums));
	}

}
