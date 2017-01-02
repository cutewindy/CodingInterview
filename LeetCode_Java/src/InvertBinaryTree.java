import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Invert a binary tree.
		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
 * to
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
 *
 * Tags: Tree
 * @author wendi
 *
 */
public class InvertBinaryTree {
	
	/**
	 * Method4:(DFS: Iteration). Pop node from stack, and swap it's left and right.
	 * Then push it's right and left into stack.
	 * (Do the swapping inorder)
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(n)
	 */
	public TreeNode invertBinaryTreeIII(TreeNode root) {
		if (root == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			swap(curr, curr.left, curr.right);
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}
		return root;
	}
	
	/**
	 * Method3:(DFS: Recursion) swap curr node's left and right. 
	 * Then going down let left and right do the same thing.
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode invertBinaryTreeII(TreeNode root) {
		if (root == null) {
			return root;
		}
		helper(root);
		return root;
	}
	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		swap(root, root.left, root.right);
		helper(root.left);
		helper(root.right);
	}
	
	/**
	 * Method2(BFS): using queue to record the next time which node swap its left and right,
	 * before swap, add left and right to q.
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(n)
	 */
	public TreeNode invertBinaryTreeI(TreeNode root) {
		if (root == null) {
			return root;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node != null) {
				q.offer(node.left);
				q.offer(node.right);
				swap(node, node.left, node.right);
			}
		}
		return root;
	}
	
	/**
	 * Method1(Backtracking): if root is not null, let left and right separately as root go into 
	 * recursion do swapping.
	 * and then swap left and right, 
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode invertBinaryTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode left = invertBinaryTree(root.left);
		TreeNode right = invertBinaryTree(root.right);
		swap(root, left, right);
		return root;
	}
	
	/**
	 * Do swapping
	 * @param TreeNode node, TreeNode left, TreeNode right
	 */
	private void swap(TreeNode node, TreeNode left, TreeNode right) {
		TreeNode temp = left;
		node.left = right;
		node.right = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvertBinaryTree result = new InvertBinaryTree();
		int[] array = {4, 2, 7, 1, 3, 6, 9};
		TreeNode root = TreeNode.generateCBT(array);
		TreeNode.printCBT(root);
		System.out.println("-----------------");
//		TreeNode.printCBT(result.invertBinaryTree(root));
//		TreeNode.printCBT(result.invertBinaryTreeI(root));
//		TreeNode.printCBT(result.invertBinaryTreeII(root));
		TreeNode.printCBT(result.invertBinaryTreeIII(root));
	}

}
