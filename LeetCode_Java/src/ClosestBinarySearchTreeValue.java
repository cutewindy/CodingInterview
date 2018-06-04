/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is 
 * closest to the target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * 
 * Tags: Tree, Binary Search
 * @author wendi
 *
 */
public class ClosestBinarySearchTreeValue {
	
	/**
	 * BST Iteration
	 * @param TreeNode root, double target
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int closestBinarySearchTreeValue(TreeNode root, double target) {
		int result = root.val;
		while (root != null) {
			if (Math.abs(root.val - target) < Math.abs(result - target)) {
				result = root.val;
			}
			root = root.val > target ? root.left : root.right;
 		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestBinarySearchTreeValue result = new ClosestBinarySearchTreeValue();
		TreeNode root = TreeNode.generateCBT(new int[] {30, 20, 40, 8, 25, 35, 45, 6, 15});
		TreeNode.printCBT(root);
		System.out.println(result.closestBinarySearchTreeValue(root, 18.6));	
	}

}
