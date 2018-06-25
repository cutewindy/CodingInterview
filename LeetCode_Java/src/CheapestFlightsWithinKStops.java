import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	 * 
	 * @param int n, int[][] flights, int src, int dst, int K
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int cheapestFlightsWithinKStops(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        Integer[] costs = new Integer[n];
        costs[src] = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] f: flights) {
            if (!map.containsKey(f[0])) map.put(f[0], new ArrayList<int[]>());
            map.get(f[0]).add(f);
        }
        Queue<Integer> queue = new LinkedList<>();
        if (!map.containsKey(src)) return -1;
        queue.offer(src);
        while (!queue.isEmpty() && K-- >= 0) {
            int size = queue.size();
            Integer[] temp = new Integer[n];
            for (int i = 0; i < n; i++) temp[i] = costs[i];
            while (size-- > 0) {
                int u = queue.poll();
                if (!map.containsKey(u)) continue;
                for (int[] v: map.get(u)) {
                    if (temp[v[1]] == null || temp[v[1]] > costs[u] + v[2]) {
                        temp[v[1]] = costs[u] + v[2];
                        queue.offer(v[1]);
                    }
                }
            }
            costs = temp;
        }
        return costs[dst] == null ? -1 : costs[dst];        
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheapestFlightsWithinKStops result = new CheapestFlightsWithinKStops();
		System.out.println(result.cheapestFlightsWithinKStops
				(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
	}

}
