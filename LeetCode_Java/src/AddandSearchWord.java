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
	
	
//    /** Initialize your data structure here. */
	/**
	 * Approach2: Trie with node '.'
	 * S: O(27^n)
	 */
//    Trie trie;
//    public WordDictionary() {
//        trie = new Trie();
//    }
//    
	/**
	 * T: O(2^n)
	 */
//    public void addWord(String word) {
//        trie.insert(word);
//    }
//    
	/**
	 * T: O(n)
	 */
//    public boolean search(String word) {
//        return trie.search(word);
//    }
//}
//    TrieNode root;
//    public Trie() {
//        this.root = new TrieNode('.');
//    }
//                            
//    public void insert(String word) {
//        insert(word, 0, root);
//    }                      
//    
//    private void insert(String word, int i, TrieNode prev) {
//        if (i == word.length()) {
//            prev.isWord = true;
//            return;
//        }
//        char c = word.charAt(i);
//        if (prev.children[c - 'a'] == null) prev.children[c - 'a'] = new TrieNode(c);
//        if (prev.children[26] == null) prev.children[26] = new TrieNode('.');
//        insert(word, i + 1, prev.children[c - 'a']);
//        insert(word, i + 1, prev.children[26]);
//    } 
//                            
//    public boolean search(String word) {
//        TrieNode curr = root;
//        for (char c: word.toCharArray()) {
//            int index = c == '.' ? 26 : (c - 'a');
//            if (curr.children[index] == null) return false;
//            curr = curr.children[index];
//        }
//        return curr.isWord;
//    }
	
	/**
	 * Approach1:  Trie without node '.'
	 * S: O(26^n)
	 */
	private TrieNode root;
	public AddandSearchWord() {
		root = new TrieNode();
	}
	
	/**
	 * T: O(n)
	 * @param word
	 */
	public void addWord(String word) {
		if (word == null || word.length() == 0) return;
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode(c);
			curr = curr.children[c - 'a'];
		}
		curr.isWord = true;
	}
	
    /**
     * T: O(26^n)
     */
	public boolean search(String word) {
		if (word == null || word.length() == 0) return true;
		return search(word, 0, root);
	}
	
	private boolean search(String word, int pos, TrieNode parent) {
		if (pos == word.length()) return parent.isWord;
		char c = word.charAt(pos);
		if (c != '.' && parent.children[c - 'a'] != null) {
			return search(word, pos + 1, parent.children[c - 'a']);
		}
		else if (c == '.'){ // recursion to find the possible char in tree equals to word[pos]='.' that can return true
			for (int i = 0; i < 26; i++) {
				if (parent.children[i] != null && search(word, pos + 1, parent.children[i])) {
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
