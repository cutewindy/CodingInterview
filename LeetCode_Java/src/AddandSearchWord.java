/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z 
 * or .. A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * hint. You should be familiar with how a Trie works. If not, please work on this problem: 
 * Implement Trie (Prefix Tree) first.
 * 
 * Tags: Backtracking, Trie, Design
 * @author wendi
 *
 */
public class AddandSearchWord {
	
	/**
	 * Using trie data structure
	 * @author wendi
	 *
	 */
	class TrieNode {
		char val;
		boolean isWord;
		TrieNode[] children = new TrieNode[26];
		public TrieNode(){}
		public TrieNode(char val) {
			this.val = val;
			this.isWord = false;
		}
	}
	
	private TrieNode root;
	
	public AddandSearchWord() {
		root = new TrieNode();
	}
	
	// Adds a word into the data structure.
	public void addWord(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode(c);
			}
			curr = curr.children[c - 'a'];
		}
		curr.isWord = true;
	}
	
    // Returns if the word is in the data structure. A word could contain the dot character '.' 
	// to represent any one letter.
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return true;
		}
		TrieNode curr = root;
		return helper(word, 0, curr);
	}
	
	private boolean helper(String word, int pos, TrieNode parent) {
		if (pos == word.length()) {
			return parent.isWord;
		}
		char c = word.charAt(pos);
		if (c != '.' && parent.children[c - 'a'] != null) {
			return helper(word, pos + 1, parent.children[c - 'a']);
		}
		else if (c != '.' && parent.children[c - 'a'] == null) {
			return false;
		}
		else { // recursion to find the possible char in tree equals to word[pos]='.' that can return true
			for (int i = 0; i < 26; i++) {
				if (parent.children[i] != null && helper(word, pos + 1, parent.children[i])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddandSearchWord result = new AddandSearchWord();
		result.addWord("bad");
		result.addWord("dad");
		result.addWord("mad");
		System.out.println(result.search("pad"));
		System.out.println(result.search("bad"));
		System.out.println(result.search(".ad"));
		System.out.println(result.search("b.."));
	}

}
