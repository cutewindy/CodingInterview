/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index. 
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is 
 * fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the 
 * index number 2.
 * Note:
 * Your solution should be in logarithmic complexity.
 * 
 * Tags: BinarySearch, Array
 * @author wendi
 *
 */
public class FindPeakElement {
	
	/**
	 * BianrySearch, since num[-1] = num[n] = -∞
	 * @param int[] nums
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
			else if (nums[mid] < nums[mid + 1]) start = mid;
			else end = mid;
		}
		return nums[start] > nums[end] ? start : end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement result = new FindPeakElement();
		System.out.println(result.findPeakElement(new int[] {1, 2, 3, 1, 1, 1, 2, 2}));
	}

}
