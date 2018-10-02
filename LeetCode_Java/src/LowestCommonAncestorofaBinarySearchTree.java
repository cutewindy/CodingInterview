/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is 
 * defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
 * (where we allow a node to be a descendant of itself).”

		        _______6______
		       /              \
		    ___2__          ___8__
		   /      \        /      \
		   0      _4       7       9
		         /  \
		         3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
 * according to the LCA definition.
 * 
 * Tags: Tree
 * @author wendi
 * 
 */
public class LowestCommonAncestorofaBinarySearchTree {
	
	/**
	 * Approach2: DFS (Iteration) (using BST), same like approach1
	 * @param TreeNode root, TreeNode p, TreeNode q
	 * @return TreeNode LCA
	 * Time: O(log(n))
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode LCAofaBSTI(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        while (root != null) {
            if (root.val > Math.max(p.val, q.val)) root = root.left;
            else if (root.val < Math.min(p.val, q.val)) root = root.right;
            else return root;
        }
        return null;		
	}
	
	/**
	 * Approach1: DFS (Recursion) (using BST)
	 * If root.val>q.val&&root.val<p.val (q.val<p.val), then root will be the LCA.
	 * @param TreeNode root, TreeNode p, TreeNode q
	 * @return TreeNode LCA
	 * Time: O(log(n))
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode LCAofaBST(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return root;
		}
		if (root.val > Math.max(p.val, q.val)) {
			return LCAofaBST(root.left, p, q);
		}
		else if (root.val < Math.min(p.val, q.val)) {
			return LCAofaBST(root.right, p, q);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestorofaBinarySearchTree result = new LowestCommonAncestorofaBinarySearchTree();
		int[] array = {9, 5, 15, 3, 7, 12, 18, 1, 4, 6, 8, 11};
		TreeNode root = TreeNode.generateCBT(array);
		TreeNode.printCBT(root);
		TreeNode p = root.left.right;
		TreeNode q = root.left.left.left;
		System.out.println("p: " + p.val);
		System.out.println("q: " + q.val);
		System.out.println(result.LCAofaBST(root, p, q).val);
		System.out.println(result.LCAofaBSTI(root, p, q).val);
	}

}
