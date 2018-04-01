import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * In English, we have a concept called root, which can be followed by some other words to form 
 * another longer word - let's call this word successor. For example, the root an, followed by other, 
 * which can form another word another.
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the 
 * successor in the sentence with the root forming it. If a successor has many roots can form it, 
 * replace it with the root with the shortest length.
 * You need to output the sentence after the replacement.
 * Example 1:
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Note:
 * 1. The input will only have lower-case letters.
 * 2. 1 <= dict words number <= 1000
 * 3. 1 <= sentence words number <= 1000
 * 4. 1 <= root length <= 100
 * 5. 1 <= sentence words length <= 1000
 * @author wendi
 *
 */
public class ReplaceWords {
	
	class TrieNode {
		char c;
		boolean isWord;
		TrieNode[] children;
		public TrieNode(char c) {
			this.c = c;
			this.isWord = false;
			this.children = new TrieNode[26];
		}
	}
	
	/**
	 * Method3: trie
	 * Put all the roots in a trie (prefix tree). Then for any query word, we can find the smallest 
	 * root that was a prefix in linear time.
	 * @param List<String> dict, String sentence
	 * @return String
	 * Time: O(n), where n is the length of the sentence. Every query of a word is in linear time.
	 * Space: O(m), the size of our trie.
	 */
	public String replaceWordsII(List<String> dict, String sentence) {
		if (dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0) return sentence;
		TrieNode root = buildTrie(dict);
		String[] S = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String word: S) {
			word = findSuccessor(word, root);
			sb.append(word).append(" ");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
	
	public String findSuccessor(String word, TrieNode root) {
		if (word == null || word.length() == 0) return word;
		StringBuilder sb = new StringBuilder();
		for (char c: word.toCharArray()) {
			if (root.children[c - 'a'] == null) return word;
			sb.append(c);
			root = root.children[c - 'a'];
			if (root.isWord) break;
		}
		return sb.toString();
	}
	
	public TrieNode buildTrie(List<String> dict) {
		TrieNode root = new TrieNode(' ');
		for (String str: dict) {
			TrieNode node = root;
			for (char c: str.toCharArray()) {
				if (node.children[c - 'a'] == null) {
					node.children[c - 'a'] = new TrieNode(c);
				}
				node = node.children[c - 'a'];
			}
			node.isWord = true;
		}
		return root;
	}
	
	
	/**
	 * Method2: prefix hashset
	 * Store all the roots in a Set structure. Then for each word, look at successive prefixes of 
	 * that word. If you find a prefix that is a root, replace the word with that prefix. Otherwise, 
	 * the prefix will just be the word itself, and we should add that to the final sentence answer.
	 * @param List<String> dict, String sentence
	 * @return String
	 * Time: O(∑wi^2) where wi is the length of the ith word.
	 * Space: O(m), the length of dict
	 */
	public String replaceWordsI(List<String> dict, String sentence) {
		if (dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0) return sentence;
		String[] sent = sentence.split("\\s+");
		StringBuilder sb = new StringBuilder();
		Set<String> set = new HashSet<>();
		for (String str: dict) set.add(str);
		for (String s: sent) {
			String sub = new String();
			for (int i = 1; i <= s.length(); i++) {
				sub = s.substring(0, i);
				if (set.contains(sub)) break;
			}
			sb.append(sub).append(" ");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
	
	/**
	 * Method1: Brute force
	 * @param List<String> dict, String sentence
	 * @return String
	 * Time: O(m*n)
	 * Space: O(1)
	 */
	public String replaceWords(List<String> dict, String sentence) {
		if (dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0) return sentence;
		String[] sent = sentence.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sent.length; i++) {
			for (String d: dict) {
				if (sent[i].startsWith(d)) {
					sent[i] = d;
				}
			}
			sb.append(sent[i]).append(" ");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceWords result = new ReplaceWords();
		System.out.println(result.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
		System.out.println(result.replaceWordsI(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
		System.out.println(result.replaceWordsII(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
		System.out.println(result.replaceWordsII(Arrays.asList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
	}

}
