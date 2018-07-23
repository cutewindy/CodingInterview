package google_intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2. In this problem we consider an undirected tree with N nodes, numbered from 1 to N. 
 * Additionally, each node also has a label attached to it and the label is an integer value. Note 
 * that different nodes can have identical labels.. From 1point 3acres bbs
 * Write a function:
 *              int solution (vector<int> &A, vector<int> &B);
 * that, given a zero-indexed array A of length N, where A[J] is the label value of the (J+1)-th 
 * node in the tree, and a zero-indexed array E of length K = (N-1)*2 in which the edges of the tree 
 * are described (for every 0 <= J < N - 2 values E[2 * J] and E[2 * J + 1]), returns the length of 
 * the longest path such that all the nodes on that path have the same label. The length of a path 
 * is defined as the number of edges in that path. 
 * For example, given A = [1,1,1,2,2] and E = [1,2,1,3,2,4,2,5], the described tree appears as follows:
                  【1】1.
                  /      \
            1【2】  【3】1  
              /     \
       2【4】   【5】2
 * and your function should return 2, because the longest path(in which all nodes ahve the same 
 * value of 1) is 2->1->3. The number of edges on this path is 2; thus, that is the answer.
 * Assume that:
 * - 1 <= N <= 1,000
 * - each element of array A is an integer within the range [1...1000,000,000]
 * @author wendi
 *
 */
public class LongestUnivaluePathandBuildTree {

	/**
	 * Graph
	 * dfs, like leetcode: "687. LongestUnivaluePath"
	 * @param int[] A, int[] E
	 * @return int
	 * Time: O(e+v)
	 * Space: O(e+v)
	 */
	private int res;
	public int longestUnivaluePathandBuildTree(int[] A, int[] E) {
		if (A == null || A.length == 0) return 0;
		// build graph
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < E.length; i += 2) {
			if (!graph.containsKey(E[i])) graph.put(E[i], new ArrayList<Integer>());
			graph.get(E[i]).add(E[i + 1]);
		}
		
		// walk graph
		res = 0;
		dfs(A, graph, A[0]);
		
		return res;
	}
	
	private int dfs(int[] A, Map<Integer, List<Integer>> graph, int u) {
		if (!graph.containsKey(u)) return 0;
		int currRes = 0;
		int singlePass = 0;
		for (int v: graph.get(u)) {
			int curr = dfs(A, graph, v);
			if (A[u - 1] == A[v - 1]) {
				currRes += curr + 1;
				singlePass = Math.max(curr + 1, singlePass);
			}
		}
		res = Math.max(currRes, res);
		return singlePass;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestUnivaluePathandBuildTree result = new LongestUnivaluePathandBuildTree();
		System.out.println(result.longestUnivaluePathandBuildTree(new int[] {1,2,1,1,1,3}, new int[] {1,2,1,3,2,4,3,5,3,6}));
	}

}
