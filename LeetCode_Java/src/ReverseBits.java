/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * 
 * Tags: Bits Manipulation
 * @author wendi
 *
 */
public class ReverseBits {
	
	/**
	 * Method2: 
	 * @param int n
	 * @return int
	 * Time: O(32)
	 * Space: O(1)
	 */
	public int reverseBitsI(int n) {
		if (n == 0) {
			return 0;
		}
		return 0;
	}
	
	/**
	 * Method1: Brute Force: Bit manipulation
	 * @param int n
	 * @return int
	 * Time: O(32)
	 * Space: O(1)
	 */
	public int reverseBits(int n) {
		if (n == 0) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			result += n & 1;
			n >>= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits result = new ReverseBits();
		System.out.println(result.reverseBits(43261596));
		System.out.println(result.reverseBitsI(43261596));
	}

}
