import java.util.Arrays;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other 
 * elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * 1. The order of the result is not important. So in the above example, [5, 3] is also correct.
 * 2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant 
 * space complexity?
 * 
 * Tags: Bit Manipulation
 * @author wendi
 *
 */
public class SingleNumberIII {
	
	/**
	 * Bit Manipulation: Find the rightmost set bit, divide numbers into two groups. Each group will 
	 * end up being one unique number.
	 * @param int[] nums
	 * @return int[]
	 * Time: O(2n)
	 * Space: O(1)
	 */
	public int[] singleNumberIII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[2];
		}
		int[] result = new int[2];
		// 1. Get the XOR of the two numbers we need to find.
		int xor = 0;
		for (int num: nums) {
			xor ^= num;
		}
		// 2. Get its last set bit.
//		int bit = xor ^ (xor & (xor - 1));
		int bit = xor & ~(xor - 1);
		// 3. Put num in two groups, and find single number in each group.
		for (int num: nums) {
			if ((num & bit) == 0) {
				result[0] ^= num;
			}
			else {
				result[1] ^= num;
			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumberIII result = new SingleNumberIII();
		System.out.println(Arrays.toString(result.singleNumberIII(new int[] {1, 2, 1, 3, 2, 5})));
	}

}
