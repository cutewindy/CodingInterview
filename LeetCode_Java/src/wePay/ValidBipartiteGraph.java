package wePay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 判断一个图是否为二分图 bipartite graph
 * 二分图的定义是：给定一个具有n个顶点的图，要给每个顶点上色，并且使相邻的顶点颜色不相同。是否能用最多两种颜色进行染色？
 * (staining method)
 * @author wendi
 *
 */
public class ValidBipartiteGraph {

	/**
	 * BFS
	 * @param int[] edges
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean validBipartiteGraph(int[][] edges) {
		if (edges == null || edges.length == 0) return false;
		Map<Integer, List<Integer>> graph = new HashMap<>();	
		buildGraph(edges, graph);
		Map<Integer, Integer> color = new HashMap<>(); // store color infor, has 0, 1 color
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		// init
		queue.offer(edges[0][0]);
		color.put(edges[0][0], 0);
		visited.add(edges[0][0]);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v: graph.get(u)) {
				if (!color.containsKey(v)) color.put(v, color.get(u) ^ 1);  // stain color
				else if (color.get(u) == color.get(v)) return false;
				if (!visited.contains(v)) {
					queue.offer(v);
					visited.add(v);
				}
			}
		}
		return true;
	}
	
	private void buildGraph(int[][] edges, Map<Integer, List<Integer>> graph) {
		for (int[] e: edges) {
			int u = e[0], v = e[1];
			if (!graph.containsKey(u)) graph.put(u, new ArrayList<Integer>());
			graph.get(u).add(v);
			if (!graph.containsKey(v)) graph.put(v, new ArrayList<Integer>());
			graph.get(v).add(u);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidBipartiteGraph result = new ValidBipartiteGraph();
		System.out.println(result.validBipartiteGraph(new int[][] {{1,2},{1,3},{2,4},{2,5},{3,4},{3,5},{4,6}}));
		System.out.println(result.validBipartiteGraph(new int[][] {{1,2},{1,3},{2,3},{2,5},{3,4},{3,5},{4,6}}));
	}

}
