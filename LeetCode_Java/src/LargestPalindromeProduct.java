/**
 * Find the largest palindrome made from the product of two n-digit numbers.
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 * Example:
 * Input: 2
 * Output: 987
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 * Note:
 * The range of n is [1,8].
 * @author wendi
 *
 */
public class LargestPalindromeProduct {
	
	/**
	 * 
	 * @param int n
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int largestPalindromeProduct(int n) {
		int max = 1;
		while (n-- > 0) {
			max *= 10;
		}
		int num1 = max - 1;
		int num2 = max - 2;
		while (num1 > 0 && num2 > 0) {
			long prod = num1 * num2;
			System.out.format("i: %d, j: %d, p: %d\n", num1, num2, prod);
			if (isPalindrome(prod)) return (int) prod % 1337;
			if ((num1 - 1) * num2 > num1 * (num2 - 1)) num1--;
			else num2--;
		}
		return -1;
	}
	
	private boolean isPalindrome(long num) {
		long reverse = 0;
		long input = num;
		while (num > 0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}
		return reverse == input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestPalindromeProduct result = new LargestPalindromeProduct();
		System.out.println(result.largestPalindromeProduct(2));
//		System.out.println(result.largestPalindromeProduct(3));
	}

}
