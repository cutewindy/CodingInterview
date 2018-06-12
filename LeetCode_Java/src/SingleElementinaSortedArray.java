/**
 * Given a sorted array consisting of only integers where every element appears twice except for one 
 * element which appears once. Find this single element that appears only once.
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * Note: Your solution should run in O(log n) time and O(1) space.
 * @author wendi
 *
 */
public class SingleElementinaSortedArray {
	
	
	/**
	 * Binary Search
	 * @param int[] nums
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int singleElementinaSortedArray(int[] nums) {
		if (nums.length == 1) return nums[0];
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (mid % 2 == 0) mid--;
			if (nums[mid] != nums[mid + 1]) start = mid + 1;
			else end = mid - 1;
		}
		if (start == 0 || nums[start - 1] != nums[start]) return nums[start];
		return nums[end];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleElementinaSortedArray result = new SingleElementinaSortedArray();
		System.out.println(result.singleElementinaSortedArray(new int[] {1,1,2,3,3,4,4,8,8}));
	}

}
