/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence 
 * of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 * @author wendi
 *
 */
public class NumberofSegmentsinaString {
	
	
	/**
	 * 
	 * @param String s
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int numberofSegmentsinaString(String s) {
		if (s == null || s.length() == 0) return 0;
		s = s.trim();
		if (s.length() == 0) return 0;
		return s.split("\\s+").length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofSegmentsinaString result = new NumberofSegmentsinaString();
		System.out.println(result.numberofSegmentsinaString("  a   b   c  "));
		System.out.println(result.numberofSegmentsinaString("         "));
	}

}
