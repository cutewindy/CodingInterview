/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each 
 * node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's 
 * value is the smaller value among its two sub-nodes.
 * Given such a binary tree, you need to output the second minimum value in the set made of all the 
 * nodes' value in the whole tree.
 * If no such second minimum value exists, output -1 instead.
 * Example 1:
 * Input: 
		    2
		   / \
		  2   5
		     / \
		    5   7
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input: 
		    2
		   / \
		  2   2
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 * @author wendi
 *
 */
public class SecondMinimumNodeInaBinaryTree {
	
	/**
	 * Set root as min, if find any one > min, return, others -1
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int secondMinimumNodeInaBinaryTree(TreeNode root) {
		if (root == null || root.left == null && root.right == null) return -1;
		int res = helper(root, root.val);
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	
	public int helper(TreeNode root, int min) {
		if (root == null) return Integer.MAX_VALUE;
		if (root.val > min) return root.val;
		return Math.min(helper(root.left, min), helper(root.right, min));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondMinimumNodeInaBinaryTree result = new SecondMinimumNodeInaBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {2, 5, 2, 7, 5});
		TreeNode root1 = TreeNode.generateCBT(new int[] {2, 2, 2, 2, 2});
		TreeNode.printCBT(root);
		System.out.println(result.secondMinimumNodeInaBinaryTree(root));
		TreeNode.printCBT(root1);
		System.out.println(result.secondMinimumNodeInaBinaryTree(root1));
	}

}
