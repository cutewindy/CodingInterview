/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * Tags: Bit Manipulation
 * @author wendi
 *
 */
public class SingleNumberII {
	
	/**
	 * Method2: Bit Manipulation using ^
	 * 
	 * @param int[] nums
	 * @return int
	 * Time: O(32n)
	 * Space: O(32)
	 */
	public int singleNumberIII(int[] nums) {
		if (nums == null|| nums.length == 0) {
			return -1;
		}
		int result = 0;
		return result;
	}
	
	
	/**
	 * Method1: Bit Manipulation: the number in 32 bits and just count how many 1s are there in each 
	 * bit, and sum %= 3 will clear it once it reaches 3. After running for all the numbers for each 
	 * bit, if we have a 1, then that 1 belongs to the single number, we can simply move it back to 
	 * its spot by doing ans |= sum << i;
	 * @param int[] nums
	 * @return int
	 * Time: O(32n)
	 * Space: O(32)
	 */
	public int singleNumberII(int[] nums) {
		if (nums == null|| nums.length == 0) {
			return -1;
		}
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int num: nums) {
				sum += num >> i & 1;
			}
			result |= sum % 3 << i;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumberII result = new SingleNumberII();
		System.out.println(result.singleNumberII(new int[] {2, 3, 1, 2, 1, 2, 1}));
		System.out.println(result.singleNumberIII(new int[] {2, 3, 1, 2, 1, 2, 1}));
	}

}
