import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, 
 * and k is a real number (floating point number). Given some queries, return the answers. If the 
 * answer does not exist, return -1.0.
 * Example:
 * Given a / b = 2.0, b / c = 3.0. 
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, 
 * string>> queries , where equations.size() == values.size(), and the values are positive. This 
 * represents the equations. Return vector<double>.
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 * The input is always valid. You may assume that evaluating the queries will result in no division 
 * by zero and there is no contradiction.
 * @author wendi
 *
 */
public class EvaluateDivision {
	
	
	/**
	 * Graph + DFS
	 * Image a/b = w as a link between node a and b, the weight from a to b is w, the reverse link 
	 * is 1/w. Query is to find a path between two nodes.
	 * @param String[][] equations, double[] values, String[][] queries
	 * @return double[]
	 * Time: O(n(E+V)) n = queries.length
	 * Space: O(E+V)
	 */
	public double[] evaluateDivision(String[][] equations, double[] values, String[][] queries) {
		// build graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
        	String u = equations[i][0];
        	String v = equations[i][1];
        	double w = values[i];
        	if (!graph.containsKey(u)) graph.put(u, new HashMap<String, Double>());
        	graph.get(u).put(v, w);
        	if (!graph.containsKey(v)) graph.put(v, new HashMap<String, Double>());
        	graph.get(v).put(u, 1 / w);
        }
        
        // walk graph to answer the queries
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	if (!graph.containsKey(queries[i][0]) || !graph.containsKey(queries[i][1])) res[i] = -1.0;
        	else res[i] = dfs(queries[i][0], queries[i][1], graph, new HashSet<String>());
        }
        
        return res;
    }
	
	private double dfs(String u, String dst, Map<String, Map<String, Double>> graph, Set<String> visited) {
		if (u.equals(dst)) return 1.0;
		for (String v: graph.get(u).keySet()) {
			if (visited.contains(v)) continue;
			visited.add(u);
			double w = dfs(v, dst, graph, visited);
			if (w != -1.0) return graph.get(u).get(v) * w;
		}
		return -1.0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvaluateDivision result = new EvaluateDivision();
		System.out.println(Arrays.toString(result.evaluateDivision(
				new String[][] {{"a", "b"}, {"b", "c"}}, 
				new double[] {2.0, 3.0}, 
				new String[][] {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}})));
	}

}
