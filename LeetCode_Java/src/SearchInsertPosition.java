/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * Tags: Array, BinarySearch
 * @author wendi
 *
 */
public class SearchInsertPosition {

	/**
	 * BinarySearch: (Template)If nums[mid]=target, then we find the position, which is mid.
	 * If nums[mid]<target, then the target is in the right of mid.
	 * Otherwise, the target is in the left of mid.
	 * @param int[] nums, int target
	 * @return int
	 */
	public int searchInsertPosition(int[] nums, int target) {
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
			else if (nums[mid] < target) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		if (target <= nums[start]) {
			return start;
		}
		else if (target <= nums[end]) {
			return end;
		}
		return end + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition result = new SearchInsertPosition();
		System.out.println(result.searchInsertPosition(new int[] {1, 3, 5, 6}, 5));
		System.out.println(result.searchInsertPosition(new int[] {1, 3, 5, 6}, 2));

	}

}
