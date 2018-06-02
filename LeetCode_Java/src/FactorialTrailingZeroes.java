/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class FactorialTrailingZeroes {

	/**
	 * Since 0 only company with 5*2,
	 * and multiple of 2 is more than multiple of 5, the number of zeros is dominant by number of 5.
	 * Multiple of 5 provides one 5, multiple of 25 provides two 5 and so on.
	 * @param int n
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int factorialTrailingZeroes(int n) {
		if (n < 5) {
			return 0;
		}
		int result = 0;
		while (n >= 5) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorialTrailingZeroes result = new FactorialTrailingZeroes();
		System.out.println(result.factorialTrailingZeroes(4617));
		System.out.println(result.factorialTrailingZeroes(7));
	}

}
