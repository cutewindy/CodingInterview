/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * 
 * Tag: Math
 * @author wendi
 * 
 */
public class UglyNumber {
	
	/**
	 * Brute Force + Math
	 * @param int num
	 * @return boolean
	 * Time: O(1) 
	 * Space: O(1)
	 */
	public boolean uglyNumber(int num) {
		if (num <= 0) {
			return false;
		}
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber result = new UglyNumber();
		System.out.println(result.uglyNumber(14));
	}

}
