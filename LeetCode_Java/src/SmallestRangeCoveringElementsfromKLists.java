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
public class SmallestRangeCoveringElementsfromKLists {
	
	/**
	 * MinHeap
	 * Image you are merging k sorted array using a heap. Then everytime you pop the smallest 
	 * element out and add the next element of that array to the heap. By keep doing this, you will 
	 * have the smallest range.
	 * @param List<List<Integer>> nums
	 * @return int[]
	 * Time: O(n*m*log(m)) n=nums.size(), m=nums[i].size()
	 * Space: O(n)
	 */
	public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) return new int[0];
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {     // int[] = [i, j, val]
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        
        // init
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new int[] {i, 0, nums.get(i).get(0)});
            max = Math.max(nums.get(i).get(0), max);
        }
        
        // update
        int[] res = null;
        while (true) {
            int[] curr = minHeap.poll();
            if (res == null || max - curr[2] < res[1] - res[0]) {
                if (res == null) res = new int[2];
                res[0] = curr[2];
                res[1] = max;
            }
            if (curr[1] + 1 == nums.get(curr[0]).size()) break;
            curr[1] = curr[1] + 1;
            curr[2] = nums.get(curr[0]).get(curr[1]);
            minHeap.offer(curr);
            max = Math.max(curr[2], max);
        }
        
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestRangeCoveringElementsfromKLists result = new SmallestRangeCoveringElementsfromKLists();
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
