import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets 
 * A and B such that every edge in the graph has one node in A and another node in B.
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge 
 * between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are 
 * no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element 
 * twice.
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 * Note:
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 * @author wendi
 *
 */
public class IsGraphBipartite {
	
	
	/**
	 * BFS:we need to check each if each cluster(edges linked together) is Bipartite.
	 * staining method
	 * @param int[][] graph
	 * @return boolean
	 * Time: O(v*e)
	 * Space: O(e)
	 */
	public boolean isGraphBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        //This graph might be a disconnected graph. So check each unvisited node.
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !isValid(graph, i, color)) return false;
        }
        return true;
    }
     
    private boolean isValid(int[][] graph, int i, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        color[i] = 0;
        queue.offer(i);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v: graph[u]) {
                if (color[v] == color[u]) return false;
                if (color[v] == -1) {
                    color[v] = color[u] ^ 1;
                    queue.offer(v);
                }
            }
        }
        return true;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsGraphBipartite result = new IsGraphBipartite();
		System.out.println(result.isGraphBipartite(new int[][] {{1,3}, {0,2}, {1,3}, {0,2}}));
	}

}
