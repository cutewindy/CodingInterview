package IBM;

import data_structure.TreeNode;
/**
 * how to insert a BST (从treenode 开始写起。。。)
 * @author wendi
 *
 */
public class InsertintoBST {
	
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
