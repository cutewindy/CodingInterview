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
	 * add word into result.
	 * @param char[][] board, String[] words
	 * @return List<String>
	 * Time: O(m*n*4^len) len=words[i].length()
	 * Space: O(Sum of len[i]), len[i]=words[i].length()
	 * Stack space: O(len)
	 */
    public List<String> wordSearchII(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Trie trie = new Trie();
        for (String word: words) trie.addWord(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.children[board[i][j] - 'a'] == null) continue;
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[i][j] = true;
                dfs(board, i, j, trie.root.children[board[i][j] - 'a'], visited, board[i][j] + "", res);
            }
        }
        return res;
    }
    
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private void dfs(char[][] board, int row, int col, TrieNode root, boolean[][] visited, String word, List<String> res) {
        if (root.isWord) {
            res.add(word);
            root.isWord = false;  // don't forget and cannot return here
        }
        for (int k = 0; k < 4; k++) {
            int i = dir[k][0] + row;
            int j = dir[k][1] + col;
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
                visited[i][j] || root.children[board[i][j] - 'a'] == null) continue;
            visited[i][j] = true;
            dfs(board, i, j, root.children[board[i][j] - 'a'], visited, word + board[i][j], res);
            visited[i][j] = false;
        }
    }
    
    class Trie {
        public TrieNode root;
        
        public Trie() {
            this.root = new TrieNode('/');
        }
        
        public void addWord(String s) {
            if (s == null || s.length() == 0) return;
            TrieNode curr = root;
            for (char c: s.toCharArray()) {
                if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode(c);
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }
    } 
    
    class TrieNode {
        char c;
        boolean isWord;
        TrieNode children[];
        public TrieNode(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearchII result = new WordSearchII();
//		char[][] board = {
//				{'o','a','a','n'},
//				{'e','t','a','e'},
//				{'i','h','k','r'},
//				{'i','f','l','v'}};
//		String[] words = {"oath","pea","eat","rain"};
		char[][] board = {{'a', 'a'}};
		String[] words = {"a"};
		System.out.println(result.wordSearchII(board, words));
	}

}
