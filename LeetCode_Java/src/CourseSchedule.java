import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a
 *  pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to 
 * finish all courses?
 * For example:  2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So 
 * it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and 
 * to take course 0 you should also 
 * have finished course 1. So it is impossible.
 * Note:
 * 1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read 
 * more about how a graph is 
 * represented.
 * 2.You may assume that there are no duplicate edges in the input prerequisites.
 * 
 * Tags: DFS, BFS, Graph, Topological Sort
 * @author wendi
 *
 */
public class CourseSchedule {

	/**
	 * Method2: DFS:
	 * @param int numCourses, int[][] prerequisites
	 * @return boolean
	 * Time: O()
	 * Space: O()
	 */
	private Map<Integer, List<Integer>> graph = new HashMap<>();
	private boolean[] visited = null;
	
	public boolean courseScheduleI(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0) {
			return true;
		}
		graph = makeGraph(prerequisites);
		visited = new boolean[numCourses];
		boolean[] visiting = new boolean[numCourses];
		return true;
	}
	
	private boolean hasCycle(int node, boolean[] visiting) {
		if (!graph.containsKey(node)) {
			return false;
		}
		visiting[node] = true;
//		for (int nextNode: graph.get(node)) {
//			if (!visited[nextNode] && ) {
//		}		
		return false;
	}
	
	private Map<Integer, List<Integer>> makeGraph(int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] prerequisite: prerequisites) {
			int key = prerequisite[1];
			int value = prerequisite[0];
			if (graph.containsKey(key)) {
				List<Integer> list = graph.get(key);
				list.add(value);
				graph.put(key, list);
			}
			else {
				List<Integer> list = new ArrayList<>();
				list.add(value);
				graph.put(key, list);
			}
		}
//		for (Entry entry: graph.entrySet()) {
//			System.out.println("key: " + entry.getKey() + ", Value: " + entry.getValue());
//		}
		return graph;
	}
	
	
	/**
	 * Method1: topological(BFS): use indegree of each node.Indegree means before you take this course, 
	 * you should take precourse.
	 * Use graph loop to find 0 indegree course, means can take this course without any precourses
	 * (or precourses has already been token). Then use this course as precourse, to update other 
	 * courses' indegree. 
	 * If the count of all 0 indegree courses is equal to numCourses, return true, 
	 * otherwise return false.
	 * @param int numCourses, int[][] prerequisites
	 * @return boolean
	 * Time: O(n^2) n is the count of courses(can use a hash to build graph, then T=O(n), S=O(n)).
	 * Space: O(n)
	 */
	public boolean courseSchedule(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0) {
			return true;
		}
		int[] inDegree = new int[numCourses];
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		// build graph and inDegree
		for (int[] p: prerequisites) {
			int u = p[1];
			int v = p[0];
			inDegree[v]++;
			if (!graph.containsKey(u)) graph.put(u, new HashSet<Integer>());
			graph.get(u).add(v);
		}
		Queue<Integer> queue= new LinkedList<>();
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) queue.offer(i);
		}
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			int u = queue.poll();
			if (!graph.containsKey(u)) continue;
			for (Integer v: graph.get(u)) {
				inDegree[v]--;
				if (inDegree[v] == 0) queue.offer(v);
			}
		}
		return count == numCourses;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule result = new CourseSchedule();
//		System.out.println(result.courseSchedule(6, new int[][] {{4, 5}, {4, 0}, {1, 4}, {2, 1}, {2, 4}, {3, 2}}));
		System.out.println(result.courseScheduleI(6, new int[][] {{4, 5}, {4, 0}, {1, 4}, {2, 1}, {2, 4}, {3, 2}}));
	}

}
