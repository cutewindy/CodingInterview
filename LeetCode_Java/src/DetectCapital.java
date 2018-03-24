/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 1. All letters in this word are capitals, like "USA".
 * 2. All letters in this word are not capitals, like "leetcode".
 * 3. Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * @author wendi
 *
 */
public class DetectCapital {
	
	/**
	 * Method2:	check the number of capital
	 * @param String word
	 * @return boolean
	 * Time: O(n)
	 * SpacE: O(1)
	 */
	public boolean detectCapitalI(String word) {
		if (word == null || word.length() <= 1) return true;
		int numUpper = 0;
		char[] w = word.toCharArray();
		for (char c: w) {
			if (Character.isUpperCase(c)) numUpper++;
		}
		if (numUpper == 1 && Character.isUpperCase(w[0])) return true; // case 3
		return numUpper == 0 || numUpper == w.length;  // case 1 or 2
	}
	
	/**
	 * Method1: Brute Force
	 * @param String word
	 * @return boolean
	 * Time: O(n)
	 * SpacE: O(1)
	 */
	public boolean detectCapital(String word) {
		if (word == null || word.length() <= 1) return true;
		char[] w = word.toCharArray();
		boolean C1 = Character.isUpperCase(w[0]);
		boolean C2 = Character.isUpperCase(w[1]);
		if (!C1 && C2) return false;   // case 4: bA
		boolean C3 = C1 && C2 ? true : false;  
		for (int i = 2; i < w.length; i++) {
			if (C3 && !Character.isUpperCase(w[i])   // not satisfied case 1
			 || !C3 && Character.isUpperCase(w[i])) return false;  // not satisfied case 2or3
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectCapital result = new DetectCapital();
		System.out.println(result.detectCapital("USA"));
		System.out.println(result.detectCapital("FlaG"));
		System.out.println(result.detectCapitalI("USA"));
		System.out.println(result.detectCapitalI("FlaG"));
	}

}
