/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along 
 * the parent-child connections. The longest consecutive path need to be from parent to child 
 * (cannot be the reverse).
 * For example,
		   1
		    \
		     3
		    / \
		   2   4
		        \
		         5
 * Longest consecutive sequence path is 3-4-5, so return 3.
		   2
		    \
		     3
		    / 
		   2    
		  / 
		 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * 
 * Tags: Tree
 * @author wendi
 *
 */
public class BinaryTreeLongestConsecutiveSequence {
	
	/**
	 * Method2: Backtracking: compare curr result, left and right, choose the largest one
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int binaryTreeLongestConsecutiveSequenceI(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helperI(root, 0, root.val - 1);
	}
	
	public int helperI(TreeNode root, int count, int parent) {
		if (root == null) {
			return count;
		}
		count = root.val == parent + 1 ? count + 1 : 1;
		int left = helperI(root.left, count, root.val);
		int right = helperI(root.right, count, root.val);
		return Math.max(Math.max(left, right), count);
	}
	
	/**
	 * Method1: DFS.
	 * Brute force: send cur node value to the next level and compare it with the next level node.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	private int result;
	public int binaryTreeLongestConsecutiveSequence(TreeNode root) {
		if (root == null) {
			return 0;
		}
		result = 0;
		helper(root, root.val - 1, 0);
		return result;
	}
	
	private void helper(TreeNode root, int parent, int count) {
		if (root == null) {
			result = Math.max(count, result);
			return;
		}
		if (root.val == parent + 1) {
			count++;
		}
		else {
			result = Math.max(count, result);
			count = 1;
		}
		helper(root.left, root.val, count);
		helper(root.right, root.val, count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLongestConsecutiveSequence result = new BinaryTreeLongestConsecutiveSequence();
		TreeNode root = TreeNode.generateCBT(new int[] {2, 4, 1, 5, 7, 3, 2, 6});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeLongestConsecutiveSequence(root));
		System.out.println(result.binaryTreeLongestConsecutiveSequenceI(root));
	}

}
