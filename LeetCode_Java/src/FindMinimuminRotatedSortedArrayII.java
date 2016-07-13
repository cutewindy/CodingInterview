/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 * 
 * Tags: Array, BinarySearch
 * @author wendi
 *
 */
public class FindMinimuminRotatedSortedArrayII {

	/**
	 * BinarySearch: Template. need to think about special case like [1, 1, 1, 0, 1, 1].
	 * If n[mid]=n[end], it's fine to remove the end, since the min number won't be removed. 
	 * If n[mid]<n[end], the min number on the left of the mid(includes the mid).
	 * Otherwise, the min number on the right of the mid(includes the mid).
	 * @param int[] nums
	 * @return int
	 * Time: O(n) worst case
	 * Space: O(1)
	 */
	public int findMinimuminRotatedSortedArrayII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == nums[end]) {
				end--;
			}
			else if (nums[mid] < nums[end]) {
				end = mid;
			}
			else {
				start = mid;
				// or start = mid + 1;
			}
		}
		return nums[start] < nums[end] ? nums[start] : nums[end];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimuminRotatedSortedArrayII result = new FindMinimuminRotatedSortedArrayII();
		System.out.println(result.findMinimuminRotatedSortedArrayII(new int[] {4, 4, 5, 6, 6, 7, 0, 1, 2}));
	}

}
