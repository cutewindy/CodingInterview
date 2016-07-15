import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * Tags: BinarySearch, Array
 * @author wendi
 *
 */
public class SearchforaRange {

	/**
	 * BinarySearch(Template): Two times of binary search. One for looking for left, one for looking for right.
	 * For left: if n[mid]<target, left edge on the right side of mid, excludes mid.
	 * For right: if n[mid]<=target, right edge on the right side of mid, includes mid.
	 * @param int[] nums, int target
	 * @return int[]
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int[] searchforaRange(int[] nums, int target) {
		int[] result = {-1, -1};
		if (nums == null || nums.length == 0) {
			return result;
		}
		// look for left edge
		int start = 0; 
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < target) {
				start = mid + 1; // or start = mid;
			}
			else {
				end = mid;
			}
		}
		if (nums[start] == target) {
			result[0] = start;
		}
		else if (nums[end] == target) {
			result[0] = end;
		}
		// look for right edge
		start = 0;
		end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= target) {
				start = mid;
			}
			else {
				end = mid - 1; // or end = mid;
			}
		}
		if (nums[end] == target) {
			result[1] = end;
		}
		else if (nums[start] == target) {
			result[1] = start;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchforaRange result = new SearchforaRange();
		System.out.println(Arrays.toString(result.searchforaRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
	}

}
