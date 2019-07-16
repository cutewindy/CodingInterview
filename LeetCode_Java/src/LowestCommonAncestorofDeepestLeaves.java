/**
 * Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.
 * Recall that:
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its 
 * children is d+1.
 * The lowest common ancestor of a set S of nodes is the node A with the largest depth such that 
 * every node in S is in the subtree with root A.
 * Example 1:
 * Input: root = [1,2,3]
 * Output: [1,2,3]
 * Explanation: 
 * The deepest leaves are the nodes with values 2 and 3.
 * The lowest common ancestor of these leaves is the node with value 1.
 * The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
 * Example 2:
 * Input: root = [1,2,3,4]
 * Output: [4]
 * Example 3:
 * Input: root = [1,2,3,4,5]
 * Output: [2,4,5]
 * Constraints:
 * 1. The given tree will have between 1 and 1000 nodes.
 * 2. Each node of the tree will have a distinct value between 1 and 1000.
 * @author wendi
 *
 */
public class LowestCommonAncestorofDeepestLeaves {
	
	
	/**
	 * DFS
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		if (root == null) return null;
		TreeNode[] res = new TreeNode[1];
		dfs(root, 0, new int[1], res);
		return res[0];
	}
	
	private int dfs(TreeNode root, int currDepth, int[] maxDepth, TreeNode[] res) {
		if (root == null) return currDepth - 1;
		int left = dfs(root.left, currDepth + 1, maxDepth, res);
		int right = dfs(root.right, currDepth + 1, maxDepth, res);
		maxDepth[0] = Math.max(currDepth, maxDepth[0]);
		if (left == maxDepth[0] && right == maxDepth[0]) {
			res[0] = root;
		}
		return Math.max(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestorofDeepestLeaves result = new LowestCommonAncestorofDeepestLeaves();
		TreeNode root1 = TreeNode.generateCBT(new int[] {1, 2, 3});
		TreeNode root2 = TreeNode.generateCBT(new int[] {1, 2, 3, 4});
		TreeNode root3 = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5});
		System.out.println(result.lcaDeepestLeaves(root1).val);
		System.out.println(result.lcaDeepestLeaves(root2).val);
		System.out.println(result.lcaDeepestLeaves(root3).val);
	}

}
