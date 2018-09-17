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
		if (num1 == null || num1.length() == 0) return num2;
		if (num2 == null || num2.length() == 0) return num1;
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int i = array1.length - 1, j = array2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = i >= 0 ? array1[i] - '0' : 0;
            int b = j >= 0 ? array2[j] - '0' : 0;
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddStrings result = new AddStrings();
		System.out.println(result.addString("123", "1278"));
		System.out.println(result.addString("1", "9"));
	}

}
