/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class ExcelSheetColumnTitle {

	/**
	 * Math: Base 26. char c = (char) ((digit - 1) / 26 + 'A');
	 * @param int n
	 * @return String
	 * Time: O(n/26 + 1), n is the int num given.
	 * Space:O(1)
	 */
	public String excelSheetColumnTitle(int n) {
        if (n == 0) return "";
        String res = "";
        while (n != 0) {
            res = (char) (((n - 1) % 26)  + 'A') + res;
            n = (n - 1) / 26;
        }
        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnTitle result = new ExcelSheetColumnTitle();
		System.out.println(result.excelSheetColumnTitle(26));
	}

}
