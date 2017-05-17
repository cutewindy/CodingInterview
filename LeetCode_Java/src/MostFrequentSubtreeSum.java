import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum 
 * of a node is defined as the sum of all the node values formed by the subtree rooted at that node 
 * (including the node itself). So what is the most frequent subtree sum value? If there is a tie, 
 * return all the values with the highest frequency in any order.
 * Examples 1
 * Input:
		  5
		 /  \
		2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
		  5
		 /  \
		2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * Tags: Tree, Hash Table
 * @author wendi
 *
 */
public class MostFrequentSubtreeSum {
	
	/**
	 * HashMap: idea is recursion traversing the tree and get sum of every sub-tree, putting sum to 
	 * count mapping to a HashMap and using an int to record the most frequent subtree sum. 
	 * Then generate result based on the HashMap.
	 * @param TreeNode root
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 * Stack space: O(log(n))
	 */
	public int[] mostFrequentSubtreeSum(TreeNode root) {
		if (root == null) return new int[0];
		Map<Integer, Integer> sum = new HashMap<>();
		int[] frequent = {0};
		helper(root, sum, frequent);
		List<Integer> result = new ArrayList<>();
		for (Integer count: sum.keySet()) {
			if (sum.get(count) == frequent[0]) {
				result.add(count);
			}
		}
		int[] resultArray = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			resultArray[i] = result.get(i);
		}
		return resultArray;
	}
	
	public int helper(TreeNode root, Map<Integer, Integer> sum, int[] frequent) {
		if (root == null) return 0;
		int subtreeSum = root.val + helper(root.left, sum, frequent) + helper(root.right, sum, frequent);
		if (sum.containsKey(subtreeSum)) {
			sum.put(subtreeSum, sum.get(subtreeSum) + 1);
		}
		else {
			sum.put(subtreeSum, 1);
		}
		if (sum.get(subtreeSum) > frequent[0]) {
			frequent[0] = sum.get(subtreeSum);
		}
		return subtreeSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostFrequentSubtreeSum result = new MostFrequentSubtreeSum();
		TreeNode root = TreeNode.generateCBT(new int[] {5, 2, -5});
		System.out.println(Arrays.toString(result.mostFrequentSubtreeSum(root)));
	}

}
