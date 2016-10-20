/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * @author wendi
 *
 */
public class AddDigits {
	
	/**
	 * Method2: Math:
	 * @param int num
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int addDigitsI(int num) {
		return 0;
	}
	
	/**
	 * Method1: loop: based on the definition.
	 * @param int num
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int addDigits(int num) {
		if (num <= 0) {
			return 0;
		}
		while (num >= 10) {
			int n = 0;
			while (num > 0) {
				n += num % 10;
				num /= 10;
			}
			num = n;
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddDigits result = new AddDigits();
		System.out.println(result.addDigits(38));
		System.out.println(result.addDigitsI(38));
	}

}
