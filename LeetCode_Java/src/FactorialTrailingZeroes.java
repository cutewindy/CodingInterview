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
	 * 100/5 = 20, we have 20 numbers have factor 5: 5, 10, 15, 20, 25, …, 95, 100.
	 * Is the number of trailing zero 20? No, it’s 24, why?
	 * Within that 20 numbers, we have 4 of them: 25 (5×5), 50 (2x5x5), 75 (3x5x5), 100 (4x5x5) that 
	 * have an extra factor of 5.
	 * So, for a given number n, we are looking how many numbers <=n have factor 5, 5×5, 5x5x5, …
	 * Summing those numbers up we got the answer.
	 * e.g. 1000! has 249 trailing zeros:
	 * 1000/5 = 200
	 * 1000/25 = 40
	 * 1000/125 = 8
	 * 1000/625 = 1
	 * 200 + 40 + 8 + 1 = 249
	 * alternatively, we can do the following
	 * 1000/5 = 200
	 * 200/5 = 40
	 * 40/5 = 8
	 * 8/5 = 1
	 * 1/5 = 0
	 * 200 + 40 + 8 + 1 + 0 = 249
	 * @param int n
	 * @return int
	 * Time: O(log5(n))
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
