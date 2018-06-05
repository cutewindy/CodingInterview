import java.util.Arrays;

/**
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * Follow up:
 * Could you solve it using only O(1) extra space
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * Example 2:
 * Input:
 * ["a"]
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation:
 * Nothing is replaced.
 * Example 3:
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 * @author wendi
 *
 */
public class StringCompression {
	
	/**
	 * Tow points
	 * We will use separate pointers read and write to mark where we are reading and writing from. 
	 * Both operations will be done left to right alternately: we will read a contiguous group of 
	 * characters, then write the compressed version to the array. At the end, the position of the 
	 * write head will be the length of the answer that was written.
	 * @param char[] chars
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int stringCompression(char[] chars) {
		if (chars == null || chars.length == 0) return 0;
		int write = 0;
		char anchor = chars[0];
		int count = 0;
		for (int read = 0; read <= chars.length; read++) {
			if (read != chars.length && chars[read] == anchor) count++;
			else {
				chars[write++] = anchor;
				if (count != 1) {
					for (char c: (count + "").toCharArray()) chars[write++] = c;
				}
				if (read != chars.length) anchor = chars[read];
				count = 1;
			}
		}
		System.out.println(Arrays.toString(chars));
		return write;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompression result = new StringCompression();
		System.out.println(result.stringCompression(new char[] {'a','b','b','b','b','c','c','d'}));
	}

}
