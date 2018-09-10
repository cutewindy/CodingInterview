/**
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first 
 * non-whitespace character is found. Then, starting from this character, takes an optional initial 
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a 
 * numerical value.
 * The string can contain additional characters after those that form the integral number, which are 
 * ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if 
 * no such sequence exists because either str is empty or it contains only whitespace characters, no 
 * conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit 
 * signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable 
 * values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * Input: "42"
 * Output: 42
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical 
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
 * @author wendi
 *
 */
public class StringtoInteger {
	
	/**
	 * Method: Brute Force
	 * 1. discards all leading whitespaces
 	 * 2. sign of the number
	 * 3. overflow
	 * 4. invalid input
	 * @param String str
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int stringtoInteger(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        long res = 0;
        int sign = 1;
        char[] Str = str.toCharArray();
        for (int i = 0; i < Str.length; i++) {
            if (i == 0 && Str[i] == '+') sign = 1;
            else if (i == 0 && Str[i] == '-') sign = -1;
            else if ('0' <= Str[i] && Str[i] <= '9') res = res * 10 + (Str[i] - '0');
            else break;
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return sign * (int) res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringtoInteger result = new StringtoInteger();
		System.out.println(result.stringtoInteger("   234+32"));
		System.out.println(result.stringtoInteger("-2147483648"));
	}

}
