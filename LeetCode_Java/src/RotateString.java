
/**
 * We are given two strings, A and B.
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost 
 * position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True 
 * if and only if A can become B after some number of shifts on A.
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * Note:
 * A and B will have length at most 100.
 * @author wendi
 *
 */
public class RotateString {
	
	/**
	 * Method2: two pointers, like "implement strstr"
	 * @param String A, String B
	 * @return boolean
	 * Time: O(n^2);
	 * Space: O(1)
	 */
	public boolean rotateStringI(String A, String B)	{
        if (A == null && B == null) return true;
        if (A == null || B == null || A.length() != B.length()) return false;
        int n = A.length();
        int start = 0;
        int Ai = 0;
        int Bi = 0;
        while (start < n && Bi < n) {
            if (A.charAt(Ai % n) == B.charAt(Bi)) {
                Ai++;
                Bi++;
            }
            else {
                start++;
                Ai = start;
                Bi = 0;
            }
        }
        return Bi == n ? true : false;
	}
	
	
	/**
	 * Method1: 
	 * BruteForce: rotate A for every possible, them compare with B, return true if there are same
	 * @param String A, String B
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public boolean rotateString(String A, String B) {
        if (A == null && B == null) return true;
        if (A == null || B == null || A.length() != B.length()) return false;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            String str = A.substring(i + 1, n) + A.substring(0, i + 1);
            if (str.equals(B)) return true;
        }
        return false;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateString result = new RotateString();
		System.out.println(result.rotateString("abcde", "cdeab"));
		System.out.println(result.rotateStringI("abcde", "cdeab"));
	}

}
