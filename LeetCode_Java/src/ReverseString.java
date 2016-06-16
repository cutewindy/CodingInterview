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
	
	public String reverseStringI(String s) {
//		if (s == null || s.length() == 0) {
//			return s;
//		}
//		String result = new String();
//		for (int i = s.length() - 1; i >= 0; i--) {
//			result += String.valueOf(s.charAt(i));
//		}
//		return result;
		
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0;
        int end = s.length() - 1;;
        char[] array = s.toCharArray();
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(array);
	}

 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		ReverseString result = new ReverseString();
 		System.out.println(result.reverseString("hello"));
 		System.out.println(result.reverseStringI("hello"));
	}

}
