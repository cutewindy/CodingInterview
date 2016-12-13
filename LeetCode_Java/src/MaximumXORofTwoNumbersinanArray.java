/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class MaximumXORofTwoNumbersinanArray {
	
	/**
	 * 
	 * @param int[] nums
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int maximumXORofTwoNumbersinanArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int maxNum = nums[0];
		for (int num: nums) {
			maxNum = Math.max(num, maxNum);
		}
		for (int num: nums) {
			result = Math.max(num ^ maxNum, result);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumXORofTwoNumbersinanArray result = new MaximumXORofTwoNumbersinanArray();
		System.out.println(result.maximumXORofTwoNumbersinanArray(new int[] {3, 10, 5, 25, 2, 8}));
	}

}
