/**
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node 
 * in the tree along the parent-child connections. The path does not need to go through the root.
 * For example:
 * Given the below binary tree,
	       1
	      / \
	     2   3
 * Return 6.
 * 
 * Tags: Tree, DFS 
 * @author wendi
 *
 */
public class BinaryTreeMaximumPathSum {
	
	/**
	 * Backtracking: use helper func to return the max path that end at curr root.left and
	 * curr root.right, then compare max_root.left + max+root.right + root.val and the global value 
	 * maxPath, obtain the max one. Choose max(max_root.left, max_root.right)+root.val return to 
	 * parents.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	private int maxPath;
	public int binaryTreeMaximumPathSum(TreeNode root) {
		if (root == null) return 0;
		maxPath = Integer.MIN_VALUE;
		getRootPathSum(root);
		return maxPath;
	}
	
	private int getRootPathSum(TreeNode root) {
		if (root == null) return 0;
		int leftPath = Math.max(getRootPathSum(root.left), 0);   // take care about the negative result
		int rightPath = Math.max(getRootPathSum(root.right), 0);
		maxPath = Math.max(leftPath + root.val + rightPath, maxPath);
		return Math.max(leftPath, rightPath) + root.val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum result = new BinaryTreeMaximumPathSum();
		TreeNode root = TreeNode.generateCBT(new int[] {1, -2, 3, -4, -5, 6, 5});
//		TreeNode root = TreeNode.generateCBT(new int[] {2, -1});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeMaximumPathSum(root));
	}

}
