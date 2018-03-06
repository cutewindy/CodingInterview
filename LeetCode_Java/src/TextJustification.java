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
		List<String> result = new ArrayList<>();
		int start = 0; // first word's index of line
		int end = 0;   // end - 1 is the last word's index of line
		while (start < words.length) {
			int count = 0;  // count how many words in a line
			int length = 0; // the length of words in a line
			while (end < words.length && length + count + words[end].length() <= maxWidth) {
				count += 1;
				length += words[end].length();
				end++;
			}
			StringBuilder sb = new StringBuilder();
			// check current line is middle line or last line
			if (end < words.length) {   // current line is middle line
				int space = count == 1 ? maxWidth - words[start].length() : (maxWidth - length) / (count - 1);
				int extraSpace = count == 1 ? maxWidth - words[start].length() : (maxWidth - length) % (count - 1);
				while (start < end) {
					sb.append(words[start]);
					for (int i = 0; i < space; i++) {
						sb.append(" ");
					}
					if (extraSpace-- > 0) {
						sb.append(" ");
					}
					
					start++;
				}
			}
			else {                      // current line is last line
				while (start < end) {
					sb.append(words[start]).append(" ");
					start++;
				}
				while (sb.length() < maxWidth) {
					sb.append(" ");
				}
			}
			result.add(sb.toString().substring(0, maxWidth));
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification result = new TextJustification();
		System.out.println(result.textJustification(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
		System.out.println(result.textJustification(new String[] {"a","b","c","d","e"}, 1));

	}

}
