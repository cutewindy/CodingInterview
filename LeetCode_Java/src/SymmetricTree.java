import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
		    1
		   / \
		  2   2
		   \   \
		   3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * Tags: Tree, DFS, BFS
 * @author wendi
 *
 */
public class SymmetricTree {

	/**
	 * Method2:DFS(Iteration) Two stacks: like the "Same Tree". 
	 * @param TreeNode root
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean symmetricTreeI(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stackP = new Stack<>();
		Stack<TreeNode> stackQ = new Stack<>();
		if (root.left != null ) stackP.push(root.left);
		if (root.right != null) stackQ.push(root.right);
		while (!stackP.isEmpty() && !stackQ.isEmpty()) {
			TreeNode p = stackP.pop();
			TreeNode q = stackQ.pop();
			// 1 check curr p a val
			if (p.val != q.val) return false;
			// 2 check p.right and q.left
			if (p.right != null) stackP.push(p.right);
			if (q.left != null) stackQ.push(q.left);
			if (stackP.size() != stackQ.size()) return false;
			// 3 check p.left and q.right
			if (p.left != null) stackP.push(p.left);
			if (q.right != null) stackQ.push(q.right);
			if (stackP.size() != stackQ.size()) return false;
		}
		return stackP.size() == stackQ.size();  // don't forget
	}
	
	/**
	 * Method1: DFS:(Recursion)Like the "Same Tree", in each level of recursion, compare the val, 
	 * p.left q.right and p.right q.left.
	 * @param TreeNode root
	 * @return boolean 
	 * Time: O(n) n is the number of nodes
	 * Space: O(1)
	 * StackSpace: O(log(n))
	 */
	public boolean symmetricTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root, root);
	}
	
	private boolean helper(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return (p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTree result = new SymmetricTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 2, 3, 4, 4, 3});
//		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 2, 0, 3, 0, 3});
		TreeNode.printCBT(root);
//		System.out.println(result.symmetricTree(root));
		System.out.println(result.symmetricTreeI(root));
	}

}
