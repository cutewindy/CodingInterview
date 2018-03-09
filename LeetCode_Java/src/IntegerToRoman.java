/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author wendi
 *
 */

public class IntegerToRoman {
	
	/**
	 * Math:
	 * @param int num
	 * @return String
	 * Time: O(1)
	 * Space: O(1)
	 */
	public String integerToRomanI(int num) {
		String[] M = {"", "M", "MM", "MMM"};
		String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		return M[num / 1000] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];
	}
	
	/**
	 * Method1: Math
	 * find the math function, different value in different field
	 * @param num The integer
	 * @return Roman representation
	 * time: O(1)
	 * space: O(1)
	 */
	public String integerToRoman(int num) {
		// define the boundary
		if (num <= 0 || num >= 4000) {
			return "";
		}
		
		// init
		StringBuilder result = new StringBuilder();
		                 //  1    5    10   50   100  500  1000
		String[] symbols = {"I", "V", "X", "L", "C", "D", "M"};
		int digit = 0;
		int scale = 1000;
		
		// convert integer to Roman
		for (int i = 6; i >= 0; i -= 2) {
			digit = num / scale;
			if (digit > 0) {
				if (1 <= digit && digit <= 3) {
					for (int j = 0; j < digit; j ++) {
						result.append(symbols[i]);
					}
				}
				else if (digit == 4) {
					result.append(symbols[i]);
					result.append(symbols[i + 1]);
				}
				else if (digit == 5) {
					result.append(symbols[i + 1]);
				}
				else if (6 <= digit && digit <= 8) {
					result.append(symbols[i + 1]);
					for (int j = 0; j < digit - 5; j ++) {
						result.append(symbols[i]);
					}
				}
				else if (digit == 9) {
					result.append(symbols[i]);
					result.append(symbols[i + 2]);
				}
			}			
			num %= scale;
			scale /= 10;
		}

		return result.toString();
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman result = new IntegerToRoman();
		System.out.println(result.integerToRoman(2976));
		System.out.println(result.integerToRomanI(2976));
	}

}
