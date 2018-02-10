/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note: 
 * 0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
          ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class HammingDistance {

	/**
	 * like counting the bits in an integer, and the useful trick to do that is : xor & (xor - 1) 
	 * will eliminate the last 1 bit in a integer
	 * @param int x, int y
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int hammingDistance(int x, int y) {
		int result = 0;
		int xor = x ^ y;
		while(xor != 0) {
			xor &= (xor - 1);
			result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HammingDistance result = new HammingDistance();
		System.out.println(result.hammingDistance(1, 4));
	}	

}
