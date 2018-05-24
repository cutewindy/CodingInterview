import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the 
 * new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array 
 * in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example 1:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 
 * 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array 
 * will be known to the caller as well.
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * 
 * Tag: Array, Two pointers
 * @author wendi
 *
 */
public class RemoveElement {

	/**
	 * Method2: Two pointers
	 * @param int[] nums, int val
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int removeElementII(int[] nums, int val) {
		if (nums == null || nums.length == 0) return 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				swap(nums, i, index);
				index++;
			}
		}
//		System.out.println(Arrays.toString(nums));  // nums = [0, 1, 3, 0, 4, 2, 2, 2]
		return index;
	}
	 
	public void swap(int[] nums, int i, int j) {
		if (i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
		
		
	/**
	 * Method1: Two pointers: start and end. if nums[start]==val, change nums[start] and nums[end], 
	 * end--; otherwise, start++.
	 * @param int[] nums, int val
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int removeElementI(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {   // take care of ==, eg: [1]
			if (nums[start] == val) {
				nums[start] = nums[end];
				end--;
			}
			else {
				start++;
			}
		}
//		System.out.println(Arrays.toString(nums));  // nums = [0, 1, 4, 0, 3, 0, 4, 2]
		return end + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveElement result = new RemoveElement();
		System.out.println(result.removeElementI(new int[] {0,1,2,2,3,0,4,2}, 2));
		System.out.println(result.removeElementII(new int[] {0,1,2,2,3,0,4,2}, 2));
	}

}
