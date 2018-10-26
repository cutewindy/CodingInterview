/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 *
 * Tags: Bit Manipulation
 * @author wendi
 *
 */
public class SumofTwoIntegers {
	
	/**
	 * Bit Manipulation
	 * For this, problem, for example, we have a = 1, b = 3,
	 * In bit representation, a = 0001, b = 0011,
	 * First, we can use "and"("&") operation between a and b to find a carry.
	 * carry = a & b, then carry = 0001
	 * Second, we can use "xor" ("^") operation between a and b to find the different bit, and assign it to a,
	 * Then, we shift carry one position left and assign it to b, b = 0010.
	 * Iterate until there is no carry (or b == 0)
	 * @param int a, int b
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int sumofTwoIntegers(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		while (b != 0) {
			int carry = a & b;
			a ^= b;
			b = carry << 1;
			System.out.println("a: " + Integer.toBinaryString(a) + ", b: " + Integer.toBinaryString(b) +", c: " + Integer.toBinaryString(carry));
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofTwoIntegers result = new SumofTwoIntegers();
		System.out.println(result.sumofTwoIntegers(3, 9));
//		System.out.println(result.sumofTwoIntegers(-1, -2));
//		System.out.println(Integer.toBinaryString(-1));
//		System.out.println(Integer.toBinaryString(-2));
//		System.out.println(Integer.toBinaryString(-3));
	}

}
