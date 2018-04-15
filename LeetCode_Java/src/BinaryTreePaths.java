import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
	   1
	 /   \
	2     3
	 \
	  5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class BinaryTreePaths {
	class Pair {
		TreeNode node;
		String path;
		Pair(TreeNode node, String path) {
			this.node = node;
			this.path = path;
		}
	}
	
	
	/**
	 * Method3: BFS(Template): use a class Pair to save the node and path to curr node(exclude curr node),
	 * until find the leaf.
	 * @param TreeNode root
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<String> binaryTreePathsII(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(root, ""));
		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			if (curr.node.left == null && curr.node.right == null) {
				result.add(curr.path + curr.node.val);
			}
			if (curr.node.left != null) {
				queue.offer(new Pair(curr.node.left, curr.path + curr.node.val + "->"));
			}
			if (curr.node.right != null) {
				queue.offer(new Pair(curr.node.right, curr.path + curr.node.val + "->"));
			}
		}
		return result;
	}
	
	
	/**
	 * Method2: DFS(Iteration: Preorder)(Template)Use a class Pair to save the curr node and path.
	 * @param TreeNode root
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<String> binaryTreePathsI(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, ""));
		while (!stack.isEmpty()) {
			Pair curr = stack.pop();
			if(curr.node.left == null && curr.node.right == null) {
				result.add(curr.path + curr.node.val);
			}
			if (curr.node.right != null) {
				stack.push(new Pair(curr.node.right, curr.path + curr.node.val + "->"));
			}
			if (curr.node.left != null) {
				stack.push(new Pair(curr.node.left, curr.path + curr.node.val + "->"));
			}
		}
		return result;
	}
	
	
	/**
	 * Method1: DFS(Recursion): Add curr.val+"->" to path. If curr has left, then go down to left. 
	 * The same as right, until find leaf.
	 * @param TreeNode root
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null) return result;
		helper(root, new ArrayList<Integer>(), result);
		return result;
	}
	
	private void helper(TreeNode root, List<Integer> comb, List<String> result) {
		// Basecase
		if (root.left == null && root.right == null) {
			comb.add(root.val);
			StringBuilder sb = new StringBuilder();
			for (int i: comb) sb.append(i).append("->");
			result.add(sb.toString().substring(0, sb.length() - 2));
			comb.remove(comb.size() - 1);
			return;
		}
		// Condition
		comb.add(root.val);
		if (root.left != null) helper(root.left, comb, result); 
		if (root.right != null) helper(root.right, comb, result);
		comb.remove(comb.size() - 1);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePaths result = new BinaryTreePaths();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 5});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreePaths(root));
//		System.out.println(result.binaryTreePathsI(root));
//		System.out.println(result.binaryTreePathsII(root));
	}

}
