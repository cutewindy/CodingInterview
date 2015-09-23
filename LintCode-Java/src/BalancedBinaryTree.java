//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as 
//a binary tree in which the depth of the two subtrees of every
//node never differ by more than 1.
//
//Have you met this question in a real interview? Yes
//Example
//Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
//
//A)  3            B)    3 
//   / \                  \
//  9  20                 20
//    /  \                / \
//   15   7              15  7
//The binary tree A is a height-balanced binary tree, but B is not.


public class BalancedBinaryTree {
	
	public static boolean balancedBinaryTree(TreeNode root) {
		return balancedBinaryTreeHelper(root) != -1;
	}
//	equals to -1 is not the balanced binary tree
	public static int balancedBinaryTreeHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = balancedBinaryTreeHelper(root.left);
		int right = balancedBinaryTreeHelper(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		int[] array = {3, 9, 20, -1, -1, 15, 7};
		//		    3        
		//		   / \          
		//		  9  20         
		//		    /  \     
		//		   15   7 
		
//		int[] array = {3, -1, 20, -1, -1, 15, 7};
		//                 3 
		//                  \
		//                  20
		//                 /  \
		//                15   7
		root = TreeNode.arraytoBinaryTree(array);
		TreeNode.showPreorder(root);
		System.out.println(balancedBinaryTree(root));
	}

}
