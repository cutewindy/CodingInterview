/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums
 *  being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *  
 * Tags: Array, Two pointers
 * @author wendi
 *
 */
public class RemoveDuplicatesfromSortedArrayII {

	/**
	 * Two pointers: use i as the door, if nums[i-1]!=nums[j], then j is not the third duplicate,
	 * and put it before i. 
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int removeDuplicatesfromSortedArrayII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1 || nums.length == 2) {
			return nums.length;
		}
		int i = 1;
		for (int j = 2; j < nums.length; j++) {
			if (nums[j] != nums[i] || nums[j] != nums[i - 1]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArrayII result = new RemoveDuplicatesfromSortedArrayII();
		int[] array = {1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 5};
		System.out.println(result.removeDuplicatesfromSortedArrayII(array));
	}

}
