import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of 
 * shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class WordLadder {
	
	/**
	 * BFS: queue level traverse
	 * @param String beginWord, String endWord, Set<String> wordList
	 * @return int
	 * Time: O(wordList.size() * word.length * 26)
	 * Space: O(wordList.size())
	 */
	public int wordLadder(String beginWord, String endWord, Set<String> wordList) { 
		if (wordList.size() == 0) {
			return 0;
		}
		int count = 0;
		wordList.add(endWord);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curr = queue.poll();
				if (curr.equals(endWord)) {
					return count;
				}
				for (int j = 0; j < curr.length(); j++) {
					char[] currArray = curr.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						currArray[j] = c;
						String word = String.valueOf(currArray);
						if (wordList.contains(word)) {
							queue.offer(word);
							wordList.remove(word);
						}
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder result = new WordLadder();
		Set<String> wordList = new HashSet<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		System.out.println(result.wordLadder("hit", "cog", wordList));
	}

}
