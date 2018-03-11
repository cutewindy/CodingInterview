/**
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits 
 * will always have different values.
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 * @author wendi
 *
 */
public class BinaryNumberwithAlternatingBits {
	
	/**
	 * bit operation
	 * @param int n
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean binaryNumberwithAlternatingBits(int n) {
		int neighbor = n & 1;
		n >>= 1;
		while (n != 0) {
			if ((n & 1) == neighbor) return false;
			neighbor = n & 1;
			n >>= 1;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNumberwithAlternatingBits result = new BinaryNumberwithAlternatingBits();
		System.out.println(result.binaryNumberwithAlternatingBits(5));
	}

}
