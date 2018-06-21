import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of 
 * nodes), write a function to check whether these edges make up a valid tree.
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * @author wendi
 *
 */
public class GraphValidTree {
			
	/**
	 * Method3: Union find
	 * @param int n, int[][] edges
	 * @return boolean
	 * Time: O(v + e)
	 * Space: O(v)
	 */
	public boolean graphValidTreeII(int n, int[][] edges) {
		if (n <= 1) return true;
		if (edges == null || edges.length != n - 1 || edges[0].length == 0) return false;
		UnionFindSet ufs = new UnionFindSet(n);
		for (int[] e: edges) {
			if (!ufs.union(e[0], e[1])) return false;
		}
		return true;
	}
	
	
	class UnionFindSet {
		int[] parents;
		public UnionFindSet(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) parents[i] = i;
		}
		
		public int find(int x) {
			while (parents[x] != x) {
				x = parents[x];
			}
			return x;
		}
		
		public boolean union(int a, int b) {
			int pA = find(a);
			int pB = find(b);
			if (pA != pB) {
				parents[pA] = pB;
				return true;
			}
			return false;
		}
 	}
	
	
	
	/**
	 * Method2: BFS
	 * @param int n, int[][] edges
	 * @return boolean
	 * Time: O(e + v)
	 * Space: O(2v)
	 */
	public boolean graphValidTreeI(int n, int[][] edges) {
		if (n <= 1) return true;
		if (edges == null || edges.length != n - 1 || edges[0].length == 0) return false;	
		
		// build the graph using adjacent list
		List<Set<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) graph.add(new HashSet<Integer>());
		for (int[] e: edges) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}
		
		// no cycle
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			Integer curr = queue.poll();
			for (Integer neighbor: graph.get(curr)) {
				if (visited[neighbor]) return false;
				visited[neighbor] = true;
				graph.get(neighbor).remove(curr);
				queue.offer(neighbor);
			}
		}
		
		// fully connected
		for (boolean find: visited) {
			if (!find) return false;
		}
		
		return true;
	}
	
	
	
	/**
	 * Method1: DFS + HashMap + HashSet
	 * @param int n, int[][] edges
	 * @return boolean
	 * Time: O(e + v)
	 * Space: O(2e+ v)
	 */
	public boolean graphValidTree(int n, int[][] edges) {
		if (n <= 1) return true;
		if (edges == null || edges.length != n - 1 || edges[0].length == 0) return false;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		// build undirected graph
		for (int[] e: edges) {
			if (!graph.containsKey(e[0])) graph.put(e[0], new ArrayList<Integer>());
			if (!graph.containsKey(e[1])) graph.put(e[1], new ArrayList<Integer>());
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}
		Set<Integer> visited = new HashSet<>();
		visited.add(0);		
		// walk graph
		return walkTree(-1, 0, graph, visited) && visited.size() == n;
	}
	
	
	public boolean walkTree(int prev, int curr, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
		if (!graph.containsKey(curr)) return true;
		for (Integer v: graph.get(curr)) {
			if (v == prev) continue;
			if (visited.contains(v)) return false;
			visited.add(v);
			if (!walkTree(curr, v, graph, visited)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphValidTree result = new GraphValidTree();
		System.out.println(result.graphValidTree(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
		System.out.println(result.graphValidTree(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
		System.out.println(result.graphValidTreeI(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
		System.out.println(result.graphValidTreeI(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
		System.out.println(result.graphValidTreeII(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
		System.out.println(result.graphValidTreeII(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
	}

}
