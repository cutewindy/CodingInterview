import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L 
 * characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each 
 * line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces 
 * on a line do not divide evenly between words, the empty slots on the left will be assigned more 
 * spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * @author wendi
 *
 */
public class TextJustification {
	
	/**
	 * Brute force
	 * @param String[] words, int maxWidth
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(l)
	 */
	public List<String> textJustification(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        for (int start = 0, end = 0; start < words.length;) {
            int wordsLength = 0;   // total length of words
            while (end < words.length && wordsLength + words[end].length() + end - start <= maxWidth) {
                wordsLength += words[end].length();
                end++;
            }
            if (end != words.length) {
                res.add(getLine(words, start, end, wordsLength, maxWidth));  // not include end
            } 
            else {
                res.add(getLastLine(words, start, end, maxWidth));  // not include end
            }
            start = end;
        }
        return res;
    }
    
    private String getLine(String[] words, int start, int end, int wordsLength, int maxWidth) {
        int space = (start + 1 == end) ? (maxWidth - wordsLength) : ((maxWidth - wordsLength) / (end - start - 1));  // take care zero
        int extraSpace = (start + 1 == end) ? 0 : ((maxWidth - wordsLength) % (end - start - 1)); // take care zero
        StringBuilder spaceSb = new StringBuilder();
        for (int i = 0; i < space; i++) spaceSb.append(" ");
        StringBuilder resSb = new StringBuilder();
        for (int i = start; i < end; i++) {
        	resSb.append(words[i]).append(spaceSb);
            if (extraSpace-- > 0) resSb.append(" ");
        }
        return resSb.toString().substring(0, maxWidth);
    }
    
    private String getLastLine(String[] words, int start, int end, int maxWidth) {
        StringBuilder resSb = new StringBuilder();
        for (int i = start; i < end; i++) {
        	resSb.append(words[i]).append(" ");
        }
        int space = maxWidth - resSb.length();
        for (int i = 0; i < space; i++) {
        	resSb.append(" ");
        }
        return resSb.toString().substring(0, maxWidth);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification result = new TextJustification();
		System.out.println(result.textJustification(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
		System.out.println(result.textJustification(new String[] {"a","b","c","d","e"}, 1));

	}

}
