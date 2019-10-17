import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are N network nodes, labeled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source 
 * node, v is the target node, and w is the time it takes for a signal to travel from source to 
 * target.
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the 
 * signal? If it is impossible, return -1.
 * Note:
 * 1. N will be in the range [1, 100].
 * 2. K will be in the range [1, N].
 * 3. The length of times will be in the range [1, 6000].
 * 4. All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 * @author wendi
 *
 */
public class NetworkDelayTime {
	
	/**
	 * Method2: Djikstra's (PriorityQueue optimized) 
	 * The idea is to find the smallest time to reach every other node from given node K
	 * Then, to check if all nodes can be reached and if it can be reached then return the time 
	 * taken to reach the farthest node (node which take longest to get the signal).
	 * As the signal traverses concurrently to all nodes, we have to find the maximum time it takes 
	 * to reach a node among all nodes from given node K.
	 * If any single node takes null time, then return -1, as not all nodes can be reached
	 * @param int[][] times, int N, int K
	 * @return int
	 * Time: O(e+v) nlog(n)
	 * Space: O(v)
	 */
    public int networkDelayTimeI(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();  // [u, {[v, time from u to v]}]
        buildGraph(times, graph);
        Map<Integer, Integer> delayTimes = new HashMap<>(); // [node, time from k to node]
        walkGraph(graph, delayTimes, K);
        if (delayTimes.size() < N) return -1;
        int res = 0;
        for (Integer time: delayTimes.values()) res = Math.max(res, time);
        return res;
    }
    
    private void buildGraph(int[][] times, Map<Integer, List<int[]>> graph) {
        for (int[] time: times) {
            graph.putIfAbsent(time[0], new ArrayList<int[]>());
            graph.get(time[0]).add(new int[] {time[1], time[2]});
        }
    }
    
    private void walkGraph(Map<Integer, List<int[]>> graph, Map<Integer, Integer> delayTimes, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1])); // [node, time from k to node]
        minHeap.offer(new int[] {K, 0});
        while (!minHeap.isEmpty()) {
            int[] u = minHeap.poll();
            if (delayTimes.containsKey(u[0])) continue;
            delayTimes.put(u[0], u[1]);
            if (!graph.containsKey(u[0])) continue;
            for (int[] v: graph.get(u[0])) {
                if (delayTimes.containsKey(v[0])) continue;
                minHeap.offer(new int[] {v[0], u[1] + v[1]});
            }
            
        }
    }
	
	
	/**
	 * Method1: BFS + DP
	 * The idea is to find the smallest time to reach every other node from given node K
	 * Then, to check if all nodes can be reached and if it can be reached then return the time 
	 * taken to reach the farthest node (node which take longest to get the signal).
	 * As the signal traverses concurrently to all nodes, we have to find the maximum time it takes 
	 * to reach a node among all nodes from given node K.
	 * If any single node takes null time, then return -1, as not all nodes can be reached
	 * @param int[][] times, int N, int K
	 * @return int
	 * Time: O(e+v) n^2
	 * Space: O(v)
	 */
	public int networkDelayTime(int[][] times, int N, int K) {
		Integer[] dist = new Integer[N + 1];
		dist[K] = 0;
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int[] t: times) {
			if (!map.containsKey(t[0])) map.put(t[0], new ArrayList<int[]>());
			map.get(t[0]).add(t);
		}
		
		// update time taken form k to v
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(K);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			if (!map.containsKey(u)) continue;
			for (int[] v: map.get(u)) {
				if (dist[v[1]] == null || dist[v[1]] > v[2] + dist[u]) { // if time taken to v from k is greater than (time taken from k to u) + (time taken from u to v), then update dist[v]
					dist[v[1]] = v[2] + dist[u];
					queue.offer(v[1]);
				}
			}
		}
		
		// find the total time taken to every v
		int res = -1;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == null) return -1;  // if d is null, it means node i can not be reached, return -1
			res = Math.max(dist[i], res);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetworkDelayTime result = new NetworkDelayTime();
		System.out.println(result.networkDelayTime(new int[][] {{2,1,4},{2,3,3},{2,5,7},{3,4,4},{1,4,1},{4,5,1},{5,6,1}}, 6, 2));
//		System.out.println(result.networkDelayTimeI(new int[][] {{2,1,4},{2,3,3},{3,4,4},{1,4,1}}, 4, 2));
	}

}
