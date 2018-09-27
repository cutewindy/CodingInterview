import java.util.HashMap;
import java.util.Map;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards 
 * (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
		      10
		     /  \
		    5   -3
		   / \    \
		  3   2   11
		 / \   \
		3  -2   1
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * Tags: Tree
 * @author wendi
 *
 */
public class PathSumIII {

	
	/**
	 * Method2: DFS(top-down)
	 * Take each node as root each time.
	 * @param TreeNode root, int sum
	 * @return int
	 * Time:O(n!)
	 * Space: O(1)
	 */
	public int pathSumIIII(TreeNode root, int sum) {
		if (root == null) return 0;
		return getFromRoot(root, sum) + pathSumIIII(root.left, sum) + pathSumIIII(root.right, sum);
	}
	
	
	public int getFromRoot(TreeNode root, int sum) {
		if (root == null) return 0;
		return (root.val == sum ? 1 : 0) + 
				getFromRoot(root.left, sum - root.val) + getFromRoot(root.right, sum - root.val);
	}
	
	
	
	/**
	 * Method1: DFS(Bottom up)
	 * @param TreeNode root, int sum
	 * @return int
	 * Time:O(n^2)
	 * Space: O(nlog(n))
	 */
	public int pathSumIII(TreeNode root, int sum) {
		if (root == null) return 0;
		return helper(root, sum, new HashMap<Integer, Integer>());
	}
	
	public int helper(TreeNode root, int sum, Map<Integer, Integer> hash) {
		if (root == null) return 0;
		int result = 0;
		Map<Integer, Integer> newHash = new HashMap<>();
		// update hash
		for (Integer key: hash.keySet()) newHash.put(key + root.val, hash.get(key));
		newHash.put(root.val, newHash.getOrDefault(root.val, 0) + 1);
		result += newHash.getOrDefault(sum, 0);
		return result + helper(root.left, sum, newHash) + helper(root.right, sum, newHash);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSumIII result = new PathSumIII();
//		TreeNode root = TreeNode.generateCBT(new int[] {10,5,-3,3,2,0,11,3,-2,0,1});
		TreeNode root = TreeNode.generateCBT(new int[] {0, 1, 1});
		System.out.println(result.pathSumIII(root, 1));
		System.out.println(result.pathSumIIII(root, 1));
	}

}
