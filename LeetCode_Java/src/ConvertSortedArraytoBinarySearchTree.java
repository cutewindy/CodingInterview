/**
 * Given an array where elements are sorted in ascending order, convert it to a height 
 * balanced BST.
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * Divide and Conquer: find root first, then recursively build each left and right subtree
	 * @param int[] nums
	 * @return TreeNode
	 * Time: O(n) n is the number of nodes
	 * Space: O(1)
	 */
	public TreeNode convertSortedArraytoBInarySearchTree(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(0, nums.length - 1, nums);
	}
	
	private TreeNode helper(int start, int end, int[] nums) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(start, mid - 1, nums);
		root.right = helper(mid + 1, end, nums);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedArraytoBinarySearchTree result = new ConvertSortedArraytoBinarySearchTree();
		TreeNode.printCBT(result.convertSortedArraytoBInarySearchTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
	}

}
