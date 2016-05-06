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
	 * Method1: loop: based on the definition.
	 * @param int num
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int addDigits(int num) {
		int result = num;
		while (result >= 10) {
			num = result;
			result = 0;
			while (num >= 10) {
				result += num % 10;
				num /= 10;
			}
			result += num;
		}
		return result;
	}
	
//	public int addDigitsI(int num) {
//		
//	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddDigits result = new AddDigits();
		System.out.println(result.addDigits(38));
//		System.out.println(result.addDigitsI(38));
	}

}
