import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
		X X X X
		X O O X
		X X O X
		X O X X
 * After running your function, the board should be:
		X X X X
		X X X X
		X X X X
		X O X X
 * 
 * Tags: BFS, Union find
 * @author wendi
 *
 */
public class SurroundedRegions {
	
	
	/**
	 * Method2: UnionFindSet
	 * If a 'O' node is on the boundary, connect it to the dummy node(m * n), and for each node 
	 * check it's neighbor, if it is 'O', connect to node.
	 * Iterate each node again, if it's 'O' and don't connect to dummy node, change it to 'X'.
	 * whole board and mark 'O' as 'X' and 'Y' as 'O'.
	 * @param char[][] board
	 * Time: O(2*m*n)
	 * Space: O(m*n)
	 */
	public void surroundedRegionsI(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		UnionFindSet ufs = new UnionFindSet(m * n + 1);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') continue;
				if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
					ufs.union(i * n + j, m * n);   // if a 'O' node is on the boundary, connect it to the dummy node
				}
				int[] dx = {-1, 0, 1, 0};
				int[] dy = {0, 1, 0, -1};
				for (int k = 0; k < 4; k++) {
					int row = i + dx[k];
					int col = j + dy[k];
					if (row >= 0 && row < m && col >= 0 && col < n && board[row][col] == 'O') {
						ufs.union(row * n + col, i * n + j);  // connect a 'O' node to its neighbor 'O' nodes
					}
				}
			}
		}
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (board[i][j] == 'O' && ufs.find(i * n + j) != ufs.find(m * n)) {
					board[i][j] = 'X';
 				}
			}
		}
 	}
	
	
	class UnionFindSet {
		int[] parents;
		public UnionFindSet(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) parents[i] = i;
		}
		
		public int find(int x) {
			int input = x;
			while (parents[x] != x) {
				x = parents[x];
			}
			while (parents[input] != x) {
				int next = parents[input];
				parents[input] = x;
				input = next;
			}
			return x;
		}
		
		public void union(int a, int b) {
			int pA = find(a);
			int pB = find(b);
			if (pA != pB) parents[pA] = pB;
		}
	}
	
	

	/**
	 * Method1: BFS
	 * Use BFS starting from 'O's on the boundary and mark them as 'Y', then iterate over the 
	 * whole board and mark 'O' as 'X' and 'Y' as 'O'.
	 * @param char[][] board
	 * Time: O(m*n)
	 * Space: O(m*n)
	 */
	public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        // do the init, where board[i][j] = 'O' at edge
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'Y';
                queue.offer(i * n);
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'Y';
                queue.offer(i * n + n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'Y';
                queue.offer(j);
            }
            if (board[m - 1][j] == 'O') {
                board[m - 1][j] = 'Y';
                queue.offer((m - 1) * n + j);
            }
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // BFS to find the union 'O' of edge, if it's union of edge, set 'Y'
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int k = 0; k < 4; k++) {
                int i = curr / n + dir[k][0];
                int j = curr % n + dir[k][1];
                if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') continue;
                board[i][j] = 'Y';
                queue.offer(i * n + j);
            }
        }
        // convert 'Y' to 'O', 'O' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions result = new SurroundedRegions();
		char[][] board = {{'X', 'X', 'X', 'X'}, 
						  {'X', 'O', 'O', 'X'}, 
						  {'X', 'X', 'O', 'X'}, 
						  {'X', 'O', 'X', 'X'}};
		result.surroundedRegions(board);
		for (char[] row: board) System.out.println(Arrays.toString(row));
		System.out.println("------------");
		char[][] boardI = {{'X', 'X', 'X', 'X'}, 
						   {'X', 'O', 'O', 'X'}, 
						   {'X', 'X', 'O', 'X'}, 
						   {'X', 'O', 'X', 'X'}};
		result.surroundedRegionsI(boardI);
		for (char[] row: boardI) System.out.println(Arrays.toString(row));
	}

}
