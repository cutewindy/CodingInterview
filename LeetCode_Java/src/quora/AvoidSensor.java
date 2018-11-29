package quora;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AvoidSensor {
	
	class Node{
		int x;
		int y;
		int r;
		public Node(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	/**
	 * graph + dfs
	 * @param int[][] points
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public boolean avoidSensor(int[][] points, int m, int n) {
		if (points == null || points.length == 0) return true;
		Node[] nodes = new Node[points.length];
		Map<Node, Set<Node>> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			Node node = new Node(points[i][0], points[i][1], points[i][2]);
			nodes[i] = node;
			map.put(node, new HashSet<Node>());
		}
		
		for (int i = 0; i < nodes.length - 1; i++) {
			for (int j = i + 1; j < nodes.length; j++) {
				int d2 = (nodes[i].y - nodes[j].y) * (nodes[i].y - nodes[j].y) + (nodes[i].x - nodes[j].x) * (nodes[i].x - nodes[j].x);
				int r2 = (nodes[i].r + nodes[j].r) * (nodes[i].r + nodes[j].r);
				if (d2 <= r2) {   // neighbors
					map.get(nodes[i]).add(nodes[j]);
					map.get(nodes[j]).add(nodes[i]);
				}
			}
		}
		
		for (Node node: nodes) {
			if (node.x - node.r <= 0 && dfs(node, map, new HashSet<Node>(), m)) return false;
		}
		
		return true;
	}
	
	private boolean dfs(Node u, Map<Node, Set<Node>> map, Set<Node> visited, int m) {
		if (u.x + u.r >= m) return true;
		visited.add(u);
		for (Node v: map.get(u)) {
			if (visited.contains(v)) continue;
			if (dfs(v, map, visited, m)) return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvoidSensor result = new AvoidSensor();
		System.out.println(result.avoidSensor(new int[][] {{1,1,1}, {2,3,1}, {5,3,2}}, 6, 5)); // true, can avoid sensor
		System.out.println(result.avoidSensor(new int[][] {{1,1,1}, {2,3,2}, {5,3,1}}, 6, 5)); // false
	}
}

