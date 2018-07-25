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
	
	private SegmentTreeNode root;
	
    public RangeSumQueryMutable(int[] nums) {
        this.root = buildSegmentTree(nums, 0, nums.length - 1);
    }
    
    /**
     * Time: O(n)
     */
    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
    	if (start > end) return null;
    	SegmentTreeNode currRoot = new SegmentTreeNode(start, end);
    	if (start == end) currRoot.sum = nums[start];
    	else {
    		int mid = start + (end - start) / 2;
    		currRoot.left = buildSegmentTree(nums, start, mid);
    		currRoot.right = buildSegmentTree(nums, mid + 1, end);
    		currRoot.sum = currRoot.left.sum + currRoot.right.sum;
    	}
    	return currRoot;
    }
    
    /**
     * Time: O(log(n))
     */
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode root, int i, int val) {
    	if (root.start == root.end) {
    		root.sum = val;
    		return;
    	}
    	int mid = root.start + (root.end - root.start) / 2;
    	if (i <= mid) update(root.left, i, val);
    	else update(root.right, i, val);
    	root.sum = root.left.sum + root.right.sum;
    }
    
    /**
     * Time: O(log(n))
     */
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode root, int start, int end) {
    	if (root.start == start && root.end == end) return root.sum;
    	int mid = root.start + (root.end - root.start) / 2;
    	if (end <= mid) return sumRange(root.left, start, end);
    	else if (start > mid) return sumRange(root.right, start, end);
    	return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeSumQueryMutable result = new RangeSumQueryMutable(new int[] {1,3,5});
		System.out.println(result.sumRange(0, 2));
		result.update(1, 2);
		System.out.println(result.sumRange(0, 2));
	}

}
