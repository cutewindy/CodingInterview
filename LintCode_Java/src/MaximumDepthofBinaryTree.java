
//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from 
//the root node down to the farthest leaf node.
//
//Have you met this question in a real interview? Yes
//Example
//Given a binary tree as follow:
//
//  1
// / \ 
//2   3
//   / \
//  4   5
//The maximum depth is 3.


public class MaximumDepthofBinaryTree {
	
	public int maximumDepthofBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maximumDepthofBinaryTree(root.left);
		int right = maximumDepthofBinaryTree(root.right);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumDepthofBinaryTree result = new MaximumDepthofBinaryTree();
		TreeNode root = new TreeNode(1);
		root = TreeNode.buildBinaryTree();
		System.out.println(result.maximumDepthofBinaryTree(root));

	}

}
