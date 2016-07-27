import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Tags: Tree, Stack
 * @author wendi
 *
 */
public class BinaryTreePostorderTraversal {

	/**
	 * Method2: DFS(Iteration: postorder)(Template)
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> binaryTreePostorderTraversalI(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			result.add(0, curr.val);
			if (curr.left != null) {
				stack.push(curr.left);
			}
			if (curr.right != null) {
				stack.push(curr.right);
			}
		}
		return result;
	}
	
	
	/**
	 * Method1: DFS(Recursion) add val in root-right-left order, then reverse result.
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> binaryTreePostorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		helper(root, result);
		return result;
	}
	
	private void helper(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(0, root.val);
		helper(root.right, result);
		helper(root.left, result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePostorderTraversal result = new BinaryTreePostorderTraversal();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		System.out.println(result.binaryTreePostorderTraversal(root));
	}

}
