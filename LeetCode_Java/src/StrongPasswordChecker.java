
/**
 * A password is considered strong if below conditions are all met:
 * 1. It has at least 6 characters and at most 20 characters.
 * 2. It must contain at least one lowercase letter, at least one uppercase letter, and at least one 
 * digit.
 * 3. It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." 
 * is strong, assuming other conditions are met).
 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM 
 * change required to make s a strong password. If s is already strong, return 0.
 * Insertion, deletion or replace of any one character are all considered as one change.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class StrongPasswordChecker {

	/**
	 * 
	 * @param String s
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int strongPasswordChecker(String s) {
		if (s == null) {
			return 0;
		}
		int result = 0;
		System.out.println("length: " + s.length());
		// 1. check number of characters
		int m = s.length();
		int add = 0;
		int delete = 0;
		if (m < 6) {
			add = 6 - m;
		}
		if (m > 20) {
			delete = m - 20;
		}
		if (add != 0) System.out.println("add: " + add);
		if (delete != 0) System.out.println("delete: " + delete);
		// 2 & 3
		char[] S = s.toCharArray();
		boolean hasLowChar = false;
		boolean hasUppChar = false;
		boolean hasDigit = false;
		char end = S[0];
		int count = 0;
		int repeat = 0;
		for (char c: S) {
			// 2. check lowercase letter, uppercase letter and digit
			if (Character.isLowerCase(c)) hasLowChar = true;
			if (Character.isUpperCase(c)) hasUppChar = true;
			if (Character.isDigit(c)) hasDigit = true;
			// 3. check three repeating digits
			if (c == end) {
				count++;
			}
			else {
				repeat += count / 3;
				end = c;
				count = 1;
			}
		}
		repeat += count / 3;
		int change = 0;
		if (!hasLowChar) change++;
		if (!hasUppChar) change++;
		if (!hasDigit) change++;
		System.out.println("change: " + change);
		System.out.println("repeat: "+ repeat);
		// 4. calculate the minimum changes
		if (m > 20) {
			result = Math.max(delete, repeat) + change;
		}
		else {
			result = Math.max(Math.max(add, change), repeat);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrongPasswordChecker result = new StrongPasswordChecker();
//		System.out.println(result.strongPasswordChecker("aaaaabbb"));
		System.out.println(result.strongPasswordChecker("1234567890123456Baaaaa"));
	}

}
