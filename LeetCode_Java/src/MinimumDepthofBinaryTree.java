import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the 
 * nearest leaf node.
 * 
 * Tags: Tree, DFS, BFS
 * @author wendi
 *
 */
public class MinimumDepthofBinaryTree {
	
	/**
	 * Method3: BFS: (level traverse Template)in each level, if find lead, return curr level depth.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int minimumDepthofBinaryTreeII(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (curr.left == null && curr.right == null) {
					return depth;
				}
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
		}
		return depth;
	}
	
	
	/**
	 * Method2: Backtracking: get the left_min_depth and right_min_depth, then return 
	 * min(left_min_depth, right_min_depth) + 1. If the return of left or right is 0, means that 
	 * cannot go down to that node. 
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Static space: O(log(n))
	 */
	public int minimumDepthofBinaryTreeI(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minimumDepthofBinaryTreeI(root.left);
		int right = minimumDepthofBinaryTreeI(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}

	/**
	 * Method1: DFS: (Recursion) If curr root is not leaf, then depth=depth+1, transport curr depth to its
	 * valid children, until find lead then return. Choose the min depth.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int minimumDepthofBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root, 0);
	}
	
	private int helper(TreeNode root, int depth) {
		// basecase: find leaf
		if (root.left == null && root.right == null) {
			return depth + 1;
		}
		// condition:
		depth = depth + 1;
		if (root.right == null) {
			return helper(root.left, depth);
		}
		if (root.left == null) {
			return helper(root.right, depth);
		}
		else {
			return Math.min(helper(root.left, depth), helper(root.right, depth));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumDepthofBinaryTree result = new MinimumDepthofBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4});
		TreeNode.printCBT(root);
		System.out.println(result.minimumDepthofBinaryTree(root));
		System.out.println(result.minimumDepthofBinaryTreeI(root));
		System.out.println(result.minimumDepthofBinaryTreeII(root));
	}

}
