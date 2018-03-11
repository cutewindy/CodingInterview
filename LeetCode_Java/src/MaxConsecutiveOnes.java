/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *              The maximum number of consecutive 1s is 3.
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * @author wendi
 *
 */
public class MaxConsecutiveOnes {

	/**
	 * dp
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int maxConsecutiveOnes(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int result = 0;
		int count = 0;
		for (int n: nums) {
			count = n == 0 ? 0 : count + 1;
			result = Math.max(count, result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxConsecutiveOnes result = new MaxConsecutiveOnes();
		System.out.println(result.maxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}));
	}

}
