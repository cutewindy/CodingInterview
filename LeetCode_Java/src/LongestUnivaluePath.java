/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same 
 * value. This path may or may not pass through the root.
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * Example 1:
 * Input:
              5
             / \
            4   5
           / \   \
          1   1   5
 * Output:
 * 2
 * Example 2:
 * Input:
              1
             / \
            4   5
           / \   \
          4   4   5
 * Output:
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more 
 * than 1000.
 * @author wendi
 *
 */
public class LongestUnivaluePath {
	
	
	
	/**
	 * DFS
	 * @param TreeNode root
	 * @return int
	 * Time: O(e+v)
	 * Space: O(e+v)
	 */
	int res;
	public int longestUnivaluePath(TreeNode root) {
		if (root == null) return 0;
		res = 0;
		rootPath(root);
		return res;
	}

	public int rootPath(TreeNode root) {
		if (root == null) return 0;
		int left = rootPath(root.left);
		int right = rootPath(root.right);
		int fromLeft = 0;
		int fromRight = 0;
		if (root.left != null && root.left.val == root.val) fromLeft += left + 1;
		if (root.right != null && root.right.val == root.val) fromRight += right + 1;
		res = Math.max(fromLeft + fromRight, res);
		return Math.max(fromLeft, fromRight);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestUnivaluePath result = new LongestUnivaluePath();
		TreeNode root = TreeNode.generateCBT(new int[] {4, 4, 5, 4, 4, 3, 5, 4});
		TreeNode.printCBT(root);
		System.out.println(result.longestUnivaluePath(root));
	}	

}
