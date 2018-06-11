import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * Example:
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 * @author wendi
 *
 */
public class WiggleSort {
	
	/**
	 * Method2: iterate through the array, we compare the current element to its next element and if 
	 * the order is incorrect, we swap them.
	 * @param int[] nums
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void wiggleSortI(int[] nums) {
        if (nums == null || nums.length == 0) return;	
        for (int i = 0; i < nums.length - 1; i++) {
        	if (i % 2 == 0 && nums[i] > nums[i + 1] ||
        		i % 2 != 0 && nums[i] < nums[i + 1]) {
        		swap(nums, i, i + 1);
        	}
        }
	}
	
	
	
	
	/**
	 * Method1: Array Sort: sort the array first, then swap elements pair-wise starting from the 
	 * second element.
	 * @param int[] nums
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiggleSort result = new WiggleSort();
		int[] nums1 = {3,5,2,1,6,4};
		result.wiggleSort(nums1);
		System.out.println(Arrays.toString(nums1));
		int[] nums2 = {3,5,2,1,6,4};
		result.wiggleSortI(nums2);
		System.out.println(Arrays.toString(nums2));
	}

}
