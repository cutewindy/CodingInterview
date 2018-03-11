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
	 * Method3: quick select
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int kthLargestElementinanArrayIII(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1 || k > nums.length) return Integer.MAX_VALUE;
		return quickSelect(nums, nums.length - k, 0, nums.length - 1);
	}	
	
	public int quickSelect(int[] nums, int k, int start, int end) {
		if (start > end) return Integer.MAX_VALUE;
		int pivot = nums[end];   // take nums[end] as pivot
		int left =start;
		int right = end;
		// put nums that are <= pivot to the left
	    // put nums that are  > pivot to the right
		while (left < right) {
			if (nums[left++] >= pivot) swap(nums, --left, --right);  
		}
		swap(nums, left, end);  // finally, swap nums[left] and nums[end]
		if (left == k) return nums[left];  // find kth smallest number
		// pivot is too big, so it must be on the left
		if (left > k) return quickSelect(nums, k, start, left - 1);   
		// pivot is too small, so it must be on the right
		return quickSelect(nums, k, left + 1, end);
	}
	
	public void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;	
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
		System.out.println(result.kthLargestElementinanArrayIII(new int[] {3,2,1,5,6,4}, 2));
	}

}
