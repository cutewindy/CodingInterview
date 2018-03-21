import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a 
 * space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * Tags: 
 * @author wendi
 *
 */
public class WordBreak {
	
	
	/**
	 * DP: dp[i]: whether s[0..i-1] can be segmented with dictionary words.
	 * dp[j] = dp[i - 1] && wordDict.contains(s[i..j-1]).
	 * @param String s, Set<String> wordDict
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        boolean[] dp = new boolean[s.length() + 1];
        // init
        dp[0] = true;
        // update
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (wordDict.contains(s.substring(i - 1, j)) && dp[i - 1]) dp[j] = true;
            }
        }
        return dp[s.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generawordDictted method stub
		WordBreak result = new WordBreak();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(result.wordBreak("leetcode", wordDict));
	}

}
