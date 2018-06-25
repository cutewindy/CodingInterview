import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a 
 * non-negative 2D map, in this map:
 * 1. 0 represents the obstacle can't be reached.
 * 2. 1 represents the ground can be walked through.
 * 3. The place with number bigger than 1 represents a tree can be walked through, and this positive 
 * number represents the tree's height.
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut 
 * off the tree with lowest height first. And after cutting, the original place has the tree will 
 * become a grass (value 1).
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to 
 * cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to 
 * be cut off.
 * Example 1:
 * Input: 
 * [
 *  [1,2,3],
 *  [0,0,4],
 *  [7,6,5]
 * ]
 * Output: 6
 * Example 2:
 * Input: 
 * [
 *  [1,2,3],
 *  [0,0,0],
 *  [7,6,5]
 * ]
 * Output: -1
 * Example 3:
 * Input: 
 * [
 *  [2,3,4],
 *  [0,0,5],
 *  [8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly 
 * without walking.
 * Hint: size of the given matrix will not exceed 50x50.
 * @author wendi
 *
 */
public class CutOffTreesforGolfEvent {
	
	
	/**
	 * PriorityQueue + BFS
	 * 1. Since we have to cut trees in order of their height, we first put trees 
	 * (int[] {row, col, height}) into a priority queue and sort by height.
	 * 2. Poll each tree from the queue and use BFS to find out steps needed form start point to end 
	 * point.
	 * @param List<List<Integer>> forest
	 * @return int
	 * Time: O((m*n)^2)
	 * Space: O(m*n)
	 */
	public int cutOffTreesforGolfEvent(List<List<Integer>> forest) {
		if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) return 0;
		int m = forest.size();
		int n = forest.get(0).size();
		
		// 1. sort height of tree using heap 
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(m*n, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (forest.get(i).get(j) == 0 || forest.get(i).get(j) == 1) continue;
				minHeap.offer(new int[] {i, j, forest.get(i).get(j)});
			}
		}
		
		// 2. find step of each tree
		int res = 0;
		int[] start = new int[] {0, 0};
		while (!minHeap.isEmpty()) {
			int[] curr = minHeap.poll();
			int[] end = new int[] {curr[0], curr[1]};
			int step = minStep(forest, start, end);
			if (step == -1) return -1;
			res += step;
			start = end;
		}
		
 		return res;
	}
	
	
	public int minStep(List<List<Integer>> forest, int[] start, int[] end) {
		int m = forest.size();
		int n = forest.get(0).size();
		int step = 0;
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				if (curr[0] == end[0] && curr[1] == end[1]) return step;
				for (int k = 0; k < 4; k++) {
					int i = curr[0] + dx[k];
					int j = curr[1] + dy[k];
					if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || forest.get(i).get(j) == 0) {
						continue;
					}
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
			step++;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CutOffTreesforGolfEvent result = new CutOffTreesforGolfEvent();
		List<List<Integer>> forest = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>(Arrays.asList(2, 3, 4));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(0, 0, 5));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(8, 7 ,6));
		forest.add(l1);
		forest.add(l2);
		forest.add(l3);
		System.out.println(result.cutOffTreesforGolfEvent(forest));
	}	

}
