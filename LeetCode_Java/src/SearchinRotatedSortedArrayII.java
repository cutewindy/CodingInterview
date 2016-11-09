/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed? 
 * Would this affect the run-time complexity? How and why? 
 * (Yes, the worse case will be O(n), without duplicate, it's O(long(n)))
 * Write a function to determine if a given target is in the array.
 * 
 * Tags: Array, Binary Search
 * @author wendi
 *
 */
public class SearchinRotatedSortedArrayII {

	/**
	 * BinarySearch: (Template) need to deal with duplicated number. 
	 * The same like "findMinimuminRotatedSortedArrayII"
	 * @param int[] nums, int target
	 * @return boolean
	 * Time: O(log(n)) worst case
	 * Space: O(1)
	 */
	public boolean searchinRotatedSortedArrayII(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int start = 0; 
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			}
			else if (nums[mid] == nums[end]) {    // It's fine to remove nums[end]
				end--;
			}
			else if (nums[mid] < nums[end]) {
				if (nums[mid] < target && target <= nums[end]) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			else {
				if (nums[start] <= target && target < nums[mid]) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
		}
		return nums[start] == target || nums[end] == target;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArrayII result = new SearchinRotatedSortedArrayII();
		System.out.println(result.searchinRotatedSortedArrayII(new int[] {1, 1, 1, 1, 0, 1, 1},  0));
	}

}
