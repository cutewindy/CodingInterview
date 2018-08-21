import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**	
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of 
 * shortest transformation sequence from beginWord to endWord, such that:
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed 
 * word.
 * Note:
 * 1. Return 0 if there is no such transformation sequence.
 * 2. All words have the same length.
 * 3. All words contain only lowercase alphabetic characters.
 * 4. You may assume no duplicates in the word list.
 * 5. You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * @author wendi
 *
 */
public class WordLadder {
	
	/**
	 * BFS: queue level traverse
	 * @param String beginWord, String endWord, List<String> wordList
	 * @return int
	 * Time: O(E + V) O(n*l*26) n=wordList.size(), l=wordList.get(0).length()
	 * Space: O(V)
	 */
	public int wordLadder(String beginWord, String endWord, List<String> wordList) { 
		// it's better not change the input
        Set<String> dict = new HashSet<>(wordList);  // O(1) to find the word
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
        	level++;
            int size = queue.size();
            while (size-- > 0) {
                char[] wordArray = queue.poll().toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char ch = wordArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                    	wordArray[i] = c;
                        String newWord = String.valueOf(wordArray);
                        if (!dict.contains(newWord)) continue;
                        if (newWord.equals(endWord)) return level + 1;
                        queue.offer(newWord);
                        dict.remove(newWord);  // avoid cycle and duplicate
                    }
                    wordArray[i] = ch;
                }
            }
        } 
        return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder result = new WordLadder();
		System.out.println(result.wordLadder("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
	}

}
