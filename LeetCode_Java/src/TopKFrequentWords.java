import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same 
 * frequency, then the word with the lower alphabetical order comes first.
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words. 
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * 1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * 2. Input words contain only lowercase letters.
 * Follow up:
 * 1. Try to solve it in O(n log k) time and O(n) extra space.
 * @author wendi
 *
 */
public class TopKFrequentWords {
	
	/**
	 * minHeap
	 * Count the frequency of each word, then add it to min heap that stores the top frequent k 
	 * candidates. At the end, we pop off the heap up to k times and reverse the result.
	 * @param String[] words, int k
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(nlog(k))
	 */
	public List<String> topKFrequentWords(String[] words, int k) {
		List<String> result = new ArrayList<>();
		if (words == null || words.length == 0) return result;
		Map<String, Integer> freq = new HashMap<>();
		for (String word: words) {
			if (!freq.containsKey(word)) freq.put(word, 0);
			freq.put(word, freq.get(word) + 1);
		}
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>
		(k, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				if (e1.getValue() != e2.getValue()) return e1.getValue() - e2.getValue();
				return e2.getKey().compareTo(e1.getKey());
			}
		});
		for (Map.Entry<String, Integer> e: freq.entrySet()) {
			minHeap.offer(e);
			if (minHeap.size() > k) minHeap.poll();
		}
		while (k-- > 0) {
			result.add(minHeap.poll().getKey());
		}
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentWords result = new TopKFrequentWords();
		System.out.println(result.topKFrequentWords(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
	}

}
