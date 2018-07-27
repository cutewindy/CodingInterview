/**
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any 
 * letters between <b> and </b> tags become bold.
 * The returned string should use the least number of tags possible, and of course the tags should 
 * form a valid combination.
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". 
 * Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 * Note:
 * 1. words has length in range [0, 50].
 * 2. words[i] has length in range [1, 10].
 * 3. S has length in range [0, 500].
 * 4. All characters in words[i] and S are lowercase letters.
 *
 */
public class BoldWordsinString {
	
	
	/**
	 * The main idea is to use a boolean array to mark the words at the corresponding positions in S. 
	 * Then build the final string based on the marked positions.
	 * @param String[] words, String S
	 * @return String
	 * Time: O(m*n) m=words.length, n=S.length()
	 * Space: O(n)
	 */
	public String boldWordsinString(String[] words, String S) {
        if (words == null || words.length == 0) return S;
        
        boolean[] marked = new boolean[S.length()];
        for (String word: words) {
        	mark(word, S, marked);
        } 
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
        	if (marked[i] && (i == 0 || !marked[i - 1])) sb.append("<b>");
        	sb.append(S.charAt(i));
        	if (marked[i] && (i == S.length() - 1 || !marked[i + 1])) sb.append("</b>");
        }
        
        return sb.toString();
    }
	
	private void mark(String word, String S, boolean[] marked) {
		int start = 0;
		while (start < S.length()) {
			start = S.indexOf(word, start);
			if (start < 0) return;
			for (int i = start; i < start + word.length(); i++) {
				marked[i] = true;
			}
			start++;
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoldWordsinString result = new BoldWordsinString();
//		System.out.println(result.boldWordsinString(new String[] {"ab", "bc"}, "aabcd"));
		System.out.println(result.boldWordsinString(new String[] {"ccb","b","d","cba","dc"}, "eeaadadadc"));
	}

}
