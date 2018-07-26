package google_intern;

import java.util.ArrayList;
import java.util.List;

/**
 * Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 
 * to 10000) and an query list. For each query, give you an integer, return the number of element in 
 * the array that are smaller than the given integer.
 * We suggest you finish problem Segment Tree Build and Segment Tree Query II first.
 * Example
 * For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]
 * Challenge
 * Could you use three ways to do it.
 * 1. Just loop
 * 2. Sort and binary search
 * 3. Build Segment Tree and Search.
 * @author wendi
 *
 */
public class CountofSmallerNumber {

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
	 * @param int[] A, int[] queries
	 * @return List<Integer>
	 * Time: O(n + alog(n) + qlog(n)) a=A.length, q=queries.length, n=10000
	 * Space: O(n)
	 */
	public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        List<Integer> res = new ArrayList<>();
        if (queries == null || queries.length == 0) return res;
        SegmentTreeNode root = build(0, 10000);
        for (int a: A) {
        	modify(root, a);
        }
        for (int q: queries) {
        	res.add(query(root, q - 1));
        }
        return res;
    }
	
	/**
	 * O(n) n = 10000
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
	
	/**
	 * O(log(n))
	 */
	private int query(SegmentTreeNode root, int index) {
		if (root.end <= index) return root.count;
		int mid = root.start + (root.end - root.start) / 2;
		if (index <= mid) return query(root.left, index);
		return query(root.left, index) + query(root.right, index);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountofSmallerNumber result = new CountofSmallerNumber();
		System.out.println(result.countOfSmallerNumber(new int[] {1,2,7,8,5}, new int[] {1,8,5}));
	}

}
