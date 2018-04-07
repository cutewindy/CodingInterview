/**
 * Given an integer, return its base 7 string representation.
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 * @author wendi
 *
 */
public class Base7 {
	
	
	/**
	 * 
	 * @param int num
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String base7(int num) {
		if (num == 0) return "0";
		StringBuilder result = new StringBuilder();
		boolean negative = false;
		if (num < 0) {
			negative = true;
			num = -num;
		}
		while (num != 0) {
			result.append(num % 7);
			num /= 7;
		} 
		if (negative) result.append("-");
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base7 result = new Base7();
		System.out.println(result.base7(100));
		System.out.println(result.base7(-7));
		System.out.println(result.base7(0));
		System.out.println(result.base7(-8));
	}

}
