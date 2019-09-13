import java.util.Arrays;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 * 
 * Tags: Math, String
 * @author wendi
 *
 */
public class MultiplyStrings {
	
	/**
	 * normalize the int array to be zero-based prod[n1.i+n2.l], and then convert back to int-based array,
	 * val = prod[pos]+carry+n1*n2, prod[pos] = val%10, carry = val/10.
	 * and then skip zeros in the "beginning" number.
	 * @param String num1, String num2
	 * @return String
	 * Time: O(m * n)
	 * Space: O(m + n)
	 */
	public String multiplyStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "0";
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                res[i + j + 1] += a * b;
                if (res[i + j + 1] >= 10) {
                    res[i + j] += res[i + j + 1] / 10;
                    res[i + j + 1] %= 10; 
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            sb.append(res[i]);
        }
        for (int i = 0; i < sb.length(); i++) {    //  case: "9133" "0"
            if (sb.charAt(i) != '0') return sb.toString().substring(i);
        }
        return "0";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings result = new MultiplyStrings();
		System.out.println(result.multiplyStrings("23", "764")); // 17572
	}

}
