import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * 1. The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * 2. Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 * @author wendi
 *
 */
public class MaximumProductofThreeNumbers {
	
	/**
	 * Method2: Single scan
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int maximumProductofThreeNumbersI(int[] nums) {
		if (nums == null || nums.length < 3) return 0;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		for (int n: nums) {
			if (n >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			}
			else if (n >= max2) {
				max3 = max2;
				max2 = n;
			}
			else if (n >= max3) {
				max3 = n;
			}
			if (n <= min1) {
				min2 = min1;
				min1 = n;
			}
			else if (n <= min2) {
				min2 = n;
			}
		}
		return Math.max(min1 * min2 * max1, max1 * max2 * max3);
	}
	
	
	/**
	 * Method1: Array sort
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int maximumProductofThreeNumbers(int[] nums) {
		if (nums == null || nums.length < 3) return 0;
		Arrays.sort(nums);
		int n = nums.length;
		return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductofThreeNumbers result = new MaximumProductofThreeNumbers();
		System.out.println(result.maximumProductofThreeNumbers(new int[] {1,2,3,4}));
		System.out.println(result.maximumProductofThreeNumbers(new int[] {-1,-2,-3}));
		System.out.println(result.maximumProductofThreeNumbersI(new int[] {1,2,3,4}));
		System.out.println(result.maximumProductofThreeNumbersI(new int[] {-1,-2,-3}));
	}

}
