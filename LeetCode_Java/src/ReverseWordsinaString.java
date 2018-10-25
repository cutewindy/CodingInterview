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
	 * Method3: Two times reverse + clean spaces
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseWordsinaStringII(String s) {	
        if (s == null || s.length() == 0) return s;
        char[] S = s.toCharArray();
        reverse(S, 0, S.length - 1);
        for (int start = 0, end = 0; end < S.length;) {
            while (end < S.length && S[end] != ' ') {
                end++;
            }
            reverse(S, start, end - 1);
            start = end + 1;
            end = start;
        }
        return cleanSpace(S);
    }
    
    private String cleanSpace(char[] S) {
        int start = 0;
        int end = 0;
        while (end < S.length) {
            if (S[end] != ' ' || start == 0 || S[start - 1] != ' ') {
                S[start] = S[end];
                start++;
            }
            end++;
        }
        return String.valueOf(S).substring(0, start).trim(); // take care: eg: " "
    }
    
    private void reverse(char[] S, int start, int end) {
        if (start >= end) return;
        while (start < end) {
            swap(S, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(char[] S, int i, int j) {
        char temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }
    
	
	/**
	 * Method2: using split function
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String reverseWordsinaStringI(String s) {
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
	public String reverseWordsinaString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String result = new String();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				String word = new String();
				while (i < s.length() && s.charAt(i) != ' ') {
					word += s.charAt(i);
					i++;
				}
				if (result.length() == 0) {
					result = word;
				}
				else {
					result = word + ' ' + result;
				}
			}			
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaString result = new ReverseWordsinaString();
		String str = "  the sky  is blue   ";
		System.out.println(str.replace(' ', '_'));
		System.out.println("*" + result.reverseWordsinaString("  the sky  is blue   ").replace(' ', '_') + "*");
		System.out.println("*" + result.reverseWordsinaString("    ").replace(' ', '_') + "*");
		System.out.println("*" + result.reverseWordsinaStringI("  the sky  is blue   ").replace(' ', '_') + "*");
		System.out.println("*" + result.reverseWordsinaStringI("    ").replace(' ', '_') + "*");
		System.out.println("*" + result.reverseWordsinaStringII("  the sky  is blue   ").replace(' ', '_') + "*");
		System.out.println("*" + result.reverseWordsinaStringII("    ").replace(' ', '_') + "*");
	}

}
