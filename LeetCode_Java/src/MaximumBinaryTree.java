/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
	      6
	    /   \
	   3     5
	    \    / 
	     2  0   
	       \
	        1
 * Note:
 * The size of the given array will be in the range [1,1000].
 * @author wendi
 *
 */
public class MaximumBinaryTree {
	
	/**
	 * 
	 * @param int[] nums
	 * @return TreeNode
	 * Time: O()
	 * Space: O()
	 */
	public TreeNode maximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		return buildTree(nums, 0, nums.length - 1);
	}
	
	private TreeNode buildTree(int[] nums, int left, int right) {
		if (left < 0 || right > nums.length - 1 || left > right) return null;
		int maxIndex = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] > nums[maxIndex]) maxIndex = i;
		}
		TreeNode root = new TreeNode(nums[maxIndex]);
		root.left = buildTree(nums, left, maxIndex - 1);
		root.right = buildTree(nums, maxIndex + 1, right);
		return root;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumBinaryTree result = new MaximumBinaryTree();
		TreeNode.printCBT(result.maximumBinaryTree(new int[] {3,2,1,6,0,5}));
	}

}
