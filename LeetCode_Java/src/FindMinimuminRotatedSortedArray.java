/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * Tags: Array, BinarySearch
 * @author wendi
 *
 */
public class FindMinimuminRotatedSortedArray {

	/**
	 * BinarySearch: (Template). If n[mid]<n[mid-1] && n[mid]<n[mid+1], then n[mid] is the min number.
	 * If n[mid]>n[start]&& n[mid]>n[end], then the min number on the right of mid.
	 * Otherwise, the min number on the left of mid. 
	 * @param int[] nums
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1) 
	 */
	public int findMinimuminRotatedSortedArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
				return nums[mid];
			}
			else if (nums[mid] > nums[end]) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return nums[start] < nums[end] ? nums[start] : nums[end];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimuminRotatedSortedArray result = new FindMinimuminRotatedSortedArray();
		System.out.println(result.findMinimuminRotatedSortedArray(new int[] {4, 5, 6, 7, 0, 1, 2}));
	}

}
