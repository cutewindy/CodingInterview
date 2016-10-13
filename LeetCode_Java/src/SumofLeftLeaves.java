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
			}
			root = stack.pop();
			if (root.right == null) {
				result += root.val;
			}
			else {
				root = root.right;
			}
		}
			
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofLeftLeaves result = new SumofLeftLeaves();
		TreeNode root = TreeNode.generateCBT(new int[] {3, 9 ,20, 15, 7, 9});
		TreeNode.printCBT(root);
		System.out.println(result.sumofLeftLeaves(root));
	}

}
