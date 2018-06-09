/**
 * We are given the head node root of a binary tree, where additionally every node's value is either 
 * a 0 or a 1.
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 * Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * Explanation: 
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 * Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 * Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 * Note:
 * The binary tree will have at most 100 nodes.
 * The value of each node will only be 0 or 1.
 * @author wendi
 *
 */
public class BinaryTreePruning {
	
	
	/**
	 * Recursion
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode binaryTreePruning(TreeNode root) {
        if (root == null) return null;
        return pruning(root);
    }
    
    private TreeNode pruning(TreeNode root) {
        if (root == null) return null;
        root.left = pruning(root.left);
        root.right = pruning(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePruning result = new BinaryTreePruning();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 0, 0, 0, 0, 1, 0});
		TreeNode.printCBT(root);
		TreeNode.printCBT(result.binaryTreePruning(root));
		
	}

}
