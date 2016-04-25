/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author wendi
 *
 */
public class PowerofTwo {
	
	/**
	 * Method2: n & (n-1) == 0
	 * @param n
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean powerofTwo (int n) {
		if (n <= 0) {
			return false;
		}
		boolean result = true;
		if ((n & (n - 1)) != 0) {
			result = false;
		}
		return result;
	}
	
	/**
	 * Method1: 2^30 % n == 0
	 * @param n
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
//	public boolean powerofTwo (int n) {
//		if (n <= 0) {
//			return false;
//		}
//		boolean result = true;
//		if (Math.pow(2, 30) % n != 0) {
//			result = false;
//		}
//		return result;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerofTwo result = new PowerofTwo();
		System.out.println(result.powerofTwo(6));

	}

}
