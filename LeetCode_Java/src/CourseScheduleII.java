import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses 
 * you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to 
 * finish all courses, return an empty array.
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So 
 * the correct course order is [0,1]
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 
 * and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course 
 * order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read 
 * more about how a graph is represented.
 * 
 * Tags: DFS, BFS, Graph, Topological Sort
 * @author wendi
 *
 */
public class CourseScheduleII {

	/**
	 * BFS:  if a node has incoming edges, it has prerequisites. Therefore, the first few in the 
	 * order must be those with no prerequisites, i.e. no incoming edges. Any non-empty DAG must 
	 * have at least one node without incoming links. If we visit these few and remove all edges 
	 * attached to them, we are left with a smaller DAG, which is the same problem. This will then 
	 * give our BFS solution.
	 * @param int numCourse, int[][] prerequisites
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] courseScheduleII(int numCourses, int[][]prerequisites) {
		int[] result = new int[numCourses];
		if (numCourses == 0) return result;
		// build graph and inDegree
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		int[] inDegree = new int[numCourses];
		for (int[] pre: prerequisites) {
			int u = pre[1];
			int v = pre[0];
			if (!graph.containsKey(u)) graph.put(u, new HashSet<Integer>());
			graph.get(u).add(v);
			inDegree[v]++;
		}
		// init: find the course, which inDegree[i]=0, offer it into queue
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) queue.offer(i);
		}
		// put course which inDegree is 0 into result, and update inDegree by graph
		int index = 0; 
		while (!queue.isEmpty()) {
			int u = queue.poll();
			result[index++] = u; 
			if (!graph.containsKey(u)) continue;
			for (int v: graph.get(u)) {
				if (--inDegree[v] == 0) queue.offer(v);
			}
		}
		return index == numCourses ? result : new int[0]; // be care about empty result
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseScheduleII result = new CourseScheduleII();
		System.out.println(Arrays.toString(result.courseScheduleII(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
	}

}
