/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of 
 * a binary tree is the length of the longest path between any two nodes in a tree. This path may or 
 * may not pass through the root.
 * Example:
 * Given a binary tree 
	          1
	         / \
	        2   3
	       / \     
	      4   5    
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * @author wendi
 *
 */
public class DiameterofBinaryTree {
	
	
	/**
	 * DFS
	 * Any path can be written as two arrows (in different directions) from some node, where an 
	 * arrow is a path that starts at some node and only travels down to child nodes.
	 * If we knew the maximum length arrows L, R for each child, then the best path touches 
	 * L + R + 1 nodes.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack Space: O(log(n))
	 */
	public int maxPath = 0;
	public int diameterofBinaryTree(TreeNode root) {
		if (root == null) return 0;
		getDiameter(root);
		return maxPath;
	}
	
	public int getDiameter(TreeNode root) {
		if (root == null) return 0;
		int left = getDiameter(root.left);
		int right = getDiameter(root.right);
		maxPath = Math.max(left + right, maxPath);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiameterofBinaryTree result = new DiameterofBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5});
		TreeNode.printCBT(root);
		System.out.println(result.diameterofBinaryTree(root));
	}

}
