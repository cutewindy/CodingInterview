/**
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements 
 * up front before implementing one.
 * 
 * Tags: Math, String
 * @author wendi
 *
 */
public class ValidNumber {
	
	/**
	 * Method2: Regex
	 * int: [0-9]+[.]?
	 * float: [0-9]*[.][0-9]+
	 * scientific: [e][+-]?[0-9]+
	 * a valid number should be an int or float, with or without scientific
	 * @param String s
	 * @return boolean
	 * Time: O(1)
	 * Space: O(1)
	 */
	public boolean validNumberI(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		String pattern = "^\\s*[+-]?(([0-9]+[.]?)|([0-9]*[.][0-9]+))([e][+-]?[0-9]+)?\\s*$";
		return s.matches(pattern);
	}

	/**
	 * Method1: Brute Force using flag
	 * We start with trimming.
	 * 1. We can only see + and - in the beginning and after an e
	 * 2. We can only see . if we didn't see e or ..
	 * 3. We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
	 * 4. If we see [0-9] we reset the number flags.
	 * 5. Any other character break the validation.
	 * At the and it is only valid if there was at least 1 number and if we did see an e then a 
	 * number after it as well.
	 * @param String s
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean validNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		boolean hasE = false;
		boolean hasDot = false;
		boolean numBefore = false;
		boolean numAfter = false;
		s = s.trim();
		char[] S = s.toCharArray();
		for (int i = 0; i < S.length; i++) {
			if (S[i] == '+' || S[i] == '-') {
				if (i != 0 && S[i - 1] != 'e') return false;
			}
			else if (S[i] == '.') {
				if (hasDot || hasE) return false;
				hasDot = true;
			}
			else if (S[i] == 'e') {
				if (hasE || !numBefore) return false;
				hasE = true;
				numAfter = false;
			}
			else if ('0' <= S[i] && S[i] <= '9') {
				numBefore = true;
				numAfter = true;
			}
			else {
				return false;
			}
		}
		return numBefore && numAfter;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber result = new ValidNumber();
		System.out.println(result.validNumber(" 00.504e-6"));
		System.out.println(result.validNumberI("-2.3e10"));
	}

}
