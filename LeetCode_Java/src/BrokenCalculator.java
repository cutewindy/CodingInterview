/**
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 * Double: Multiply the number on the display by 2, or;
 * Decrement: Subtract 1 from the number on the display.
 * Initially, the calculator is displaying the number X.
 * Return the minimum number of operations needed to display the number Y.
 * Example 1:
 * Input: X = 2, Y = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 * Example 2:
 * Input: X = 5, Y = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 * Example 3:
 * Input: X = 3, Y = 10
 * Output: 3
 * Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 * Example 4:
 * Input: X = 1024, Y = 1
 * Output: 1023
 * Explanation: Use decrement operations 1023 times.
 * 
 * Note:
 * 1. 1 <= X <= 10^9
 * 2. 1 <= Y <= 10^9
 * @author wendi
 *
 */
public class BrokenCalculator {
	
	/**
	 * Considering how to change Y to X
	 * If Y <= X, we won't do Y / 2 anymore.
	 * We will increase Y until it equals to X
	 * So before that, while Y > X, we'll keep reducing Y, until it's smaller than X.
	 * If Y is odd, we can do only Y = Y + 1
	 * If Y is even, if we plus 1 to Y, then Y is odd, we need to plus another 1.
	 * And because (Y + 1 + 1) / 2 = (Y / 2) + 1, 3 operations are more than 2.
	 * We always choose Y / 2 if Y is even.
	 * @param int X, int Y
	 * @return int
	 * Time: O(log(Y - X))
	 * Space: O(1)
	 */
	public int brokenCalculator(int X, int Y) {
		int res = 0;
		while (X < Y) {
			res++;
			if (Y % 2 == 0) Y /= 2;
			else Y++;
		}
		return res + X - Y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrokenCalculator result = new BrokenCalculator();
		System.out.println(result.brokenCalculator(3, 10));
		System.out.println(result.brokenCalculator(1024, 1));
	}

}
