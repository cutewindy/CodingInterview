import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of words (without duplicates), find all word squares you can build from them.
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, 
 * where 0 ≤ k < max(numRows, numColumns).
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word 
 * reads the same both horizontally and vertically.
		b a l l
		a r e a
		l e a d
		l a d y
 * Note:
 * 1. There are at least 1 and at most 1000 words.
 * 2. All words will have the exact same length.
 * 3. Word length is at least 1 and at most 5.
 * 4. Each word contains only lowercase English alphabet a-z.
 * Example 1:
		Input:
		["area","lead","wall","lady","ball"]
		Output:
		[
		  [ "wall",
		    "area",
		    "lead",
		    "lady"
		  ],
		  [ "ball",
		    "area",
		    "lead",
		    "lady"
		  ]
		]
		Explanation:
		The output consists of two word squares. The order of output does not matter 
		(just the order of words in each word square matters).
 * Example 2:
		Input:
		["abat","baba","atan","atal"]
		Output:
		[
		  [ "baba",
		    "abat",
		    "baba",
		    "atan"
		  ],
		  [ "baba",
		    "abat",
		    "baba",
		    "atal"
		  ]
		]
		Explanation:
		The output consists of two word squares. The order of output does not matter (just the order 
		of words in each word square matters).
 * @author wendi
 *
 */
public class WordSquares {
	
	class TrieNode{
		List<String> startWith;
		TrieNode[] children;
		public TrieNode() {
			this.startWith = new ArrayList<>();
			this.children = new TrieNode[26];
		}		
	}
	
	class Trie{
		private TrieNode root;
		
		public Trie(String[] words) {
			root = new TrieNode();
			for (String word: words) {
				TrieNode curr = root;
				for (char c: word.toCharArray()) {
					if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
					curr.children[c - 'a'].startWith.add(word);
					curr = curr.children[c - 'a'];
				}
			}
		}
		
		private List<String> findPrefix(String word) {
			TrieNode curr = root;
			for (char c: word.toCharArray()) {
				if (curr.children[c - 'a'] == null) return new ArrayList<String>();
				curr = curr.children[c - 'a'];
			}
			return curr.startWith;
		}
	}
	
	/**
	 * Trie + Backtracking  
	 * "https://leetcode.com/problems/word-squares/discuss/91333/Explained.-My-Java-solution-using-Trie-126ms-1616"
	 * check the validity of the word square while we build it.
	 * Example: ["area","lead","wall","lady","ball"]
	 * We know that the sequence contains 4 words because the length of each word is 4.
	 * Every word can be the first word of the sequence, let's take "wall" for example.
	 * Which word could be the second word? Must be a word start with "a" (therefore "area"), 
	 * because it has to match the second letter of word "wall".
	 * Which word could be the third word? Must be a word start with "le" (therefore "lead"), 
	 * because it has to match the third letter of word "wall" and the third letter of word "area".
	 * What about the last word? Must be a word start with "lad" (therefore "lady"). For the same 
	 * reason above.
	 * In order for this to work, we need to fast retrieve all the words with a given prefix. There 
	 * could be 2 ways doing this:
	 * 1. Using a hashtable, key is prefix, value is a list of words with that prefix.
	 * 2. Trie, we store a list of words with the prefix on each trie node.
	 * The implemented below uses Trie.
	 * @param String[] words
	 * @return List<List<String>>
	 * Time: O()
	 * Space: O()
	 * Stack space: O()
	 */
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> res = new ArrayList<>();
		if (words == null || words.length == 0) return res;
		Trie trie = new Trie(words);
		List<String> path = new ArrayList<>();
		for (String word: words) {
			path.add(word);
			dfs(word.length(), trie, path, res);
			path.remove(path.size() - 1);
		}
		return res;
	}
	
	private void dfs(int len, Trie trie, List<String> path, List<List<String>> res) {
		if (path.size() == len) {
			res.add(new ArrayList<>(path));
			return;
		}
		int i = path.size();
		StringBuilder prefix = new StringBuilder();
		for (String word: path) {
			prefix.append(word.charAt(i));
		}
		List<String> startWith = trie.findPrefix(prefix.toString());
		for (String sw: startWith) {
			path.add(sw);
			dfs(len, trie, path, res);
			path.remove(path.size() - 1);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSquares result = new WordSquares();
		System.out.println(result.wordSquares(new String[] {"area","lead","wall","lady","ball"}));
	}

}
