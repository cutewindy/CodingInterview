import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and 
 * so on.
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 * Example 1:
		   1
		 /   \
		7     0
	   / \
	  7   8
 * Input: [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation: 
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Note:
 * 1. The number of nodes in the given tree is between 1 and 10^4.
 * 2. -10^5 <= node.val <= 10^5
 * @author wendi
 *
 */
public class MaximumLevelSumofaBinaryTree {
	
	
	/**
	 * BFS: level order traversal
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int maximumLevelSumofaBinaryTree(TreeNode root) {
		if (root == null) return 0;
		int level = 1;
		int maxSum = Integer.MIN_VALUE;
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int sum = 0;
			while (size-- > 0) {
				TreeNode curr = queue.poll();
				sum += curr.val;
				if (curr.left != null) queue.offer(curr.left);
				if (curr.right != null) queue.offer(curr.right);
			}
			if (sum > maxSum) {
				maxSum = sum;
				res = level;
			}
			level++;
		}
		return res;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumLevelSumofaBinaryTree result = new MaximumLevelSumofaBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 7, 0, 7, -8});
		System.out.println(result.maximumLevelSumofaBinaryTree(root));
	}

}
