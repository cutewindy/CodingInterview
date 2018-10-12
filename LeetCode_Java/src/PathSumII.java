import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given 
 * sum.
 * For example:
 * Given the below binary tree and sum = 22,
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \    / \
		        7    2  5   1
 * return
 *  [
 *    [5,4,11,2],
 *    [5,8,4,5]
 *  ]
 *  
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class PathSumII {
	
	/**
	 * DFS: save currPath and left sum(not include curr.val). If currNode is a leaf, check if the 
	 * sum is curr.val.
	 * If currNode has left, go to left with sum-curr.val.
	 * If currNode has right, go to right with sum-curr.val.
	 * Since we use List<Integer> to save currPath, add sth need to remove sth finaly. 
	 * @param TreeNode root, int sum
	 * @return List<List<Integer>>
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path.add(root.val);
            if (sum == root.val) res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        dfs(root.left, sum - root.val, path, res);
        dfs(root.right, sum - root.val, path, res);
        path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSumII result = new PathSumII();
		TreeNode root = TreeNode.generateCBT(new int[] {5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1});
		TreeNode.printCBT(root);
		System.out.println(result.pathSumII(root, 22));
	}

}
