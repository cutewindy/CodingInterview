import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest 
 * transformation sequence(s) from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * 
 * Tags: Array, Backtracking, BFS, String
 * @author wendi
 *
 */
public class WordLadderII {
	
	/**
	 * BFS to build graph then DFS to walk graph
	 * @param String beginWord, String endWord, Set<String> wordList
	 * @return List<List<String>>
	 * Time: O(E+V)
	 * Space: O(V)
	 * Stack space: O(V)
	 */	
	public List<List<String>> wordLadderII(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		if (wordList.size() == 0) return res;
		Set<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) return res;		
		
		// 1 BFS to build graph
		Map<String, List<String>> hash = new HashMap<>();  // example: [key:value]=[hot:hit]
		buildGraph(beginWord, endWord, wordSet, hash);
		if (!hash.containsKey(endWord)) return res;
//		for (String word: hash.keySet()) {
//			System.out.println(word + ": " + hash.get(word));
//		}
		
		// 2 DFS to walk graph
		List<String> path = new ArrayList<>(Arrays.asList(endWord));
		walkGraph(endWord, beginWord, hash, path, res);
		
		return res;
	}
	
	
	private void buildGraph(String beginWord, String endWord, 
			 				Set<String> wordSet, Map<String, List<String>> hash) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<String> newWord = new ArrayList<>();
			while (size-- > 0) {
				String curr = queue.poll();
				char[] currArray = curr.toCharArray();
				for (int i = 0; i < currArray.length; i++) {
					char oldChar = currArray[i];
					for (char newChar = 'a'; newChar <= 'z'; newChar++) {
						currArray[i] = newChar;
						String word = String.valueOf(currArray);
						
						// case1: if wordSet don't have word or previous level already has word node, continue
						if (!wordSet.contains(word) || visited.contains(word)) continue;
						
						// case2: if next level has word node, add curr as child to word directly
						if (hash.containsKey(word)) hash.get(word).add(curr);
						
						// case3: create new node in graph and add curr as child to word
						else {  
							hash.put(word, new ArrayList<String>(Arrays.asList(curr)));
							newWord.add(word);
							queue.offer(word);
						}
					}	
					currArray[i] = oldChar;
				}
			}
			if (hash.containsKey(endWord)) break;          // find the shortest path
			for (String newW: newWord) visited.add(newW);  // add curr level's word into visited
		}
	}
	
	
	private void walkGraph(String prevWord, String endWord, Map<String, List<String>> hash, 
						   List<String> path, List<List<String>> result) {
		if (prevWord.equals(endWord)) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (String curr: hash.get(prevWord)) {
			path.add(0, curr);
			walkGraph(curr, endWord, hash, path, result);
			path.remove(0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderII result = new WordLadderII();
		System.out.println(result.wordLadderII(
				"hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
		System.out.println(result.wordLadderII(
				"hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"))));
	}

}
