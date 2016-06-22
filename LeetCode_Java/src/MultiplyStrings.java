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
		if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
			return "0";
		}
		int[] prod = new int[num1.length() + num2.length()];
		Arrays.fill(prod, 0);
		for (int i1 = num1.length() - 1; i1 >= 0; i1--) {
			int pos = 0;
			int carry = 0;
			for (int i2 = num2.length() - 1; i2 >= 0; i2--) {
				int n1 = (int) (num1.charAt(i1) - '0');
				int n2 = (int) (num2.charAt(i2) - '0');
				pos = i1 + i2 + 1;
//				System.out.println("n1: " + n1 + ", n2: " + n2);
				int value = prod[pos] + carry + n1 * n2;
//				System.out.println("value: " + value);
				prod[pos] = value % 10;
				carry = value / 10;
//				System.out.println("carry: " + carry);
//				System.out.println(prod[pos] + "     " + carry);
			}
			if (carry != 0) {
				prod[pos - 1] = carry;
			}
		}
		String result = new String();
		for (int p: prod) {
			result += String.valueOf(p);
		}
		while (result.charAt(0) == '0' && result.length() > 1) {
			result = result.substring(1);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings result = new MultiplyStrings();
		System.out.println(result.multiplyStrings("23", "764")); // 17572
	}

}
