/**
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree 
 * node values and the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * Example:
 * Input: 
	         1
	       /   \
	      2     3
 * Output: 1
 * Explanation: 
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 * 1. The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * 2. All the tilt values won't exceed the range of 32-bit integer.
 * @author wendi
 *
 */
public class BinaryTreeTilt {
	
	/**
	 * DFS
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int binaryTreeTilt(TreeNode root) {
		if (root == null) return 0;
		int[] result = new int[1];
		sumofBT(root, result);
		return result[0];
	}
	
	public int sumofBT(TreeNode root, int[] res) {
		if (root == null) return 0;
		int left = sumofBT(root.left, res);
		int right = sumofBT(root.right, res);
		res[0] += Math.abs(left - right);
		return left + root.val + right;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeTilt result = new BinaryTreeTilt();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3});
		TreeNode.printCBT(root);
		System.out.println(result.binaryTreeTilt(root));
	}

}
