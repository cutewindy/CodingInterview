import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the 
 * sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @author wendi
 *
 */
public class KthLargestElementinanArray {

	/**
	 * Method3: quick select, divide and conquer
	 * @param int[] nums, int k
	 * @return int
	 * Time: ave: O(n), worse case: O(n^2)
	 * Space: O(1)
	 */
	public int kthLargestElementinanArrayIII(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1 || k > nums.length) return Integer.MAX_VALUE;
		return quickSelect(nums, nums.length - k, 0, nums.length - 1);
	}	
	
	public int quickSelect(int[] nums, int k, int l, int r) {
		if (l > r) return Integer.MAX_VALUE;
		// put nums that are <  pivot to the left
	    // put nums that are >= pivot to the right
		int pivot = nums[r];   // take nums[end] as pivot
		int i = l;  // starting index that all nums large than nums[r]
		for (int j = l; j < r; j++) {
			if (nums[j] < pivot) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, r);  // finally, swap nums[i] and nums[r]
		if (i == k) return nums[i];  // find kth smallest number
		if (i > k) return quickSelect(nums, k, l, i - 1); // pivot is too big, so it must be on the left
		return quickSelect(nums, k, i + 1, r);  // pivot is too small, so it must be on the right
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;	
	}
	
	
	/**
	 * Method2: minHeap
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(nlog(k))
	 * Space: O(k)
	 */
	public int kthLargestElementinanArrayII(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1 || k > nums.length) return -1;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
		for (int num: nums) {
			minHeap.add(num);
			if (minHeap.size() > k) minHeap.poll();
		}
		return minHeap.poll();
	}	
	
	
	/**
	 * Method1: arrays.sort
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int kthLargestElementinanArray(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1 || k > nums.length) return -1;
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElementinanArray result = new KthLargestElementinanArray();
//		System.out.println(result.kthLargestElementinanArray(new int[] {3,2,1,5,6,4}, 4));
//		System.out.println(result.kthLargestElementinanArrayII(new int[] {3,2,1,5,6,4}, 2));
//		System.out.println(result.kthLargestElementinanArrayIII(new int[] {3,2,1,5,6,4}, 2));
		System.out.println(result.kthLargestElementinanArrayIII(new int[] {5,1,6,4,2,3}, 2));
	}

}
