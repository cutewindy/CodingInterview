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
	 * Two pointers, use i as a door, the value before i(exclude) has no duplicate.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int removeDuplicatesfromSortedArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i == 0 || nums[j] != nums[i - 1]) {
                swap(nums, i, j);
                i++;
            }
        }
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray result = new RemoveDuplicatesfromSortedArray();
		int[] array = {1, 1, 2};
		System.out.println(result.removeDuplicatesfromSortedArray(array));
	}

}
