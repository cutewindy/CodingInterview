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
	 * Method2: Backtracking + DP: 
	 * Using helper func to return longest consecutive sequence ending,
	 * which is ending at root. Then curr = max(left, right) + 1 if both root.left and root.right 
	 * are consecutive sequence with root. 
	 * Using int[] result to update max longest consecutive sequence of whole tree
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int binaryTreeLongestConsecutiveSequenceI(TreeNode root) {
		if (root == null) return 0;
		int[] result = new int[1];
		helperI(root, result);
		return result[0];
	}
	
	public int helperI(TreeNode root, int[] result) {
		if (root == null) return 0;
		int left = helperI(root.left, result);
		int right = helperI(root.right, result);
		int curr = 1;
		if (root.left != null && root.val + 1 == root.left.val) {
			curr = Math.max(left + 1, curr);
		}
		if (root.right != null && root.val + 1 == root.right.val) {
			curr = Math.max(right + 1, curr);
		}
		result[0] = Math.max(curr, result[0]);
		return curr;
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
	public int binaryTreeLongestConsecutiveSequence(TreeNode root) {
		if (root == null) return 0;
		int[] result = new int[1];
		helper(root, root.val - 1, 0, result);
		return result[0];
	}
	
	private void helper(TreeNode root, int parent, int count, int[] result) {
		if (root == null) return;
		if (root.val == parent + 1) {
			count++;
		}
		else {
			count = 1;
		}
		result[0] = Math.max(count, result[0]);
		helper(root.left, root.val, count, result);
		helper(root.right, root.val, count, result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLongestConsecutiveSequence result = new BinaryTreeLongestConsecutiveSequence();
		TreeNode root = TreeNode.generateCBT(new int[] {2, 4, 1, 5, 7, 3, 2, 6});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeLongestConsecutiveSequence(root));
//		System.out.println(result.binaryTreeLongestConsecutiveSequenceI(root));
	}

}
