//Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.
//
//Have you met this question in a real interview? Yes
//Example
//Given the below binary tree:
//
//  1
// / \
//2   3
//return 6.

public class BinaryTreeMaximumPathSum {

	private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
		int singlePath;
		int maxPath;
		ResultType (int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	
	private ResultType maxPathHelper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		//divide
		ResultType left = maxPathHelper(root.left);
		ResultType right = maxPathHelper(root.right);
		
		//conquer
		//figure up the path cover the root
		int sin = Math.max(left.singlePath, right.singlePath) + root.val;
		sin = Math.max(0, sin);
		//compare the left maxPath, the right maxPath and the left&right&rootPath
		int max = Math.max(left.maxPath, right.maxPath);
		max = Math.max(left.singlePath + right.singlePath + root.val, max);
		
 		return new ResultType(sin, max);
	}
	
	public int binaryTreeMaximumPathSum(TreeNode root) {
		ResultType result = maxPathHelper(root);
		return result.maxPath;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum re = new BinaryTreeMaximumPathSum();
		int[] array ={1, 2, 3};
		TreeNode root = TreeNode.arraytoBinaryTree(array);
//		TreeNode.showPreorder(root);
		System.out.println(re.binaryTreeMaximumPathSum(root));
		
	}

}
