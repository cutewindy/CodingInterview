/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of 
 * nodes), write a function to find the number of connected components in an undirected graph.
 * Example 1:
		     0          3
		     |          |
		     1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * Example 2:
		     0           4
		     |           |
		     1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * 
 * Tags: DFS, BFS, Union Find, Graph
 * @author wendi
 *
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
	
	class UnionFind {
		int[] parents;
		public UnionFind(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}
		}
		public int find(int node) {
			int parent = node;
			while (parents[parent] != parent) {
				parent = parents[parent];
			}
			while (parents[node] != parent) {  // pass compression
				int temp = parents[node];
				parents[node] = parent;
				node = temp;
			}
			return parent;
		}
		
		public boolean union(int node1, int node2) {
			int p1 = find(node1);
			int p2 = find(node2);
			if (p1 == p2) {
				return false;
			}
			else {
				parents[p2] = p1;
			}
			return true;
		}
	}

	
	/**
	 * Union find: for each edge, if we need to do union, then the single node--.
	 * @param int n, int[][] edges
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int numberofConnectedComponentsinanUndirectedGraph(int n, int[][] edges) {
		if (edges == null || edges.length == 0 || n <= 1) {
			return n;
		}
		int result = n;
		UnionFind uf = new UnionFind(n);
		for (int[] edge: edges) {
			if (uf.union(edge[0], edge[1])) {
				result--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofConnectedComponentsinanUndirectedGraph result = new NumberofConnectedComponentsinanUndirectedGraph();
		System.out.println(result.numberofConnectedComponentsinanUndirectedGraph(5, new int[][]
				{{0,1},{2, 1},{2,0},{2,4}}));
	}

}
