import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where 
 * each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * Tags: DP, Backtracking
 * @author wendi
 *
 */
public class WordBreakII {
	
	
	/**
	 * Backtracking: 
	 * @param String s, Set<String> wordDict
	 * @return List<String> 
	 * Time: O()
	 * Space: O()
	 */
	public List<String> wordBreakII(String s, Set<String> wordDict) {
		List<String> result = new ArrayList<>();
		helper(s, wordDict, 0, new ArrayList<String>(), result);
		return result;
	}

	
	public void helper(String s, Set<String> wordDict, int start, List<String> curr, List<String> result) {
		if (start == s.length()) {
			StringBuilder res = new StringBuilder();
			for (String str: curr) {
				res.append(str).append(" ");
			}
			result.add(res.toString().substring(0, res.length() - 1));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			String str = s.substring(start, i + 1);
			if (wordDict.contains(str)) {
				curr.add(str);
				helper(s, wordDict, i + 1, curr, result);
				curr.remove(curr.size() - 1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakII result = new WordBreakII();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(result.wordBreakII("catsanddog", wordDict));
	}

}
