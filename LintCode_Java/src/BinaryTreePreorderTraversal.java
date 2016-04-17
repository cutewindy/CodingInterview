import java.util.ArrayList;
import java.util.Stack;

//Given a binary tree, return the preorder traversal of its
//		nodes' values.
//
//Have you met this question in a real interview? Yes
//Example
//Given binary tree {1,#,2,3}:
//
//1
// \
//  2
// /
//3
//return [1,2,3].
//
//Challenge
//Can you do it without recursion?

		
public class BinaryTreePreorderTraversal {
		
	//traverse
	public ArrayList<Integer> binaryTreePreorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		preTraversalHelper(result, root);
		return result;
	}
	
	public void preTraversalHelper(ArrayList<Integer> result, TreeNode root) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		preTraversalHelper(result, root.left);
		preTraversalHelper(result, root.right);
	}
	
	
	
	//divide conquer
	public ArrayList<Integer> binaryTreePreorderTraversalI(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		//leaf or null
		if (root == null) {
			return result;
		}
		//divide
		ArrayList<Integer> left = binaryTreePreorderTraversalI(root.left);
		ArrayList<Integer> right = binaryTreePreorderTraversalI(root.right);
		//conquer
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		return result;
	}

	//stack
	public ArrayList<Integer> binaryTreePreorderTraversalII(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return result;
		}
		stack.push(root); 
 		while (!stack.empty()) {
 			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePreorderTraversal result = new BinaryTreePreorderTraversal();
		TreeNode root = TreeNode.buildBinaryTree();
		TreeNode.showPreorder(root);
		System.out.println(result.binaryTreePreorderTraversal(root));
		System.out.println(result.binaryTreePreorderTraversalI(root));
		System.out.println(result.binaryTreePreorderTraversalII(root));
	}

}
