/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.
 * left has a value < node.val, and any descendant of node.right has a value > node.val.  Also 
 * recall that a preorder traversal displays the value of the node first, then traverses node.left, 
 * then traverses node.right.)
 * Example 1:
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *           8
 *         /   \
 *        5     10
 *       / \      \
 *      1   7      12      
 * Note: 
 * 1. 1 <= preorder.length <= 100
 * 2. The values of preorder are distinct.
 * @author wendi
 *
 */
public class ConstructBinarySearchTreefromPreorderTraversal {
	
	
	/**
	 * DFS
	 * @param int[] preorder
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public TreeNode constructBinarySearchTreefromPreorderTraversal(int[] preorder) {
		if (preorder == null || preorder.length == 0) return null;
		int[] index = new int[1];
		return dfs(preorder, index, null);
	}
	
	private TreeNode dfs(int[] preorder, int[] index, TreeNode max) {
		if (index[0] == preorder.length || max != null && preorder[index[0]] > max.val) return null;
		TreeNode root = new TreeNode(preorder[index[0]++]);
		root.left = dfs(preorder, index, root);
		root.right = dfs(preorder, index, max);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinarySearchTreefromPreorderTraversal result = new ConstructBinarySearchTreefromPreorderTraversal();
		TreeNode.printCBT(result.constructBinarySearchTreefromPreorderTraversal(new int[] {8,5,1,7,10,12}));
	}

}
