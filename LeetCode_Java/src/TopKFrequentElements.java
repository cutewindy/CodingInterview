import java.util.ArrayList;
import java.util.List;

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
	 * 
	 * @param int[] nums, int k
	 * @return List<Integer> 
	 * Time: O()
	 * Space: O()
	 */
	public List<Integer> topKFrequentElements(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0 || k == 0) return result;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentElements result = new TopKFrequentElements();
		System.out.println(result.topKFrequentElements(new int[] {1, 1, 1, 2, 2, 3}, 2));
	}

}
