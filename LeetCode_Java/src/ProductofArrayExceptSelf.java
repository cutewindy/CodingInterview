import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is 
 * equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as 
 * extra space for the purpose of space complexity analysis.)
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class ProductofArrayExceptSelf {

	/**
	 * two times of DP: calculate product of left and product of right, exclusive nums[i],
	 * then res[i] = left * right.
	 * @param int[] nums
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] productofArrayExceptSelf(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return new int[1];
		}
		int[] result = new int[nums.length];
		// DP1: product of nums[i]'s left(exclusive nums[i]).
		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = left;
			left *= nums[i];
		}
		// DP2: product of nums[i]'s right(exclusive nums[i]).
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] *= right;
			right *= nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductofArrayExceptSelf result = new ProductofArrayExceptSelf();
		System.out.println(Arrays.toString(result.productofArrayExceptSelf(new int[] {1, 2, 3, 4})));
	}

}
