/**
 * Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, 
 * return true if and only if for every integer X from 1 to N, the binary representation of X is a 
 * substring of S.
 * Example 1:
 * Input: S = "0110", N = 3
 * Output: true
 * Example 2:
 * Input: S = "0110", N = 4
 * Output: false
 * Note:
 * 1. 1 <= S.length <= 1000
 * 2. 1 <= N <= 10^9
 * @author wendi
 *
 */
public class BinaryStringWithSubstringsRepresenting1ToN {
	
	
	/**
	 * Brute force
	 * @param String S, int N
	 * @return boolean
	 * Time: O(s*n)
	 * Space: O(1)
	 */
	public boolean binaryStringWithSubstringsRepresenting1ToN(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String str = Integer.toBinaryString(i);
            if (!S.contains(str)) return false;
        }
        return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryStringWithSubstringsRepresenting1ToN result = new BinaryStringWithSubstringsRepresenting1ToN();
		System.out.println(result.binaryStringWithSubstringsRepresenting1ToN("0110", 3));
	}

}
