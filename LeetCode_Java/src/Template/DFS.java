package Template;
import java.util.*;
import data_structure.TreeNode;

public class DFS {
	
	/**
	 * InorderTraversal Iteration
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> inorderTraversalIteration(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			res.add(root.val); // TODO
			root = root.right;
		}
		return res;
	}
	
	
	/**
	 * InorderTraversal Recursion
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<Integer> inorderTraversalRecursion(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		inorderTraversalDFS(root, res);
		return res;
	}
	
	private void inorderTraversalDFS(TreeNode root, List<Integer> res) {
		if (root == null) return;
		inorderTraversalDFS(root.left, res);
		res.add(root.val);  // TODO
		inorderTraversalDFS(root.right, res);
	}
	
	
	/**
	 * PreorderTraversal Iteration
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> preorderTraversalIteration(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			res.add(curr.val);  // TODO
			if (curr.right != null) stack.push(curr.right);
			if (curr.left != null) stack.push(curr.left);
		}
		return res;
	}
	
	
	/**
	 * PreorderTraversal Recursion
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<Integer> preorderTraversalRecursion(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		preorderTraversalDFS(root, res);
		return res;
	}	
	
	private void preorderTraversalDFS(TreeNode root, List<Integer> res) {
		if (root == null) return;
		res.add(root.val); // TODO
		preorderTraversalDFS(root.left, res);
		preorderTraversalDFS(root.right, res);
	}
	
	
	/**
	 * PostorderTraversal Iteration
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> postorderTraversalIteration(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			res.add(0, curr.val); // TODO
			if (curr.left != null) stack.push(curr.left);
			if (curr.right != null) stack.push(curr.right);
		}
		return res;
	}
	
	
	/**
	 * PostorderTraversal Recursion
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<Integer> postorderTraversalRecursion(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		postorderTraversalDFS(root, res);
		return res;
	}
	
	private void postorderTraversalDFS(TreeNode root, List<Integer> res) {
		if (root == null) return;
		postorderTraversalDFS(root.left, res);
		postorderTraversalDFS(root.right, res);
		res.add(root.val);  // TODO
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS test = new DFS();
		TreeNode root = TreeNode.generateCBT(new int[] {5,3,7,2,4,6,8,1});
		TreeNode.printCBT(root);
		System.out.println(test.inorderTraversalIteration(root));
		System.out.println(test.inorderTraversalRecursion(root));
		System.out.println(test.preorderTraversalIteration(root));
		System.out.println(test.preorderTraversalRecursion(root));
		System.out.println(test.postorderTraversalIteration(root));
		System.out.println(test.postorderTraversalRecursion(root));
	}

}
