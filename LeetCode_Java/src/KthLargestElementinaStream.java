import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest 
 * element in the sorted order, not the kth distinct element.
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array 
 * nums, which contains initial elements from the stream. For each call to the method KthLargest.add, 
 * return the element representing the kth largest element in the stream.
 * Example:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note: 
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 * @author wendi
 *
 */
public class KthLargestElementinaStream {
	
	private PriorityQueue<Integer> minHeap;
	private int maxSize;
	public KthLargestElementinaStream(int k, int[] nums) {
		maxSize = k;
		minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
		for (int num: nums) {
			minHeap.offer(num);
			if (minHeap.size() > maxSize) minHeap.poll();
		}
	}
	
	public int add(int val) {
		minHeap.offer(val);
		if (minHeap.size() > maxSize) minHeap.poll();
		return minHeap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElementinaStream result = new KthLargestElementinaStream(3, new int[] {4, 5, 8, 2});
		System.out.println(result.add(3));
		System.out.println(result.add(5));
		System.out.println(result.add(10));
		System.out.println(result.add(9));
		System.out.println(result.add(4));
	}

}
