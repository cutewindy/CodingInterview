import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class RecoverBinarySearchTree {

	/**
	 * DFS(Iteration: Inorder,Template) Using inorder traverse to find the two wrong nodes. 
	 * If pre>curr, f1=pre. After f1 been found, if pre>curr, f2 = curr.
	 * @param TreeNode root
	 * Time: O(n)
	 * Space: O(n)
	 */
	public void recoverBinarySearchTree(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode f1 = null;
		TreeNode f2 = null;
		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null) {  // curr is not the first node
				if (f1 == null && pre.val >= root.val) { // find first wrong node
					f1 = pre;
				}
				if (f1 != null && pre.val >= root.val) { // find second wrong node
					f2 = root;
				}
			}
			pre = root;
			root = root.right;
		}
		int temp = f1.val; // swap two wrong nodes
		f1.val = f2.val;
		f2.val = temp;
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecoverBinarySearchTree result = new RecoverBinarySearchTree();
		TreeNode root = TreeNode.generateCBT(new int[] {10, 5, 20, 12, 6, 3, 25, 2, 4});
		TreeNode.printCBT(root);
		result.recoverBinarySearchTree(root);
		TreeNode.printCBT(root);
	}

}
