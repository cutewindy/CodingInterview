/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is 
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You 
 * may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * 
 * Tags: DFS, BFS, UnionFind
 * @author wendi
 *
 */
public class NumberofIslands {
	
	
	/**
	 * Method2: UnionFindSet. 
	 * @param char[][] grid
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int numberofIslandsI(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int res = 0;
		UnionFindSet ufs = new UnionFindSet(m * n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0') continue;
				res++;
				int[] dx = {-1, 0, 1, 0};
				int[] dy = {0, 1, 0, -1};
				for (int k = 0; k < 4; k++) {
					int row = i + dx[k];
					int col = j + dy[k];
					if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') continue;
					if (ufs.union(i * n + j, row * n + col)) res--;
				}
			}
		}
		return res;
	}
	
	class UnionFindSet {
		int[] parents;
		public UnionFindSet(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) parents[i] = i;
		}
		
		public int find(int x) {
			while (parents[x] != x) {
				x = parents[x];
			}
			return x;
		}
		
		public boolean union(int a, int b) {
			int pA = find(a);
			int pB = find(b);
			if (pA != pB) {
				parents[pA] = pB;
				return true;
			}
			return false;
		}
	}

	/**
	 * Method1: DFS(Recursion). 
	 * Find '1' in the grid first. Then use helper to find the union island.
	 * If find, set grid[i][j]='0', means this area has already been found, it's union island,
	 * should not count to res.
	 * @param char[][] grid
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public int numberofIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                dfs(grid, i, j);
                res++;
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || 
        		grid[row][col] == '0') return;
        grid[row][col] = '0';
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            dfs(grid, row + dx[k], col + dy[k]);
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofIslands result = new NumberofIslands();
		System.out.println(result.numberofIslands(new char[][] 
				{{'1', '1', '1', '1', '0'}, 
				 {'1', '1', '0', '1', '0'},
				 {'1', '1', '0', '0', '0'},
				 {'1', '1', '0', '0', '0'},
				 {'0', '0', '0', '0', '0'}}));
		System.out.println(result.numberofIslandsI(new char[][] 
				{{'1', '1', '1', '1', '0'}, 
				 {'1', '1', '0', '1', '0'},
				 {'1', '1', '0', '0', '0'},
				 {'1', '1', '0', '0', '0'},
				 {'0', '0', '0', '0', '0'}}));
	}

}
