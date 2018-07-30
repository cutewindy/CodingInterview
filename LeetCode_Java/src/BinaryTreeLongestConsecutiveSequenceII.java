/**
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
 * Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and 
 * [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the 
 * path can be in the child-Parent-child order, where not necessarily be parent-child order.
 * Example 1:
 * Input:
 *         1
 *        / \
 *       2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 * Example 2:
 * Input:
 *         2
 *        / \
 *       1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 * @author wendi
 *
 */
public class BinaryTreeLongestConsecutiveSequenceII {
	
	/**
	 * Backtracking
	 * For each subtree we recursively compute the length of longest ascending and descending path 
	 * starting from the subtree root. Then we can efficiently check if we could join the two 
	 * subtree together to get a longer child-parent-child path. In another word, for each subtree, 
	 * the longest child-parent-child consecutive (with root being the parent) is dec+inc-1 since 
	 * both the ascending and descending path start from root.
	 * @param TreeNode root
	 * @return int
	 * Time:O(n)
	 * Space: O(1)
	 * Stack spcae: O(log(n))
	 */
	private int res;
	public int binaryTreeLongestConsecutiveSequenceII(TreeNode root) {
		if (root == null) return 0;
		res = 0;
		dfs(root);
		return res;
	}
	
	private int[] dfs(TreeNode root) {
		if (root == null) return new int[2];  // [increasing, decreasing]
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		int inc = 1, dec = 1;   
		if (root.left != null) {
			if (root.val == root.left.val + 1) inc += left[0];
			if (root.val == root.left.val - 1) dec += left[1];
		}
		if (root.right != null) {
			if (root.val == root.right.val + 1) inc = Math.max(right[0] + 1, inc);
			if (root.val == root.right.val - 1) dec = Math.max(right[1] + 1, dec);
		}
		res = Math.max(inc + dec - 1, res);
		return new int[] {inc, dec};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLongestConsecutiveSequenceII result = new BinaryTreeLongestConsecutiveSequenceII();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeLongestConsecutiveSequenceII(root));
		TreeNode root1 = TreeNode.generateCBT(new int[] {2, 1, 3});
		TreeNode.printCBT(root1);
		System.out.println(result.binaryTreeLongestConsecutiveSequenceII(root1));
	}

}
