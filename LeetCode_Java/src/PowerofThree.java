/**
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 * @author wendi
 *
 */
public class PowerofThree {
	
	/**
	 * Math.pow(3, 19) % n == 0
	 * @param n
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean powerofThree (int n) {
		if (n <= 0) {
			return false;
		}
		boolean result = true;
		if (Math.pow(3, 19) % n == 0) {
			result = false;
		}	
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerofThree result = new PowerofThree();
		System.out.println(result.powerofThree(81));
	}

}
