/**
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * 1. The length of both num1 and num2 is < 5100.
 * 2. Both num1 and num2 contains only digits 0-9.
 * 3. Both num1 and num2 does not contain any leading zero.
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class AddStrings {
	
	/**
	 * Brute Force
	 * @param String num1, String num2
	 * @return String
	 * Time: O(max(n1, n2))
	 * Space: O(n1 + n2)
	 */
	public String addString(String num1, String num2) {
		if (num1 == null || num1.length() == 0) {
			return num2;
		}
		if (num2 == null || num2.length() == 0) {
			return num1;
		} 
		StringBuilder result = new StringBuilder();
		char[] Num1 = num1.toCharArray();
		char[] Num2 = num2.toCharArray();
		int i = Num1.length - 1;
		int j = Num2.length - 1;
		int carry = 0;
		while (i >= 0 && j >= 0) {
			int sum = Num1[i] - '0' + Num2[j] - '0' + carry;
			result.append(sum % 10);
			carry = sum / 10;
			i--;
			j--;
		}
		while (i >= 0) {
			int sum = Num1[i] - '0' + carry;
			result.append(sum % 10);
			carry = sum / 10;
			i--;
		}
		while (j >= 0) {
			int sum = Num2[j] - '0' + carry;
			result.append(sum % 10);
			carry = sum / 10;
			j--;
		}
		if (carry > 0) {   // Don't forget
			result.append(carry);
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddStrings result = new AddStrings();
		System.out.println(result.addString("123", "1278"));
		System.out.println(result.addString("1", "9"));
	}

}
