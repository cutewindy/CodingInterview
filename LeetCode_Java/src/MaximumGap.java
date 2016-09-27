/**
 * Given an unsorted array, find the maximum difference between the successive elements in its 
 * sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed 
 * integer range.
 * 
 * Tags: Sort
 * @author wendi
 *
 */
public class MaximumGap {
	
	/**
	 * 
	 * @param int[] nums
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumGap result = new MaximumGap();
		System.out.println(result.maximumGap(new int[] {6, 1, 2, 7}));
	}

}
