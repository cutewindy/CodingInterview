import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * Bucket Sort: same like "451. Sort Characters By Frequency"
	 * @param int[] nums, int k
	 * @return List<Integer> 
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> topKFrequentElements(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0 || k == 0) return result;
		Map<Integer, Integer> counter = new HashMap<>();
		int max = 0;
		for (int num: nums) {
			if (counter.containsKey(num)) {
				counter.put(num, counter.get(num) + 1);
			}
			else {
				counter.put(num, 1);
			}
			max = Math.max(counter.get(num), max);
		}
		List<Integer>[] bucket = new ArrayList[max + 1];
		for (int num: counter.keySet()) {
			int count = counter.get(num);
			if (bucket[count] == null) {
				bucket[count] = new ArrayList<>();
			}
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentElements result = new TopKFrequentElements();
		System.out.println(result.topKFrequentElements(new int[] {1, 1, 1, 2, 2, 3}, 2));
	}

}
