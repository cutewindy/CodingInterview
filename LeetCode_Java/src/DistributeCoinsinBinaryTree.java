/**
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there 
 * are N coins total.
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The 
 * move may be from parent to child, or from child to parent.)
 * Return the number of moves required to make every node have exactly one coin.
 * Example 1:
 *      3
 *     / \
 *    0   0
 * Input: [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its 
 * right child.
 * Example 2:
 *      0
 *     / \
 *    3   0
 * Input: [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves].  
 * Then, we move one coin from the root of the tree to the right child.
 * Example 3:
 *      1
 *     / \
 *    0   2
 * Input: [1,0,2]
 * Output: 2
 * Example 4:
 *      1
 *     / \
 *    0   0
 *     \
 *      3
 * Input: [1,0,0,null,3]
 * Output: 4
 * 
 * Note:
 * 1. 1<= N <= 100
 * 2. 0 <= node.val <= N
 * @author wendi
 *
 */
public class DistributeCoinsinBinaryTree {
	
	
	/**
	 * dfs: post order traversal
	 * recursion func returns the amount of coins each node need or have excessively exclude itself. 
	 * For each node, it will try to balance the amount of the coins used by its left child and 
	 * right child.
	 * It will return a positive number if there is excessive coins which could be used by its 
	 * parent node, or a negative number if current node or its children need coins.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int distributeCoinsinBinaryTree(TreeNode root) {
		if (root == null) return 0;
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}
	
	private int dfs(TreeNode root, int[] res) {
		if (root == null) return 0;
		int left = dfs(root.left, res);
		int right = dfs(root.right, res);
		int currCoins = left + right + root.val - 1;
		res[0] += Math.abs(currCoins);
		return currCoins;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistributeCoinsinBinaryTree result = new DistributeCoinsinBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {0, 3, 0});
		TreeNode.printCBT(root);
		System.out.println(result.distributeCoinsinBinaryTree(root));
	}

}
