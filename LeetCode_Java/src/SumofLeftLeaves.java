import java.util.Stack;

/**
 * Find the sum of all left leaves in a given binary tree.
 * Example:
		    3
		   / \
		  9  20
		    /  \
		   15   7
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * 
 * Tags: Tree
 * @author wendi
 *
 */
public class SumofLeftLeaves {
	
	/**
	 * Method2: Recursion: For given node, check whether its left child is a leaf. 
	 * If it is the case, return its value as answer.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int sumofLeftLeavesI(TreeNode root) {
		if (root == null) {
			return 0;
		}	
		return helper(root.left, true) + helper(root.right, false);
	}
	
	private int helper(TreeNode root, boolean isLeft) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null && isLeft) {
			return root.val;
		}
		return helper(root.left, true) + helper(root.right, false);
	}
	
	/**
	 * Method1: Iteration: Inorder traversal: for each node check whether its left child is a leaf. 
	 * If it is true, we add its value to answer, otherwise add left child to the stack to process it late.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(log(n))
	 */
	public int sumofLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int result = 0;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
				if (root != null && root.left == null && root.right == null) {
					result += root.val;
				}
			}
			root = stack.pop();
			root = root.right;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofLeftLeaves result = new SumofLeftLeaves();
		TreeNode root = TreeNode.generateCBT(new int[] {3, 9 ,20, 15, 7, 9});
		TreeNode.printCBT(root);
		System.out.println(result.sumofLeftLeaves(root));
		System.out.println(result.sumofLeftLeavesI(root));
	}

}
