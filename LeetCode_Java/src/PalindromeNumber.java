/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * click to show spoilers.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
 * you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class PalindromeNumber {

	/**
	 * Two Pointers: Get the reversed right half of x, then compare it with the left half.
	 * Using two pointers to find the mid point.
	 * @param int x
	 * @return boolean
	 * Time: O(n) n is the number of digits of x
	 * Space: O(1)
	 */
	public boolean palindromeNumber(int x) {
		if (x < 0) return false;
		int half = 0;
		int slow = x;
		int fast = x;
		while (fast != 0) {
			half = half * 10 + slow % 10;
			slow /= 10;
			fast /= 100;
		}
		return half == slow || half / 10 == slow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber result = new PalindromeNumber();
		System.out.println(result.palindromeNumber(91819));
	}

}
