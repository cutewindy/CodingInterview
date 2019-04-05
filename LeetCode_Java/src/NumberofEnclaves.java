import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 * A move consists of walking from one land square 4-directionally to another land square, or off 
 * the boundary of the grid.
 * Return the number of land squares in the grid for which we cannot walk off the boundary of the 
 * grid in any number of moves.
 * Example 1:
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: 
 * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the 
 * boundary.
 * Example 2:
 * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: 
 * All 1s are either on the boundary or can reach the boundary.
 * Note:
 * 1. 1 <= A.length <= 500
 * 2. 1 <= A[i].length <= 500
 * 3. 0 <= A[i][j] <= 1
 * 4. All rows have the same size.
 * @author wendi
 *
 */
public class NumberofEnclaves {
	
	/**
	 * Approach1: BFS
	 * @param int[][] A
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public int numberofEnclaves(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int m = A.length;
        int n = A[0].length;
        
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 1 && !visited[i][0]) bfs(A, i, 0, visited);
            if (A[i][n - 1] == 1 && !visited[i][n - 1]) bfs(A, i, n - 1, visited);
        }
        for (int j = 0; j < n; j++) {
            if (A[0][j] == 1 && !visited[0][j]) bfs(A, 0, j, visited);
            if (A[m - 1][j] == 1 && !visited[m - 1][j]) bfs(A, m - 1, j, visited);
        }
        
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (A[i][j] == 1) res++;
            }
        }
        
        return res;
	}
	
	private void bfs(int[][] A, int x, int y, boolean[][] visited) {
		Queue<Integer> queue = new LinkedList<>();
		int m = A.length;
		int n = A[0].length;
		queue.offer(x * n + y);
		visited[x][y] = true;
		int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		while (!queue.isEmpty()) {
            int pos = queue.poll();
            A[pos / n][pos % n] = 0;
            for (int k = 0; k < 4; k++) {
                int i = pos / n + dir[k][0];
                int j = pos % n + dir[k][1];
                if (i <= 0 || i >= m - 1 || j <= 0 || j >= n - 1 || A[i][j] == 0 || visited[i][j]) continue;
                queue.offer(i * n + j);
                visited[i][j] = true;
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofEnclaves result = new NumberofEnclaves();
		System.out.println(result.numberofEnclaves(new int[][] {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
	}

}
