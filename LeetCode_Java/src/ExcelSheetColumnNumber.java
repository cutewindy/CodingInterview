/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:

	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28
 * Tag: Math
 * @author wendi
 */
public class ExcelSheetColumnNumber {
	/**
	 * In decimalism, from high-order digit to low-order digit, res = res * 10 + d. (res initialized to 0).
	 * @param String s
	 * @return int 
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int excelSheetColumnNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
//		int d = (int)'A' - 1;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < 'A' || c > 'Z') {
				return 0;
			}
//			result = 26 * result + (int)c - d;
			result = result * 26 + (int)(c - 'A') + 1;
		}			
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnNumber result = new ExcelSheetColumnNumber();
		System.out.println(result.excelSheetColumnNumber("AAA"));
	}

}
