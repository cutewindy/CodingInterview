//Given the root and two nodes in a Binary Tree. Find the lowest
//common ancestor(LCA) of the two nodes.
//
//The lowest common ancestor is the node with largest depth which 
//is the ancestor of both nodes.
//
//Have you met this question in a real interview? Yes
//Example
//For the following binary tree:
//
//  4
// / \
//3   7
//   / \
//  5   6
//LCA(3, 5) = 4
//
//LCA(5, 6) = 7
//
//LCA(6, 7) = 7

public class LowestCommonAncestor {
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || root == A || root == B) {
			return root;
		}
		//divide
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		//conquer
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4, 3, 7, -1, -1, 5, 6};
//		   4
//		  / \
//		 3   7
//		    / \
//		   5   6
		TreeNode root = TreeNode.arraytoBinaryTree(array);
		System.out.println(lowestCommonAncestor(root, root.left, root.right.left).val);
//		TreeNode.showPreorder(root);
	}

}
