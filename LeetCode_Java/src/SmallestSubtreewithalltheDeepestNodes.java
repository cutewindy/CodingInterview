/**
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 * Example 1:
 * Input: [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation:
 * 				 3
 *            /      \
 *           5        1
 *         /   \    /   \
 *        6     2  0     8
 *             / \
 *            7   4
 * We return the node with value 2, colored in yellow in the diagram.
 * The nodes colored in blue are the deepest nodes of the tree.
 * The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
 * The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
 * Both the input and output have TreeNode type.
 * Note:
 * 1. The number of nodes in the tree will be between 1 and 500.
 * 2. The values of each node are unique.
 * @author wendi
 *
 */
public class SmallestSubtreewithalltheDeepestNodes {

	
	/**
	 * get the depth first, then find the nodes with largest depth, return their common 
	 * ancestor. 
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
    public TreeNode smallestSubtreewithalltheDeepestNodes(TreeNode root) {
        if (root == null) return root;
        int depth = getDepth(root);
        return dfs(root, depth - 1);
    }
    
    private TreeNode dfs(TreeNode root, int depth) {
        if (depth == 0) return root;
        if (root == null) return null;
        TreeNode left = dfs(root.left, depth - 1);
        TreeNode right = dfs(root.right, depth - 1);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestSubtreewithalltheDeepestNodes result = new SmallestSubtreewithalltheDeepestNodes();
		TreeNode root = TreeNode.generateCBT(new int[] {3,5,1,6,2,0,8,7,4});
		TreeNode.printCBT(root);
		TreeNode.printCBT(result.smallestSubtreewithalltheDeepestNodes(root));
	}

}
