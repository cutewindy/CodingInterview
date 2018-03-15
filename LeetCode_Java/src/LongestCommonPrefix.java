/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author wendi
 *
 */
public class LongestCommonPrefix {
	
	/**
	 * Method3: using first str as prefix, then compare each word by word
	 * @param String[] strs
	 * @return String
	 * Time: O(nk)
	 * Space: O(1)
	 */
    public String longestCommonPrefixII(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int index = 0;
        for (; index < strs[0].length(); index++) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[0].charAt(index) != strs[i].charAt(index)) {
                    return index == 0 ? "" : strs[0].substring(0, index);
                }
            }            
        }
        return strs[0].substring(0, index);
    }
	
	
	/**
	 * Method2: start from the first one, compare prefix with next string and update prefix, until end;
	 * @param String strs
	 * @return String
	 * Time: O(nk) k is the min length of string in array
	 * Space: O(1)
	 */
	public String longestCommonPrefixI(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
				j++;
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
	
	
	/**
	 * Method1: start from the first char, compare it with all string, and then the second char.
	 * Find min length in strs, make sure that the index < minLength.
	 * @param array of string
	 * @return String 
	 * Time: O(nk) k is the min length of string in array
	 * Space: O(1)
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String result = new String();
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			minLength = Math.min(strs[i].length(), minLength);
		}
		for (int index = 0; index < minLength; index++) {
			boolean equal = true;
			char c = strs[0].charAt(index);
			for (int i = 1; i < strs.length; i++) {
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
		}	
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix result = new LongestCommonPrefix();
		System.out.println(result.longestCommonPrefix(new String[] {"ABCD", "ABED", "ABCF"}));
		System.out.println(result.longestCommonPrefix(new String[] {""}));
		System.out.println(result.longestCommonPrefixI(new String[] {"ABCD", "ABED", "ABCF"}));
		System.out.println(result.longestCommonPrefixI(new String[] {""}));
		System.out.println(result.longestCommonPrefixII(new String[] {"ABCD", "ABED", "ABCF"}));
		System.out.println(result.longestCommonPrefixII(new String[] {""}));
	}

}
