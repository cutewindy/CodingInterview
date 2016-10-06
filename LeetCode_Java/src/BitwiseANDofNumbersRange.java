/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in 
 * this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 * 
 * Tags: Bit Manipulation
 * @author wendi
 *
 */
public class BitwiseANDofNumbersRange {
	
	/**
	 * Mathod3: Bit Manipulation, n & (n-1) turns off the right most bit
	 * @param int m, int n
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int bitwiseANDofNumbersRangeII(int m, int n) {
		if (m < 0 || n < 0 || n < m) {
			return 0;
		}
		while (n > m) {
			n &= (n-1);
		}
		return n;
	}
	
	
	/**
	 * Mathod2: Bit Manipulation, using mask
	 * @param int m, int n
	 * @return int
	 * Time: O(32)
	 * Space: O(1)
	 */
	public int bitwiseANDofNumbersRangeI(int m, int n) {
		if (m < 0 || n < 0 || n < m) {
			return 0;
		}
		int mask = Integer.MAX_VALUE;
		while ((mask & m) != (mask & n)) {  // be careful about the priority operation
			mask <<= 1;
		}
		return mask & m;
	}
	
	
	/**
	 * Mathod1: Bit Manipulation
	 * @param int m, int n
	 * @return int
	 * Time: O(32)
	 * Space: O(1)
	 */
	public int bitwiseANDofNumbersRange(int m, int n) {
		if (m < 0 || n < 0 || n < m) {
			return 0;
		}
		int count = 0;
		while (m != n) {
			m >>>= 1;
			n >>>= 1;
			count++;
		}
		return m << count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseANDofNumbersRange result = new BitwiseANDofNumbersRange();
		System.out.println(result.bitwiseANDofNumbersRange(5, 7));
		System.out.println(result.bitwiseANDofNumbersRangeI(5, 7));
		System.out.println(result.bitwiseANDofNumbersRangeII(11, 14));
	}

}
