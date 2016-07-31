import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
	   1
	    \
	     2
	    /
	   3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Tags: Tree, Hash Table, Stack
 * @author wendi
 *
 */
public class BinaryTreeInorderTraversal {

	/**
	 * Method3: Morris:
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> binaryTreeInorderTraversalII(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		TreeNode curr = root;
		TreeNode pre = null;
		while (curr != null) {
			if (curr.left == null) {  // no left, go right directly
				result.add(curr.val);
				curr = curr.right;
			}
			else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr) { // go to the right most of curr.left
					pre = pre.right;
				}
				if (pre.right == null) { // means have not build the visual path
					pre.right = curr;
					curr = curr.left;
				}
				if (pre.right == curr) { // means have already build the visual path, need to remove
					result.add(curr.val);
					pre.right = null;
					curr = curr.right;
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Method2: DFS(Iteration: inorder Template). First, push the left most in the stack.
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> binaryTreeInorderTraversalI(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			result.add(curr.val);
			curr = curr.right;
		}
		return result;
	}
	
	/**
	 * Method1: DFS(Recursion) add val in left-root-right order.
	 * @param TreeNode root
	 * @return List<Integer> 
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<Integer> binaryTreeInorderTraversal(TreeNode root) {
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
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInorderTraversal result = new BinaryTreeInorderTraversal();
		TreeNode root = TreeNode.generateCBT(new int[] {6, 2, 8, 1, 4, 7, 9});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeInorderTraversal(root));
		System.out.println(result.binaryTreeInorderTraversalI(root));
		System.out.println(result.binaryTreeInorderTraversalII(root));
	}

}
