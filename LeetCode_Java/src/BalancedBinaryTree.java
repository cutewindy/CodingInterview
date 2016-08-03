/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth 
 * of the two subtrees of every node never differ by more than 1.
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class BalancedBinaryTree {
	
	/**
	 * Method2: DFS(Bottom up) return the height of the current node in DFS recursion. 
	 * When the sub tree of the current node (inclusive) is balanced, the function helper() returns 
	 * a non-negative value as the height. Otherwise -1 is returned. 
	 * According to the leftHeight and rightHeight of the two children, the parent node could check 
	 * if the sub tree is balanced, and decides its return value.
	 * @param TreeNode root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean balancedBinaryTreeI(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root) != -1;  // -1 means not balanced.
	}
	
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		if (left == -1) return -1;
		int right = helper(root.right);
		if (right == -1) return -1;
		return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
	}
	
	/**
	 * Method1: DFS:(Top_down): The first method checks whether the tree is balanced strictly according to 
	 * the definition of balanced binary tree: the difference between the heights of the two sub 
	 * trees are not bigger than 1, and both the left sub tree and right sub tree are also balanced. 
	 * With the helper function depth()
	 * @param TreeNode root
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean balancedBinaryTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.abs(left - right) <= 1 && balancedBinaryTree(root.left) && balancedBinaryTree(root.right);
	}
	
	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(depth(root.left), depth(root.right))  +1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBinaryTree result = new BalancedBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
		TreeNode.printCBT(root);
		System.out.println(result.balancedBinaryTree(root));
	}

}
