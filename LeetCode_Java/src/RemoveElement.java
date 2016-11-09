/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.

 * Hint:
 * Try two pointers.
 * Did you use the property of "the order of elements can be changed"?
 * What happens when the elements to remove are rare?
 * 
 * Tag: Array, Two pointers
 * @author wendi
 *
 */
public class RemoveElement {

	/**
	 * Two pointers: start and end. if nums[start]==val, change nums[start] and nums[end], end--;
	 * otherwise, start++. 
	 * @param int[] nums
	 * @param int val
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int removeElement(int[] nums, int val) {
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
		return end + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveElement result = new RemoveElement();
		int[] nums = {2, 3, 3, 2};
		int val = 3;
		System.out.println(result.removeElement(nums, val));
	}

}
