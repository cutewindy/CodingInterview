/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between 
 * the values of any two different nodes in the tree.
 * Example :
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
		          4
		        /   \
		      2      6
		     / \    
		    1   3  
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between 
 * node 3 and node 2.
 * Note:
 * 1. The size of the BST will be between 2 and 100.
 * 2. The BST is always valid, each node's value is an integer, and each node's value is different.
 * @author wendi
 *
 */
public class MinimumDistanceBetweenBSTNodes {
	
	
	/**
	 * DFS: Inorder traversal
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int min = Integer.MAX_VALUE;
	public TreeNode prev = null;
	public int minimumDistanceBetweenBSTNodes(TreeNode root) {
		if (root == null) return 0;
		getMin(root);
		return min;
	}
	
	public void getMin(TreeNode root) {
		if (root == null) return;
		getMin(root.left);
		if (prev != null) min = Math.min(root.val - prev.val, min);
		prev = root;
		getMin(root.right);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumDistanceBetweenBSTNodes result = new MinimumDistanceBetweenBSTNodes();
		TreeNode root = TreeNode.generateCBT(new int[] {4, 2, 6 ,1, 3});
		TreeNode.printCBT(root);
		System.out.println(result.minimumDistanceBetweenBSTNodes(root));
	}

}
