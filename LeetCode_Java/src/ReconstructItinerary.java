import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus
 * , the itinerary must begin with JFK.
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest 
 * lexical order when read as 
 * a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than 
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in 
 * lexical order.
 * 
 * Tags: DFS, Graph
 * @author wendi
 *
 */
public class ReconstructItinerary {

	/**
	 * 
	 * @param String[][] tickets
	 * @return List<String>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<String> reconstructItinerary(String[][] tickets) {
		List<String> result = new ArrayList<>();
		if (tickets == null || tickets.length == 0) {
			return result;
		}
		// generate graph
		Map<String, PriorityQueue<String>> graph = new HashMap<>();
		for (String[] ticket: tickets) {
			String key = ticket[0];
			String value = ticket[1];
			if (graph.containsKey(key)) {
				PriorityQueue<String> queue = graph.get(key);
				queue.offer(value);
				graph.put(key, queue);
			}
			else {
				PriorityQueue<String> queue = new PriorityQueue<>();
				queue.offer(value);
				graph.put(key, queue);
			}
		}
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		// find the path
		while (!stack.isEmpty()) {
			String curr = stack.peek();
			if (!graph.containsKey(curr) || graph.get(curr).isEmpty()) {
				result.add(0, stack.pop());
			}
			else {
				stack.push(graph.get(curr).remove());
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReconstructItinerary result = new ReconstructItinerary();
		String[][] tickets = {{"JFK","A"}, {"A","C"}, {"A","E"}, {"C","B"}, {"E","D"}, {"D", "A"}};
		System.out.println(result.reconstructItinerary(tickets));
	}

}
