/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once 
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 
 * respectively. It doesn't matter what you leave beyond the new length.
 * 
 * Tags: Array, Two pointers
 * @author wendi
 *
 */
public class RemoveDuplicatesfromSortedArray {

	/**
	 * Two pointers, use i as a door, the value before i has no duplicate.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int removeDuplicatesfromSortedArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {  // means it is not duplicate value, put it in front of i
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray result = new RemoveDuplicatesfromSortedArray();
		int[] array = {1, 1, 2};
		System.out.println(result.removeDuplicatesfromSortedArray(array));
	}

}
