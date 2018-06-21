import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you 
 * may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, 
 * it should be filled with INF.
 * Example: 
 * Given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
	  3  -1   0   1
	  2   2   1  -1
	  1  -1   2  -1
	  0  -1   3   4
 * @author wendi
 *
 */
public class WallsandGates {
	
	
	/**
	 * BFS
	 * Push all gates into queue first. Then for each gate update its neighbor cells and push them 
	 * to the queue.
	 * Repeating above steps until there is nothing left in the queue.
	 * @param int[][] rooms
	 * Time: O(m*n)
	 * Space: O(1)
	 */
	public void wallsandGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
		
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) queue.offer(new int[] {i, j});
			}
		}

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				for (int k = 0; k < 4; k++) {
					int i = curr[0] + dx[k];
					int j = curr[1] + dy[k];
					if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length ||
						rooms[i][j] <= rooms[curr[0]][curr[1]] + 1) continue;
					rooms[i][j] = rooms[curr[0]][curr[1]] + 1;
					queue.offer(new int[] {i, j});
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WallsandGates result = new WallsandGates();
		int INF = Integer.MAX_VALUE;
		int[][] rooms = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == 0 && j ==1 || i == 2 && j == 3 || i == 2 && j == 1 || i == 1 && j == 3 || i == 3 && j == 1) {
					rooms[i][j] = -1;
				}
				else if (i == 0 && j == 2 || i == 3 && j == 0) rooms[i][j] = 0;
				else rooms[i][j] = INF;
			}
		}
		for (int[] r: rooms) System.out.println(Arrays.toString(r));
		result.wallsandGates(rooms);
		System.out.println("-------------------");
		for (int[] r: rooms) System.out.println(Arrays.toString(r));
	}

}
