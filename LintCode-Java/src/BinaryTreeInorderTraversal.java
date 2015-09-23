import java.util.ArrayList;

//Given a binary tree, return the inorder traversal of its nodes' values.
//
//Have you met this question in a real interview? Yes
//Example
//Given binary tree {1,#,2,3},
//
//   1
//    \
//     2
//    /
//   3
// 
//
//return [1,3,2].
//
//Challenge
//Can you do it without recursion?

public class BinaryTreeInorderTraversal {
	
	//traverse
	public ArrayList<Integer> binaryTreeInorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		result.addAll(binaryTreeInorderTraversal(root.left));
		result.add(root.val);
		result.addAll(binaryTreeInorderTraversal(root.right));		
		return result;
	}
	
	
	//divide & conquer
	public ArrayList<Integer> binaryTreeInorderTraversalI(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		
		//divide
		ArrayList<Integer> left = binaryTreeInorderTraversalI(root.left);
		ArrayList<Integer> right = binaryTreeInorderTraversalI(root.right);
		
		//conquer
		result.addAll(left);
		result.add(root.val);
		result.addAll(right);
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInorderTraversal result =  new BinaryTreeInorderTraversal();
		TreeNode root = TreeNode.buildBinaryTree();
		System.out.println(result.binaryTreeInorderTraversal(root));
		System.out.println(result.binaryTreeInorderTraversalI(root));
	}

}
