import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", 
 * "2r1", "3d", "w3", "4"]
 * 
 * Tags: Backtracking, Bit Manipulation
 * @author wendi
 *
 */
public class GeneralizedAbbreviation {

	/**
	 * DFS: The idea is: for every character, we can keep it or abbreviate it. To keep it, we add it 
	 * to the current solution and carry on backtracking. To abbreviate it, we omit it in the 
	 * current solution, but increment the count, which indicates how many characters have we 
	 * abbreviated. When we reach the end or need to put a character in the current solution, and 
	 * count is bigger than zero, we add the number into the solution.
	 * @param String word
	 * @return List<String>
	 * Time: O(2^n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public List<String> generalizeAbbreviation(String word) {
		List<String> result = new ArrayList<>();
		if (word == null) {
			return result;
		}
		helper(word, 0, "", 0, result);
		return result;
	}
	
	private void helper(String word, int i, String combo, int count, List<String> result) {
		if (i == word.length()) {
			if (count != 0) {
				combo += count;
			}
			result.add(combo);
			return;
		}
		// choose word[i] in combo, not abbreviate word[i]
		helper(word, i + 1, combo + (count > 0 ?  count : "") + word.charAt(i), 0, result);
		// not choose word[i] in combo, abbreviate word[i]
		helper(word, i + 1, combo, count + 1, result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralizedAbbreviation result = new GeneralizedAbbreviation();
		System.out.println(result.generalizeAbbreviation("ABC"));
		System.out.println(result.generalizeAbbreviation(""));
	}	

}
