import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the 
 * list of banned words.  It is guaranteed there is at least one word that isn't banned, and that 
 * the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the 
 * paragraph are not case sensitive.  The answer is in lowercase.
 * Example:
 * Input: 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation: 
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the 
 * paragraph. 
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"), 
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * Note:
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have 
 * uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * Different words in paragraph are always separated by a space.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 * @author wendi
 *
 */
public class MostCommonWord {
	
	/**
	 * map + set
	 * @param String paragraph, String[] banned
	 * @return String
	 * Time: O(m+n)
	 * Space: O(m+n)
	 */
	public String mostCommonWord(String paragraph, String[] banned) {
		if (paragraph == null || paragraph.length() == 0) return "";
		String[] words = paragraph.replaceAll("[^a-zA-Z\\s]", "").toLowerCase().trim().split("\\s+");
		System.out.println(Arrays.toString(words));
		Set<String> set = new HashSet<>();
		for (String str: banned) set.add(str);
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		String res = "";
		for (String word: words) {
			if (set.contains(word)) continue;
			map.put(word, map.getOrDefault(word, 0) + 1);
			if (map.get(word) > max) {
				max = map.get(word);
				res = word;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostCommonWord result = new MostCommonWord();
		System.out.println(result.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
	}

}
