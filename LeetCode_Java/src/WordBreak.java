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
	
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;
        public TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            this.children = new TrieNode[256];
        }
    }
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode('/');
        }
        
        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            TrieNode curr = root;
            for (char c: word.toCharArray()) {
                if (curr.children[c] == null) curr.children[c] = new TrieNode(c);
                curr = curr.children[c];
            }
            curr.isWord = true;
        }
        
        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            TrieNode curr = root;
            for (char c: word.toCharArray()) {
                if (curr.children[c] == null) return false;
                curr = curr.children[c];
            }
            return curr.isWord;
        }
    }
	
	/**
	 * Method3: Trie(TLE)
	 * @param String s, Set<String> wordDict
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public boolean wordBreakII(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return true;	
        Trie trie = new Trie();
        for (String word: wordDict) {
            trie.insert(word);
        }
        return dfs(s, 0, trie);
    }
    
    private boolean dfs(String s, int start, Trie trie) {
        if (start == s.length()) return true;
        for (int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i + 1);
            if (trie.search(subStr) && dfs(s, i + 1, trie)) {
                return true;
            }
        }
        return false;
	}
	
	
	/**
	 * Method2: DP: dp[i]: whether s[0..i-1] can be segmented with dictionary words.
	 * dp[i] = dp[j] && wordDict.contains(s[j]...s[i-1]).
	 * @param String s, Set<String> wordDict
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public boolean wordBreakI(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        boolean[] dp = new boolean[s.length() + 1];
        // init
        dp[0] = true;
        // update
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                	dp[i] = true;
                	break;
                }
            }
        }
        return dp[s.length()];
	}

	
	/**
	 * Method1: DFS + Moreization
	 * @param String s, Set<String> wordDict
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        return dfs(s, 0, new boolean[s.length()], wordDict);
	}
	
	private boolean dfs(String s, int start, boolean[] visited, Set<String> wordDict) {
		if (start == s.length()) return true;
		if (visited[start]) return false;
		visited[start] = true;
		for (int i = start; i < s.length(); i++) {
			if (wordDict.contains(s.substring(start, i + 1)) && dfs(s, i + 1, visited, wordDict)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generawordDictted method stub
		WordBreak result = new WordBreak();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(result.wordBreak("leetcode", wordDict));
		System.out.println(result.wordBreakI("leetcode", wordDict));
		System.out.println(result.wordBreakII("leetcode", wordDict));
	}

}
