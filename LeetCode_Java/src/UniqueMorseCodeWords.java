import java.util.HashSet;
import java.util.Set;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of 
 * dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
 * ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each 
 * letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation 
 * "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation: 
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * There are 2 different transformations, "--...-." and "--...--.".
 * Note:
 * 1. The length of words will be at most 100.
 * 2. Each words[i] will have length in range [1, 12].
 * 3. words[i] will only consist of lowercase letters.
 * @author wendi
 *
 */
public class UniqueMorseCodeWords {
	
	
	/**
	 * Set
	 * @param String[] words
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int uniqueMorseCodeWords(String[] words) {
		if (words == null || words.length == 0) return 0;
		String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
			"--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		Set<String> set = new HashSet<>();
		for (String word: words) {
			StringBuilder sb = new StringBuilder();
			for (char c: word.toCharArray()) {
				sb.append(morse[c - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueMorseCodeWords result = new UniqueMorseCodeWords();
		System.out.println(result.uniqueMorseCodeWords(new String[] {"gin", "zen", "gig", "msg"}));
	}

}
