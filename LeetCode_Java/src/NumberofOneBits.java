/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits 
 * it has (also known as the Hamming weight).

 * For example, the 32-bit integer ’11' has binary representation 
 * 00000000000000000000000000001011, so the function should return 3.
 * @author wendi
 * Tag: BitManipulation
 *
 */
public class NumberofOneBits {

	/**
	 * Method1: using n&=(n-1) to calculate the number of 1 in binary type, 
	 * since n&=(n-1) can remove the last 1 of a number which is in binary type.
	 * @param unsign int
	 * @return int
	 * Time: O(Integer.toBinaryString.length()) or O(1)?
	 * Space: O(1)
	 */
	public int numberofOneBits(long n) {
		int result = 0;
		while (n != 0) {
			n &= (n - 1);
			result++;
		}
		return result;
	}
	
	/**
	 * Method2: Burst
	 * @param unsign int
	 * @return int
	 * Time: O(Integer.toBinaryString.length()) or O(1)?
	 * Space: O(1)
	 */
	public int numberofOneBitsI(long n) {
		if (n <= 0) {
			return 0;
		}
		int result = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				result++;
			}
			n >>= 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofOneBits result = new NumberofOneBits();
		System.out.println(result.numberofOneBits(2147483648L));
		System.out.println(result.numberofOneBitsI(2147483648L));

	}

}
