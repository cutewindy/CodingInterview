import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and 
 * uppercase letters only.
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are as follows:
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to 
 * the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end 
 * and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 * Example 1:
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa 
 * azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * Notes:
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 * @author wendi
 *
 */
public class GoatLatin {
	
	
	/**
	 * Brute Force
	 * @param String S
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String goatLatin(String S) {
		if (S == null || S.length() == 0) return S;
		StringBuilder res = new StringBuilder();
		String[] words = S.trim().split("\\s+");
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		for (int i = 0; i < words.length; i++) {
			if (vowels.contains(words[i].charAt(0))) {
				res.append(words[i]);
			}
			else {
				res.append(words[i].substring(1, words[i].length())).append(words[i].charAt(0));
			}
			res.append("ma");
			for (int k = 0; k < i + 1; k++) {
				res.append("a");
			}
			res.append(" ");
		}
		return res.toString().substring(0, res.length() - 1);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoatLatin result = new GoatLatin();
		System.out.println(result.goatLatin("jumped over the lazy dog"));
	}

}
