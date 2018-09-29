import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a 
 * price w.
 * Now given all the cities and fights, together with starting city src and the destination dst, 
 * your task is to find the cheapest price from src to dst with up to k stops. If there is no such 
 * route, output -1.
 * Example 1:
 * Input: 
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation: 
 * The graph looks like this:
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the 
 * picture.
 * Example 2:
 * Input: 
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation: 
 * The graph looks like this:
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the 
 * picture.
 * Note:
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 * @author wendi
 *
 */
public class CheapestFlightsWithinKStops {
	
	/**
	 * Approach4: PriorityQueue
	 * @param int n, int[][] flights, int src, int dst, int K
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int cheapestFlightsWithinKStopsIII(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        buildGraph(flights, graph);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {    // [dst, stop, price]
        	@Override
        	public int compare(int[] a, int[] b) {
        		return a[2] - b[2]; 
        	}
        });
        minHeap.offer(new int[] {src, K, 0});
        while (!minHeap.isEmpty()) {
        	int[] curr = minHeap.poll();
        	int u = curr[0];
        	int stop = curr[1];
        	int price = curr[2];
        	if (u == dst) return price;
        	if (stop < 0 || !graph.containsKey(u)) continue;
        	for (Integer v: graph.get(u).keySet()) {
        		minHeap.offer(new int[] {v, stop - 1, price + graph.get(u).get(v)});
        	}
        }
        return -1;
	}
	
	
	/**
	 * Approach2: DFS
	 * @param int n, int[][] flights, int src, int dst, int K
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 * Stack space: O(K)
	 */
	public int cheapestFlightsWithinKStopsI(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        buildGraph(flights, graph);
        int[] res = new int[] {Integer.MAX_VALUE};
        dfs(src, dst, K + 1, 0, graph, res);
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
	}
	
	private void dfs(int src, int dst, int K, int price, Map<Integer, Map<Integer, Integer>> graph, int[] res) {
		if (K < 0) return;
		if (src == dst) {
			res[0] = Math.min(price, res[0]);
			return;
		}
		if (price >= res[0] || !graph.containsKey(src)) return; // important, prunning
		for (Integer next: graph.get(src).keySet()) {
			dfs(next, dst, K - 1, price + graph.get(src).get(next), graph, res);
		}
	}
	
	
	/**
	 * Approach1: BFS
	 * @param int n, int[][] flights, int src, int dst, int K
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int cheapestFlightsWithinKStops(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        buildGraph(flights, graph);
        Queue<int[]> queue = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        queue.offer(new int[] {src, 0});   // [node, price]
        while (!queue.isEmpty() && K-- >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int u = curr[0];
                int price = curr[1];
                if (!graph.containsKey(u)) continue;
                for (Integer v: graph.get(u).keySet()) {
                    int newPrice = graph.get(u).get(v) + price;
                    if (newPrice >= res) continue;   // important, prunning
                    if (v == dst) {
                        res = Math.min(newPrice, res);
                    }
                    else {
                        queue.offer(new int[] {v, newPrice});
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private void buildGraph(int[][] flights, Map<Integer, Map<Integer, Integer>> graph) {
        for (int[] f: flights) {
            if (!graph.containsKey(f[0])) graph.put(f[0], new HashMap<Integer, Integer>());
            graph.get(f[0]).put(f[1], f[2]);
        }        
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheapestFlightsWithinKStops result = new CheapestFlightsWithinKStops();
		System.out.println(result.cheapestFlightsWithinKStops
				(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
		System.out.println(result.cheapestFlightsWithinKStopsI
				(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
		System.out.println(result.cheapestFlightsWithinKStopsIII
				(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
	}

}
