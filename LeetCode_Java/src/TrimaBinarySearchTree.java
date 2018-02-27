/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so 
 * that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so 
 * the result should return the new root of the trimmed binary search tree.
 * Example 1:
 * Input: 
		    1
		   / \
		  0   2	
		  L = 1
		  R = 2
 * Output: 
		    1
		      \
		       2
 * Example 2:
 * Input: 
		    3
		   / \
		  0   4
		   \
		    2
		   /
		  1
		  L = 1
		  R = 3
 * Output: 
		      3
		     / 
		   2   
		  /
		 1
 * @author wendi
 *
 */
public class TrimaBinarySearchTree {
	
	/**
	 * Recursive solution
	 * @param TreeNode root, int L, int R
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public TreeNode trimaBinarySearchTree(TreeNode root, int L, int R) {
		if (root == null) return null;
		return helper(root, L, R);
	}
	
	public TreeNode helper(TreeNode root, int L, int R) {
		if (root == null) return null;
		if (root.val < L) {
			return helper(root.right, L, R);
		}
		if (root.val > R) {
			return helper(root.left, L, R);
		}
		root.left = helper(root.left, L, R);
		root.right = helper(root.right, L, R);
		return root;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrimaBinarySearchTree result = new TrimaBinarySearchTree();
		TreeNode root = TreeNode.generateCBT(new int[] {3, 0, 4, -2, 2, 3, 5, -3, -1, 1});
		TreeNode newroot = result.trimaBinarySearchTree(root, 1, 3);
		TreeNode.printCBT(root);
		TreeNode.printCBT(newroot);
	}

}
