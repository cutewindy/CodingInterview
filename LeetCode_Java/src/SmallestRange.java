import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at 
 * least one number from each of the k lists.
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * Example 1:
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation: 
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Note:
 * 1. The given list may contain duplicates, so ascending order means >= here.
 * 2. 1 <= k <= 3500
 * 3. -105 <= value of elements <= 105.
 * 4. For Java users, please note that the input type has been changed to List<List<Integer>>. And 
 * after you reset the code template, you'll see this point.
 * @author wendi
 *
 */
public class SmallestRange {
	
	/**
	 * MinHeap
	 * Image you are merging k sorted array using a heap. Then everytime you pop the smallest 
	 * element out and add the next element of that array to the heap. By keep doing this, you will 
	 * have the smallest range.
	 * @param List<List<Integer>> nums
	 * @return int[]
	 * Time: O(n*m) n=nums.size(), m=nums[i].size()
	 * Space: O(n)
	 */
	public int[] smallestRange(List<List<Integer>> nums) {
		if (nums == null || nums.size() == 0) return new int[2];
		PriorityQueue<Node> minHeap = new PriorityQueue<>(nums.size(), new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				return a.val - b.val;
			}
		});
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			int val = nums.get(i).get(0);
			minHeap.offer(new Node(i, 0, val));
			max = Math.max(val, max);
		}
		int[] res = {0, Integer.MAX_VALUE};
		while (true) {
			Node curr = minHeap.poll();
			if (max - curr.val < res[1] - res[0]) {
				res[1] = max;
				res[0] = curr.val;
			}
			if (curr.j + 1 >= nums.get(curr.i).size()) break;
			curr.j = curr.j + 1;
			curr.val = nums.get(curr.i).get(curr.j);
			minHeap.offer(curr);
			max = Math.max(curr.val, max);
		}
		return res;
	}
	
	class Node{
		int i;
		int j;
		int val;
		public Node(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestRange result = new SmallestRange();
		List<Integer> l1 = new ArrayList<>(Arrays.asList(4, 10, 15, 24,26));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(0, 9, 12, 20));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(5, 18, 22, 30));
		List<List<Integer>> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		System.out.println(Arrays.toString(result.smallestRange(list)));
	}

}
