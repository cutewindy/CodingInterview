import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and 
 * the nodes have the same value.
 * @author wendi
 *
 */
public class SameTree {
	
	/**
	 * Method2: (Iteration)Two stacks: check curr nodes val, and then check curr right and left nodes.
	 * Don't forget to check the size of two stack before return.
	 * @param TreeNode p, TreeNode q
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean sameTreeI(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		Stack<TreeNode> stackP = new Stack<>();
		Stack<TreeNode> stackQ = new Stack<>();
		stackP.push(p);
		stackQ.push(q);
		while (!stackP.isEmpty() && !stackQ.isEmpty()) {
			TreeNode pNode = stackP.pop();
			TreeNode qNode = stackQ.pop();
			// 1 check curr p and q node val
			if (pNode.val != qNode.val) return false;  // cannot use pNode != qNode
			// 2 push curr.right to stack, and check stack size
			if (pNode.right != null) stackP.push(pNode.right);
			if (qNode.right != null) stackQ.push(qNode.right);
			if (stackP.size() != stackQ.size()) return false;
			// 3 push curr.left to stack, and check stack size
			if (pNode.left != null) stackP.push(pNode.left);
			if (qNode.left != null) stackQ.push(qNode.left);
			if (stackP.size() != stackQ.size()) return false;
		}
		return stackP.size() == stackQ.size();
	}
	
	
	/**
	 * Method1: Recursion: in each level of recursion, compare the val, left and right.
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
//		System.out.println(result.sameTree(p, q));
		System.out.println(result.sameTreeI(p, q));
	}

}
