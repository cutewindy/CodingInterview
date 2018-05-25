/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s 
 * complement method is used.
 * Note:
 * 1. All letters in hexadecimal (a-f) must be in lowercase.
 * 2. The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented 
 * by a single zero character '0'; otherwise, the first character in the hexadecimal string will not 
 * be the zero character.
 * 3. The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * 4. You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * Input: 26
 * Output: "1a"
 * Example 2:
 * Input: -1
 * Output: "ffffffff"
 * 
 * Tags: Bit Manipulation
 * @author wendi
 *
 */
public class ConvertaNumbertoHexadecimal {
	
	/**
	 * Bit manipulation: each time we take a look at the last four digits of binary version of the 
	 * input, and maps that to a hex char shift the input to the right by 4 bits, do it again until 
	 * input becomes 0.
	 * @param int num
	 * @return String
	 * Time: O(8)
	 * Space: O(1)
	 */
	public String convertaNumbertoHexadecimal(int num) {
		if (num == 0) return "0";
		StringBuilder result = new StringBuilder();
		String[] map = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
		while (num != 0) {
			result.append(map[num & 0xf]);   // result.append(map[num & 15]);
			num >>>= 4;
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertaNumbertoHexadecimal result = new ConvertaNumbertoHexadecimal();
		System.out.println(result.convertaNumbertoHexadecimal(-1));
	}

}
