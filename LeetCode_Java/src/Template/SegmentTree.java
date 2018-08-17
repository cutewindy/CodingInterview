package Template;

import java.util.Arrays;

/**
 * 解决**区间操作**相关问题
 * 什么情况下，无法使用线段树？
 * 如果我们删除或者增加区间中的元素，那么区间的大小将发生变化，此时是无法使用线段树解决这种问题的。
 * 
 * 举一反三：
 * 区间最大值: root.max = Math.max(root.left.max, root.right.max);
 * 区间最小值: root.min = Math.min(root.left.min, root.right.min);
 * 区间和: root.sum = root.left.sum + root.right.sum;
 * 区间数量: root.count = root.left.count + root.right.count;
 * 
 * 307. Range Sum Query - Mutable
 * 315. Count of Smaller Numbers After Self
 * 248. Count of Smaller Number(Lint code)
 * 
 * @author wendi
 *
 */
public class SegmentTree {
	
	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int max;
		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.max = 0;
		}
	}	

	public SegmentTreeNode root;
	public SegmentTree(int[] nums) {
		if (nums == null || nums.length == 0) return;
		this.root = build(nums, 0, nums.length - 1);
	}
	
	/**
	 * O(n)&O(n)，一共2n个节点
	 * 自上而下递归生成节点
	 * 自下而上更新节点
	 */
	public SegmentTreeNode build(int[] nums, int start, int end) {
		SegmentTreeNode root = new SegmentTreeNode(start, end);
		if (start == end) {
			root.max = nums[start];
			return root;
		}
		int mid = start + (end - start) / 2;
		root.left = build(nums, start, mid);
		root.right = build(nums, mid + 1, end);
		root.max = Math.max(root.left.max, root.right.max);
		return root;
	}
	
	/**
	 * O(logn)&O(1)
	 * 自上而下递归找在区间范围内的线段树节点(locate node)，返回最大的节点
	 */
	public int query(int start, int end) {
		return query(root, start, end);
	}
	
	public int query(SegmentTreeNode root, int start, int end) {
		if (root.start == start && root.end == end) return root.max;
		int mid = root.start + (root.end - root.start) / 2;
		if (end <= mid) return query(root.left, start, end);
		else if (start > mid) return query(root.right, start, end);
		return Math.max(query(root.left, start, mid), query(root.right, mid + 1, end)); 
	}
	
	/**
	 * O(logn)&O(1)
	 * 自上而下递归找索引为index的线段树节点(locate index)，更新该节点的值
	 * 自下而上更新所有父亲节点的值
	 */
	public void modify(int index, int value) {
		modify(root, index, value);
	}
	
	public void modify(SegmentTreeNode root, int index, int value) {
		if (root.start == index && root.end == index) {
			root.max = value;
			return;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (index <= mid) modify(root.left, index, value);
		else modify(root.right, index, value);
		root.max = Math.max(root.left.max, root.right.max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 4, 2, 5, 6, 3};
		SegmentTree ST = new SegmentTree(nums);
		for (int i = 0; i < nums.length; i++) System.out.print(" " + i + " ");
		System.out.println("\n" + Arrays.toString(nums));
		System.out.println("max num in range [1, 3]:   " + ST.query(1, 3));
		System.out.println("root.max:                  " + ST.root.max);
		ST.modify(2, 7);
		System.out.println("\nmodify nums[2] as 7:");
		System.out.println("max num in range [1, 3]:   " + ST.query(1, 3));
		System.out.println("root.max:                  " + ST.root.max);
	}

}
