import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * Return: [1,2],[1,4],[1,6]
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * Return: [1,1],[1,1]
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3 
 * Return: [1,3],[2,3]
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 * 
 * Tags: Heap
 * @author wendi
 *
 */
public class FindKPairswithSmallestSums {
	class Pair{
		int i;
		int j;
		int sum;
		public Pair(int i, int j, int sum) {
			this.i = i;
			this.j = j;
			this.sum = sum;
		}
	}
	
	/**
	 * Method3: Find the next element from the heap, and add new element into heap from current 
	 * element's down(if j == 0) and right.
	 * @param int[] nums1, int[] nums2, int k
	 * @return List<int[]>
	 * Time: O(k * (1+2log(k)))  one poll and two offer
	 * Space: O(k)
	 */
	public List<int[]> findKPairswithSmallestSumsII(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return result;
		}
		PriorityQueue<Pair> heap = new PriorityQueue<>(k, new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				return a.sum - b.sum;
			}
		});		
		// init
		heap.offer(new Pair(0, 0, nums1[0] + nums2[0]));
		// find first k
		while (!heap.isEmpty() && k-- > 0) {
			Pair temp = heap.poll();
			if (temp.i + 1 < nums1.length && temp.j == 0) {  // if (j == 0) add down element
				heap.offer(new Pair(temp.i + 1, temp.j, nums1[temp.i + 1] + nums2[temp.j]));
			}
			if (temp.j + 1 < nums2.length) {
				heap.offer(new Pair(temp.i, temp.j + 1,nums1[temp.i] + nums2[temp.j + 1]));
			}
			result.add(new int[] {nums1[temp.i], nums2[temp.j]});
		}
		return result;
	}
	
	
	/**
	 * Method2: Optimizing method1
	 * @param int[] nums1, int[] nums2, int k
	 * @return List<int[]>
	 * Time: O()
	 * Space: O()
	 */
	public List<int[]> findKPairswithSmallestSumsI(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();

		return result;
	}
	
	
	/**
	 * Method1: Brute Force + Heap
	 * @param int[] nums1, int[] nums2, int k
	 * @return List<int[]>
	 * Time: O(m * n)
	 * Space: O(m * n)
	 */
	public List<int[]> findKPairswithSmallestSums(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return result;
		}
		// offer pair in minHeap
		PriorityQueue<Pair> heap = new PriorityQueue<>(k, new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				return a.sum - b.sum;
			}
		});
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				heap.offer(new Pair(i, j, nums1[i] + nums2[j]));
			}
		}
		// poll first k pair from heap
		for (int i = 0; i < k && !heap.isEmpty(); i++) {   // be careful about case heap.size() < k
			Pair res = heap.poll();
			result.add(new int[] {nums1[res.i], nums2[res.j]});
		}
		return result;
	}
	
	public void printResult(List<int[]> lists) {
		List<List<Integer>> res = new ArrayList<>();
		for (int[] list: lists) {
			List<Integer> temp = new ArrayList<>(Arrays.asList(list[0], list[1]));
			res.add(temp);
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKPairswithSmallestSums result = new FindKPairswithSmallestSums();
		result.printResult(result.findKPairswithSmallestSums(new int[] {1, 2, 4}, new int[] {1, 2, 8}, 5));
		result.printResult(result.findKPairswithSmallestSumsI(new int[] {1, 2, 4}, new int[] {1, 2, 8}, 5));
		result.printResult(result.findKPairswithSmallestSumsII(new int[] {1, 2, 4}, new int[] {1, 2, 8}, 5));
	}

}
