/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest 
 * means subtree with largest number of nodes in it.
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
		    10
		    / \
		   5  15
		  / \   \ 
		 1   8   7
 * The Largest BST Subtree in this case is the highlighted one. 
 * The return value is the subtree's size, which is 3.
 * Hint:
 * You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the 
 * tree, which will result in O(nlogn) time complexity.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 * 
 * Tags: Tree
 * @author wendi
 *
 */
public class LargestBSTSubtree {
	
	/**
	 * 
	 * @param TreeNode root
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0;
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestBSTSubtree result = new LargestBSTSubtree();
		TreeNode root = TreeNode.generateCBT(new int[] {10, 5 ,15, 1, 8, 7});
		TreeNode.printCBT(root);
		System.out.println(result.largestBSTSubtree(root));
	}

}
