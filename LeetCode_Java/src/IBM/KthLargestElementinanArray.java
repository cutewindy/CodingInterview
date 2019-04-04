package IBM;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
 * @author wendi
 *
 */
public class KthLargestElementinanArray {
	
	/**
	 * Approach3: quick select
	 * Time: O(n) worse case: O(n^2)
	 * Space: O(1)
	 */
    public int findKthLargestII(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        int i = start;
        int pivot = nums[end];
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        if (i == k) return nums[k];
        else if (i < k) return quickSelect(nums, i + 1, end, k);
        else return quickSelect(nums, start, i - 1, k);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
	
	/**
	 * Approach2: minheap
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
    public int findKthLargestI(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.poll();
    }
	
	
	/**
	 * Approach1: Array sort
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
