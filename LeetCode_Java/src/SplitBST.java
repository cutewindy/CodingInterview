/**
 * Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into 
 * two subtrees where one subtree has nodes that are all smaller or equal to the target value, while 
 * the other subtree has all nodes that are greater than the target value.  It's not necessarily the 
 * case that the tree contains a node with value V.
 * Additionally, most of the structure of the original tree should remain.  Formally, for any child 
 * C with parent P in the original tree, if they are both in the same subtree after the split, then 
 * node C should still have the parent P.
 * You should output the root TreeNode of both subtrees after splitting, in any order.
 * Example 1:
 * Input: root = [4,2,6,1,3,5,7], V = 2
 * Output: [[2,1],[4,3,6,null,null,5,7]]
 * Explanation:
 * Note that root, output[0], and output[1] are TreeNode objects, not arrays.
 * The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
	          4
	        /   \
	      2      6
	     / \    / \
	    1   3  5   7
 * while the diagrams for the outputs are:
	          4
	        /   \
	      3      6      and    2
	            / \           /
	           5   7         1
 * Note:
 * 1. The size of the BST will not exceed 50.
 * 2. The BST is always valid and each node's value is different.
 * @author wendi
 *
 */
public class SplitBST {
	
	
	/**
	 * DFS
	 * @param TreeNode root, int V
	 * @return TreeNode
	 * Time: O(log(n))
	 * Space: O(1)
	 * Stack space:O(log(n))
	 */
	public TreeNode[] splitBST(TreeNode root, int V) {
		if (root == null) return new TreeNode[2];
        TreeNode[] res = new TreeNode[2];
        if (root.val > V) {
            TreeNode[] temp = splitBST(root.left, V);
            root.left = temp[1];
            res[0] = temp[0];
            res[1] = root;
        }
        else {
            TreeNode[] temp = splitBST(root.right, V);
            root.right = temp[0];
            res[0] = root;
            res[1] = temp[1];
        }
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitBST result = new SplitBST();
		TreeNode root = TreeNode.generateCBT(new int[] {4,2,6,1,3,5,7});
		System.out.println(result.splitBST(root, 2));
	}

}
