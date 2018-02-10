/**
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * @author wendi
 *
 */
public class ReverseString {
	
	/** 
	 * Method2: Two Pointers: transform string to char array, and then do it in-place
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseStringI(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0;
        int end = s.length() - 1;;
        char[] S = s.toCharArray();
        while (start < end) {
            char temp = S[start];
            S[start] = S[end];
            S[end] = temp;
            start++;
            end--;
        }
//        return String.valueOf(S);
        return new String(S);
	}
	
	/**
	 * Method1: use the reverse() function of StringBuilder()
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder result = new StringBuilder(s);
		return String.valueOf(result.reverse());
	}

 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		ReverseString result = new ReverseString();
 		System.out.println(result.reverseString("hello"));
 		System.out.println(result.reverseStringI("hello"));
	}

}
