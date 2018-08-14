package Template;

import java.util.Arrays;

/**
 * 212. Word Search II
 * @author wendi
 *
 */

public class Trie {
	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode('/');
	}

	public void insert(String s) {
		if (s == null || s.length() == 0) return;
		TrieNode curr = root;
		for (char c: s.toCharArray()) {
			if (curr.children[c] == null) curr.children[c] = new TrieNode(c);
			curr = curr.children[c];
		}
		curr.isWord = true;
	}
	
	public boolean search(String s) {
		if (s == null || s.length() == 0) return false;
		TrieNode curr = root;
		for (char c: s.toCharArray()) {
			if (curr.children[c] == null) return false;
			curr = curr.children[c];
		}
		return curr.isWord;
	}
	
	public boolean startWith(String s) {
		if (s == null || s.length() == 0) return false;
		TrieNode curr = root;
		for (char c: s.toCharArray()) {
			if (curr.children[c] == null) return false;
			curr = curr.children[c];
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"chole", "wendi", "xiaotian"};
		Trie trie = new Trie();
		for (String word: words) {
			trie.insert(word);
		}
		System.out.println(Arrays.toString(words));
		System.out.println("can find \"chole\": " + trie.search("chole"));
		System.out.println("can find \"yufen\": " + trie.search("yufen"));
		System.out.println("start with \"wen\": " + trie.startWith("wen"));
	}

}


class TrieNode {
	char c;
	boolean isWord;
	TrieNode[] children;
	public TrieNode(char c) {
		this.c = c;
		this.isWord = false;
		this.children = new TrieNode[256];
	}
}