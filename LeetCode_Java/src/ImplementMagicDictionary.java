import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement a magic directory with buildDict, and search methods.
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 * For the method search, you'll be given a word, and judge whether if you modify exactly one 
 * character into another character in this word, the modified word is in the dictionary you just built.
 * Example 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * Note:
 * 1. You may assume that all the inputs are consist of lowercase letters a-z.
 * 2. For contest purpose, the test data is rather small by now. You could think about highly 
 * efficient algorithm after the contest.
 * 3. Please remember to RESET your class variables declared in class MagicDictionary, as static/class 
 * variables are persisted across multiple test cases. Please see here for more details.
 * @author wendi
 *
 */
public class ImplementMagicDictionary {
	
	/**
	 * Method2: Trie
	 * First, build the TrieTree in buildDict;
	 * Second, for each given word, scan char by char. For each char, try modify it and then call 
	 * the findWord method in TrieTree. If returns true then return true. If not then see if the 
	 * TrieTree has exactly this char, if yes then keep going, if not return false.
	 * Finally, if reaches the end of the word return false. This means the TrieTree has exactly 
	 * this word. But modifying any of the character cannot fit in the dictionary.
	 */
	class TrieNode {
		char c;
		boolean isWord;
		TrieNode[] children;
		public TrieNode(char c) {
			this.c = c;
			this.isWord = false;
			this.children = new TrieNode[26];
		}
		public TrieNode() {
			this.children = new TrieNode[26];
		}
	}
	
    /** Initialize your data structure here. */
	TrieNode root;
    public ImplementMagicDictionary() {
        this.root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word: dict) {
        	TrieNode prev = root;
        	for (char c: word.toCharArray()) {
        		if (prev.children[c - 'a'] == null) prev.children[c - 'a'] = new TrieNode(c);
        		prev = prev.children[c - 'a'];
        	}
        	prev.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode prev = root;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	for (char ch = 'a'; ch <= 'z'; ch++) {
        		if (ch == c || prev.children[ch - 'a'] == null) continue;
        		if (findWord(prev.children[ch - 'a'], word, i + 1)) return true;
        	}
        	if (prev.children[c - 'a'] == null) return false;
        	prev = prev.children[c - 'a'];
        }
        return false;
    }	
	
	
    private boolean findWord(TrieNode prev, String word, int i) {
    	if (i == word.length() && prev.isWord) return true;
    	if (i == word.length()) return false;
    	char c = word.charAt(i);
    	if (prev.children[c - 'a'] != null) return findWord(prev.children[c - 'a'], word, i + 1);
    	return false;
    }
    
//	/**
//	 * Method1: Set
//	 */
//    /** Initialize your data structure here. */
//	private Set<String> words;
//    public ImplementMagicDictionary() {
//        this.words = new HashSet<>();
//    }
//    
//    /** Build a dictionary through a list of words */
//    /**
//     * Time: O(n) n=dict.length
//     */
//    public void buildDict(String[] dict) {
//        words.addAll(Arrays.asList(dict));
//    }
//    
//    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
//    /**
//     * Time: O(26*n) n = word.length
//     */
//    public boolean search(String word) {
//        if (word == null || word.length() == 0) return false;
//        char[] W = word.toCharArray();
//        for (int i = 0; i < W.length; i++) {
//        	char c = W[i];
//        	for (char ch = 'a'; ch <= 'z'; ch++) {
//        		if (ch == c) continue;
//        		W[i] = ch;
//        		if (words.contains(String.valueOf(W))) return true;
//        	}
//        	W[i] = c;
//        }
//        return false;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementMagicDictionary result = new ImplementMagicDictionary();
		result.buildDict(new String[] {"hello", "leetcode"});
		System.out.println(result.search("hello"));
		System.out.println(result.search("hhllo"));
		System.out.println(result.search("hell"));
		System.out.println(result.search("leetcoded"));
	}

}
