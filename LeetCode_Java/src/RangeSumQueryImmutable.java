/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class RangeSumQueryImmutable {
	
	private int[] sum;
	public RangeSumQueryImmutable(int[] nums) {
		if (nums == null || nums.length == 0) {  // case: nums = []
			sum = new int[0];
			return;
		}
		sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = nums[i] + sum[i - 1];
		}
	}
	
	/**
	 * DP: using sum array to store sum[i] from 0 to i.
	 * @param int i, int j
	 * @return int
	 * Time: O(1)
	 * Space: O(n)
	 */
	public int rangeSumQueryImmutable(int i, int j) {
		if (i < 0 || i > j || j >= sum.length) {
			return 0;
		}
		return i == 0 ? sum[j] : sum[j] - sum[i - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeSumQueryImmutable result = new RangeSumQueryImmutable(new int[] {-2, 0, 3, -5, 2, -1});
		System.out.println(result.rangeSumQueryImmutable(2, 5));
	}

}
