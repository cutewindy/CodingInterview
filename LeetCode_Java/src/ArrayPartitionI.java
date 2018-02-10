import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say 
 * (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large 
 * as possible.
 
 * Example 1:
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * 
 * @author wendi
 *
 */
public class ArrayPartitionI {

	/**
	 * The algorithm is first sort the input array and then the sum of 1st, 3rd, 5th…, is the answer.
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int arrayPartitionI(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length % 2 != 0) {
			return 0;
		}
		int result = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayPartitionI result = new ArrayPartitionI();
		System.out.println(result.arrayPartitionI(new int[] {1, 4, 3, 2}));
	}

}
