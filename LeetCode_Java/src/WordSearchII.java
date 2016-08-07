import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells 
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than 
 * once in a word.
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
		[
		  ['o','a','a','n'],
		  ['e','t','a','e'],
		  ['i','h','k','r'],
		  ['i','f','l','v']
		]
 * Return ["eat","oath"].
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * click to show hint.
 * You would need to optimize your backtracking to pass the larger test. Could you stop backtracking 
 * earlier?
 * If the current candidate does not exist in all words' prefix, you could stop backtracking 
 * immediately. What kind of data structure could answer such query efficiently? Does a hash table 
 * work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, 
 * please work on this problem: Implement Trie (Prefix Tree) first.
 * 
 * Tags: Backtracking, Trie
 * @author wendi
 *
 */
public class WordSearchII {

	/**
	 * Trie + Backtracking: build tree by using TrieNode class. And search word in Trie tree.If find,
	 * add combo into result.
	 * @param char[][] board, String[] words
	 * @return List<String>
	 * Time: O(n^2)
	 * Space: O(n^2)
	 * Stack space: O(k) k is the length of word
	 */
	class TrieNode{
		char val;
		boolean isWord;
		TrieNode[] children = new TrieNode[26];
		public TrieNode() {} // prepare for root
		public TrieNode(char val) {
			this.val = val;
			isWord = false;
		}
	}
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		if (words == null || words.length == 0) {
			return result;
		}
		// build TrieNode tree
		TrieNode root = new TrieNode();
		for (String word: words) {
			TrieNode curr = root;
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (curr.children[c - 'a'] == null) {
					curr.children[c - 'a'] = new TrieNode(c);
				}
				curr = curr.children[c - 'a'];
			}
			curr.isWord = true;
		}
		// search word in TrieNode tree
		boolean[][] isVisited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				TrieNode curr = root;
				helper(board, isVisited, curr, i, j, "", result);
			}
		}
		return result;
	}
	
	private void helper(char[][] board, boolean[][] isVisited, TrieNode curr, int i, int j, String combo, List<String> result) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] ||
				curr.children[board[i][j] - 'a'] == null) {
			return;
		}
		isVisited[i][j] = true;
		curr = curr.children[board[i][j] - 'a'];
		combo += curr.val;
		if (curr.isWord) {
			result.add(combo);
			curr.isWord = false; // cannot return right now
		}
		helper(board, isVisited, curr, i - 1, j, combo, result); // up
		helper(board, isVisited, curr, i + 1, j, combo, result); // down
		helper(board, isVisited, curr, i, j - 1, combo, result); // left
		helper(board, isVisited, curr, i, j + 1, combo, result); // right
		isVisited[i][j] = false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearchII result = new WordSearchII();
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(result.findWords(board, words));
	}

}
