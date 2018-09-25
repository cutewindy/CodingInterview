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
     * If i >= 0, second pointer j stop at min value > nums[i], otherwise, no second pointer.
     * Reverse nums[] from i to nums.length-1.
     * 这个题目本身不难，关键是理解题意，我们以一个例子来分析，给定325421，求其下一个比它大的数，怎么办呢？我们应该从最低位
     * 开始，1->2->4->5,这一段是升序的，也就是5421已经是最大数，不存在比它大的组合，我们继续找，1->2->4->5->2，出现降
     * 序这个位置就是我们要找的关键点，只需要将2与其后的数字中的（1,2,4,5）比它大的最小数，也就4替换，然后再将后面的数
     * （1,2,2,5）升序排列便可得到下一个数，过程为：325421->345221->341225
     * swap and sort rest
	 * @param int[] nums
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) return;
		
		// 1 find first pointer i.
		int i = nums.length - 2;
		while (i >= 0) {
			if (nums[i] < nums[i + 1]) break;
			i--;
		}
	
		// 2 if has second pointer, find it as j, and swap(i, j), not the case of [5,4,3,2,1]
		if (i >= 0) {
			int j = nums.length - 1;
			while (j > i) {
				if (nums[j] > nums[i]) break;
				j--;
			}
			swap(nums, i, j);
		}
		
		// 3 reverse nums[] from i+1 to nums.length-1.
		reverse(nums, i + 1, nums.length - 1);
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private void reverse(int nums[], int start, int end) { // Two pointers
		while (start < end) {
			swap(nums, start++, end--);
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
