import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from
 *  top to bottom.
 * For example:
 * Given the following binary tree,
		   1            <---
		 /   \
		2     3         <---
		 \     \
		  5     4       <---
 * You should return [1, 3, 4].
 * 
 * Tags: Tree, DFS, BFS
 * @author wendi
 *
 */
public class BinaryTreeRightSideView {
	
	/**
	 * Method2: DFS: the size of result equals to the depth of tree. Traverse tree in right-left order, in each depth, the first node is the 
	 * right side view node.
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<Integer> BinaryTreeRightSideViewI(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		helper(root, 1, result);
		return result;
	}
	
	private void helper(TreeNode root, int currDepth, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (result.size() < currDepth) {
			result.add(root.val);
		}
		helper(root.right, currDepth + 1, result);
		helper(root.left, currDepth + 1, result);
	}
	
	/**
	 * Method1:BFS. Traverse tree in BFS order. Then in each level, the last node of queue is the right side view node.
	 * @param TreeNode root
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> BinaryTreeRightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (i == size - 1) {
					result.add(curr.val);
				}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeRightSideView result = new BinaryTreeRightSideView();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5});
		TreeNode.printCBT(root);
//		System.out.println(result.BinaryTreeRightSideView(root));
		System.out.println(result.BinaryTreeRightSideViewI(root));
	}

}
