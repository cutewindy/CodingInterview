import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * Tags: Array, Math
 * @author wendi
 *
 */
public class PlusOne {
	
	/**
	 * Brute Force
	 * @param int[] digits
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[] {1}; 
		}
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				return digits;
			}
			digits[i] = 0;
		}
		int[] result = new int[n + 1];
		result[0] = 1;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlusOne result = new PlusOne();
		System.out.println(Arrays.toString(result.plusOne(new int[] {9, 9, 9})));
	}

}
