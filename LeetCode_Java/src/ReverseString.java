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
	public void reverseStringI(char[] s) {
        if (s == null || s.length == 0) return;
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            swap(s, l++, r--);
        }
    }
    
    private void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
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
 		result.reverseStringI(new char[] {'h', 'e', 'l', 'l', 'o'});
	}

}
