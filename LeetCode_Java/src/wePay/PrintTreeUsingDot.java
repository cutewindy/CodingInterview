package wePay;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import data_structure.TreeNode;
/**
 * 打印一棵树，如果如果是空节点，
 * 用 . dot 表示
 * 比如
 *       1
 *    2    3
 *      4    5
 * 打印结果为
 * 1
 * 2 3
 * .  4 . 5
 * @author wendi
 *
 */
public class PrintTreeUsingDot {

	/**
	 * BFS level order traversal
	 * @param TreeNode root
	 * @return List<List<String>>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<List<String>> printTreeUsingDot(TreeNode root) {
		List<List<String>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<String> list = new ArrayList<>();
			while(size-- > 0) {
				TreeNode curr = queue.poll();
				if (curr == null) {
					list.add(".");
				}
				else {
					list.add(String.valueOf(curr.val));
					queue.offer(curr.left);
					queue.offer(curr.right);
				}
			}
			res.add(list);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintTreeUsingDot result = new PrintTreeUsingDot();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5});
		System.out.println(result.printTreeUsingDot(root));
	}

}
