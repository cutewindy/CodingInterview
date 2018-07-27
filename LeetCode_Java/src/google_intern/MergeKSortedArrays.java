package google_intern;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given k sorted integer arrays, merge them into one sorted array.
 * Example
 * Given 3 sorted arrays:
 * [
 *   [1, 3, 5, 7],
 *   [2, 4, 6],
 *   [0, 8, 9, 10, 11]
 * ]
 * return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
 * Challenge
 * Do it in O(N log k).
 * N is the total number of integers.
 * k is the number of arrays.
 * @author wendi
 *
 */
public class MergeKSortedArrays {
	
	class Node {
		int row, col;
		int val;
		public Node(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
	
	/**
	 * MinHeap
	 * @param int[][] arrays
	 * @return int[]
	 * Time: O(nlog(k))
	 * Space: O(k)
	 */
    public int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) return null;
        int k = arrays.length;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>() {
        	@Override
        	public int compare(Node a, Node b) {
        		return a.val - b.val;
        	}
        });
        
        int size = 0;
        for (int i = 0; i < k; i++) {
        	if (arrays[i] == null || arrays[i].length == 0) continue;
        	minHeap.offer(new Node(i, 0, arrays[i][0]));
        	size += arrays[i].length;
        }
        
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
        	Node curr = minHeap.poll();
        	res[i] = curr.val;
        	if (curr.col != arrays[curr.row].length - 1) {
        		minHeap.offer(new Node(curr.row, curr.col + 1, arrays[curr.row][curr.col + 1]));
        	}
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeKSortedArrays result = new MergeKSortedArrays();
		System.out.println(Arrays.toString(result.mergeKSortedArrays(new int[][] {{1, 3, 5, 7},{2, 4, 6},{0, 8, 9, 10, 11}})));
	}

}
