import java.util.Arrays;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular 
 * automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell 
 * interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules 
 * (taken from the above Wikipedia article):
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by over-population..
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * Follow up: 
 * 1. Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot 
 * update some cells first and then use their updated values to update other cells.
 * 2. In this question, we represent the board using a 2D array. In principle, the board is infinite, which 
 * would cause problems when the active area encroaches the border of the array. How would you address 
 * these problems?
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class GameofLife {
	
	/**
	 * Using 2-bit to store the new state.
	 * [2nd bit, 1st bit] = [next state, current state]
	 * - 00  dead (next) <- dead (current)
	 * - 01  dead (next) <- live (current)  
	 * - 10  live (next) <- dead (current)  
	 * - 11  live (next) <- live (current) 
	 * In the beginning, every 2nd bit is 0,So we only need to care about when the 2nd bit will become 1.
	 * Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
	 * Transition 00 -> 10: when board == 0 and lives == 3.
	 * Then get the 2nd state.
	 * @param int[][] board
	 * Time: O(mn)
	 * Space: O(1)
	 */
	public void gameofLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = liveNeighbors(board, i, j);
				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3;
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] >>= 1;
			}
		}
	}
	
	private int liveNeighbors(int[][] board, int row, int col) {
		int m = board.length;
		int n = board[0].length;
		int lives = 0;
		for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, m - 1); i++) {
			for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, n - 1); j++) {
				lives += board[i][j] & 1;
			}
		}
		lives -= board[row][col] & 1;  // don't forget
		return lives;
	}
	
	public static void main(String[] args) { 
		GameofLife result = new GameofLife();
		int[][] board = {{0, 0, 1, 1, 1}, {1, 1, 1, 1, 0}};
		for (int[] b: board) {
			System.out.println(Arrays.toString(b));
		}
		result.gameofLife(board);
		System.out.println("-------------------");
		for (int[] b: board) {
			System.out.println(Arrays.toString(b));
		}
	}	
}
