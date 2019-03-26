package dropbox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberofIslands {

	
	/**
	 * Union Find
	 * @param int m, int n, int[][] positions
	 * @return int
	 * Time: O(m*n + l)
	 * Space: O(m*n)
	 */
    public List<Integer> NumberofIslandsII(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFindSet ufs = new UnionFindSet(m * n);
        int[][] grid = new int[m][n];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int cnt = 0;
        for (int[] p: positions) {
            grid[p[0]][p[1]] = 1;
            cnt++;
            for (int k = 0; k < 4; k++) {
                int i = p[0] + dir[k][0];
                int j = p[1] + dir[k][1];
                if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) continue;
                if (ufs.union(p[0] * n + p[1], i * n + j)) cnt--;
            } 
            res.add(cnt);
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
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) return false;
            parents[parentA] = parentB;
            return true;
        }
    } 




    
	
	
	/**
	 * BFS
	 * @param char[][] grid
	 * @return int
	 * Time: O(m*n)
	 * Space: O(1)
	 */
    public int numberofIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';
                    queue.add(i * n + j);
                    bfs(grid, queue);
                }
            }
        }
        return res;
    }
    
    private void bfs(char[][] grid, Queue<Integer> queue) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int d = queue.poll();
            for (int k = 0; k < 4; k++) {
                int i = d / n + dir[k][0];
                int j = d % n + dir[k][1];
                if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') continue;
                queue.offer(i * n + j);
                grid[i][j] = '0';
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
