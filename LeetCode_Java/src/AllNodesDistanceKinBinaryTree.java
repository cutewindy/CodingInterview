import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer 
 * can be returned in any order.
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * Output: [7,4,1]
 * Explanation: 
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * Note:
 * 1. The given tree is non-empty.
 * 2. Each node in the tree has unique values 0 <= node.val <= 500.
 * 3. The target node is a node in the tree.
 * 4. 0 <= K <= 1000.
 * @author wendi
 *
 */
public class AllNodesDistanceKinBinaryTree {
	
	/**
	 * Graph
	 * 1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
	 * 2. do BFS with source vertice (target) to find all vertices with distance K to it.
	 * @param TreeNode root, TreeNode target, int K
	 * @return List<Integer>
	 * Time: O(E + V)
	 * Space: O(E + V)
	 */
	public List<Integer> allNodesDistanceKinBinaryTree(TreeNode root, TreeNode target, int K) {
        if (root == null) return new ArrayList<>();
        if (K == 0) return new ArrayList<>(Arrays.asList(target.val));
        
        // build graph (DFS)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(null, root, graph);
        if (graph.size() == 0) return new ArrayList<>();

        // find k distance (BFS)
        List<Integer> res = new ArrayList<>();
        findKDistance(graph, target.val, K, res);
        
        return res;
    }
    
    private void buildGraph(TreeNode prev, TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null) return;
        if (prev != null) {
            if (!graph.containsKey(prev.val)) graph.put(prev.val, new ArrayList<Integer>());
            graph.get(prev.val).add(root.val);
            if (!graph.containsKey(root.val)) graph.put(root.val, new ArrayList<Integer>());
            graph.get(root.val).add(prev.val);
        }
        buildGraph(root, root.left, graph);
        buildGraph(root, root.right, graph);
    }
    
    private void findKDistance(Map<Integer, List<Integer>> graph, int target, int K, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        Set<Integer> visited = new HashSet<>();
        visited.add(target);
        while (!queue.isEmpty()) {
            if (K-- == 0) {
                while (!queue.isEmpty()) res.add(queue.poll());
            }
            int size = queue.size();
            while (size-- > 0) {
                int u = queue.poll();
                for (Integer v: graph.get(u)) {
                    if (visited.contains(v)) continue;
                    visited.add(v);
                    queue.offer(v);
                }
            }
        }		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllNodesDistanceKinBinaryTree result = new AllNodesDistanceKinBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {3, 5, 1, 6, 2, 0, 8, 7, 4});
		TreeNode target = root.left;
		System.out.println(result.allNodesDistanceKinBinaryTree(root, target, 2));
	}

}
