package quora;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceonofKing_KnightonBoard {

	
	/**
	 * Manhattan distance
	 * @param int m, int n, int[] start, int[] end
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int shortestDistanceonofKingonBoard(int m, int n, int[] start, int[] end) {
		return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
	}
	
	
	/**
	 * bfs -> double bfs
	 * @param int m, int n, int[] start, int[] end
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public int shortestDistanceonofKnightonBoard(int m, int n, int[] start, int[] end) {
		int[][] d = new int[][] {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 2}, {2, -1}, {-1, -2}};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		int res = -1;
		boolean[][] visited = new boolean[m][n];
		visited[start[0]][start[1]] = true;
		while (!queue.isEmpty()) {
			res++;
			int size = queue.size();
			while (size-- > 0) {
				int[] curr = queue.poll();
				if (curr[0] == end[0] && curr[1] == end[1]) return res;
				for (int k = 0; k < 8; k++) {
					int i = curr[0] + d[k][0];
					int j = curr[1] + d[k][1];
					if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) continue;
					queue.offer(new int[] {i, j});
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestDistanceonofKing_KnightonBoard result = new ShortestDistanceonofKing_KnightonBoard();
		System.out.println(result.shortestDistanceonofKingonBoard(4, 5, new int[] {3, 1}, new int[] {0, 3}));  // 5
		System.out.println(result.shortestDistanceonofKnightonBoard(4, 5, new int[] {3, 1}, new int[] {0, 3})); // 3
		System.out.println(result.shortestDistanceonofKnightonBoard(4, 5, new int[] {3, 1}, new int[] {0, 2})); // 2
	}

}
