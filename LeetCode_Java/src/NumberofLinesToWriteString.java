import java.util.Arrays;

/**
 * We are to write the letters of a given string S, from left to right into lines. Each line has 
 * maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 
 * units, it is written on the next line. We are given an array widths, an array where widths[0] is 
 * the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * Now answer two questions: how many lines have at least one character from S, and what is the width 
 * used by the last such line? Return your answer as an integer list of length 2.
 * Example :
 * Input: 
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3, 60]
 * Explanation: 
 * All letters have the same length of 10. To write all 26 letters,
 * we need two full lines and one line with 60 units.
 * Example :
 * Input: 
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * Output: [2, 4]
 * Explanation: 
 * All letters except 'a' have the same length of 10, and 
 * "bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
 * For the last 'a', it is written on the second line because
 * there is only 2 units left in the first line.
 * So the answer is 2 lines, plus 4 units in the second line.
 * Note:
 * 1.The length of S will be in the range [1, 1000].
 * 2.S will only contain lowercase letters.
 * 3.widths is an array of length 26.
 * 4.widths[i] will be in the range of [2, 10].
 * @author wendi
 *
 */
public class NumberofLinesToWriteString {
	
	
	/**
	 * Brute force:
	 * If the space w of the next character in S fits our current line, we will add it. Otherwise, 
	 * we will start a new line, and use w space to put that character on the next line.
	 * @param int[] widths, String S
	 * @return int[]
	 * Time; O(n)
	 * Space: O(1)
	 */
	public int[] numberofLinesToWriteString(int[] widths, String S) {
		if (S == null || S.length() == 0) return new int[2];
		int lines = 0;
		int width = 0;
		char[] s = S.toCharArray();
		for (char c: s) {
			width += widths[c - 'a'];
			if (width > 100) {
				lines++;
				width = widths[c - 'a'];
			}
		}
		return new int[] {lines + 1, width};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofLinesToWriteString result = new NumberofLinesToWriteString();
		System.out.println(Arrays.toString(result.numberofLinesToWriteString(
				new int[] {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
				"bbbcccdddaaa")));
	}

}
