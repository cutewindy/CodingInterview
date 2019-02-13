import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * For each node at position (X, Y), its left and right children respectively will be at positions 
 * (X-1, Y-1) and (X+1, Y-1).
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches 
 * some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * If two nodes have the same position, then the value of the node that is reported first is the 
 * value that is smaller.
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of 
 * values of nodes.
 * Example 1:
 *         3
 *       /   \
 *      9     20
 *           /  \
 *         15    7   
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation: 
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * Example 2:
 *         1
 *       /   \
 *      2     3
 *     / \   /  \
 *    4   5 6    7      
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation: 
 * The node with value 5 and the node with value 6 have the same position according to the given 
 * scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 * Note:
 * 1. The tree will have between 1 and 1000 nodes.
 * 2. Each node's value will be between 0 and 1000.
 * @author wendi
 *
 */
public class VerticalOrderTraversalofaBinaryTree {
	
	/**
	 * Method2: DFS
	 * 1. use a hashmap to record the rows of each col, and record the minCol, [col, rows]
	 * 2. use a treemap to record the nodes of each rows, [row, nodes]
	 * @param TreeNode root
	 * @return List<List<Integer>>
	 * Time: O(nlog(n)) n is the number of nodes
	 * Space: O(n)
	 */
	public List<List<Integer>> verticalOrderTraversalofaBinaryTreeI(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		int[] rangeMin = new int[1];
		Map<Integer, TreeMap<Integer, List<Integer>>> map = new HashMap<>();  // [col, [row, list]]
		dfs(root, 0, 0, rangeMin, map);
		while (map.containsKey(rangeMin[0])) {
			int col = rangeMin[0]++;
			List<Integer> list = new ArrayList<>();
			for (Integer row: map.get(col).keySet()) {
				Collections.sort(map.get(col).get(row));
				list.addAll(map.get(col).get(row));
			}
			res.add(list);
		}
		return res;
	}
	
	private void dfs(TreeNode root, int row, int col, int[] rangeMin, Map<Integer, TreeMap<Integer, List<Integer>>> map) {
		if (root == null) return;
		rangeMin[0] = Math.min(col, rangeMin[0]);
		if (!map.containsKey(col)) map.put(col, new TreeMap<Integer, List<Integer>>());
		if (!map.get(col).containsKey(row)) map.get(col).put(row, new ArrayList<Integer>());
		map.get(col).get(row).add(root.val);
		dfs(root.left, row + 1, col - 1, rangeMin, map);
		dfs(root.right, row + 1, col + 1, rangeMin, map);
	}
	
	
	/**
	 * Method1: BFS 
	 * Same like "BinaryTreeVerticalOrderTraversal" 
	 * @param TreeNode root
	 * @return List<List<Integer>>
	 * Time: O(nlog(n)) n is the number of nodes
	 * Space: O(n)
	 */
	public List<List<Integer>> verticalOrderTraversalofaBinaryTree(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		int[] range = new int[2];
		getRange(root, range, 0);
		for (int i = range[0]; i <= range[1]; i++) res.add(new ArrayList<Integer>());
		bfs(root, -range[0], res);
		return res;
	}
	
	private void bfs(TreeNode root, int rootCol, List<List<Integer>> res) {
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		nodes.offer(root);
		cols.offer(rootCol);
		while (!nodes.isEmpty()) {
			int size = nodes.size();
			Map<Integer, List<Integer>> map = new HashMap<>();  //[key, value] = [col in each level, list]
			while (size-- > 0) {
				TreeNode node = nodes.poll();
				int col = cols.poll();
				map.putIfAbsent(col, new ArrayList<Integer>());
				map.get(col).add(node.val);
				if (node.left != null) {
					nodes.offer(node.left);
					cols.offer(col - 1);
				}
				if (node.right != null) {
					nodes.offer(node.right);
					cols.offer(col + 1);
				}
			}
			for (Integer col: map.keySet()) {
				Collections.sort(map.get(col));
				res.get(col).addAll(map.get(col));
			}
		}
	}
	
	private void getRange(TreeNode root, int[] range, int col) {
		if (root == null) return;
		range[0] = Math.min(col, range[0]);
		range[1] = Math.max(col, range[1]);
		getRange(root.left, range, col - 1);
		getRange(root.right, range, col + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerticalOrderTraversalofaBinaryTree result = new VerticalOrderTraversalofaBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1,2,3,4,5,6,7});
		TreeNode.printCBT(root);
		System.out.println(result.verticalOrderTraversalofaBinaryTree(root));
		System.out.println(result.verticalOrderTraversalofaBinaryTreeI(root));
	}

}
