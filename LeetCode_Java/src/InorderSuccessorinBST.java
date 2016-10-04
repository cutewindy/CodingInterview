
/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * Tags: Tree
 * @author wendi
 *
 */
public class InorderSuccessorinBST {
	
	/**
	 * Method2: Iteration
	 * The idea is to compare root's value with p's value if root is not null, and consider the 
	 * following two cases:
	 * 1. root.val > p.val. In this case, root can be a possible answer, so we store the root node 
	 *    first and call it res. However, we don't know if there is anymore node on root's left that 
	 *    is larger than p.val. So we move root to its left and check again.
	 * 2. root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's 
	 *    left child. So we only need to consider root's right child, thus we move root to its right 
	 *    and check again.
	 * We continuously move root until exhausted. To this point, we only need to return the res in 
	 * case 1.
	 * @param TreeNode root, TreeNode p
	 * @return TreeNode
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public TreeNode inorderSuccessorinBSTI(TreeNode root, TreeNode p) {
		if (root == null || p == null) {
			return null;
		}
		TreeNode result = null;
		while (root != null) {
			if (root.val > p.val) {
				result = root;
				root = root.left;
			}
			else {
				root = root.right;
			}
		}
		return result;
	}
	
	
	/**
	 * Method1: Recursion
	 * If root.val <= p.val, then the inorder successor must be in the right subtree. 
	 * Else if root.val > p.val, the inorder successor could be current root, or some smaller value 
	 * inside the left subtree.
	 * @param TreeNode root, TreeNode p
	 * @return TreeNode
	 * Time: O(log(n))
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode inorderSuccessorinBST(TreeNode root, TreeNode p) {
		if (root == null || p == null) {
			return null;
		}
		return helper(root, p);
	}
	
	private TreeNode helper(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		if (root.val <= p.val) {
			return helper(root.right, p);
		}
		else {
			TreeNode left = helper(root.left, p);
			return left == null ? root : left;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InorderSuccessorinBST result = new InorderSuccessorinBST();
		TreeNode root = TreeNode.generateCBT(new int[] {10, 4, 12, 1, 6});
		TreeNode p = root.left.right;
		TreeNode.printCBT(root);
		System.out.println(p.val);
		System.out.println(result.inorderSuccessorinBST(root, p).val);
		System.out.println(result.inorderSuccessorinBST(root, p).val);
	}

}
