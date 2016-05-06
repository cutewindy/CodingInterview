/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and 
 * the nodes have the same value.
 * @author wendi
 *
 */
public class SameTree {
	
	/**
	 * Recursion: in each level of recursion, compare the val, left and right.
	 * @param TreeNode root p
	 * @param TreeNode root q
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean sameTree (TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		else if (p == null || q == null) {
			return false;
		}	
		return (p.val == q.val && sameTree(p.left, q.left) && sameTree(p.right, q.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SameTree result = new SameTree();
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {1, 2, 3, 4, 5};
		TreeNode p = TreeNode.generateCBT(array1);
		TreeNode q = TreeNode.generateCBT(array2);
		TreeNode.printCBT(p);
		TreeNode.printCBT(q);
		System.out.println(result.sameTree(p, q));
		
	}

}
