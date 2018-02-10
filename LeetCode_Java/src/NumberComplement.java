/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the 
 * bits of its binary representation.
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 
 * 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. 
 * So you need to output 0.
 * 
 * @author wendi
 *
 */
public class NumberComplement {
	
	/**
	 * 101, its complement is 010, the sum is 111. So we only need get the sum, then do substraction
	 * @param int num
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int numberComplement(int num) {
		int sum = 0;
		int n = num;
		while (n != 0) {
			n >>= 1;
			sum = (sum << 1) + 1;
		}
		return sum - num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberComplement result = new NumberComplement();
		System.out.println(result.numberComplement(5));
	}

}
