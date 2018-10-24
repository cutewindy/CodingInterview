import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are 
 * surrounded by water.
 * Count the number of distinct islands. An island is considered to be the same as another if and 
 * only if one island can be translated (and not rotated or reflected) to equal the other.
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 * @author wendi
 *
 */
public class NumberofDistinctIslands {
	
	/**
	 * Approach2: BFS:
	 * @param int[][] grid
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	
    public int numberofDistinctIslandsI(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> set = new HashSet<>();
         
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 0) continue;
        		grid[i][j] = 0;
        		set.add(bfs(grid, i, j));
        	}
        }
        return set.size();
    }
    
    private String bfs(int[][] grid, int row, int col) {
    	int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        String[] dir = new String[] {"u", "r", "d", "l"};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        StringBuilder sb = new StringBuilder("s");
        while (!queue.isEmpty()) {
        	int[] curr = queue.poll();
        	for (int k = 0; k < 4; k++) {
        		int i = curr[0] + dx[k];
        		int j = curr[1] + dy[k];
        		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) continue;
        		grid[i][j] = 0;
        		sb.append(dir[k]);
        		queue.offer(new int[] {i, j});
        	}
        	// take care: 
        	// [[0,0,0,0,1,1,1],[1,1,1,1,1,1,1],[0,0,0,0,0,0,0],[0,0,0,0,1,1,1],[1,1,1,1,1,1,0],[0,0,0,1,0,0,0]]
        	sb.append("n");  // next level
        }
        return sb.toString();
    }
    
	
	/**
	 * Approach1: DFS:
	 * The key to the solution is to find a way to represent the distinct shape. To describe the 
	 * shape, in fact, is to describe its moving directions assuming we start at the first 1 we 
	 * meet s - start, and move u - up, d - down, l - left, r - right.
	 * With curShape.append("b"); one with shape ord_r, another with shape ordr, and they will be 
	 * regarded as different shapes. Or else, they will be regarded as the same shape since their 
	 * moving directions are within the same order.
	 * @param int[][] grid
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n)
	 * Stack space: O(m*n)
	 */
	
	int[] dx;
	int[] dy;
	String[] dir;
	
    public int numberofDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> set = new HashSet<>();
        dx = new int[] {-1, 0, 1, 0};
        dy = new int[] {0, 1, 0, -1};
        dir = new String[] {"u", "r", "d", "l"};
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 0) continue;
        		grid[i][j] = 0;
        		StringBuilder sb = new StringBuilder("s");
        		dfs(grid, i, j, sb);
        		System.out.println(sb.toString());
        		set.add(sb.toString());
        	}
        }
        return set.size();
    }
    
    private void dfs(int[][] grid, int row, int col, StringBuilder sb) {
    	for (int k = 0; k < 4; k++) {
    		int i = row + dx[k];
    		int j = col + dy[k];
    		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) continue;
    		grid[i][j] = 0;
    		sb.append(dir[k]);
    		dfs(grid, i, j, sb);
            sb.append("b");  // take care: [[1,1,0,0],[1,0,1,1],[0,0,0,1]]
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofDistinctIslands result = new NumberofDistinctIslands();
		System.out.println(result.numberofDistinctIslands(new int[][] {{1,1,0,1,1}, {1,0,0,0,0}, {0,0,0,0,1}, {1,1,0,1,1}}));
		System.out.println(result.numberofDistinctIslandsI(new int[][] {{1,1,0,1,1}, {1,0,0,0,0}, {0,0,0,0,1}, {1,1,0,1,1}}));
	}

}
