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
	 * Method3: backtracking + prefixSum + hashMap
	 * So the idea is similar as Two sum, using HashMap to store (key: the prefix sum, value: how 
	 * many ways get to this prefix sum) , and whenever reach a node, we check if prefix sum - target 
	 * exists in hashmap or not, if it does, we added up the ways of prefix sum - target into res.
	 * For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3, 
	 * let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and 
	 * {2} ways.
	 * @param TreeNode root, int sum
	 * @return int
	 * Time:O(n)
	 * Space: O(nlog(n))
	 */
	public int pathSumIIIII(TreeNode root, int sum) {
		if (root == null) return 0;
		int[] res = new int[1];
		Map<Integer, Integer> map = new HashMap<>();// [key, value] = [sum, freq]
		map.put(0, 1);
		dfs(root, sum, 0, map, res); 
		return res[0];
	}
	
	private void dfs(TreeNode root, int target, int currSum, Map<Integer, Integer> map, int[] res) {
		if (root == null) return;
		currSum += root.val;
		if (map.containsKey(currSum - target)) res[0] += map.get(currSum - target);
		map.put(currSum, map.getOrDefault(currSum, 0) + 1);
		dfs(root.left, target, currSum, map, res);
		dfs(root.right, target, currSum, map, res);
        map.put(currSum, map.get(currSum) - 1);  // take care, don't forget
	}

	
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
	 * Method1: DFS(top down) + hashmap
	 * @param TreeNode root, int sum
	 * @return int
	 * Time:O(nlog(n))
	 * Space: O(nlog(n))
	 */
	public int pathSumIII(TreeNode root, int sum) {
		if (root == null) return 0;
		int[] res = new int[1];
		dfs(root, sum, new HashMap<Integer, Integer>(), res);
		return res[0];
	}
	
	public void dfs(TreeNode root, int sum, Map<Integer, Integer> hash, int[] res) {
		if (root == null) return;
		Map<Integer, Integer> newHash = new HashMap<>();
		// update hash
		newHash.put(root.val, 1);
		for (Integer key: hash.keySet()) {
			newHash.put(root.val + key, newHash.getOrDefault(root.val + key, 0) + hash.get(key));
		}
		res[0] += newHash.getOrDefault(sum, 0);
		dfs(root.left, sum, newHash, res); 
		dfs(root.right, sum, newHash, res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSumIII result = new PathSumIII();
//		TreeNode root = TreeNode.generateCBT(new int[] {10,5,-3,3,2,0,11,3,-2,0,1});
		TreeNode root = TreeNode.generateCBT(new int[] {0, 1, 1});
		System.out.println(result.pathSumIII(root, 1));
		System.out.println(result.pathSumIIII(root, 1));
		System.out.println(result.pathSumIIIII(root, 1));
	}
	

}
