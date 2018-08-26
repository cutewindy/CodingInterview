package google_intern;
import data_structure.TreeNode;
/**
 * for example:
 * input:
 *     0
 *    / \
 *   1   0
 *  / \   \
 * 1   0   1
 * 
 * output:
 *     1
 *    / \
 *   1   1
 *  / \   \
 * 0   0   0
 * @author wendi
 *
 */
public class SinkZero {
	
	
	/**
	 * post order traversal
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n^2)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode sinkZero(TreeNode root) {
		if (root == null) return root;
		sinkZero(root.left);
		sinkZero(root.right);
		if (root.val == 0) dfs(root);
		return root;
	}
	
	private void dfs(TreeNode root) {
		if (root == null) return;
		if (root.left != null && root.left.val == 1) {
			root.val = 1;
			root.left.val = 0;
			dfs(root.left);
		}
		else if (root.right != null && root.right.val == 1) {
			root.val = 1;
			root.right.val = 0;
			dfs(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinkZero result = new SinkZero();
		TreeNode root = TreeNode.generateCBT(new int[] {0, 1, 0, 1, 0, 1});
		TreeNode.printCBT(root);
		TreeNode.printCBT(result.sinkZero(root));
	}

}
