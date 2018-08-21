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
	 * Method4: DFS: (Iterative):(Template Inorder): 
	 * Traverse tree in inorder, if it's a BST, pre.val<curr.val 
	 * @param TreeNode: root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean validateBinarySearchTreeIII(TreeNode root) {
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
	 * Method3: DFS: (Recursion):(Template Inorder): 
	 * Traverse tree in inorder, if it's a BST, pre.val<curr.val 
	 * @param TreeNode: root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean validateBinarySearchTreeII(TreeNode root) {
		if (root == null) return true;
		TreeNode[] prev = new TreeNode[] {null};
		return dfsII(root, prev);
	}
	
	private boolean dfsII(TreeNode root, TreeNode[] prev) {
		if (root == null) return true;
		if (!dfsII(root.left, prev)) return false;
		if (prev[0] != null && prev[0].val >= root.val) return false;
		prev[0] = root;
		return dfsII(root.right, prev);
	}
	
	/**
	 * Method2: DFS(Recursion): TOP-DOWM 
	 * Parents give children tree nodes, currNode root, maxNode with the 
	 * max val and minNode with the min val.
	 * If minNode.val < currNode.val < maxNode.val, it's satisfied as BST, otherwise return false.
	 * Then check currNode.left and currNode.right. 
	 * To left, currNode is maxNode, but to right, currNode is minNode .
	 * @param TreeNode root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean validateBinarySearchTreeI(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root, null, null);
//		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean helper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
		if (root == null) {
			return true;
		}
		if (minNode != null && root.val <= minNode.val || maxNode != null && root.val >= maxNode.val) {
			return false;
		}
		return helper(root.left, minNode, root) && helper(root.right, root, maxNode);
	}
	
	// or use long min and long max
    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (min >= root.val || root.val >= max) return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }	
    
    
	/**
	 * Method1: DFS(Recursion): BOOTOM-UP
	 * @param TreeNode root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean validateBinarySearchTree(TreeNode root) {
		if (root == null) return true;
		boolean[] res = {true};
		checkValid(root, res);
		return res[0];
	}
    
	public int[] checkValid(TreeNode root, boolean[] res) {    // int[] = {min, max}
		if (root == null) return null;
		int[] left = checkValid(root.left, res);
		int[] right = checkValid(root.right, res);
		if (left == null && right == null) return new int[] {root.val, root.val};
		if (left != null && left[1] >= root.val || right != null && right[0] <= root.val) res[0] = false;
		if (left == null) return new int[] {root.val, right[1]};
		if (right == null) return new int[] {left[0], root.val};
		return new int[] {left[0], right[1]};
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBinarySearchTree result = new ValidateBinarySearchTree();
		TreeNode root = TreeNode.generateCBT(new int[] {20, 10, 30, 5, 15, 25, 40, 1, 6, 12, 18, 22, 27, 35, 45});
//		TreeNode root = TreeNode.generateCBT(new int[] {1, 1});
		TreeNode.printCBT(root);
		System.out.println(result.validateBinarySearchTree(root));
		System.out.println(result.validateBinarySearchTreeI(root));
		System.out.println(result.validateBinarySearchTreeII(root));
		System.out.println(result.validateBinarySearchTreeIII(root));
	}

}
