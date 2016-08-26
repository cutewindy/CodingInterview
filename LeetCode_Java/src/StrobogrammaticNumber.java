import java.util.Arrays;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * Tags: HashTable, Math
 * @author wendi
 *
 */
public class StrobogrammaticNumber {

	/**
	 * Two Pointers: (Array based) strobogrammatic number: 0, 1, 6, 8, 9
	 * @param String num
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean strobogrammaticNumber(String num) {
		if (num == null || num.length() == 0) return true;
		int start = 0;
		int end = num.length() - 1;
		char[] nums = num.toCharArray();
		char[] map = new char[10];
		Arrays.fill(map, 'x');
		map[0] = '0';
		map[1] = '1';
		map[6] = '9';
		map[8] = '8';
		map[9] = '6';
		while (start <= end) {
			if (map[nums[start] - '0'] != nums[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrobogrammaticNumber result = new StrobogrammaticNumber();
		System.out.println(result.strobogrammaticNumber("6081809"));
		System.out.println(result.strobogrammaticNumber("6"));
		System.out.println(result.strobogrammaticNumber("69"));
		System.out.println(result.strobogrammaticNumber("25"));
	}

}
