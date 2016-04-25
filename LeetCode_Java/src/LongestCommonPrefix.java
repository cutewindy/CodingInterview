/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author wendi
 *
 */
public class LongestCommonPrefix {
	
	/**
	 * start from the first char, compare it with all string, and then the second char
	 * find min length in strs, make sure that the index < minLength
	 * @param array of string
	 * @return String 
	 * Time: O(n * Min.length in list)
	 * Space: O(1)
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String result = new String();
		int n = strs.length;
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			minLength = Math.min(strs[i].length(), minLength);
		}
		int index = 0;
		while (index < minLength) {
			boolean equal = true;
			char c = strs[0].charAt(index);
			for (int i = 1; i < n; i++) {
				if (strs[i].charAt(index) != c) {
					equal = false;
					break;
				}
			}
			if (equal) {
				result += String.valueOf(c);
			}
			else {
				break;
			}
			index++;
		}	
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix result = new LongestCommonPrefix();
		String[] strs = {"ABCDE", "ABEFGEE", "ACEFEGS"};
//		String[] strs = {""};
		System.out.println(result.longestCommonPrefix(strs));

	}

}
