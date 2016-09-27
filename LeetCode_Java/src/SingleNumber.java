/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using 
 * extra memory?
 * 
 * Tags: Hash Table, Bit Manipulation
 * @author wendi
 *
 */
public class SingleNumber {
	
	/**
	 * Bit Manipulation
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int result = 0;
		for (int num: nums) {
			result ^= num;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber result = new SingleNumber();
		System.out.println(result.singleNumber(new int[] {3, 2, 1, 4, 3, 1, 4}));
	}

}
