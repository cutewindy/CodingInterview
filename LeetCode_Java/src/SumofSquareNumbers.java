/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such 
 * that a2 + b2 = c.
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * Input: 3
 * Output: False
 * @author wendi
 *
 */
public class SumofSquareNumbers {
	
	/**
	 * Method2: Using sqrt function
	 * Instead of finding if c - a^2 is a perfect square using sum of odd numbers, as done in the 
	 * last approach, we can make use of the inbuilt sqrt function and check if sqrt{c - a^2}
​​     * turns out to be an integer. If it happens for any value of a in the range [0, sqrt{c}], 
 	 * we can return a True value immediately.
	 * @param c
	 * @return boolean
	 * Time: O(sqat(c)log(c)) We iterate over sqrt{c} values for choosing a. For every a chosen, 
	 * finding square root of c - a^2 takes log(c) time in the worst case.
	 * Space: O(1)
	 */
	public boolean sumofSquareNumbersI(int c) {
		for (long a = 0; a * a <= c; a++) {
			double b = Math.sqrt(c - a * a);
			if (b == (int) b) return true;
		}
		return false;
	}	
	
	
	/**
	 * Method1: brute force(time limited exceeded)
	 * @param int c
	 * @return boolean
	 * Time: O(c) Two loops up to sqrt{c}.
	 * Space: O(1)
	 */
	public boolean sumofSquareNumbers(int c) {
		for (int i = 0; i * i <= c; i++) {
			for (int j = i; j * j <= c && c - i * i >= j * j; j++) {
				if (c - i * i == j * j) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofSquareNumbers result = new SumofSquareNumbers();
		System.out.println(result.sumofSquareNumbers(5));
		System.out.println(result.sumofSquareNumbersI(5));
	}

}
