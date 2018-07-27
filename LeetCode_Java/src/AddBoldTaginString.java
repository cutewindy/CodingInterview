/**
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and 
 * </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to 
 * wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold 
 * tags are consecutive, you need to combine them.
 * Example 1:
 * Input: 
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * Example 2:
 * Input: 
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * Note:
 * 1. The given dict won't contain duplicates, and its length won't exceed 100.
 * 2. All the strings in input have length in range [1, 1000].
 * @author wendi
 *
 */
public class AddBoldTaginString {

	/**
	 * Same problem with "758 Bold Words in String"
	 * @param String s, String[] dict
	 * @return String
	 * Time: O(m*n) m = dict.length, n = s.length()
	 * Space: O(n)
	 */
	public String addBoldTaginString(String s, String[] dict) {
		if (s == null || s.length() == 0 || dict == null || dict.length == 0) return s;
		
		boolean[] marked = new boolean[s.length()];
		for (String word: dict) {
			mark(s, word, marked);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (marked[i] && (i == 0 || !marked[i - 1])) sb.append("<b>");
			sb.append(s.charAt(i));
			if (marked[i] && (i == s.length() - 1 || !marked[i + 1])) sb.append("</b>");
		}
		
		return sb.toString();
	}
	
	private void mark(String s, String word, boolean[] marked) {
		if (word == null || word.length() == 0) return;
		int start = 0;
		while (start < s.length()) {
			start = s.indexOf(word, start);
			if (start < 0) return;
			for (int i = start; i < start + word.length(); i++) {
				marked[i] = true;
			}
			start++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBoldTaginString result = new AddBoldTaginString();
		System.out.println(result.addBoldTaginString("aaabbcc" , new String[] {"aaa","aab","bc"}));
	}

}
