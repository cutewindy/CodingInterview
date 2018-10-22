import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position 
 * of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * @author wendi
 *
 */
public class FindFirstandLastPositionofElementinSortedArray {
	
	/**
	 * Approach2: Binary search, one pass
	 * @param int[] nums, int target
	 * @return int[]
	 * Time: O(log(n))
	 * Space:O(1)
	 */
	public int[] findFirstandLastPositionofElementinSortedArrayI(int[] nums, int target) {
		if (nums == null || nums.length == 0) return new int[] {-1, -1};
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			if (nums[start] == target && nums[end] == target) return new int[] {start, end};
			int mid = start + (end - start) / 2;
			if (nums[mid] < target) start = mid + 1;
			else if (nums[mid] > target) end = mid - 1;
			else {
				if (nums[start] == target) end--;
				else start++;
			}
		}
		if (nums[start] == target && nums[end] == target) return new int[] {start, end};
		else if (nums[start] == target) return new int[] {start, start};
		else if (nums[end] == target) return new int[] {end, end};
		return new int[] {-1, -1};
	}
	
	
	
	/**
	 * Approach1: Binary search, two pass
	 * @param int[] nums, int target
	 * @return int[]
	 * Time: O(log(n))
	 * Space:O(1)
	 */
	public int[] findFirstandLastPositionofElementinSortedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        int start = findStart(nums, target);
        if (start == -1) return new int[] {-1, -1};
        int end = findEnd(nums, target);
        return new int[] {start, end};
    }
    
    private int findStart(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid;
            else end = mid;
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
    
    private int findEnd(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) start = mid;
            else end = mid;
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
	}
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstandLastPositionofElementinSortedArray result = new FindFirstandLastPositionofElementinSortedArray();
		System.out.println(Arrays.toString(result.findFirstandLastPositionofElementinSortedArray(new int[] {5,7,7,8,8,10}, 8)));
		System.out.println(Arrays.toString(result.findFirstandLastPositionofElementinSortedArray(new int[] {5,7,7,8,8,10}, 6)));
		System.out.println(Arrays.toString(result.findFirstandLastPositionofElementinSortedArrayI(new int[] {5,7,7,8,8,10}, 8)));
		System.out.println(Arrays.toString(result.findFirstandLastPositionofElementinSortedArrayI(new int[] {5,7,7,8,8,10}, 6)));
	}

}
