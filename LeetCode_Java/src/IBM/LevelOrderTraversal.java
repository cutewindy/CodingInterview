package IBM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import data_structure.TreeNode;

/**
 * 给一个binary tree，列出level order traversal的结果，output list of lists
    followup：zigzag level order traversal
 * @author wendi
 *
 */
public class LevelOrderTraversal {
	
	
	/**
	 * BST
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			List<Integer> list = new ArrayList<>();
			while (size-- > 0) {
				TreeNode curr = queue.poll();
				list.add(curr.val);
				if (curr.left != null) queue.offer(curr.left);
				if (curr.right != null) queue.offer(curr.right);
			}
			if (level % 2 == 0) Collections.reverse(list);
			res.add(list);
		}
		return res;
	}
	
	
	
	/**
	 * BST
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			while (size-- > 0) {
				TreeNode curr = queue.poll();
				list.add(curr.val);
				if (curr.left != null) queue.offer(curr.left);
				if (curr.right != null) queue.offer(curr.right);
			}
			res.add(list);
		}
		return res;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderTraversal result = new LevelOrderTraversal();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6, 7});
		TreeNode.printCBT(root);
		System.out.println(result.levelOrderTraversal(root));
		System.out.println(result.zigzagLevelOrderTraversal(root));
	}

}
