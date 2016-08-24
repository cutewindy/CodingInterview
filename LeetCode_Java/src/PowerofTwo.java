/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Tags: Math, Bit Manipulation
 * @author wendi
 *
 */
public class PowerofTwo {
	
	/**
	 * Method2: Bit Manipulation: n & (n-1) == 0
	 * @param int n
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean powerofTwoI(int n) {
		if (n <= 0) {
			return false;
		}
		return (n & (n - 1)) == 0;
	}
	
	/**
	 * Method1: Math:Because the range of an integer = -2147483648 (-2^31) ~ 2147483647 (2^31-1), 
	 * the max possible power of two = 2^30 = 1073741824.
	 * (1) If n is the power of two, let n = 2^k, where k is an integer.
	 * We have 2^30 = (2^k) * 2^(30-k), which means (2^30 % 2^k) == 0.
	 * (2) If n is not the power of two, let n = j*(2^k), where k is an integer and j is an odd number.
	 * We have (2^30 % j*(2^k)) == (2^(30-k) % j) != 0.
	 * @param int n
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean powerofTwo(int n) {
		if (n <= 0) {
			return false;
		}
		return Math.pow(2, 30) % n == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerofTwo result = new PowerofTwo();
		System.out.println(result.powerofTwo(6));
		System.out.println(result.powerofTwoI(6));

	}

}
