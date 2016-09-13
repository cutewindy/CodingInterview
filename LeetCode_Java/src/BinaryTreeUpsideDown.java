/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node 
 * that shares the same parent node) or empty, flip it upside down and turn it into a tree where the 
 * original right nodes turned into left leaf nodes. Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},
		    1
		   / \
		  2   3
		 / \
		4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
		   4
		  / \
		 5   2
		    / \
		   3   1  
 * 
 * Tags: Tree
 * @author wendi
 *
 */
public class BinaryTreeUpsideDown {
	
	
	/**
	 * Method2: Iteration
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public TreeNode binaryTreeUpsideDownI(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		// init
		TreeNode left = root;
		TreeNode right = null;
		root = null;
		while (left != null) {
			TreeNode next = left.left;
			left.left = right;
			right = left.right;
			left.right = root;
			root = left;
			left = next;
		}
		return root;
	}
	
	
	/**
	 * Method1: Recursion: Backtracking
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(log(n))
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode binaryTreeUpsideDown(TreeNode root) {
		if (root == null) {
			return root;
		}
		return helper(root);
	}
	
	private TreeNode helper(TreeNode root) {
		if (root.left == null) {
			return root;
		}
		TreeNode newRoot = helper(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		return newRoot;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeUpsideDown result = new BinaryTreeUpsideDown();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5});
		TreeNode.printCBT(root);
		TreeNode.printCBT(result.binaryTreeUpsideDown(root));
		TreeNode root1 = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5});
		TreeNode.printCBT(root1);
		TreeNode.printCBT(result.binaryTreeUpsideDownI(root1));
	}	

}
