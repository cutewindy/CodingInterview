/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Tags: Design, Trie
 * @author wendi
 *
 */


public class ImplementTrie {
	class TrieNode {
		char val;
		boolean isWord;
		TrieNode[] children = new TrieNode[26];
		public TrieNode() {}  // prepare for root
		public TrieNode(char val) {
			this.val = val;
			this.isWord = false;
		}
	}
	
	private TrieNode root;

	public ImplementTrie() {
		root = new TrieNode();
	}
	
	// Inserts a word into the trie
	public void insert(String word) {
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
	
	// Returns if the word is in the trie.
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return true;
		}
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) {
				return false;
			}
			curr = curr.children[c - 'a'];
		}
		return curr.isWord;
	}
	
	// Returns if there is any word in the trie that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return true;
		}
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (curr.children[c - 'a'] == null) {
				return false;
			}
			curr = curr.children[c - 'a'];
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementTrie result = new ImplementTrie();
		result.insert("ab");
		System.out.println(result.search("a"));
		System.out.println(result.startsWith("a"));
	}

}
