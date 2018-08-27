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
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. 
 * The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction 
 * means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence 
 * so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence 
 * that can be reconstructed from seqs and it is the org sequence.
 * Example 1:
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 * Output:
 * false
 * Explanation:
 * [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid 
 * sequence that can be reconstructed.
 * Example 2:
 * Input:
 * org: [1,2,3], seqs: [[1,2]]
 * Output:
 * false
 * Explanation:
 * The reconstructed sequence can only be [1,2].
 * Example 3:
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * Output:
 * true
 * Explanation:
 * The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 * Example 4:
 * Input:
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * Output:
 * true
 * @author wendi
 *
 */
public class SequenceReconstruction {
	
	
	/**
	 * Topology sort + BFS
	 * @param int[] org, List<List<Integer>> seqs
	 * Time: O(n)
	 * Space: O(n)
	 */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    	if (seqs == null && org == null) return true;
    	if (seqs == null || org == null) return false;
    	
    	// build graph
    	Map<Integer, Integer> indegree = new HashMap<>();
    	Map<Integer, Set<Integer>> graph = new HashMap<>();
    	for (List<Integer> seq: seqs) {
    		if (seq.size() == 0) continue;
    		indegree.putIfAbsent(seq.get(0), 0);
    		for (int i = 1; i < seq.size(); i++) {
    			int u = seq.get(i - 1);
    			int v = seq.get(i);
    			indegree.putIfAbsent(v, 0);
    			if (!graph.containsKey(u)) graph.put(u, new HashSet<Integer>());
    			if (!graph.get(u).contains(v)) {
    				graph.get(u).add(v);
    				indegree.put(v, indegree.get(v) + 1);
    			}
    		}
    	}
    	
    	// find root, which indegree is 0
    	Queue<Integer> queue = new LinkedList<>();
    	for (Integer u: indegree.keySet()) {
    		if (indegree.get(u) == 0) queue.offer(u);
    	}
    	
    	// walk graph
    	int index = 0;
    	while (!queue.isEmpty()) {
    		if (queue.size() > 1) return false;  // at the same level have more than one path, return false
    		int u = queue.poll();
    		if (index >= org.length || org[index++] != u) return false; // not the same path, return false
    		if (!graph.containsKey(u)) continue;
    		for (Integer v: graph.get(u)) {
    			indegree.put(v, indegree.get(v) - 1);
    			if (indegree.get(v) == 0) queue.offer(v);
    		}
    	}
    	
        return index == indegree.size() && index == org.length; // check org is the same as path, no less no more
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceReconstruction result = new SequenceReconstruction();
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3));
		List<Integer> list3 = new ArrayList<>(Arrays.asList(2, 3));
		System.out.println(result.sequenceReconstruction(new int[] {1,2,3}, new ArrayList<>(Arrays.asList(list1, list2))));
		System.out.println(result.sequenceReconstruction(new int[] {1,2,3}, new ArrayList<>(Arrays.asList(list1))));
		System.out.println(result.sequenceReconstruction(new int[] {1,2,3}, new ArrayList<>(Arrays.asList(list1, list2, list3))));
	}

}
