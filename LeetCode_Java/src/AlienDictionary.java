import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are 
 * unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted 
 * lexicographically by the rules of this new language. Derive the order of letters in this language.
 * Example 1:
 * Given the following words in dictionary,
		[
		  "wrt",
		  "wrf",
		  "er",
		  "ett",
		  "rftt"
		]
 * The correct order is: "wertf".
 * Example 2:
 * Given the following words in dictionary,
		[
		  "z",
		  "x"
		]
 * The correct order is: "zx".
 * Example 3:
 * Given the following words in dictionary,
		[
		  "z",
		  "x",
		  "z"
		]
 * The order is invalid, so return "".
 * Note:
 * 1. You may assume all letters are in lowercase.
 * 2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * 3. If the order is invalid, return an empty string.
 * 4. There may be multiple valid order of letters, return any one of them is fine.
 * @author wendi
 *
 */
public class AlienDictionary {
	
	
	/**
	 * Topology sort + BFS
	 * @param String[] words
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String alienDictionary(String[] words) {
		if (words == null || words.length == 0) return "";
		
		// init indegree
		Map<Character, Integer> indegree = new HashMap<>();
		for (String word: words) {
			for (char c: word.toCharArray()) indegree.putIfAbsent(c, 0);
		}
		
		// build graph
		Map<Character, Set<Character>> graph = new HashMap<>();
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
				char c1 =  words[i].charAt(j);
				char c2 = words[i + 1].charAt(j);
				if (c1 != c2) {
					if (!graph.containsKey(c1)) graph.put(c1, new HashSet<Character>());
					if (!graph.get(c1).contains(c2)) {
						graph.get(c1).add(c2);
						indegree.put(c2, indegree.get(c2) + 1);
					}
					break;
				}
			}
		}
		
		// find root, which indegree is 0
		// as we should return the topo order with lexicographical order
        // we should use PriorityQueue instead of a FIFO Queue
		Queue<Character> queue = new PriorityQueue<>();
		for (Character c: indegree.keySet()) {
			if (indegree.get(c) == 0) queue.offer(c);
		}
		
		// walk graph
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Character u = queue.poll();
			sb.append(u);
			if (!graph.containsKey(u)) continue;
			for (Character v: graph.get(u)) {
				indegree.put(v, indegree.get(v) - 1);
				if (indegree.get(v) == 0) queue.offer(v);
			}
		}
		
		return sb.length() == indegree.size() ? sb.toString() : "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlienDictionary result = new AlienDictionary();
		System.out.println(result.alienDictionary(new String[] {"wrt", "wrf", "er", "ett", "rftt"}));
		System.out.println(result.alienDictionary(new String[] {"ab", "adc"}));
		System.out.println(result.alienDictionary(new String[] {"za", "zb", "cc", "cb"}));
	}

}
