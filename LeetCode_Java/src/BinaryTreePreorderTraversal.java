import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Tags: Tree, Stack
 * @author wendi
 *
 */
public class BinaryTreePreorderTraversal {

	/**
	 * Method3: Morris:Same like inorder traversal, the different is result.add()
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> binaryTreePreorderTraversalII(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		TreeNode curr = root;
		TreeNode pre = null;
		while (curr != null) {
			if (curr.left == null) { // no left, go right directly
				result.add(curr.val);
				curr = curr.right;
			}
			else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr) { // go to the right most of curr.left
					pre = pre.right;
				}
				if (pre.right == null) { // means have not build the visual path
					result.add(curr.val);
					pre.right = curr;
					curr = curr.left;
				}
				if (pre.right == curr) { // means have already build the visual path, need to remove
					pre.right = null;
					curr = curr.right;
				}
			}
		}
		return result;
	}
	
	/**
	 * Method2: DFS(Iteration: Preorder Template) Using stack. The order pushing in the stack is
	 * root->right->left
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> binaryTreePreorderTraversalI(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			result.add(curr.val);
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}
		return result;
	}
	
	/**
	 * Method1: DFS(Recursion) add val in root-left-right order.
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<Integer> binaryTreePreorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
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
		result.add(root.val);
		helper(root.left, result);
		helper(root.right, result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePreorderTraversal result = new BinaryTreePreorderTraversal();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 7, 3, 4, 8, 9});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreePreorderTraversal(root));
		System.out.println(result.binaryTreePreorderTraversalI(root));
		System.out.println(result.binaryTreePreorderTraversalII(root));
	}

}
