/**
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, 
 * insert the value into the BST. Return the root node of the BST after the insertion. It is 
 * guaranteed that the new value does not exist in the original BST.
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a 
 * BST after insertion. You can return any of them.
 * For example, 
 * Given the tree:
        4
       / \
      2   7
     / \
    1   3
 * And the value to insert: 5
 * You can return this binary search tree:
         4
       /   \
      2     7
     / \   /
    1   3 5
 * This tree is also valid:
         5
       /   \
      2     7
     / \   
    1   3
         \
          4
 * @author wendi
 *
 */
public class InsertintoaBinarySearchTree {
	
	/**
	 * Approach2: BST Iteration
	 * @param TreeNode root, int val
	 * @return TreeNode
	 * Time: O(log(n))
	 * Space: O(1)
	 */
    public TreeNode insertintoaBSTI(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null) {
            prev = curr;
            if (curr.val > val) curr = curr.left;
            else curr = curr.right;
        }
        if (prev.val > val) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);
        return root;
    }
    
    
    
	/**
	 * Approach1: BST Recursion
	 * @param TreeNode root, int val
	 * @return TreeNode
	 * Time: O(log(n))
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
    public TreeNode insertintoaBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertintoaBST(root.left, val);
        else root.right = insertintoaBST(root.right, val);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertintoaBinarySearchTree result = new InsertintoaBinarySearchTree();
		TreeNode root = TreeNode.generateCBT(new int[] {4, 2, 7, 1, 3});
		TreeNode.printCBT(root);
		TreeNode.printCBT(result.insertintoaBST(root, 5));
	}

}
