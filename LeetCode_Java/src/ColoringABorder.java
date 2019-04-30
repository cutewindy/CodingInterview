import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid 
 * square at that location.
 * Two squares belong to the same connected component if and only if they have the same color and 
 * are next to each other in any of the 4 directions.
 * The border of a connected component is all the squares in the connected component that are either 
 * 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the 
 * first or last row or column).
 * Given a square at location (r0, c0) in the grid and a color, color the border of the connected 
 * component of that square with the given color, and return the final grid.
 * Example 1:
 * Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * Output: [[3, 3], [3, 2]]
 * Example 2:
 * Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * Output: [[1, 3, 3], [2, 3, 3]]
 * Example 3:
 * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 * Note:
 * 1. 1 <= grid.length <= 50
 * 2. 1 <= grid[0].length <= 50
 * 3. 1 <= grid[i][j] <= 1000
 * 4. 0 <= r0 < grid.length
 * 5. 0 <= c0 < grid[0].length
 * 6. 1 <= color <= 1000
 * @author wendi
 *
 */
public class ColoringABorder {

	
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    /**
     * BFS
     * @param int[][] grid, int r0, int c0, int color
     * @return int[][]
     * Time: O(m*n)
     * Space: O(m*n)
     */
    public int[][] coloringABorder(int[][] grid, int r0, int c0, int color) {
        Queue<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] colored = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        int origColor = grid[r0][c0];
        queue.offer(r0 * n + c0);
        visited[r0][c0] = true;
        colored[r0][c0] = true;
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int k = 0; k < 4; k++) {
                int i = dir[k][0] + pos / n;
                int j = dir[k][1] + pos % n;
                if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != origColor || visited[i][j]) continue;
                queue.offer(i * n + j);
                colored[i][j] = true;
                visited[i][j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (colored[i][j] && isBorder(colored, i, j)) grid[i][j] = color;
            }
        }
        
        return grid;
    }
    
    private boolean isBorder(boolean[][] colored, int i, int j) {
        if (i == 0 || i == colored.length - 1 || j == 0 || j == colored[0].length - 1) return true;
        for (int k = 0; k < 4; k++) {
            if (!colored[i + dir[k][0]][j + dir[k][1]]) return true;
        }
        return false;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColoringABorder result = new ColoringABorder();
		System.out.println(Arrays.deepToString(result.coloringABorder(new int[][] 
				{{1,1,1},{1,1,1},{1,1,1}}, 1, 1, 2)));
	}

}
