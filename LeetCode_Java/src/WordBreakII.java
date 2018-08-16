import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	 * DFS + Memoization: used HashMap to save the previous results to prune duplicated branches
	 * @param String s, List<String> wordDict
	 * @return List<String> 
	 * Time: O(2^n) n=s.length()
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<String> wordBreakII(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);        
        return dfs(s, 0, words, new HashMap<Integer, List<String>>());
    }
    
    private List<String> dfs(String s, int start, Set<String> words, Map<Integer, List<String>> visited) {
        if (start == s.length()) return null;
        if (visited.containsKey(start)) return visited.get(start);
        List<String> res = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i + 1);
            if (words.contains(word)) {
                List<String> path = dfs(s, i + 1, words, visited);
                if (path == null) {
                	res.add(word);
                	continue;
                }
                for (String p: path) {
                    res.add(word + " " + p);
                }
            }
        }
        visited.put(start, res);
        return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakII result = new WordBreakII();
		System.out.println(result.wordBreakII("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
	}

}
