/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * Tags: String
 * @author wendi
 *
 */
public class ZigZagConversion {

	/**
	 * Math:  letters in each time: 2numRows-2
	 * return times: count=s.length/(2numRows-2)
	 * In each time, if row=0 or row=numRows, result add only once, otherwise, add twice.
	 * @param String s, int numRows
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String zigZagConversion(String s, int numRows) {
		StringBuilder result = new StringBuilder();
		if (s == null || s.length() == 0 || numRows < 2) {
			return s;
		}
		int count = s.length() / (2 * numRows - 2) + 1;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < count; j++) {
				if (i == 0 || i == numRows - 1) {
					int index = i + j * (2 * numRows - 2);
					if (index < s.length()) {
						result.append(s.charAt(index));
					}
				}
				else {
					int index1 = i + j * (2 * numRows - 2);
					int index2 = 2 * numRows - 2 - i + j * (2 * numRows - 2);
					if (index1 < s.length()) {
						result.append(s.charAt(index1));
					}
					if (index2 < s.length()) {
						result.append(s.charAt(index2));
					}
 				}
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion result = new ZigZagConversion();
		System.out.println(result.zigZagConversion("PAYPALISHIRING", 5));
	}

}
