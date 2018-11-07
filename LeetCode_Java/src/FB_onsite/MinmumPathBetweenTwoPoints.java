package FB_onsite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * "无限大棋盘 给两个格子 一些格子上有障碍物不能走 问两格子的最短路
 * 
 * 第一题考的应该是无解的判断，需要双向BFS, 一边能走的全走完就返回无解
 * 层主正解 不过当时面试官只让我写了单向bfs 然后follow up问了问双向的
 * 
 * 想请问一下楼主，如果只能用单向bfs来解，该如何判断什么时候无解。十分感谢！
 * 棋盘无限大，貌似只能双向
 * @author wendi
 *
 */
public class MinmumPathBetweenTwoPoints {
	
	/**
	 * Bidirectional BFS
	 * @param int[][] grid, int row1, int col1, int row2, int col2
	 * @return int
	 * Time: O(4^d)
	 * Space: O(m*n)
	 */
	public int minmumPathBetweenTwoPoints(int[][] grid, int row1, int col1, int row2, int col2) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		boolean[][] visited1 = new boolean[m][n];
		boolean[][] visited2 = new boolean[m][n];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		// init
		queue1.offer(row1 * n + col1);
		queue2.offer(row2 * n + col2);
		visited1[row1][col1] = true;
		visited2[row2][col2] = true;
		int distance = 0;
		// update
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			distance++;
			if (!queue1.isEmpty()) {
				int size = queue1.size();
				while (size-- > 0) {
					int curr = queue1.poll();
					for (int k = 0; k < 4; k++) {
						int i = dx[k] + curr / n;
						int j = dy[k] + curr % n;
						if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1 || visited1[i][j]) continue;
						visited1[i][j] = true;
						grid[i][j] += distance;
						if (visited2[i][j]) return grid[i][j];
						queue1.offer(i * n + j);
					}
				}
			}
			if (!queue2.isEmpty()) {
				int size = queue2.size();
				while (size-- > 0) {
					int curr = queue2.poll();
					for (int k = 0; k < 4; k++) {
						int i = dx[k] + curr / n;
						int j = dy[k] + curr % n;
						if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1 || visited2[i][j]) continue;
						visited2[i][j] = true;
						grid[i][j] += distance;
						if (visited1[i][j]) {
							System.out.println("ddd");
							return grid[i][j];
						}
						queue2.offer(i * n + j);
					}
				}
			}
		}
		
		return -1;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinmumPathBetweenTwoPoints result = new MinmumPathBetweenTwoPoints();
		int[][] grid = new int[][] {{-2, 0, 0, 0, -1}, {0, -1, 0, 0, 0}, {0, -1, -1, 0, 0}, {0, 0, -2, 0, -1}};
		for (int[] g: grid) {
			System.out.println(Arrays.toString(g));
		}
		System.out.println(result.minmumPathBetweenTwoPoints(grid, 0, 0, 3, 2));
		for (int[] g: grid) {
			System.out.println(Arrays.toString(g));
		}
	}

}
