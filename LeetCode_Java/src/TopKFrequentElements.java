import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * Tags: HashTable, Heap
 * @author wendi
 *
 */
public class TopKFrequentElements {

	/**
	 * Method3: Bucket Sort: 
	 * same like "451. Sort Characters By Frequency"
	 * @param int[] nums, int k
	 * @return List<Integer> 
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> topKFrequentElementsII(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0 || k == 0) return result;
		Map<Integer, Integer> counter = new HashMap<>();
		int max = 0;
		for (int num: nums) {
			counter.put(num, counter.getOrDefault(num, 0) + 1);
			max = Math.max(counter.get(num), max);
		}
		List<Integer>[] bucket = new ArrayList[max + 1];
		for (int num: counter.keySet()) {
			int count = counter.get(num);
			if (bucket[count] == null) bucket[count] = new ArrayList<>();
			bucket[count].add(num);
		}
		for (int i = max; i > 0 && k > 0; i--) {
			if (bucket[i] != null) {
				result.addAll(bucket[i]);
				k -= bucket[i].size();
			}
		}
		return result;
	}
	
	
	
	/**
	 * Method2: TreeMap: 
	 * @param int[] nums, int k
	 * @return List<Integer> 
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public List<Integer> topKFrequentElementsI(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0 || k == 0) return res;
		Map<Integer, Integer> counter = new HashMap<>();
		for (int n: nums) counter.put(n, counter.getOrDefault(n, 0) + 1);
		TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
		for (Integer n: counter.keySet()) {
			int freq = counter.get(n);
			if (!treeMap.containsKey(freq)) treeMap.put(freq, new ArrayList<Integer>());
			treeMap.get(freq).add(n);
		}
		while (res.size() < k) {
			res.addAll(treeMap.pollLastEntry().getValue());
		}
		return res;
	}
	
	
	
	/**
	 * Method1: MinHeap 
	 * 1. build a counter map that maps a num to its frequency
	 * 2. build a heap/priority queue that keeps track of k most significant entries
	 * 3. iterate through the final heap and get the keys
	 * @param int[] nums, int k
	 * @return List<Integer> 
	 * Time: O(nlog(k))
	 * Space: O(n)
	 */
	public List<Integer> topKFrequentElements(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0 || k == 0) return res;
		Map<Integer, Integer> counter = new HashMap<>();
		for (int n: nums) counter.put(n, counter.getOrDefault(n, 0) + 1);
		PriorityQueue<Map.Entry<Integer, Integer>> heap = 
				new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
		for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
			heap.offer(e);
			if (heap.size() > k) heap.poll();
		}
		while (!heap.isEmpty()) {
			res.add(heap.poll().getKey());
		}
 		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentElements result = new TopKFrequentElements();
		System.out.println(result.topKFrequentElements(new int[] {1, 1, 1, 2, 2, 3}, 2));
		System.out.println(result.topKFrequentElementsI(new int[] {1, 1, 1, 2, 2, 3}, 2));
		System.out.println(result.topKFrequentElementsII(new int[] {1, 1, 1, 2, 2, 3}, 2));
	}

}
