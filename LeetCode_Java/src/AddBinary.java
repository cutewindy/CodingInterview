/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * @author wendi
 *
 */
public class AddBinary {
	/**
	 * From end to start add char one by one, use carry to record the carry bit
	 * @param String a, String b
	 * @return String
	 * Time: O(n)  n is the longest length of a and b
	 * Space: O(1)
	 */
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}
		else if (b == null || b.length() == 0) {
			return a;
		}
		String result = new String();
		int iA = a.length() - 1;
		int iB = b.length() - 1;
		int carry = 0;
		while (carry != 0 || iA >= 0 || iB >= 0) {
			int numA = iA >= 0 ? a.charAt(iA--) - '0' : 0;
			int numB = iB >= 0 ? b.charAt(iB--) - '0' : 0;
			int sum = numA + numB + carry;
			result = String.valueOf(sum & 1) + result;
			carry = sum >> 1;	
//			iA--;
//			iB--;
		}		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary result = new AddBinary();
		System.out.println(result.addBinary("1010", "1011"));
	}

}
