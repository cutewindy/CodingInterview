
/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * For example:
 * Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
 * return 4.
 * @author wendi
 *
 */
public class CountUnivalueSubtrees {

	/**
	 * Backtracking: Use an ArrayList to save the count of univalue subtrees
	 * Basecase: if root == null, return false
	 * The condition for a subtree to be a uni-value subtree is that:
     * (The left subtree has to be a uni-value subtree or null) && 
     * (right subtree has to be a uni-value subtree or null) && 
     * (left null || left.val== root.val) && 
     * (right null || right.val==root.val)
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int countUnivalueSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] result = new int[1];
		helper(root, result);
		return result[0];
	}
	
	private boolean helper(TreeNode root, int[] result) {
		if (root == null) {
			return true;
		}
		boolean left = helper(root.left, result); // left = true means left is univalue subtrees
		boolean right = helper(root.right, result); // right = true means right is univalue subtrees
		if (left && right 
		 && (root.left == null || root.val == root.left.val) 
		 && (root.right == null || root.val == root.right.val)) {
			result[0]++;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountUnivalueSubtrees result = new CountUnivalueSubtrees();
//		TreeNode root = TreeNode.generateCBT(new int[] {5, 1, 5, 1, 5, 5});
		TreeNode root = TreeNode.generateCBT(new int[] {5, 4, 5, 4, 4, 5});
		TreeNode.printCBT(root);
		System.out.println(result.countUnivalueSubtrees(root));
	}

}
