/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * 
 * Tags: Bit Manipulation
 * @author wendi
 *
 */
public class PowerofFour {
	/**
	 * Method2: Math: 
 	 * There are 2 criteria for a number to be power of 4:
	 * 1. is power of 2: n & (n-1) = 0.
	 * 2. the single 1 bit always appears at the odd position: n & 0b10101010... = 0.
	 * @param int num
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean powerofFour(int num) {
		if (num <= 0) {
			return false;
		}
		return (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
	}

	/**
	 * Method1: for loop, n % 4 == 0
	 * @param int num
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
//	public boolean powerofFour(int num) {
//		if (num <= 0) {
//			return false;
//		}
//		boolean result = true;
//		while (num != 1) {
//			if (num % 4 != 0) {
//				result = false;
//				break;
//			}
//			num /= 4;
//		}	
//		return result;
//	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerofFour result = new PowerofFour();
		System.out.println(result.powerofFour(16));
	}

}
