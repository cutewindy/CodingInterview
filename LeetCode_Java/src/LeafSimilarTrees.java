import java.util.Stack;

/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves 
 * form a leaf value sequence.
 *                  3
 *               /      \
 *              5        1
 *            /   \     /  \
 *           6     2   9    8
 *                / \
 *               7   4   
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * Note:
 * 1. Both of the given trees will have between 1 and 100 nodes.
 * @author wendi
 *
 */
public class LeafSimilarTrees {
	
	/**
	 * Approach2: DFS find the leaf save as string, then compare two string
	 * @param TreeNode root1, TreeNode root2
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 * Stack space: O(log(n))
	 */
    public boolean leafSimilarTreesI(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return true;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs(root1, sb1);
        dfs(root2, sb2);
        return sb1.toString().trim().equals(sb2.toString().trim());
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val).append(" ");
            return;
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
    }
	
	
	/**
	 * Approach1: Stack inorder traversal
	 * Use a stack<TreeNode> to keep dfs path.
	 * dfs(stack) will return next leaf.
	 * Check leaves one by one, until the end or difference.
	 * @param TreeNode root1, TreeNode root2
	 * @return boolean
	 * Time: O(n)
	 * Space: O(log(n))
	 */
    public boolean leafSimilarTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return true;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (dfs(stack1) != dfs(stack2)) return false;
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    private int dfs(Stack<TreeNode> stack) {
        while (true) {
            TreeNode root = stack.pop();
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
            if (root.left == null && root.right == null) return root.val;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeafSimilarTrees result = new LeafSimilarTrees();
		TreeNode root = TreeNode.generateCBT(new int[] {3, 5, 1, 6, 2, 9, 8, 7, 4});
		TreeNode.printCBT(root);
		System.out.println(result.leafSimilarTrees(root, root));
		System.out.println(result.leafSimilarTreesI(root, root));
	}

}
