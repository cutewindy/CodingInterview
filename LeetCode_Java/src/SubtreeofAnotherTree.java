/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure 
 * and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of 
 * this node's descendants. The tree s could also be considered as a subtree of itself.
 * Example 1:
 * Given tree s:
		     3
		    / \
		   4   5
		  / \
		 1   2
 * Given tree t:
		   4 
		  / \
		 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
		     3
		    / \
		   4   5
		  / \
		 1   2
		    /
		   0
 * Given tree t:
		   4
		  / \
		 1   2
 * Return false.
 * @author wendi
 *
 */
public class SubtreeofAnotherTree {
	
	/**
	 * DFS
	 * @param TreeNode s, TreeNode t
	 * @return boolean
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public boolean subtreeofAnotherTree(TreeNode s, TreeNode t) {
		if (s == null) return false;
		return helper(s, t) || subtreeofAnotherTree(s.left, t) || subtreeofAnotherTree(s.right, t);
	}
	
	public boolean helper(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s == null || t == null) return false;
		return s.val == t.val && helper(s.left, t.left) && helper(s.right, t.right);
 	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubtreeofAnotherTree result = new SubtreeofAnotherTree();
		TreeNode s = TreeNode.generateCBT(new int[] {3, 4, 5, 1, 2});
		TreeNode t = TreeNode.generateCBT(new int[] {4, 1, 2});
		System.out.println(result.subtreeofAnotherTree(s, t));
	}

}
