/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Tags: Tree, Array, DFS
 * @author wendi
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

	/**
	 * DFS(Recursion) First element of preorder is the root of subtree. First element of inorder is the 
	 * left most element of the subtree. 
	 * Find the same element of preorder[preIndex] in inorder traversal as root, it's inorder[inIndex].
	 * Then left part is [inStart, inIndex-1], right part is [inIndex+1, inEnd].
	 * Next left root is preorder[preIndex+1], right root is preorder[preIndex+inIndex-inStart+1]
	 * inIndex - inStart + 1 is the number of left nodes 
	 * @param int[] preorder, int[] inorder
	 * @return TreeNode
	 * Time: O(n^2)   // can use a hashmap save inorder [value, index] pair to improve T to O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode constructBinaryTreefromPreorderandInorderTraversal(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 ||
				preorder.length != inorder.length) { 
			return null;
		}
		return helper(preorder, inorder, 0, 0, inorder.length - 1);
	}
	
	private TreeNode helper(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
		if (preIndex > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		// get the root index in inorder
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == preorder[preIndex]) {
				inIndex = i;
				break;
			}
		}
		TreeNode root = new TreeNode(inorder[inIndex]);
		root.left = helper(preorder, inorder, preIndex + 1, inStart, inIndex - 1);
		root.right = helper(preorder, inorder, preIndex + inIndex - inStart + 1, inIndex + 1, inEnd);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromPreorderandInorderTraversal result = new ConstructBinaryTreefromPreorderandInorderTraversal();
		int[] preorder = {1, 2, 4, 8, 9, 5, 10, 3, 6, 7};
		int[] inorder = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
		TreeNode.printCBT(result.constructBinaryTreefromPreorderandInorderTraversal(preorder, inorder));
	}

}
