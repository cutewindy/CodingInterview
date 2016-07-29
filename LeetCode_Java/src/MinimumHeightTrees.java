import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result 
 * graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called 
 * minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return 
 * a list of their root labels.
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and 
 * a list of undirected edges (each edge is a pair of labels).
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] 
 * is the same as [1, 0] and thus will not appear together in edges.
 * Example 1:
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
	        0
	        |
	        1
	       / \
	      2   3
 * return [1]
 * Example 2:
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
	     0  1  2
	      \ | /
	        3
	        |
	        4
	        |
	        5
 * return [3, 4]
 * Hint:
 * How many MHTs can a graph have at most?
 * Note:
 * (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any 
 * two vertices are connected by exactly one path. In other words, any connected graph without simple 
 * cycles is a tree.”
 * (2) The height of a rooted tree is the number of edges on the longest downward path between the 
 * root and a leaf.
 * 
 * Tags: BFS, Graph
 * @author wendi
 *
 */
public class MinimumHeightTrees {

	/**
	 * BFS:The actual implementation is similar to the BFS topological sort. Remove the leaves, 
	 * update the degrees of inner vertexes. Then remove the new leaves. Doing so level by level 
	 * until there are 2 or 1 nodes left. What's left is our answer!
	 * @param int n, int[][] edges
	 * @return List<Integer>
	 * Time: O(n) 
	 * Space: O(n)
	 */
	public List<Integer> minimumHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();
		if (n == 0) {
			return result;
		}
		if (n == 1) {
			result.add(0);
			return result;
		}
		// build graph and inDegree
		Map<Integer, List<Integer>> graph = new HashMap<>();  
		int[] inDegree = new int[n];
		for (int i = 0; i < n; i++) { // create node
			List<Integer> neighbors = new ArrayList<>();
			graph.put(i, neighbors);
		}
		for (int[] edge: edges) {  // add neighbors for each node, and record inDegree of each node
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
			inDegree[edge[0]]++;
			inDegree[edge[1]]++;
		}
		// init: find the leaf, which inDegree is 1, and offer it into queue
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 1) {
				queue.offer(i);
			}
		}
		// remove leaf level by level, until there are no more than 2.(At most two roots)
		while (n > 2) {
			n -= queue.size();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int leaf = queue.poll();
				inDegree[leaf]--;
				for (int neighbor: graph.get(leaf)) {
					inDegree[neighbor]--;
					if (inDegree[neighbor] == 1) {
						queue.offer(neighbor);
					}
				}
			}
		}
		for (int root: queue) {
			result.add(root);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees result = new MinimumHeightTrees();
		System.out.println(result.minimumHeightTrees(6, new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
	}

}
