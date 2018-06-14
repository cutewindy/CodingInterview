import java.util.HashMap;
import java.util.Map;

/**
 * Implement a MapSum class with insert, and sum methods.
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key 
 * and the integer represents the value. If the key already existed, then the original key-value 
 * pair will be overridden to the new one.
 * For the method sum, you'll be given a string representing the prefix, and you need to return the 
 * sum of all the pairs' value whose key starts with the prefix.
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 * @author wendi
 *
 */
public class MapSumPairs {
	
	
	/**	Method3: Trie
	 * For every node of the trie corresponding to some prefix, we will remember the desired answer 
	 * and store it at this node. As in method 2, this involves modifying each node by 
	 * delta = val - map[key].
	 *  */
	/** Initialize your data structure here. */
	private TrieNode root;
	private Map<String, Integer> map;
	class TrieNode {
		int val;
		Map<Character, TrieNode> children = new HashMap<>();
		public TrieNode() {
			this.val = 0;
			this.children = new HashMap<>();
		}
	}

	public MapSumPairs() {
		this.root = new TrieNode();
		this.map = new HashMap<>();
	}
	
	/**
	 * Time: O(k), where k is the length of the key
	 */
	public void insert(String key, int val) {
		int delta = val - map.getOrDefault(key, 0);
		map.put(key, val);
		TrieNode curr = root;
        for (char c: key.toCharArray()) {
        	if (!curr.children.containsKey(c)) curr.children.put(c, new TrieNode());
        	curr.children.get(c).val += delta;
        	curr = curr.children.get(c);
        	System.out.println("c: " + c + " val: " + curr.val);
        }
    }
    
	/**
	 * Time: O(k) 
	 */
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c: prefix.toCharArray()) {
        	if (!curr.children.containsKey(c)) return 0;
        	curr = curr.children.get(c);
        }
        return curr.val;
    }
	
	
    
//	/**	Method2: Prefix HashMap */
//	/** Initialize your data structure here. */
//	private Map<String, Integer> map;
//	private Map<String, Integer> score;
//	public MapSumPairs() {
//		map = new HashMap<>();
//		score = new HashMap<>();
//	}
//	
//	/**
//	 * Time: O(k^2) where k is the length of the key, as k strings are made of an average length of k
//	 */
//	public void insert(String key, int val) {
//        int delta = val - map.getOrDefault(key, 0);
//        map.put(key, val);
//        String prefix = "";
//        for (char c: key.toCharArray()) {
//        	prefix += c;
//        	score.put(prefix, score.getOrDefault(prefix, 0) + delta);
//        }
//    }
//    
//	/**
//	 * Time: O(1) 
//	 */
//    public int sum(String prefix) {
//        if (prefix == null || prefix.length() == 0) return 0;
//    	return score.getOrDefault(prefix, 0);
//    }
	
	
	
//	/**	Method1: BruteForce HashMap */
//	/** Initialize your data structure here. */
//	private Map<String, Integer> map;
//	public MapSumPairs() {
//		map = new HashMap<>();
//	}
//	
//	/**
//	 * Time: O(1)
//	 */
//	public void insert(String key, int val) {
//        map.put(key, val);
//    }
//    
//	/**
//	 * Time: O(np) where n is the number of items in the map, and p is the length of the prefix.
//	 */
//    public int sum(String prefix) {
//        if (prefix == null || prefix.length() == 0) return 0;
//    	int res = 0;
//    	for (String key: map.keySet()) {
//    		if (key.startsWith(prefix)) res += map.get(key);
//    	}
//        return res;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapSumPairs result = new MapSumPairs();
		result.insert("apple", 3);
		System.out.println(result.sum("ap"));
		result.insert("app", 2);
		System.out.println(result.sum("ap"));
		result.insert("app", 1);
		System.out.println(result.sum("ap"));
	}

}
