import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D 
 * elevation map, compute the volume of water it is able to trap after raining.
 * Note:
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 
 * 20,000.
 * Example:
 * Given the following 3x6 height map:
		[
		  [1,4,3,1,3,2],
		  [3,2,1,3,2,4],
		  [2,3,3,2,3,1]
		]
 * Return 4.
 * The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before 
 * the rain.
 * After the rain, water are trapped between the blocks. The total volume of water trapped is 4.
 * 
 * Tags: BFS, heap
 * @author wendi
 *
 */
public class TrappingRainWaterII {
	class Node {
		int x;
		int y;
		int h;
		public Node(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	
	/**
	 * Heap: from the borders, pick the shortest cell visited and check its neighbors:
     * If the neighbor is shorter, collect the water it can trap and update its height as its height 
     * plus the water trapped.
     * Add all its neighbors to the queue.
	 * @param int[][] heightMap
	 * @return int
	 * Time: O(m * n + 2log(k)) k is number of node in heap
	 * Space: O(m * n + k)
	 */
	public int trappingRainWaterII(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
		
		int m = heightMap.length;
		int n = heightMap[0].length;
		int result = 0;
		Queue<Node> heap = new PriorityQueue<>(10, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				return a.h - b.h;
			}
		});
		boolean[][] visited = new boolean[m][n];
		
		// init, add all the Nodes which are on borders to the queue.
		for (int j = 0; j < n; j++) {   
			heap.add(new Node(0, j, heightMap[0][j])); // top
			visited[0][j] = true;
			heap.add(new Node(m - 1, j, heightMap[m - 1][j])); // bottom
			visited[m - 1][j] = true;
		}
		for (int i = 1; i < m - 1; i++) {  
			heap.add(new Node(i, 0, heightMap[i][0]));  // left
			visited[i][0] = true;
			heap.add(new Node(i, n - 1, heightMap[i][n - 1]));  // right
			visited[i][n - 1] = true;
		}
		
		// update heap and result
		int[][] dire = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		while (!heap.isEmpty()) {
			Node curr = heap.poll();
			for (int i = 0; i < dire.length; i++) {
				int row = curr.x + dire[i][0];
				int col = curr.y + dire[i][1];
				if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) continue;   // check whether out of bound or is visited				
				if (heightMap[row][col] < curr.h) {
					result += curr.h - heightMap[row][col];
					heightMap[row][col] = curr.h;
				}
				heap.add(new Node(row, col, heightMap[row][col]));
				visited[row][col] = true;
			}
		}
		return result;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWaterII result = new TrappingRainWaterII();
		System.out.println(result.trappingRainWaterII(new int[][] {{6, 4, 4, 3, 6},{5, 1, 2, 2, 1},{6, 5, 1, 5, 6},{6, 6, 5, 6, 6}}));
		System.out.println(result.trappingRainWaterII(new int[][] {{1,4,3,1,3,2} ,{3,2,1,3,2,4} ,{2,3,3,2,3,1}}));
	}

}
