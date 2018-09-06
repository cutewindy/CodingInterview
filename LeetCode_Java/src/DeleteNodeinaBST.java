/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * 1. Search for a node to remove.
 * 2. If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * Example:
 * root = [5,3,6,2,4,null,7]
 * key = 3
		    5
		   / \
		  3   6
		 / \   \
 		2   4   7
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
		    5
		   / \
		  4   6
		 /     \
		2       7
 * Another valid answer is [5,2,6,null,4,null,7].
		    5
		   / \
		  2   6
		   \   \
		    4   7
 * @author wendi
 *
 */
public class DeleteNodeinaBST {
	
	/**
	 * Find the node to be removed and its parent using binary search, and then use deleteNode 
	 * to delete the root node of the subtree and return the new root node. 
	 * @param TreeNode root, int key
	 * @return TreeNode
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public TreeNode deleteNodeinaBST(TreeNode root, int key) {
		if (root == null) return root;
		if (root.val == key) return deleteNode(root);
		TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null && curr.left.val == key) {
                curr.left = deleteNode(curr.left);
                break;
            }
            else if (curr.right != null && curr.right.val == key) {
                curr.right = deleteNode(curr.right);
                break;
            }
            if (curr.val < key) curr = curr.right;
            else curr = curr.left;
        }
        return root;
    }
    
    private TreeNode deleteNode(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode prev = root.left;
        while (prev.right != null) {
            prev = prev.right;
        }
        prev.right = root.right;
        return root.left;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNodeinaBST result = new DeleteNodeinaBST();
		TreeNode root = TreeNode.generateCBT(new int[] {5, 3, 7, 2, 4, 6});
		TreeNode.printCBT(root);
		TreeNode.printCBT(result.deleteNodeinaBST(root, 3));
	}

}
