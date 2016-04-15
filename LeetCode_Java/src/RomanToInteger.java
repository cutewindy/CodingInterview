import java.util.HashMap;
//Given a roman numeral, convert it to an integer.
//
//Input is guaranteed to be within the range from 1 to 3999.

public class RomanToInteger {
	/**
	 * 
	 * @param s Roman representation
	 * @return an integer
	 * time: O(n), n means the length of string
	 * space: O(1)
	 */
	public int romanToInteger(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		HashMap<Character, Integer> symbols = new HashMap<Character, Integer>();
		symbols.put('I', 1);
		symbols.put('V', 5);
		symbols.put('X', 10);
		symbols.put('L', 50);
		symbols.put('C', 100);
		symbols.put('D', 500);
		symbols.put('M', 1000);

		result = symbols.get(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			if (symbols.get(s.charAt(i)) >= symbols.get(s.charAt(i + 1))) {
				result += symbols.get(s.charAt(i));
			}
			else {
				result -= symbols.get(s.charAt(i));
			}
		}		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToInteger result = new RomanToInteger();
		System.out.println(result.romanToInteger("XCVI"));
	}

}
