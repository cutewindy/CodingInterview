/**
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class PowerofThree {
	
	/**
	 * Math: 1162261467 is 3^19,  3^20 is bigger than int  
	 * @param int n
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean powerofThree (int n) {
		if (n <= 0) {
			return false;
		}
		return Math.pow(3, 19) % n == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerofThree result = new PowerofThree();
		System.out.println(result.powerofThree(81));
	}

}
