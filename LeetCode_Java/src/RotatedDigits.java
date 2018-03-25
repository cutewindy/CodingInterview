import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid 
 * number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 
 * 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not 
 * rotate to any other number and become invalid.
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: 
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 * N  will be in range [1, 10000].
 * @author wendi
 *
 */
public class RotatedDigits {
	
	/**
	 * Brute force
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int rotatedDigits(int N) {
		int result = 0;
		Set<Integer> rotated = new HashSet<>(Arrays.asList(2, 5, 6, 9));
		Set<Integer> unrotated = new HashSet<>(Arrays.asList(3, 4, 7));
		for (int i = 1; i <= N; i++) {
			if (isRight(i, rotated, unrotated)) result++;
		}
		return result;
	}
	
	public boolean isRight(int n, Set<Integer> rotated, Set<Integer> unrotated) {
		boolean found = false;
		while (n != 0) {
			if (unrotated.contains(n % 10)) return false;
			if (rotated.contains(n % 10)) found = true;
			n /= 10;
		}
		return found;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotatedDigits result = new RotatedDigits();
		System.out.println(result.rotatedDigits(12));
		System.out.println(result.rotatedDigits(857));
	}

}
