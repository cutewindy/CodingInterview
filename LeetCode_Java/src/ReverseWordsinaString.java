/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Tags: String
 * @author wendi
 * 
 */

public class ReverseWordsinaString {
	
	/**
	 * Method2: using split function
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseWordsinaString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder result = new StringBuilder();
		String[] array = s.split(" ");
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i].length() != 0) {
				result.append(array[i]).append(" ");  
			}
		}
		// remove the last " " and care about case "      "
		return result.length() == 0 ? "" : result.toString().substring(0, result.length() - 1);
	}
	
	
	/**
	 * Method1: judge the charAt one by one
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
//	public String reverseWordsinaString(String s) {
//		if (s == null || s.length() == 0) {
//			return "";
//		}
//		String result = new String();
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) != ' ') {
//				String word = new String();
//				while (i < s.length() && s.charAt(i) != ' ') {
//					word += s.charAt(i);
//					i++;
//				}
//				if (result.length() == 0) {
//					result = word;
//				}
//				else {
//					result = word + ' ' + result;
//				}
//			}			
//		}
//		return result;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaString result = new ReverseWordsinaString();
		String str = "  the sky  is blue   ";
		System.out.println(str.replace(' ', '_'));
		System.out.println(result.reverseWordsinaString("  the sky  is blue   ").replace(' ', '_') + "*");
		System.out.println(result.reverseWordsinaString("    ") + "*");

	}

}
