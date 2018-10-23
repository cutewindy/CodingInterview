/**
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes 
 * with most significant 2 bits being 10.
 * This is how the UTF-8 encoding would work:
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 * Note:
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to 
 * store the data. This means each integer represents only 1 byte of data.
 * Example 1.
 * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
 * Return true.
 * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 * Example 2:
 * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
 * Return false.
 * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 * @author wendi
 *
 */
public class UTF_8Validation {
	
	/**
	 * Bit
	 * @param int[] data
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean uTF_8Validation(int[] data) {
        if (data == null || data.length == 0) return false;
        int i = 0;
        while (i < data.length) {
            int cnt = 0;
            if ((data[i] >> 7) == 0) cnt = 0;            // 0000 0000-0000 007F | 0xxxxxxx
            else if ((data[i] >> 5) == 0b110) cnt = 1;   // 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
            else if ((data[i] >> 4) == 0b1110) cnt = 2;  // 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
            else if ((data[i] >> 3) == 0b11110) cnt = 3; // 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
            else return false;
            i++;
            while (cnt-- > 0) {
                if (i >= data.length || (data[i] >> 6) != 0b10) return false;
                i++;
            }
        }
        return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UTF_8Validation result = new UTF_8Validation();
		System.out.println(result.uTF_8Validation(new int[] {197, 130, 1}));
		System.out.println(result.uTF_8Validation(new int[] {235, 140, 4}));
	}

}
