/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * Tags: BinarySearch, Array
 * @author wendi
 *
 */
public class SearchinRotatedSortedArray {

	/**
	 * BinarySearch: (Template) First is to find which part(left or right) of mid is sorted array, than find target 
	 * in which part by using sorted array.
	 * @param int[] nums, int target
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int searchinRotatedSortedArray(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			else if (nums[mid] < nums[end]) {  // means right part of mid is sorted array
				if (nums[mid] < target && target <= nums[end]) {  // means target in the right part of mid
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			else { 								// means left part of mid is sorted array
				if (nums[start] <= target && target < nums[mid]) {  // means target in the left part of mid
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
		}
		if (nums[start] == target) {
			return start;
		}
		else if (nums[end] == target) {
			return end;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArray result = new SearchinRotatedSortedArray();
		System.out.println(result.searchinRotatedSortedArray(new int[] {4, 5, 6, 7, 0, 1, 2}, 2));
	}

}
