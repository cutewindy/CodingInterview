import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the 
 * farthest leaf node.
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class MaximumDepthofBinaryTree {
	
	/**
	 * Method2: BFS(Level traversal:template)
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int maximumDepthofBinaryTreeI(TreeNode root) {
		if (root == null) {
			return 0;
		}		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int result = 0;
		while (!queue.isEmpty()) {
			result++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
		}
		return result;
	}
 	
	/**
	 * Method1: DFS(Recursion)
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int maximumDepthofBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root);
	}
	
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(helper(root.left), helper(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumDepthofBinaryTree result = new MaximumDepthofBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4});
		TreeNode.printCBT(root);
		System.out.println(result.maximumDepthofBinaryTree(root));
		System.out.println(result.maximumDepthofBinaryTreeI(root));
	}

}
