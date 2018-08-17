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
	
    class SegmentTree {
        public SegmentTreeNode root;
        
        public SegmentTree (int start, int end) {
            root = build(start, end);
        }
        
        public SegmentTreeNode build(int start, int end) {
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start == end) return root;
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
            return root;
        }
        
        public int query(int val) {
            return query(root, val);
        }
        
        public int query(SegmentTreeNode root, int val) {
            if (root.end <= val) return root.count;
            int mid = root.start + (root.end - root.start) / 2;
            if (mid >= val) return query(root.left, val);
            return query(root.left, val) + query(root.right, val);
        }
        
        public void modify(int val) {
            modify(root, val);
        }
        
        public void modify(SegmentTreeNode root, int val) {
            if (root.start == val && root.end == val) {
                root.count++;
                return;
            }
            int mid = root.start + (root.end - root.start) / 2;
            if (mid >= val) modify(root.left, val);
            else modify(root.right, val);
            root.count = root.left.count + root.right.count;
        }
    }
	
	/**
	 * SegmentTree
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O(n + n + n*2log(n))
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
        SegmentTree ST = new SegmentTree(min, max);
        for (int i = nums.length - 1; i >= 0; i--) {
        	if (nums[i] == min) res.add(0, 0);  // take care when nums[i]==min
        	else res.add(0, ST.query(nums[i] - 1));
        	ST.modify(nums[i]);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountofSmallerNumbersAfterSelf result = new CountofSmallerNumbersAfterSelf();
		System.out.println(result.countofSmallerNumbersAfterSelf(new int[] {5,2,6,1}));
		System.out.println(result.countofSmallerNumbersAfterSelf(new int[] {0,2,1}));
	}

}
