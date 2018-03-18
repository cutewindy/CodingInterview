/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see 
 * below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You 
 * are responsible to gather all the input requirements up front.
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first 
 * non-whitespace character is found. Then, starting from this character, takes an optional initial 
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a 
 * numerical value.
 * The string can contain additional characters after those that form the integral number, which are 
 * ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if 
 * no such sequence exists because either str is empty or it contains only whitespace characters, 
 * no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out 
 * of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
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
