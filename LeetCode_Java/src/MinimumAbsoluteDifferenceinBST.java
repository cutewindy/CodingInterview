import java.util.Stack;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between 
 * values of any two nodes.
 * Example:
 * Input:
		   1
		    \
		     3
		    /
		   2
 * Output:
 * 1
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 * @author wendi
 *
 */
public class MinimumAbsoluteDifferenceinBST {
	
	/**
	 * Stack: inorder traversal
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int minimumAbsoluteDifferenceinBST(TreeNode root) {
		if (root == null) return 0;
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            } 
            root = stack.pop();
            if (prev != null) res = Math.min(root.val - prev.val, res);
            prev = root;
            root = root.right;
            
        }
        return res;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumAbsoluteDifferenceinBST result = new MinimumAbsoluteDifferenceinBST();
		TreeNode root = TreeNode.generateCBT(new int[] {2, 1, 3});
		System.out.println(result.minimumAbsoluteDifferenceinBST(root));
	}

}
