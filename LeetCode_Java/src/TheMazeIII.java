import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by 
 * rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. 
 * When the ball stops, it could choose the next direction. There is also a hole in this maze. The 
 * ball will drop into the hole if it rolls on to the hole.
 * Given the ball position, the hole position and the maze, find out how the ball could drop into 
 * the hole by moving the shortest distance. The distance is defined by the number of empty spaces 
 * traveled by the ball from the start position (excluded) to the hole (included). Output the moving 
 * directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, 
 * you should output the lexicographically smallest way. If the ball cannot reach the hole, output 
 * "impossible".
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You 
 * may assume that the borders of the maze are all walls. The ball and the hole coordinates are 
 * represented by row and column indexes.
 * Example 1
 * Input 1: a maze represented by a 2D array
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 * Input 3: hole coordinate (rowHole, colHole) = (0, 1)
 * Output: "lul"
 * Explanation: There are two shortest ways for the ball to drop into the hole.
 * The first way is left -> up -> left, represented by "lul".
 * The second way is up -> left, represented by 'ul'.
 * Both ways have shortest distance 6, but the first way is lexicographically smaller because 
 * 'l' < 'u'. So the output is "lul".
 * Example 2
 * Input 1: a maze represented by a 2D array
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 * Input 3: hole coordinate (rowHole, colHole) = (3, 0)
 * Output: "impossible"
 * Explanation: The ball cannot reach the hole.
 * Note:
 * 1. There is only one ball and one hole in the maze.
 * 2. Both the ball and hole exist on an empty space, and they will not be at the same position 
 * initially.
 * 3. The given maze does not contain border (like the red rectangle in the example pictures), but 
 * you could assume the border of the maze are all walls.
 * 4. The maze contains at least 2 empty spaces, and the width and the height of the maze won't 
 * exceed 30.
 * @author wendi
 *
 */
public class TheMazeIII {
	
	/**
	 * BFS
	 * Similar to The Maze II, we just need to build a Node class, implement compareTo of Node, and 
	 * record the route of every node.
	 * 
	 * Can be improved by using PriorityQueue like "TheMazeII"
	 * 
	 * @param int[][] maze, int[] ball, int[] hole
	 * @return String
	 * Time: O(m*n*max(m*n))
	 * Space: O(m*n)
	 */
	public String theMazeIII(int[][] maze, int[] ball, int[] hole) {
		// init
		int m = maze.length;
		int n = maze[0].length;
		Node[][] nodes = new Node[m][n];
		Queue<Node> queue = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		String[] ds = {"u", "r", "d", "l"};
		
		// add start node
		Node start = new Node(ball[0], ball[1], 0, "");
		queue.offer(start);
		nodes[ball[0]][ball[1]] = start;
		
		// update nodes
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			for (int k = 0; k < 4; k++) {
				int i = curr.x;
				int j = curr.y;
				int count = 0;
				while (i + dx[k] >= 0 && i + dx[k] < m && j + dy[k] >= 0 && j + dy[k] < n &&
					   maze[i + dx[k]][j + dy[k]] == 0 && 
					   (i + dx[k] != hole[0] || j + dy[k] != hole[1])) { // stop until hit the wall or hole 
					i += dx[k];
					j += dy[k];
					count++;
				}
				if (i + dx[k] == hole[0] && j + dy[k] == hole[1]) {  // check the hole
					i += dx[k];
					j += dy[k];
					count++;
				}
				Node newNode = new Node(i, j, curr.d + count, curr.s + ds[k]);
				if (nodes[i][j] == null || nodes[i][j].compareTo(newNode) > 0) { // if we find a route shorter
					nodes[i][j] = newNode;
					queue.offer(newNode);
				}
			}
		}
		return nodes[hole[0]][hole[1]] == null ? "impossible" : nodes[hole[0]][hole[1]].s;
	}
	
	
	class Node {
		int x, y;
		int d;
		String s;
		public Node(int x, int y, int d, String s) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
		}
		
		public int compareTo(Node that) {
			if (this.d != that.d) return this.d - that.d;
			return this.s.compareTo(that.s);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheMazeIII result = new TheMazeIII();
		System.out.println(result.theMazeIII(new int[][] {{0, 0, 0, 0, 0},
													      {1, 1, 0, 0, 1},
													      {0, 0, 0, 0, 0},
													      {0, 1, 0, 0, 1},
													      {0, 1, 0, 0, 0}}, 
				   							new int[] {4, 3}, new int[] {0, 1}));		
	}

}


