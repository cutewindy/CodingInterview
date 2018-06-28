import java.util.HashMap;
import java.util.Map;

/**
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of 
 * three-digits integers.
 * For each integer in this list:
 * The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 * The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. 
 * The position is the same as that in a full binary tree.
 * The units digit represents the value V of this node, 0 <= V <= 9.
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 
 * 5. You need to return the sum of all paths from the root towards the leaves.
 * Example 1:
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation: 
 * The tree that the list represents is:
 *     3
 *    / \
 *   5   1
 * The path sum is (3 + 5) + (3 + 1) = 12.
 * Example 2:
 * Input: [113, 221]
 * Output: 4
 * Explanation: 
 * The tree that the list represents is: 
 *     3
 *      \
 *       1
 * The path sum is (3 + 1) = 4.
 * @author wendi
 *
 */
public class PathSumIV {
	
	/**
	 * Method2:DFS(top down) Using HashMap as tree
	 * keep a root to leaf running sum. If we see a leaf node (node.left == null && node.right == null), 
	 * we add the running sum to the final result.
	 * Now each tree node is represented by a number. 1st digits is the level, 2nd is the position 
	 * in that level (note that it starts from 1 instead of 0). 3rd digit is the value. We need to 
	 * find a way to traverse this tree and get the sum.
	 * The idea is, we can form a tree using a HashMap. The key is first two digits which marks the 
	 * position of a node in the tree. The value is value of that node. Thus, we can easily find a 
	 * node's left and right children using math.
	 * Formula: For node xy? its left child is (x+1)(y*2-1)? and right child is (x+1)(y*2)?
	 * Given above HashMap and formula, we can traverse the tree.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	
	private int sum;
	public int pathSumIVI(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		sum = 0;
		Map<Integer, Integer> treeMap = new HashMap<>();
		for (int n: nums) treeMap.put(n / 10, n % 10);
		traverseTree(treeMap, nums[0] / 10, 0);
		return sum;
	}	
	
	private void traverseTree(Map<Integer, Integer> treeMap, int root, int prevSum) {
		int level = root / 10;
		int pos = root % 10;
		int left = (level + 1) * 10 + 2 * pos - 1;
		int right = (level + 1) * 10 + 2 * pos;
		if (!treeMap.containsKey(left) && !treeMap.containsKey(right)) {
			sum += prevSum + treeMap.get(root);
			return;
		}
		if (treeMap.containsKey(left)) traverseTree(treeMap, left, prevSum + treeMap.get(root));
		if (treeMap.containsKey(right)) traverseTree(treeMap, right, prevSum + treeMap.get(root));
	}
	
	
	
	
	
	
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	
	/**
	 * Method1: Build Tree
	 * @param int[] nums
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int pathSumIV(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		TreeNode root = buildTree(nums, 0, 1, 0);
		return pathSum(root);
	}
	
	
	private int pathSum(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return root.val;
		int left = pathSum(root.left);
		int right = pathSum(root.right);
		return (left == 0 ?  0 : left + root.val) + (right == 0 ? 0 : right + root.val);
	}
	
	private TreeNode buildTree(int[] nums, int start, int find, int level) {
		if (start >= nums.length) return null;
		TreeNode curr = null;
		for (int i = start; i < nums.length; i++) {
			if (nums[i] / 100 - 1 != level) continue;
			int pos = 2 * level + nums[i] / 10 % 10 - 1;
			pos = pos == 0 ? 1 : pos;
			if (find == pos) {
				curr = new TreeNode(nums[i] % 10);
				curr.left = buildTree(nums, i + 1, 2 * pos, level + 1);
				curr.right = buildTree(nums, i + 1, 2 * pos + 1, level + 1);
				break;
			}
		}
		System.out.println("level: " + level + " node: " + (curr == null ? -1 : curr.val));
		return curr;		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSumIV result = new PathSumIV();
//		System.out.println(result.pathSumIV(new int[] {111,217,221,315,415}));
		System.out.println(result.pathSumIVI(new int[] {113,229,349,470,485}));
//		System.out.println(result.pathSumIV(new int[] {113, 215, 221, 315, 324, 336, 347, 434, 456}));
	}

}
