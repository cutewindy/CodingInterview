/**
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and 
 * all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes 
 * inclusive at the last level h.
 * 
 * Tags: Tree, Binary Search
 * @author wendi
 *
 */
public class CountCompleteTreeNodes {

	/**
	 * Method3: (Iteration) BinarySearch: find which part is final complete tree.
	 * If(height(root.right)==h-1), left part is a final complete tree with heigth h-1, move to right.
	 * Otherwise, right part is a final complete tree with height h-2, move to left find next one.
	 * @param TreeNode root
	 * @return int
	 * Time: O()
	 * Space: O(1)
	 */
	public int countCompleteTreeNodesII(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h = height(root);
		int result = 0;
		while (root != null) {
			if (height(root.right) == h - 1) { // means tree of root.left is a final complete tree with heigth = h-1
				result += (1 << (h - 1)) - 1 + 1;
				root = root.right;
			}
			else {   // means tree of root.right is a final complete tree with height = h-2
 				result += (1 << (h - 2)) - 1 + 1;
 				root = root.left;
			}
			h--;
		}
		return result;
	}
	
	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return height(root.left) + 1;
	}
	
	/**
	 * Method2: (Iteration + DFS) When leftDepth==rightDepth, it's a final compete tree, 
	 * the nodes number is 2^h - 1. Otherwise, count left complete tree + right complete tree + 1.
	 * @param TreeNode root
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int countCompleteTreeNodesI(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);
		if (leftDepth != rightDepth) {	
			return countCompleteTreeNodesI(root.left) + countCompleteTreeNodesI(root.right) + 1;
		}
		return (1 << leftDepth) - 1;
	}
	
	private int leftDepth(TreeNode root) {
		int depth = 0;
		while (root != null) {
			depth++;
			root = root.left;
		}
		return depth;
	}
	
	private int rightDepth(TreeNode root) {
		int depth = 0;
		while (root != null) {
			depth++;
			root = root.right;
		}
		return depth;
	}
	
	
	/**
	 * Method1: DFS (Time Limit Exceeded)
	 * @param TreeNode root
	 * @return int 
	 * Time: O()
	 * Space: O()
	 */
	public int countCompleteTreeNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root.left) + helper(root.right) + 1;
	}
	
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root.left) + helper(root.right) + 1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountCompleteTreeNodes result = new CountCompleteTreeNodes();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		TreeNode.printCBT(root);
//		System.out.println(result.countCompleteTreeNodes(root));
//		System.out.println(result.countCompleteTreeNodesI(root));
		System.out.println(result.countCompleteTreeNodesII(root));
	}

}
