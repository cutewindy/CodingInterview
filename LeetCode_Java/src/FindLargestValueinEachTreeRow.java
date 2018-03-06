import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You need to find the largest value in each row of a binary tree.
 * Example:
 * Input: 
	          1
	         / \
	        3   2
	       / \   \  
	      5   3   9 
 * Output: [1, 3, 9]
 * @author wendi
 *
 */
public class FindLargestValueinEachTreeRow {
	
	/**
	 * BFS
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> findLargestValueinEachTreeRow(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				max = Math.max(curr.val, max);
				if (curr.left != null) queue.offer(curr.left);
				if (curr.right != null) queue.offer(curr.right);
			}
			result.add(max);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindLargestValueinEachTreeRow result = new FindLargestValueinEachTreeRow();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 3, 2, 5, 3, 9});
		TreeNode.printCBT(root);
		System.out.println(result.findLargestValueinEachTreeRow(root));
	}

}
