package wePay;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给一个文件，每次查找一个词时返回它字典序后一个词，用踹树
 * [cat, dog, cow, donkey, zebra, monkey], input donkey, output monkey; input dog, output donkey。 
 * 可以sort再binary search。或者用trie解决。
 * 一个file里每一行有一个word，然
 * 后给你一个word然你找file里字母序列的下
 * 一个word，讨论数据结构，复杂度
 * @author wendi
 *
 */
public class WordLadderIIAlphabeticalNextWord {
	
	/**
	 * Approach2: Trie
	 * @param Strint[] words
	 * @return String
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public String wordLadderIIAlphabeticalNextWordI(String[] words, String target) {	
		Trie trie = new Trie();
		for (String word: words) {
			trie.insert(word);
		}
		Stack<TrieNode> stack = new Stack<>();
		findTarget(stack, trie.root, target);
		return findNextWord(stack, new StringBuilder());
	}
	
	private void findTarget(Stack<TrieNode> stack, TrieNode root, String target) {
		stack.push(root);
		for (char c: target.toCharArray()) {
			stack.push(root.children[c - 'a']);
			root = root.children[c - 'a'];
		}
	}
	
	private String findNextWord(Stack<TrieNode> stack, StringBuilder sb) {
		while (!stack.isEmpty()) {
			TrieNode curr = stack.pop();
			for (char c = 'a'; c <= 'z'; c++) {
				if (curr.children[c] != null && curr.children[c].isWord) {
					sb.append(c);
					return sb.toString();
				}
				else if (curr.children[c] != null) {
					stack.push(curr.children[c]);
					sb.append(c);
					return findNextWord(stack, sb);
				}
			}
		}
		return "";
	}
	
	class Trie{
		TrieNode root;
		
		public Trie() {
			root = new TrieNode(' ');
		}
		
		public void insert(String word) {
			TrieNode curr = root;
			for (char c: word.toCharArray()) {
				if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode(c);
				curr = curr.children[c - 'a'];
			}
			curr.isWord = true;
		}
	}
	
	class TrieNode {
		char val;
		boolean isWord;
		TrieNode[] children;
		public TrieNode (char val) {
			this.val = val;
			this.isWord = false;
			this.children = new TrieNode[26];
		}
	}
	
	/**
	 * Approach1: Sort array + binary Search
	 * @param Strint[] words
	 * @return String
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public String wordLadderIIAlphabeticalNextWord(String[] words, String target) {
		Arrays.sort(words);
		int start = 0, end = words.length - 1;
		int index = -1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (words[mid].equals(target)) {
				index = mid;
				break;
			}
			else if (words[mid].compareTo(target) < 0) start = mid + 1;
			else end = mid - 1;
		}
		if (words[start].equals(target)) index = start;
		else if (words[end].equals(end)) index = end;
		return words[index + 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderIIAlphabeticalNextWord result = new WordLadderIIAlphabeticalNextWord();
		System.out.println(result.wordLadderIIAlphabeticalNextWord(
				new String[] {"cat", "dog", "cow", "donkey", "zebra", "monkey"}, "dog"));
		System.out.println(result.wordLadderIIAlphabeticalNextWord(
				new String[] {"cat", "dog", "cow", "donkey", "zebra", "monkey"}, "donkey"));
		System.out.println(result.wordLadderIIAlphabeticalNextWordI(
				new String[] {"cat", "dog", "cow", "donkey", "zebra", "monkey"}, "dog"));
		System.out.println(result.wordLadderIIAlphabeticalNextWordI(
				new String[] {"cat", "dog", "cow", "donkey", "zebra", "monkey"}, "donkey"));
	}

}
