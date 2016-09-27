import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list 
 * of words and your method will be called repeatedly many times with different parameters. How 
 * would you optimize it?
 * Design a class which receives a list of words in the constructor, and implements a method that 
 * takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * 
 * Tags: Hash Table, Design
 * @author wendi
 *
 */
public class ShortestWordDistanceII {
	
	Map<String, List<Integer>> hash;
	public ShortestWordDistanceII(String[] words) {
		hash = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (hash.containsKey(words[i])) {
				hash.get(words[i]).add(i);
			}
			else {
				List<Integer> list = new ArrayList<>(Arrays.asList(i));
				hash.put(words[i], list);
			}
		}
	}
	
	/**
	 * Using hash<String, List<Integer>> + Two pointers
	 * The idea is pretty simple. Memorizing all the positions that each string appears. Put it into 
	 * a array and store <String, List<Integer>> as a pair in the hash map. When we need to find the 
	 * shortest path of two string, just get the two list of these two string. Use two pointers and 
	 * scan the two lists at the same time. When any pointer reach the end. Stop the loop. When we 
	 * found out that the first position is greater than the second one. We add one to the second 
	 * pointer. Else, add to the first pointer. This idea is like always keep minimum difference 
	 * between the two position and move the two pointers.
	 * @param String word1, String word2
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int shortest(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return -1;
		}
		int i = 0;
		int j = 0;
		int result = Integer.MAX_VALUE;
		while (i < hash.get(word1).size() && j < hash.get(word2).size()) {
			int index1 = hash.get(word1).get(i);
			int index2 = hash.get(word2).get(j);
			result = Math.min(Math.abs(index1 - index2), result);
			if (index1 < index2) {
				i++;
			}
			else {
				j++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestWordDistanceII result = new ShortestWordDistanceII(new String[] {"practice", "makes", "perfect", "coding", "makes"});
		System.out.println(result.shortest("coding", "practice"));
		System.out.println(result.shortest("makes", "coding"));
	}

}
