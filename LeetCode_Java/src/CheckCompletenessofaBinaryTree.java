import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, determine if it is a complete binary tree.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all 
 * nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive 
 * at the last level h.
 * Example 1:
	        1
	      /   \
	     2     3
	    / \   /
	   4   5 6
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), 
 * and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
	        1
	      /   \
	     2     3
	    / \     \
	   4   5     7
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 * Note:
 * 1. The tree will have between 1 and 100 nodes.
 * @author wendi
 *
 */
public class CheckCompletenessofaBinaryTree {
	
	
	/**
	 * BFS: Use BFS to do a level order traversal,add childrens to the bfs queue,
	 * until we met the first empty node.
	 * For a complete binary tree, there should not be any node after we met an empty one.
	 * @param TreeNode root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean checkCompletenessofaBinaryTree(TreeNode root) {
		if (root == null) return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr == null) break;
			else {
				queue.offer(curr.left);
				queue.offer(curr.right);
			}
		}
		while (!queue.isEmpty()) {
			if (queue.poll() != null) return false; 
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckCompletenessofaBinaryTree result = new CheckCompletenessofaBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		System.out.println(result.checkCompletenessofaBinaryTree(root));
	}

}
