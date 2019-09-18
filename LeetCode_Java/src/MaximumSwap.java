/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued 
 * number. Return the maximum valued number you could get.
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * 1. The given number is in the range [0, 108]
 * @author wendi
 *
 */
public class MaximumSwap {
	
	
	/**
	 * math
	 * Use buckets to record the last position of digit 0 ~ 9 in this num.
	 * Loop through the num array from left to right. For each position, we check whether there 
	 * exists a larger digit in this num (start from 9 to current digit). We also need to make sure 
	 * the position of this larger digit is behind the current one. If we find it, simply swap these 
	 * two digits and return the result.
	 * @param int num
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int maximumSwap(int num) {
		if (num == 0) return 0;
		char[] digits = Integer.toString(num).toCharArray();
		int[] index = new int[10];
		for (int i = 0; i < digits.length; i++) {
			index[digits[i] - '0'] = i;
		}
		for (int i = 0; i < digits.length; i++) {
			for (int j = 9; j > digits[i] - '0'; j--) {
				if (index[j] > i) {
					swap(digits, i, index[j]);
					return Integer.parseInt(new String(digits));
				}
			}
		}
		return num;
	}
	
	private void swap(char[] digits, int i, int j) {
		char temp = digits[i];
		digits[i] = digits[j];
		digits[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSwap result = new MaximumSwap();
		System.out.println(result.maximumSwap(2736));
	}

}
