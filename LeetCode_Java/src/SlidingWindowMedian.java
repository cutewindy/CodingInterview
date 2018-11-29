import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is 
 * no middle value. So the median is the mean of the two middle value.
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Given an array nums, there is a sliding window of size k which is moving from the very left of 
 * the array to the very right. You can only see the k numbers in the window. Each time the sliding 
 * window moves right by one position. Your job is to output the median array for each window in the 
 * original array.
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * Note: 
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty 
 * array.
 * @author wendi
 *
 */
public class SlidingWindowMedian {
	
	
	/**
	 * Two treeMap
	 * @param int[] nums, int k
	 * @return double[]
	 * Time: O(nlog(k)), add: O(log(k)), keepBalance: O(log(k)), getMedian: O(1), remove: O(log(k))
	 * Space: O(k)
	 */
	public double[] slidingWindowMedian(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) return new double[0];
		int n = nums.length;
		double[] res = new double[n - k + 1];
		TreeMap<Integer, Integer> maxTreeMap = new TreeMap<>(Collections.reverseOrder());  // [key, value] = [num, frequency], left half
		TreeMap<Integer, Integer> minTreeMap = new TreeMap<>();  // [key, value] = [num, frequency], right half
		int totalMaxSize = k / 2; // left half size <= right half size
		int[] maxSize = new int[1];
		for (int i = 0; i < k - 1; i++) {
			addToTreeMap(maxTreeMap, minTreeMap, maxSize, nums[i]);
			keepBalance(maxTreeMap, minTreeMap, maxSize, totalMaxSize);
		}
		
		for (int i = k - 1; i < n; i++) {
			addToTreeMap(maxTreeMap, minTreeMap, maxSize, nums[i]);
			keepBalance(maxTreeMap, minTreeMap, maxSize, totalMaxSize);
			res[i - k + 1] = getMedian(maxTreeMap, minTreeMap, k);
			removeFromTreeMap(maxTreeMap, minTreeMap, maxSize, nums[i - k + 1]);
		}
		
		return res;
	}
	
	private void addToTreeMap(TreeMap<Integer, Integer> maxTreeMap, TreeMap<Integer, Integer> minTreeMap, int[] maxSize, int num) {
		if (!minTreeMap.containsKey(num)) minTreeMap.put(num, 0);
		minTreeMap.put(num, minTreeMap.get(num) + 1);
		int curr = minTreeMap.keySet().iterator().next();
		minTreeMap.put(curr, minTreeMap.get(curr) - 1);
		if (minTreeMap.get(curr) == 0) minTreeMap.remove(curr);
		if (!maxTreeMap.containsKey(curr)) maxTreeMap.put(curr, 0);
		maxTreeMap.put(curr, maxTreeMap.get(curr) + 1);
		maxSize[0]++;
	}
	
	private void removeFromTreeMap(TreeMap<Integer, Integer> maxTreeMap, TreeMap<Integer, Integer> minTreeMap, int[] maxSize, int num) {
		if (maxTreeMap.containsKey(num)) {
			maxTreeMap.put(num, maxTreeMap.get(num) - 1);
			if (maxTreeMap.get(num) == 0) maxTreeMap.remove(num);
			maxSize[0]--;
		}
		else {
			minTreeMap.put(num, minTreeMap.get(num) - 1);
			if (minTreeMap.get(num) == 0) minTreeMap.remove(num);
		}
	}
	
	private void keepBalance(TreeMap<Integer, Integer> maxTreeMap, TreeMap<Integer, Integer> minTreeMap, int[] maxSize, int totalMaxSize) {
		if (maxSize[0] <= totalMaxSize) return;
		int curr = maxTreeMap.keySet().iterator().next();
		maxTreeMap.put(curr, maxTreeMap.get(curr) - 1);
		if (maxTreeMap.get(curr) == 0) maxTreeMap.remove(curr);
		if (!minTreeMap.containsKey(curr)) minTreeMap.put(curr, 0);
		minTreeMap.put(curr, minTreeMap.get(curr) + 1);
		maxSize[0]--;
	}
	
	private double getMedian(TreeMap<Integer, Integer> maxTreeMap, TreeMap<Integer, Integer> minTreeMap, int k) {
		if (k % 2 == 1) return (double) minTreeMap.keySet().iterator().next();
		double left = (double) maxTreeMap.keySet().iterator().next();
		double right = (double) minTreeMap.keySet().iterator().next();
		return (left + right) / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowMedian result = new SlidingWindowMedian();
		System.out.println(Arrays.toString(result.slidingWindowMedian(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
	}	

}
