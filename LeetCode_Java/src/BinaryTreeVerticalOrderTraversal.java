import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to 
 * bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * Examples 1:
 * Input: [3,9,20,null,null,15,7]
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7 
 * Output:
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * Examples 2:
 * Input: [3,9,8,4,0,1,7]
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7 
 * Output:
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * Examples 3:
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 * Output:
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 * @author wendi
 *
 */
public class BinaryTreeVerticalOrderTraversal {
	
	
	/**
	 * BFS
	 * 1. calculate the rang first, then insert value into corresponding buckets.
	 * 2. put node, index into queue at the same time. Every left child access index - 1 while right 
	 *    child index + 1
	 * @param TreeNode root
	 * @return List<List<Integer>>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<List<Integer>> binaryTreeVerticalOrderTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		
		// 
		int[] range = new int[2];
		getRange(root, range, 0);
		for (int i = range[0]; i <= range[1]; i++) {
			res.add(new ArrayList<Integer>());
		}
		
		// 
		Queue<TreeNode> qNode = new LinkedList<>();
		qNode.offer(root);
		Queue<Integer> qIndex = new LinkedList<>();
		qIndex.offer(-range[0]);
		while (!qNode.isEmpty()) {
			TreeNode curr = qNode.poll();
			int index = qIndex.poll();
			res.get(index).add(curr.val);
			if (curr.left != null) {
				qNode.offer(curr.left);
				qIndex.offer(index - 1);
			}
			if (curr.right != null) {
				qNode.offer(curr.right);
				qIndex.offer(index + 1);
			}
		}
		
		return res;
	}
	

	
	private void getRange(TreeNode root, int[] range, int col) {
		if (root == null) return;
		range[0] = Math.min(range[0], col);
		range[1] = Math.max(range[1], col);
		getRange(root.left, range, col - 1);
		getRange(root.right, range, col + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeVerticalOrderTraversal result = new BinaryTreeVerticalOrderTraversal();
		TreeNode root = TreeNode.generateCBT(new int[] {3,9,8,4,0,1,7,2,3,5});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeVerticalOrderTraversal(root));
	}

}
