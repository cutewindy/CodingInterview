import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
	    2
	   / \
	  1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
	    1
	   / \
	  2   3
 * Binary tree [1,2,3], return false.
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class ValidateBinarySearchTree {

	/**
	 * DFS: (Iterative):(Template Inorder): Traverse tree in inorder, if it's a BST, pre.val<curr.val 
	 * @param TreeNode: root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean validateBinarySearchTreeI(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val) {
				return false;
			}
			pre = root;
			root = root.right;
		}
		return true;
	}
	
	
	
	/**
	 * Method1: DFS(Recursion): Parents give children tree nodes, currNode root, maxNode with the max val and minNode with the min val.
	 * If minNode.val < currNode.val < maxNode.val, it's satisfied as BST, otherwise return false.
	 * Then check currNode.left and currNode.right. 
	 * To left, currNode is maxNode, but to right, currNode is minNode .
	 * @param TreeNode root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean validateBinarySearchTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root, null, null);
	}
	
	private boolean helper(TreeNode root, TreeNode maxNode, TreeNode minNode) {
		if (root == null) {
			return true;
		}
		if ((minNode != null && root.val <= minNode.val) || (maxNode != null && root.val >= maxNode.val)) {
			return false;
		}
		return helper(root.left, root, minNode) && helper(root.right, maxNode, root);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBinarySearchTree result = new ValidateBinarySearchTree();
		TreeNode root = TreeNode.generateCBT(new int[] {20, 10, 30, 5, 15, 25, 40, 1, 6, 12, 18, 22, 27, 35, 45});
//		TreeNode root = TreeNode.generateCBT(new int[] {1, 1});
		TreeNode.printCBT(root);
//		System.out.println(result.validateBinarySearchTree(root));
		System.out.println(result.validateBinarySearchTreeI(root));
	}

}
