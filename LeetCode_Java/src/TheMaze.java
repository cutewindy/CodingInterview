import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by 
 * rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball 
 * stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze, determine whether the ball could 
 * stop at the destination.
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
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 * Example 2
 * Input 1: a maze represented by a 2D array
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination.
 * Note:
 * 1. There is only one ball and one destination in the maze.
 * 2. Both the ball and the destination exist on an empty space, and they will not be at the same 
 * position initially.
 * 3. The given maze does not contain border (like the red rectangle in the example pictures), but 
 * you could assume the border of the maze are all walls.
 * 4. The maze contains at least 2 empty spaces, and both the width and height of the maze won't 
 * exceed 100.
 * @author wendi
 *
 */
public class TheMaze {
	
	/**
	 * BFS
	 * @param int[][] maze, int[] start, int[] destination
	 * @return boolean
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public boolean theMaze(int[][] maze, int[] start, int[] destination) {
		int m = maze.length;
		int n = maze[0].length;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[0] == destination[0] && curr[1] == destination[1]) return true;
			for (int k = 0; k < 4; k++) {
				int i = curr[0];
				int j = curr[1];
				while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0) {
					i += dx[k];
					j += dy[k];
				}
				i -= dx[k];
				j -= dy[k];
				if (i == destination[0] && j == destination[1]) return true;
				if (!visited[i][j]) {
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheMaze result = new TheMaze();
		System.out.println(result.theMaze(new int[][] {{0, 0, 1, 0, 0},
													   {0, 0, 0, 0, 0},
													   {0, 0, 0, 1, 0},
													   {1, 1, 0, 1, 1},
													   {0, 0, 0, 0, 0}}, 
								          new int[] {0, 4}, new int[] {4, 4}));
	}

}
