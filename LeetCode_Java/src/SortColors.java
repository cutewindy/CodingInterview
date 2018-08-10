import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same 
 * color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * click to show follow up.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total 
 * number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * Tags: Array, Two Pointers, Sort
 * @author wendi
 *
 */
public class SortColors {

	/**
	 * Two Pointers: 
	 * @param int[] nums
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        int s = 0;      // points to 0
        int e = n - 1;  // points to 2
        int i = 0;      // points to 1
        while (i <= e) {
            if (nums[i] == 0) swap(nums, s++, i++);
            else if (nums[i] == 1) i++;
            else swap(nums, i, e--);
        }
	}
	
	private void swap(int[] nums, int i, int j) {
		if (i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors result = new SortColors();
		int[] nums = new int[] {0, 1, 2, 1, 1, 0, 2};
		result.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

}
