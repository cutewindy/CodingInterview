import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array 
 * has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * Example:
 * Input: [5,2,6,1]
 * Output: [2,1,1,0] 
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * @author wendi
 *
 */
public class CountofSmallerNumbersAfterSelf {
	
	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int count;
		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.count = 0;
		}
	}
	
	/**
	 * SegmentTree
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O(n + n + 2log(n))
	 * Space: O(n)
	 */
	public List<Integer> countofSmallerNumbersAfterSelf(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
        	min = Math.min(num, min);
        	max = Math.max(num, max);
        }
        SegmentTreeNode root = build(min, max);
        for (int i = nums.length - 1; i >= 0; i--) {
        	if (nums[i] == min) res.add(0, 0);
        	else res.add(0, query(root, nums[i] - 1));
        	modify(root, nums[i]);
        }
        return res;
    }
	
	/**
	 * O(n)
	 */
	private SegmentTreeNode build(int start, int end) {
		SegmentTreeNode root = new SegmentTreeNode(start, end);
		if (start == end) return root;
		int mid = start + (end - start) / 2;
		root.left = build(start, mid);
		root.right = build(mid + 1, end);
		return root;
	}
	
	/**
	 * O(log(n))
	 */
	private int query(SegmentTreeNode root, int index) {
		if (root.end <= index) return root.count;
		int mid = root.start + (root.end - root.start) / 2;
		if (index <= mid) return query(root.left, index);
		return query(root.left, index) + query(root.right, index);
	}
	
	/**
	 * O(log(n))
	 */
	private void modify(SegmentTreeNode root, int index) {
		if (root.start == index && root.end == index) {
			root.count++;
			return;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (index <= mid) modify(root.left, index);
		else modify(root.right, index);
		root.count = root.left.count + root.right.count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountofSmallerNumbersAfterSelf result = new CountofSmallerNumbersAfterSelf();
		System.out.println(result.countofSmallerNumbersAfterSelf(new int[] {5,2,6,1}));
		System.out.println(result.countofSmallerNumbersAfterSelf(new int[] {0,2,1}));
	}

}
