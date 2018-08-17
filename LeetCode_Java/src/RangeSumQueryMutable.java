/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), 
 * inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * 1. The array is only modifiable by the update function.
 * 2. You may assume the number of calls to update and sumRange function is distributed evenly.
 * @author wendi
 *
 */
public class RangeSumQueryMutable {
	
	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int sum;
		
		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}
	
    class SegmentTree {
        public SegmentTreeNode root;
        
        public SegmentTree(int[] nums) {
            if (nums == null || nums.length == 0) return;
            this.root = build(nums, 0, nums.length - 1);
        }
        
        /**
         * Time: O(n)
         */
        public SegmentTreeNode build(int[] nums, int start, int end) {
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start == end) {
                root.sum = nums[start];
                return root;
            }
            int mid = start + (end - start) / 2;
            SegmentTreeNode left = build(nums, start, mid);
            SegmentTreeNode right = build(nums, mid + 1, end);
            root.left = left;
            root.right = right;
            root.sum = left.sum + right.sum;
            return root;
        }
        
        /**
         * Time: O(log(n))
         */
        public int query(int start, int end) {
            return query(this.root, start, end);
        }
        
        public int query(SegmentTreeNode root, int start, int end) {
            if (root.start == start && root.end == end) return root.sum;
            int mid = root.start + (root.end - root.start) / 2;
            if (mid >= end) return query(root.left, start, end);
            else if (mid < start) return query(root.right, start, end);
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
        
        /**
         * Time: O(log(n))
         */
        public void modify(int index, int val) {
            modify(this.root, index, val);
        }
        
        public void modify(SegmentTreeNode root, int index, int val) {
            if (root.start == index && root.end == index) {
                root.sum = val;
                return;
            }
            int mid = root.start + (root.end - root.start) / 2;
            if (mid >= index) modify(root.left, index, val);
            else modify(root.right, index, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }

    SegmentTree ST; 
    public RangeSumQueryMutable(int[] nums) {
        this.ST = new SegmentTree(nums);
    }
    
    /**
     * @param int i, int val
     * Time: O(log(n))
     */
    public void update(int i, int val) {
        ST.modify(i, val);
    }
    
    /**
     * @param int i, int j
     * @return int
     * Time: O(log(n))
     */
    public int sumRange(int i, int j) {
        return ST.query(i, j);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeSumQueryMutable result = new RangeSumQueryMutable(new int[] {1,3,5});
		System.out.println(result.sumRange(0, 2));
		result.update(1, 2);
		System.out.println(result.sumRange(0, 2));
	}

}
