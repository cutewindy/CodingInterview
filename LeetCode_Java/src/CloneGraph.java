import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of 
 * the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 1 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * 2 Second node is labeled as 1. Connect node 1 to node 2.
 * 3 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
	       1
	      / \
	     /   \
	    0 --- 2
	         / \
	         \_/
 * 
 * Tags: DFS, BFS, Graph
 * @author wendi
 *
 */
public class CloneGraph {

	class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	public UndirectedGraphNode generateUndiretedGraph() {
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);
		return node0;
	}
	
	/**
	 * BFS: clone old node level by level. Use hashMap<oldNode, newNode> to record the old node has
	 * already been cloned. Use queue to save the old node, which has not been clone its neighbors.
	 * @param UndirectedGraphnode node
	 * @return UndirectedGraphNode
	 * Time: O(n)
	 * Space: O(n)
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> hash = new HashMap<>();
		queue.offer(node);  // node in the queue means the corresponding new node has not connect to neighbors
		hash.put(node, newNode); // use hash to save the old node has already clone new node
		while (!queue.isEmpty()) {
			UndirectedGraphNode oldNode = queue.poll();
			for (UndirectedGraphNode neighbor: oldNode.neighbors) {
				if (!hash.containsKey(neighbor)) {  // if not copy this node, copy it first, and then update queue and hash
					UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
					queue.offer(neighbor);
					hash.put(neighbor, newNeighbor);
				}
				hash.get(oldNode).neighbors.add(hash.get(neighbor)); // clone new neighbor to new node.
			}
		}
		return newNode;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloneGraph result = new CloneGraph();
		UndirectedGraphNode node = result.generateUndiretedGraph();
		System.out.println(node.label);
		UndirectedGraphNode newNode = result.cloneGraph(node);
		System.out.println(newNode.label);
	}

}
