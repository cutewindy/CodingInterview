import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is 
 * either red or blue, and there could be self-edges or parallel edges.
 * Each [i, j] in red_edges denotes a red directed edge from node i to node j.  Similarly, each 
 * [i, j] in blue_edges denotes a blue directed edge from node i to node j.
 * Return an array answer of length n, where each answer[X] is the length of the shortest path from 
 * node 0 to node X such that the edge colors alternate along the path (or -1 if such a path doesn't 
 * exist).
 * Example 1:
 * Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * Output: [0,1,-1]
 * Example 2:
 * Input: n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * Output: [0,1,-1]
 * Example 3:
 * Input: n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * Output: [0,-1,-1]
 * Example 4:
 * Input: n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * Output: [0,1,2]
 * Example 5:
 * Input: n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * Output: [0,1,1]
 * Constraints:
 * 1. 1 <= n <= 100
 * 2. red_edges.length <= 400
 * 3. blue_edges.length <= 400
 * 4. red_edges[i].length == blue_edges[i].length == 2
 * 5. 0 <= red_edges[i][j], blue_edges[i][j] < n
 * @author wendi
 *
 */
public class ShortestPathwithAlternatingColors {
	
	/**
	 * Approach1: Set(graph) + bfs
	 * @param int n, int[][] red_edges, int[][] blue_edges
	 * @return int[]
	 * Time: O(V + E)
	 * Space: O(V + E)
	 */
	public int[] shortestPathwithAlternatingColorsI(int n, int[][] red_edges, int[][] blue_edges) {
		int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        res[0][0] = 0;
        res[0][1] = 0;
        Set<Integer>[][] graph = new Set[n][2];
        for (int[] e: red_edges) {
            if (graph[e[0]][0] == null) graph[e[0]][0] = new HashSet<>();
            graph[e[0]][0].add(e[1]);
        }
        for (int[] e: blue_edges) {
            if (graph[e[0]][1] == null) graph[e[0]][1] = new HashSet<>();
            graph[e[0]][1].add(e[1]);
        }
        // bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        queue.offer(new int[] {0, 1});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int pos = curr[0];
                int color = curr[1];
                if (graph[pos][1 - color] == null) continue;
                for (int next: graph[pos][1 - color]) {
                    if (res[next][1 - color] != Integer.MAX_VALUE) continue;
                    res[next][1 - color] = res[pos][color] + 1;
                    queue.offer(new int[] {next, 1 - color});
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (res[i][0] == Integer.MAX_VALUE && res[i][1] == Integer.MAX_VALUE) ans[i] = -1;
            else ans[i] = Math.min(res[i][0], res[i][1]);
        }
        return ans;
	}
	
	
	/**
	 * Approach1: Map(graph) + bfs + Set(visited)
	 * @param int n, int[][] red_edges, int[][] blue_edges
	 * @return int[]
	 * Time: O(V + E)
	 * Space: O(V + E)
	 */
	public int[] shortestPathwithAlternatingColors(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        Map<Integer, Set<Integer>> red_map = new HashMap<>();
        Map<Integer, Set<Integer>> blue_map = new HashMap<>();
        for (int[] e: red_edges) {
            if (!red_map.containsKey(e[0])) red_map.put(e[0], new HashSet<Integer>());
            red_map.get(e[0]).add(e[1]);
        }
        for (int[] e: blue_edges) {
            if (!blue_map.containsKey(e[0])) blue_map.put(e[0], new HashSet<Integer>());
            blue_map.get(e[0]).add(e[1]);
        }
        bfs(red_map, blue_map, res);
        bfs(blue_map, red_map, res);
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
    }
    
    private void bfs(Map<Integer, Set<Integer>> map1, Map<Integer, Set<Integer>> map2, int[] res) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 0;
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        visited1.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                res[curr] = Math.min(level, res[curr]);
                if (!map1.containsKey(curr)) continue;
                for (int next: map1.get(curr)) {
                	if (visited1.contains(next)) continue;
                    queue.offer(next);
                    visited1.add(next);
                }
            }
            Map<Integer, Set<Integer>> tempMap = map1;
            map1 = map2;
            map2 = tempMap;
            Set<Integer> tempSet = visited1;
            visited1 = visited2;
            visited2 = tempSet;
            level++;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPathwithAlternatingColors result = new ShortestPathwithAlternatingColors();
		System.out.println(Arrays.toString(result.shortestPathwithAlternatingColors(5, new int[][] {{0,1},{1,2},{2,3},{3,4}}, new int[][] {{1,2},{2,3},{3,1}})));
		System.out.println(Arrays.toString(result.shortestPathwithAlternatingColors(5, new int[][] {{0,1},{1,2},{2,3},{3,4}}, new int[][] {{1,2},{2,3},{3,1}})));
	}

}
