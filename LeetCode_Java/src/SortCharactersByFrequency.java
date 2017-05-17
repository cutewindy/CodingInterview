import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * Tags: Hash Table, Heap
 * @author wendi
 *
 */
public class SortCharactersByFrequency {
	
	/**
	 * Method2: HashMap + Bucket sort
	 * 1. Build a map of characters to the number of times it occurs in the string
	 * 2. Create an array where the index of the array represents how many times that character 
	 *    occurred in the String
	 * 3. Iterate from the end of the array to the beginning, and at each index, append each 
	 *    character to the return string that number of times.
	 * Using max to save the space.
	 * @param String s
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String sortCharactersByFrequencyI(String s) {
		if (s == null || s.length() == 0) return "";
		Map<Character, Integer> count = new HashMap<>();
		int max = 0;
		for (char c: s.toCharArray()) {
			if (count.containsKey(c)) {
				count.put(c, count.get(c) + 1);
			}
			else {
				count.put(c, 1);
			}
			max = Math.max(count.get(c), max);
		}
		List<Character>[] bucket = new ArrayList[max + 1]; 
		for (Character c: count.keySet()) {
			int frequent = count.get(c);
			if (bucket[frequent] == null) {
				bucket[frequent] = new ArrayList<>();
			}
			bucket[frequent].add(c);
		}
		StringBuilder result = new StringBuilder();
		for (int i = max; i >= 0; i--) {
			if (bucket[i] != null) {
				for (char c: bucket[i]) {
					for (int j = 0; j < i; j++) {
						result.append(c);
					}
				}
			}
		}
		return result.toString();
	}
	
	
	/**
	 * Method1: HashMap + Heap
	 * @param String s
	 * @return String
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public String sortCharactersByFrequency(String s) {
		if (s == null || s.length() == 0) return "";
		Map<Character, Integer> count = new HashMap<>();
		for (char c: s.toCharArray()) {
			if (count.containsKey(c)) {
				count.put(c, count.get(c) + 1);
			}
			else {
				count.put(c, 1);
			}
		}
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        		100,
        		new Comparator<Map.Entry<Character, Integer>>() {
	        		@Override
		            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
		                return b.getValue() - a.getValue();
	        		}
	            }
        );
		pq.addAll(count.entrySet());
		StringBuilder result = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> e = pq.poll();
			for (int i = 0; i < (int) e.getValue(); i++) {
				result.append(e.getKey());
			}
		}
		return result.toString();
 	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortCharactersByFrequency result = new SortCharactersByFrequency();
		System.out.println(result.sortCharactersByFrequency("tree"));
		System.out.println(result.sortCharactersByFrequencyI("tree"));
	}

}
