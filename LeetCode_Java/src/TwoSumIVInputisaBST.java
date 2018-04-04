import java.util.HashSet;
import java.util.Set;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the 
 * BST such that their sum is equal to the given target.
 * Example 1:
 * Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
 * Target = 9
 * Output: True
 * Example 2:
 * Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
 * Target = 28
 * Output: False
 * @author wendi
 *
 */
public class TwoSumIVInputisaBST {
	
	/**
	 * Using HashSet
	 * @param TreeNode root, int k
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean twoSumIVInputisaBST(TreeNode root, int k) {
		if (root == null) return false;
		return towSuminBST(root, k, new HashSet<Integer>());
	}
	
	public boolean towSuminBST(TreeNode root, int target, Set<Integer> seen) {
		if (root == null) return false;
		if (seen.contains(target - root.val)) return true;
		seen.add(root.val);
		return towSuminBST(root.left, target, seen) || towSuminBST(root.right, target, seen);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumIVInputisaBST result = new TwoSumIVInputisaBST();
		TreeNode root = TreeNode.generateCBT(new int[] {5, 3, 6, 2, 4, 7});
		TreeNode.printCBT(root);
		System.out.println(result.twoSumIVInputisaBST(root, 9));
		System.out.println(result.twoSumIVInputisaBST(root, 28));
	}

}
