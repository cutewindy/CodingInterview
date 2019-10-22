import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
         1
        / \
       2   5
      / \   \
     3   4   6
 * The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * click to show hints.
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node 
 * of a pre-order traversal.
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class FlattenBinaryTreetoLinkedList {

	/**
	 * Method3: Brute force:
	 * DFS(Iteration) If root has left, then the result should be that the most right.right 
	 * of root.left is the root of root.right. Then set root.right = root.left, root.left = null. 
	 * @param TreeNode root
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void flattenBinaryTreetoLinkedListII(TreeNode root) {
		if (root == null) {
			return;
		}
		while (root != null) {
			if (root.left != null) {
				TreeNode pre = root.left;
				// find the most right of root.left
				while (pre.right != null) {
					pre = pre.right;
				}
				// flatten root by move root.right to the most right of root.left,
				// then move root.left to root.right
				pre.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
	
	/**
	 * Method2: post order traversal
	 * @param TreeNode root
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public void flattenBinaryTreetoLinkedListI(TreeNode root) {
		if (root == null) return;
		TreeNode[] prev = new TreeNode[1];
		prev[0] = null;
		dfs(root, prev);
		return;
	}
	
	private void dfs(TreeNode root, TreeNode[] prev) {
		if (root == null) return;
		// flatten children
		dfs(root.right, prev);
		dfs(root.left, prev);
		// flatten curr root
		root.right = prev[0];
		root.left = null;
		prev[0] = root;
	}
	
	/**
	 * Method1: DFS(Iteration: Preorder) get the node in preorder with stack. 
	 * Then set curr.left = null, curr.right = next node preorder.
	 * @param TreeNode root
	 * Time: O(n)
	 * Space: O(n)
	 */
	public void flattenBinaryTreetoLinkedList(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
			curr.left = null;
			curr.right = !stack.isEmpty() ? stack.peek() : null;
		}
		return;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlattenBinaryTreetoLinkedList result = new FlattenBinaryTreetoLinkedList();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		TreeNode.printCBT(root);
//		result.flattenBinaryTreetoLinkedList(root);
//		result.flattenBinaryTreetoLinkedListI(root);
		result.flattenBinaryTreetoLinkedListII(root);
		TreeNode.printCBT(root);
	}

}
