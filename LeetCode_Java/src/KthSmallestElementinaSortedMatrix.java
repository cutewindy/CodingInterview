import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the 
 * kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
		matrix = [
		   [ 1,  5,  9],
		   [10, 11, 13],
		   [12, 13, 15]
		],
 * k = 8,
 * return 13.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * Tags: Binary Search, Heap
 * @author wendi
 *
 */
public class KthSmallestElementinaSortedMatrix {
	class Node {
		int i;
		int j;
		int val;
		public Node(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}
	}
	
	/**
	 * Heap: pull min element from minHeap, and offer matrix[i][j+1] into heap. If j = 0, offer 
	 * matrix[i+1][j] into heap as well
	 * @param int[] matrix, int k
	 * @return int
	 * Time: O(klog(2k-1))
	 * Space: O(k)
	 */
	public int kthSmallestElementinaSortedMatrix(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}
		PriorityQueue<Node> heap = new PriorityQueue<>(k, new Comparator<Node>(){
			@Override 
			public int compare(Node a, Node b) {
				return a.val - b.val;
			}
		});
		heap.offer(new Node(0, 0, matrix[0][0]));
		Node result = new Node(-1, -1, -1);
		while (!heap.isEmpty() && k-- > 0) {
			result = heap.poll();
			int row = result.i;
			int col = result.j;
			if (col + 1 < matrix[0].length) {
				heap.offer(new Node(row, col + 1, matrix[row][col + 1]));
			}
			if (col == 0 && row + 1 < matrix.length) {
				heap.offer(new Node(row + 1, result.j, matrix[row + 1][col]));
			}
		}
		return result.val;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestElementinaSortedMatrix result = new KthSmallestElementinaSortedMatrix();
		System.out.println(result.kthSmallestElementinaSortedMatrix(new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}},  8));
	}

}
