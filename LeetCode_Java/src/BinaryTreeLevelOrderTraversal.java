import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to 
 * right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
 * return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]
 * 
 * Tags: Tree, BFS
 * @author wendi
 *
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * BFS(Level traversal Template)
	 * @param TreeNode root
	 * @return List<List<Integer>>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				level.add(curr.val);
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			result.add(level);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLevelOrderTraversal result = new BinaryTreeLevelOrderTraversal();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeLevelOrderTraversal(root));
	}

}
