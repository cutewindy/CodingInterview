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
	 * Method2:(Backtracking)(bottom up) Using class to record whether subtree is valid BST and the 
	 * number of nodes at the same time.
	 * If size = -1, means the subtree is not a valid BST.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	class BSTNode {
		int size;
		TreeNode min;
		TreeNode max;
		
		BSTNode(int size, TreeNode lower, TreeNode upper) {
			this.size = size;
			this.min = lower;
			this.max = upper;
		}
	}
	
	public int largestBSTSubtreeI(TreeNode root) {
		if (root == null) return 0;
		int[] result = new int[1];
		traverse(root, result);
		return result[0];
	}
	
	public BSTNode traverse(TreeNode root, int[] result) {
		if (root == null) return new BSTNode(0, null, null);
		BSTNode left = traverse(root.left, result);
		BSTNode right = traverse(root.right, result);
		if (left.size < 0 || right.size < 0   // check whether curr subtree is a valid BST
		 || left.max != null && root.val <= left.max.val 
		 || right.min != null && root.val >= right.min.val) {
			return new BSTNode(-1, null, null);
		}
		int size = left.size + right.size + 1;  // update curr size
		result[0] = Math.max(size, result[0]);  // update result
		TreeNode min = left.min == null ? root : left.min;  // update curr min node
		TreeNode max = right.max == null ? root : right.max;  // update curr max node
		return new BSTNode(size, min, max);
	}
	
	/**
	 * Method1: Brute force(Top down): find which part is BST, then count the the number of node, 
	 * return the largest one.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0;
		if (isBST(root, null, null)) return countNodes(root);
		return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right)) ;
	}
	
	public boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) return true;
		if (min != null && root.val <= min.val || max != null && root.val >= max.val) {
			return false;
		}
		return isBST(root.left, min, root) && isBST(root.right, root, max);
	}
	
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestBSTSubtree result = new LargestBSTSubtree();
		TreeNode root = TreeNode.generateCBT(new int[] {10, 5 ,15, 1, 8, 7});
		TreeNode.printCBT(root);
		System.out.println(result.largestBSTSubtree(root));
	}

}
