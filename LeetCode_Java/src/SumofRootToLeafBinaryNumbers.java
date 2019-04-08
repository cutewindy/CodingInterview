/**
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary 
 * number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, 
 * then this could represent 01101 in binary, which is 13.
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * Return the sum of these numbers.
 * Example 1:
 *         1
 *       /   \
 *      0     1
 *    /  \   /  \
 *   0    1 0    1
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Note:
 * 1. The number of nodes in the tree is between 1 and 1000.
 * 2. node.val is 0 or 1.
 * 3. The answer will not exceed 2^31 - 1.
 * @author wendi
 *
 */
public class SumofRootToLeafBinaryNumbers {
	
	
	/**
	 * dfs
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	int mod = 1000000000 + 7;
	public int sumofRootToLeafBinaryNumbers(TreeNode root) {
		if (root == null) return 0;
		int[] res = new int[1];
		dfs(root, 0, res);
		return res[0];
	}
	
	private void dfs(TreeNode root, int curr, int[] res) {
		if (root == null) return;
		curr = (curr * 2 + root.val) % mod;
		if (root.left == null && root.right == null) {
			res[0] += curr;
			res[0] %= mod;  // take care
			return;
		}
		dfs(root.left, curr, res);
		dfs(root.right, curr, res);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofRootToLeafBinaryNumbers result = new SumofRootToLeafBinaryNumbers();
		TreeNode root = TreeNode.generateCBT(new int[] {1,0,1,0,1,0,1});
		root.printCBT(root);
		System.out.println(result.sumofRootToLeafBinaryNumbers(root));
	}

}
