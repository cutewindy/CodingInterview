import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example 1:
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * @author wendi
 *
 */
public class WiggleSortII {
	
	/**
	 * 
	 * @param int[] nums
	 * Time: O()
	 * Space: O()
	 */
	public void  wiggleSortII(int[] nums) {
		if (nums == null || nums.length <= 1) return;
		int n = nums.length;
		int m = kLargestElement(nums, 0, nums.length - 1, (n - 1) / 2);
		System.out.println(m);
	}
	
	
	private int kLargestElement(int[] nums, int l, int r, int k) {
		if (l == r) return nums[l];
		int pivot = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[r]) {
				swap(nums, pivot, r);
				pivot++;
			}
		}
		swap(nums, pivot, r);
		if (pivot == k) return nums[pivot];
		if (pivot < k) return kLargestElement(nums, pivot + 1, r, k);
		return kLargestElement(nums, l, pivot - 1, k);
	}
	
	private void swap(int[] nums, int i, int j) {
		if (i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSortII result = new WiggleSortII();
		int[] nums1 = {1, 5, 1, 1, 6, 4};
		result.wiggleSortII(nums1);
		System.out.println(Arrays.toString(nums1));
		int[] nums2 = {1, 3, 2, 2, 3, 1};
		result.wiggleSortII(nums2);
		System.out.println(Arrays.toString(nums2));
	}

}
