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
	 * Space: O(h)
	 */
	public List<List<Integer>> pathSumII(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		List<Integer> currPath = new ArrayList<>();
		helper(root, sum, currPath, result);
		return result;
	}
	
	private void helper(TreeNode root, int sum, List<Integer> currPath, List<List<Integer>> result) {
		if (root.left == null && root.right == null) {  // if root is leaf, check sum
			if (sum == root.val) {
				currPath.add(root.val);
				result.add(new ArrayList<>(currPath));
				currPath.remove(currPath.size() - 1);
			}
			return;
		}
		currPath.add(root.val);
		if (root.left != null) {
			helper(root.left, sum - root.val, currPath, result);
		}
		if (root.right != null) {
			helper(root.right, sum - root.val, currPath, result);
		}
		currPath.remove(currPath.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSumII result = new PathSumII();
		TreeNode root = TreeNode.generateCBT(new int[] {5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1});
		TreeNode.printCBT(root);
		System.out.println(result.pathSumII(root, 22));
	}

}
