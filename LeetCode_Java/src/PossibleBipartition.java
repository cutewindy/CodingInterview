import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups 
 * of any size.
 * Each person may dislike some other people, and they should not go into the same group. 
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b 
 * into the same group.
 * Return true if and only if it is possible to split everyone into two groups in this way.
 * Example 1:
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * Note:
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 * @author wendi
 *
 */
public class PossibleBipartition {
	
	/**
	 * BFS, stain color
	 * @param int N, int[][] dislikes
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean possibleBipartition(int N, int[][] dislikes) {
		if (N == 1 || dislikes == null || dislikes.length == 0) return true;
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		buildGraph(N, dislikes, graph);
		// stain color, two colors: 0 or 1
		int[] color = new int[N + 1];
		Arrays.fill(color, -1);
		for (int i = 1; i <= N; i++) {
			if (color[i] == -1 && !stainColor(i, graph, color)) return false;
		}
		return true;
	}
	
	private boolean stainColor(int first, Map<Integer, Set<Integer>> graph, int[] color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(first);
		color[first] = 0;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			if (!graph.containsKey(u)) continue;
			for (Integer v: graph.get(u)) {
				if (color[v] == color[u]) return false;
				if (color[v] == -1) {
					color[v] = color[u] ^ 1;
					queue.offer(v);
				}
			}
		}
		return true;
	}
	
	private void buildGraph(int N, int[][] dislikes, Map<Integer, Set<Integer>> graph) {
		for (int i = 1; i <= N; i++) graph.put(i, new HashSet<Integer>());
		for (int[] dislike: dislikes) {
			graph.get(dislike[0]).add(dislike[1]);
			graph.get(dislike[1]).add(dislike[0]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PossibleBipartition result = new PossibleBipartition();
		System.out.println(result.possibleBipartition(4, new int[][] {{1,2},{1,3},{2,4}}));
		System.out.println(result.possibleBipartition(4, new int[][] {{1,2},{1,3},{2,3}}));
	}

}
