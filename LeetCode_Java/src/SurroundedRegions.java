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
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public void surroundedRegions(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		Queue<int[]> queue = new LinkedList<>();
		// do the init, where board[i][j] = 'O' at edge
		for (int col = 0; col < n; col++) {
			if (board[0][col] == 'O') {               // 1 top line
				queue.offer(new int[] {0, col});
			}
			if (board[m - 1][col] == 'O') {
				queue.offer(new int[] {m - 1, col});  // 2 down line
			}
		}
		for (int row = 0; row < m; row++) {
			if (board[row][0] == 'O') {
				queue.offer(new int[] {row, 0});      // 3 left line
			}
			if (board[row][n - 1] == 'O') {
				queue.offer(new int[] {row, n - 1});  // 4 right line
			}
		}
		// BFS to find the union 'O' of edge, if it's union of edge, set 'Y'
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int row = point[0];
			int col = point[1];
			if (board[row][col] == 'Y') continue; // already change to 'X'
			board[row][col] = 'Y';
			if (row > 0 && board[row - 1][col] == 'O') queue.offer(new int[] {row - 1, col});      // check top
			if (row < m - 1 && board[row + 1][ col] == 'O') queue.offer(new int[] {row + 1, col}); // check down
			if (col > 0 && board[row][col - 1] == 'O') queue.offer(new int[] {row, col - 1});      // check left
			if (col < n - 1 && board[row][col + 1] == 'O') queue.offer(new int[] {row, col + 1});  // check right
		}
		// convert 'Y' to 'O', 'O' to 'X'
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (board[row][col] == 'O') {
					board[row][col] = 'X';
				}
				if (board[row][col] == 'Y') {
					board[row][col] = 'O';
				}
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
