/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note: n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * Example 1:
 * Input: 3
 * Output: 3
 * Example 2:
 * Input: 11
 * Output: 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the 
 * number 10.
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class NthDigit {
	
	/**
	 * 
	 * @param int n
	 * @return int
	 * Time: O(?)
	 * Space: O(1)
	 */
	public int nthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;
		while (n > len * count) {
			n -= len * count;
			len++;
			count *= 10;
			start *= 10;
		}
        start += (n - 1) / len;
        return Integer.toString(start).charAt((n - 1) % len) - '0'; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthDigit result = new NthDigit();
		System.out.println(result.nthDigit(11));
	}

}
