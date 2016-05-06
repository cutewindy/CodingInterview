import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Invert a binary tree.

	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	to
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
 * @author wendi
 *
 */
public class InvertBinaryTree {
	/**
	 * Method1(Iteration): using queue to record the next time which node swap its left and right,
	 * before swap, add left and right to q.
	 * @param TreeNode root
	 * @return TreeNode root
	 * Time: O(n)
	 * Space: O(n)
	 */
	public TreeNode invertBinaryTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node != null) {
				q.add(node.left);
				q.add(node.right);
				swap(node, node.left, node.right);
			}
		}
		return root;
	}
	
	/**
	 * Method1(Recursion): if root is not null, swap its left and right, 
	 * and let left and right separately as root go into recursion.
	 * @param TreeNode root
	 * @return TreeNode root
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode invertBinaryTreeI(TreeNode root) {
		if (root == null) {
			return root;
		}
		swap(root, root.left, root.right);
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
		return root;
	}
	
	
	private static void swap(TreeNode node, TreeNode left, TreeNode right) {
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
//		TreeNode newRoot = result.invertBinaryTree(root);
//		TreeNode.printCompleteBinaryTree(newRoot);
		
		TreeNode newRoot1 = result.invertBinaryTreeI(root);
		TreeNode.printCBT(newRoot1);
	}

}
