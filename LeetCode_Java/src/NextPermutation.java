import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater 
 * permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, 
 * sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in 
 * the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class NextPermutation {

	/**
	 * Two pointers: two pointers start from back. First pointer i stop at descending point.
     * If i != 0, second pointer j stop at value > nums[i - 1], otherwise, no second pointer.
     * Reverse nums[] from i to nums.length-1.
     * swap and sort rest
	 * @param int[] nums
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int i = nums.length - 1;
		// 1 find first pointer i.
		while (i > 0) {
			if (nums[i] > nums[i - 1]) {
				break;
			}
			i--;
		}
		// 2 if has second pointer, find it j, and swap(i-1, j).
		if (i != 0) {   // not the case of [5,4,3,2,1]
			int j = nums.length - 1;
			while (j >= i) {
				if (nums[j] > nums[i - 1]) {
					swap(nums, i - 1, j);
					break;
				}
				j--;
			}
		}
		// 3 reverse nums[] from i to nums.length-1.
		reverse(nums, i);
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private void reverse(int nums[], int i) { // Two pointers
		int start = i;
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation result = new NextPermutation();
		int[] nums = {6, 3, 4, 8, 8, 7, 4, 1};
//		int[] nums = {5, 4, 3, 2, 1};
		result.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

}
