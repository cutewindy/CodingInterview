/**
 * Given the root of a binary tree, find the maximum value V for which there exists different nodes 
 * A and B where V = |A.val - B.val| and A is an ancestor of B.
 * (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an 
 * ancestor of B.)
 * Example 1:
 *                   8
 *               /       \
 *             3          10
 *          /    \          \
 *        1       6          14
 *              /   \       /
 *             4     7     13       
 * Input: [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: 
 * We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * Note:
 * 1. The number of nodes in the tree is between 2 and 5000.
 * 2. Each node will have value between 0 and 100000.
 * @author wendi
 *
 */
public class MaximumDifferenceBetweenNodeandAncestor {
	
	
	/**
	 * DFS(top down)
	 * pass the minimum and maximum values to the children,
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
    public int maximumDifferenceBetweenNodeandAncestor(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        dfs(root, root.val, root.val, res);
        return res[0];
    }
    
    private void dfs(TreeNode root, int min, int max, int[] res) {
        if (root == null) return;
        res[0] = Math.max(Math.abs(root.val - min), res[0]);
        res[0] = Math.max(Math.abs(root.val - max), res[0]);
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        dfs(root.left, min, max, res);
        dfs(root.right, min, max, res);
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumDifferenceBetweenNodeandAncestor result = new MaximumDifferenceBetweenNodeandAncestor();
		TreeNode root = TreeNode.generateCBT(new int[] {8, 3, 10, 1, 6, 10, 14, 2, 3, 4, 7, 13});
		TreeNode.printCBT(root);
		System.out.println(result.maximumDifferenceBetweenNodeandAncestor(root));
	}

}
