package dropbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
             
 * @author wendi
 *
 */
public class WordBreak {
	
	
	/**
	 * dp
	 * @param String s, List<String> wordDict
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 */
    public List<String> wordBreakI(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        return dfs(s, 0, new HashMap<Integer, List<String>>(), set);
    }
    
    private List<String> dfs(String s, int start, Map<Integer, List<String>> map, Set<String> set) {
        if (start == s.length()) return null;
        if (map.containsKey(start)) return map.get(start);
        List<String> list = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i + 1);
            if (set.contains(word)) {
                List<String> curr = dfs(s, i + 1, map, set);
                if (curr == null) list.add(word);
                else {
                    for (String next: curr) list.add(word + " " + next);
                }
            }
        }
        map.put(start, list);
        return list;
    }
	
	
	/**
	 * dp
	 * @param String s, List<String> wordDict
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                String word = s.substring(i, j + 1);
                if (set.contains(word) && dp[i]) {
                    dp[j + 1] = true;
                }
            }
        }
        return dp[s.length()];
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak result = new WordBreak();
		System.out.println(result.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
		System.out.println(result.wordBreakI("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
	}

}
