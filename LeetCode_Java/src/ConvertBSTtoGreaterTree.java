import java.util.Stack;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original 
 * BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * Example:
 * Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13
 * Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 * @author wendi
 *
 */
public class ConvertBSTtoGreaterTree {
	
	
	/**
	 * Method2: Stack. perform a reverse in-order traversal is via iteration.
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(n)
	 */
	public TreeNode convertBSTtoGreaterTreeI(TreeNode root) {
		if (root == null) return root;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		int sum = 0;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.right;
			}
			node = stack.pop();
			sum += node.val;
			node.val = sum;
			node = node.left;
		}
		return root;
	}
	
	
	
	/**
	 * Method1: DFS. perform a reverse in-order traversal is via recursion.
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(h)
	 */
	int sum;
	public TreeNode convertBSTtoGreaterTree(TreeNode root) {
		if (root == null) return null;
		sum = 0;
		helper(root);
		return root;
	}
	
	public void helper(TreeNode root) {
		if (root == null) return;
		helper(root.right);
		sum += root.val;
		root.val = sum;
		helper(root.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertBSTtoGreaterTree result = new ConvertBSTtoGreaterTree();
		TreeNode root = TreeNode.generateCBT(new int[] {5, 2, 13});
		TreeNode.printCBT(root);
		TreeNode.printCBT(result.convertBSTtoGreaterTree(root));
		TreeNode.printCBT(result.convertBSTtoGreaterTreeI(root));
	}

}
