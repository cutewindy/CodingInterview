package IBM;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import data_structure.TreeNode;

public class InorderTreverseBT {
	

	
	/**
	 * DFS(iteration)
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> inorderTreversalBTI(TreeNode root) {	
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}
	
	
	
	/**
	 * DFS(recursion)
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<Integer> inorderTreversalBT(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		dfs(root, result);
		return result;
	}
	
	private void dfs(TreeNode root, List<Integer> res) {
		if (root == null) return;
		dfs(root.left, res);
		res.add(root.val);
		dfs(root.right, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InorderTreverseBT result = new InorderTreverseBT();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		TreeNode.printCBT(root);
		System.out.println(result.inorderTreversalBT(root));
		System.out.println(result.inorderTreversalBT(root));
	}

}
