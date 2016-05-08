/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
 * between two nodes v and w as the lowest node in T that has both v and w as descendants 
 * (where we allow a node to be a descendant of itself).”

		        _______3______
		       /              \
		    ___5__          ___1__
		   /      \        /      \
		   6      _2       0       8
		         /  \
		         7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA 
 * of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * 
 * Tag: Tree
 * @author wendi
 *
 */
public class LowestCommonAncestorofaBinaryTree {
	
	/**
	 * Recursion: if root==q||root==q, then root is LCA. otherwise, 
	 * if left has p||q, right has p||q, return root;
	 * if left has p and q, return left;
	 * if right has p and q, return right;
	 * both doesn't have, return null.  
	 * @param TreeNode root
	 * @param TreeNode p
	 * @param TreeNode q
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public TreeNode LCAofaBT(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = LCAofaBT(root.left, p, q);
		TreeNode right = LCAofaBT(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		else if (left != null && right == null) {
			return left;
		}
		else if (left == null && right != null) {
			return right;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestorofaBinaryTree result = new LowestCommonAncestorofaBinaryTree();
		int[] array = {3, 5, 1, 6, 2, 0, 8, 7, 4};
		TreeNode root = TreeNode.generateCBT(array);
		TreeNode.printCBT(root);
		TreeNode p = root.left;
		TreeNode q = root.left.left.right;
		System.out.println("p: " + p.val);
		System.out.println("q: " + q.val);
		System.out.println(result.LCAofaBT(root, p, q).val);
	}

}
