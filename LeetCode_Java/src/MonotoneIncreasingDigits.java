/**
 * Given a non-negative integer N, find the largest number that is less than or equal to N with 
 * monotone increasing digits.
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent 
 * digits x and y satisfy x <= y.)
 * Example 1:
 * Input: N = 10
 * Output: 9
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 * Example 3:
 * Input: N = 332
 * Output: 299
 * Note: N is an integer in the range [0, 10^9].
 * @author wendi
 *
 */
public class MonotoneIncreasingDigits {
	
	
	/**
	 * Math
	 * @param int N
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int monotoneIncreasingDigits(int N) {
        char[] array = String.valueOf(N).toCharArray();
        int mark = array.length;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i - 1] > array[i]) {
                mark = i;
                array[i - 1]--;
            }
        }
        for (int i = mark; i < array.length; i++) {
            array[i] = '9';
        }
        return Integer.parseInt(new String(array));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonotoneIncreasingDigits result = new MonotoneIncreasingDigits();
		System.out.println(result.monotoneIncreasingDigits(332));
	}

}
