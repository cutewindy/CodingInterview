/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Tags: Tree, Array, DFS
 * @author wendi
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

	/**
	 * DFS: (Recursion): Last element of postorder is the root of subtree. First element of inorder is the 
	 * left most element of the subtree.  
	 * Find the inIndex as root, left part is [isStart, inIndex-1], right part is [inIndex+1, inEnd].
	 * Next left root is postIndex-(inEnd - inStart) -1, right root is postIndex-1.
	 * @param int[] inorder, int[] postorder
	 * @return TreeNode
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public TreeNode constructBinaryTreefromInorderandPostorderTraversal(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0|| postorder == null || postorder.length == 0 ||
				inorder.length != postorder.length) {
			return null;
		}
		return helper(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
	}
	
	private TreeNode helper(int[] postorder, int[] inorder, int postIndex, int inStart, int inEnd) {
		if (postIndex < 0 || inStart > inEnd) {
			return null;
		}
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postIndex]) {
				inIndex = i;
				break;
			}
		}
		TreeNode root = new TreeNode(inorder[inIndex]);
		root.left = helper(postorder, inorder, postIndex - (inEnd - inIndex) - 1, inStart, inIndex - 1);
		root.right = helper(postorder, inorder, postIndex - 1, inIndex + 1, inEnd);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromInorderandPostorderTraversal result = new ConstructBinaryTreefromInorderandPostorderTraversal();
		int[] inorder = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
		int[] postorder = {8, 9, 4, 10, 5, 2, 6, 7, 3, 1};
		TreeNode.printCBT(result.constructBinaryTreefromInorderandPostorderTraversal(inorder, postorder));
	}

}
