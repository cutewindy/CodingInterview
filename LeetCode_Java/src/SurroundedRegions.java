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
	 * BFS/ Union find
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
		for (char[] bo: board) {
			System.out.println(Arrays.toString(bo));
		}
	}

}
