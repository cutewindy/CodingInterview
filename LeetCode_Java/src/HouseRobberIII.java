/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this 
 * area, called the "root." Besides the root, each house has one and only one parent house. After a tour, 
 * the smart thief realized that "all houses in this place forms a binary tree". It will automatically 
 * contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
		     3
		    / \
		   2   3
		    \   \ 
		     3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
		     3
		    / \
		   4   5
		  / \   \ 
		 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class HouseRobberIII {

	/**
	 * DFS(Recursion): Use an array to save the profits of two states, no robber or robber at this node.
	 * dp[0] means the profits that no robber at this node. dp[0] means the profits that robber at this node.
	 * If no robber, dp[0] = max(left[0], left[1]) + max(right[0], right[1]).
	 * If robber, dp[1] = left[0] + right[0] + node.val.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int houseRobberIII(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}
	
	private int[] helper(TreeNode root) {
		int[] dp = new int[2];    // dp[0] means not robber, dp[1] means robber
		if (root == null) {
			return dp;
		}
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		dp[0] = Math.max(left[0], left[1]) + 
				Math.max(right[0], right[1]);
		dp[1] = left[0] + right[0] + root.val;
		return dp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobberIII result = new HouseRobberIII();
		TreeNode root = TreeNode.generateCBT(new int[] {3, 4, 5, 1, 3, 0, 1});
		TreeNode.printCBT(root);
		System.out.println(result.houseRobberIII(root));
	}

}
