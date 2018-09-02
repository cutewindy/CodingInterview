package wePay;
/**
 * “asv123bjh^-25j6”给这样一个string，把里面的数加起来（123-25+6），之后讨论overflow等问题
 * @author wendi
 *
 */
public class AddNumberinaString {
	
	/**
	 * Brute force
	 * @param String str
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int addNumberinaString(String str) {
		if (str == null || str.length() == 0) return 0;
		char[] Str = str.toCharArray();
		int res = 0;
		int sign = 1;
		for (int i = 0; i < Str.length;) {
			if (Character.isDigit(Str[i])) {
				int num = 0;
				int j = i;
				while (j < Str.length && Character.isDigit(Str[j])) {
					num = num * 10 + Str[j] - '0';
					j++;
				}
				res += sign * num;
				sign = 1;
				i = j;
			}
			else {
				if (Str[i] == '+') sign = 1;
				else if (Str[i] == '-') sign = -1;
				i++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddNumberinaString result = new AddNumberinaString();
		System.out.println(result.addNumberinaString("asv123bjh^-25j2"));
		System.out.println(result.addNumberinaString("12abc3def5"));
		System.out.println(result.addNumberinaString("10abc-5ghi3xyz"));
	}

}
