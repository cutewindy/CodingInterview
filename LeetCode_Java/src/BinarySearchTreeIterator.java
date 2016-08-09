import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the 
 * root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the 
 * height of the tree.
 * 
 * Tags: Tree, Stack, Design
 * @author wendi
 *
 */
public class BinarySearchTreeIterator {

	/**
	 * By using stack with O(n) memory and O(1) time both for hasNext and next.
	 */
	Stack<TreeNode> stack = new Stack<>();
	public BinarySearchTreeIterator(TreeNode root) {
		findLeft(root);
	}
	
	// return true if has next smallest number
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	// return the next smallest number
	public int next() {
		TreeNode next = stack.pop();
		findLeft(next.right);
		return next.val;
	}
	
	// push all the left node into stack
	private void findLeft(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.generateCBT(new int[] {7, 4, 9, 2, 6, 8, 10, 1, 3, 5});
		TreeNode.printCBT(root);
		BinarySearchTreeIterator it = new BinarySearchTreeIterator(root);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
