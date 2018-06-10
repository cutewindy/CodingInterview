/**
 * Given two strings representing two complex numbers.
 * You need to return a string representing their multiplication. Note i2 = -1 according to the 
 * definition.
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong 
 * to the range of [-100, 100]. And the output should be also in this form.
 * @author wendi
 *
 */
public class ComplexNumberMultiplication {
	
	/**
	 * Brute force + regex
	 * @param String a, String b
	 * @return String
	 * Time: O(m+n)
	 * Space: O(1)
	 */
	public String complexNumberMultiplication(String a, String b) {
		String[] A = a.split("\\+|i");
		String[] B = b.split("\\+|i");
		return multiply(Integer.valueOf(A[0]), Integer.valueOf(A[1]), Integer.valueOf(B[0]), Integer.valueOf(B[1]));
	}
	
	private String multiply(int a, int b, int c, int d) {
		StringBuilder sb = new StringBuilder();
		sb.append(a * c - b * d).append("+").append(b * c + a * d).append("i");
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumberMultiplication result = new ComplexNumberMultiplication();
		System.out.println(result.complexNumberMultiplication("1+1i", "1+1i"));
	}

}
