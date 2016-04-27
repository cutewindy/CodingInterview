/**
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * @author wendi
 *
 */
public class ReverseString {
	/**
	 * use the reverse() function of StringBuilder()
	 * @param s
	 * @return
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String reverseString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder(s);
//		for (int i = s.length() - 1; i >=0; i--) {
//			result.append(s.charAt(i));
//		}		
		return String.valueOf(result.reverse());
	}

 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		ReverseString result = new ReverseString();
 		System.out.println(result.reverseString("hello"));
	}

}
