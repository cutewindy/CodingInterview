import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by 
 * rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball 
 * stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze, find the shortest distance for the 
 * ball to stop at the destination. The distance is defined by the number of empty spaces traveled 
 * by the ball from the start position (excluded) to the destination (included). If the ball cannot 
 * stop at the destination, return -1.
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You 
 * may assume that the borders of the maze are all walls. The start and destination coordinates are 
 * represented by row and column indexes.
 * Example 1
 * Input 1: a maze represented by a 2D array
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * Output: 12
 * Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 *              The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 * Example 2
 * Input 1: a maze represented by a 2D array
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * Output: -1
 * Explanation: There is no way for the ball to stop at the destination.
 * Note:
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the same 
 * position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures), but you 
 * could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 
 * 100.
 * @author wendi
 *
 */
public class TheMazeII {

	/**
	 * BFS
	 * Use distances[i][j] to store the shortest distance from start to maze[i][j].
	 * @param int[][] maze, int[] start, int[] destination
	 * @return int
	 * Time: O(m*n*max(m,n)) Complete traversal of maze will be done in the worst case. 
	 *       For every current node chosen, we can travel up to a maximum depth of max(m,n) in any 
	 *       direction.
	 * Space: O(m*n)
	 */
	public int theMazeII(int[][] maze, int[] start, int[] destination) {
		int m = maze.length;
		int n = maze[0].length;
		int[][] distances = new int[m][n];
		for (int[] d: distances) Arrays.fill(d, Integer.MAX_VALUE);
		distances[start[0]][start[1]] = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int k = 0; k < 4; k++) {
				int i = curr[0];
				int j = curr[1];
				int count = 0;
				while (i + dx[k] >= 0 && i + dx[k] < m && j + dy[k] >= 0 && j + dy[k] < n && 
						maze[i + dx[k]][j + dy[k]] == 0) {
					i += dx[k];
					j += dy[k];
					count++;
				}
				if (distances[i][j] > distances[curr[0]][curr[1]] + count) {
					distances[i][j] = distances[curr[0]][curr[1]] + count;
					queue.offer(new int[] {i, j});
				}
			}
		}
		return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? 
				-1 : distances[destination[0]][destination[1]];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheMazeII result = new TheMazeII();
		System.out.println(result.theMazeII(new int[][] {{0, 0, 1, 0, 0},
														 {0, 0, 0, 0, 0},
												    	 {0, 0, 0, 1, 0},
													     {1, 1, 0, 1, 1},
														 {0, 0, 0, 0, 0}}, 
											new int[] {0, 4}, new int[] {4, 4}));
	}

}
