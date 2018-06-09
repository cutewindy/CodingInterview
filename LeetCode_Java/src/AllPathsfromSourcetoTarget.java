import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and 
 * return them in any order.
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of 
 * all nodes j for which the edge (i, j) exists.
 * Example:
 * Input: [[1,2], [3], [3], []] 
 * Output: [[0,1,3],[0,2,3]] 
 * Explanation: The graph looks like this:
		0--->1
		|    |
		v    v
		2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Note:
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 * @author wendi
 *
 */
public class AllPathsfromSourcetoTarget {
	
	
	/**
	 * Recursion
	 * @param int[][] graph
	 * @return List<List<Integer>>
	 * Time: O(n^2)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<List<Integer>> allPathsfromSourcetoTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		findPath(graph, 0, new ArrayList<Integer>(Arrays.asList(0)), res);
		return res;
	}
	
	private void findPath(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
		if (node == graph.length - 1) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		for (int next: graph[node]) {
			path.add(next);
			findPath(graph, next, path, res);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllPathsfromSourcetoTarget result = new AllPathsfromSourcetoTarget();
		System.out.println(result.allPathsfromSourcetoTarget(new int[][] {{1,2}, {3}, {3}, {}}));
	}

}
