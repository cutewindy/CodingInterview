/**
 * Two players play a turn based game on a binary tree.  We are given the root of this binary tree, 
 * and the number of nodes n in the tree.  n is odd, and each node has a distinct value from 1 to n.
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value 
 * y with 1 <= y <= n and y != x.  The first player colors the node with value x red, and the second 
 * player colors the node with value y blue.
 * Then, the players take turns starting with the first player.  In each turn, that player chooses 
 * a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the 
 * chosen node (either the left child, right child, or parent of the chosen node.)
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn.  If 
 * both players pass their turn, the game ends, and the winner is the player that colored more nodes.
 * You are the second player.  If it is possible to choose such a y to ensure you win the game, 
 * return true.  If it is not possible, return false.
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * Output: true
 * Explanation: The second player can choose the node with value 2.
 * Constraints:
 * 1. root is the root of a binary tree with n nodes and distinct node values from 1 to n.
 * 2. n is odd.
 * 3. 1 <= x <= n <= 100
 * @author wendi
 *
 */
public class BinaryTreeColoringGame {
	
	
	/**
	 * dfs:
	 * The first player colors a node,
	 * there are at most 3 nodes connected to this node.
	 * Its left, its right and its parent.
	 * Take this 3 nodes as the root of 3 subtrees.

	 * The second player just color any one root,
	 * and the whole subtree will be his.
	 * And this is also all he can take,
	 * since he cannot cross the node of the first player.

	 * @param TreeNode root, int n, int x
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	int left, right, val;
	public boolean binaryTreeColoringGame(TreeNode root, int n, int x) {
		left = 0;
		right = 0;
		val = x;
		int parent = dfs(root);
		return Math.max(Math.max(left, right), parent) > n / 2;
	}
	
	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int l = dfs(root.left);
		int r = dfs(root.right);
		if (root.val == val) {
			left = l;
			right = r;
			return 0;
		}
		return l + r + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeColoringGame result = new BinaryTreeColoringGame();
		TreeNode root = TreeNode.generateCBT(new int[] {1,2,3,4,5,6,7,8,9,10,11});
		System.out.println(result.binaryTreeColoringGame(root, 11, 3));
	}

}
