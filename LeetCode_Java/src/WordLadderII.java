import java.util.ArrayList;
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
 * Each intermediate word must exist in the word list
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Return
		  [
		    ["hit","hot","dot","dog","cog"],
		    ["hit","hot","lot","log","cog"]
		  ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
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
	 * Time: O()
	 * Space: O()
	 * Stack space: O()
	 */	
	public List<List<String>> wordLadderII(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		if (wordList.size() == 0) {
			return result;
		}
		wordList.add(endWord);
		Map<String, List<String>> hash = new HashMap<>();
		// 1 BFS to build graph
		buildGraph(beginWord, endWord, wordList, hash);
//		for (String word: hash.keySet()) {
//			System.out.println(word + ": " + hash.get(word));
//		}
		
		// 2 DFS to walk graph
		if (!hash.containsKey(endWord)) {
			return result;
		}
		List<String> path = new ArrayList<>();
		path.add(endWord);
		walkGraph(beginWord, endWord, hash, endWord, path, result);
		return result;
	}
	
	
	private void buildGraph(
			String beginWord, 
			String endWord, 
			Set<String> wordList, 
			Map<String, List<String>> hash) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<String> newWord = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				String curr = queue.poll();
				for (int j = 0; j < curr.length(); j++) {
					char[] currArray = curr.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						currArray[j] = c;
						String word = String.valueOf(currArray);
						if (visited.contains(word)) {  // case1: if previous or curr level has word node, continue
							continue;
						}
						if (hash.containsKey(word)) {  // case2: if next level has word node, add curr as child to word directly
							hash.get(word).add(curr);
						} 
						else if (wordList.contains(word)) {  // case3: if wordList has word, create new node in graph and add curr as child to word
							List<String> list = new ArrayList<>();
							list.add(curr);
							hash.put(word, list);
							newWord.add(word);
							queue.add(word);
							wordList.remove(word);
						}
						
					}	
				}
			}
			if (hash.containsKey(endWord)) {   // find the shortest path
				break;
			}
			for (String newW: newWord) {    // add curr level's word into visited
				visited.add(newW);
			}
		}
	}
	
	
	private void walkGraph(
			String beginWord, 
			String endWord, 
			Map<String, List<String>> hash, 
			String curr,
			List<String> path, 
			List<List<String>> result) {
		if (curr.equals(beginWord)) {
			result.add(new ArrayList<>(path));
			return;
		}
		List<String> children = hash.get(curr);
		for (String child: children) {
			path.add(0, child);
			walkGraph(beginWord, endWord, hash, child, path, result);
			path.remove(0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderII result = new WordLadderII();
		Set<String> wordList = new HashSet<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		System.out.println(result.wordLadderII("hit", "cog", wordList));
	}

}
